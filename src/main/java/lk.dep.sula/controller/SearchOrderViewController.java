package lk.dep.sula.controller;

import lk.dep.sula.business.BOFactory;
import lk.dep.sula.business.BOTypes;
import lk.dep.sula.business.custom.OrderBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import lk.dep.sula.db.DBConnection;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import lk.dep.sula.dto.SearchOrderDTO;
import lk.dep.sula.entity.Customer;
import lk.dep.sula.entity.OrderDetail;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.dep.sula.dao.SearchOrderDAOImpl;
import lk.dep.sula.util.SerchOrderTM;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchOrderViewController implements Initializable {
    public JFXComboBox<Customer> cmbcus;
    public AnchorPane root;
    public TableView tblOrders;
    public TableColumn colOrderId;
    public TableColumn colOrderDate;
    public TableColumn colCusId;
    public TableColumn colCusNm;
    public TableColumn colTot;
    public FontAwesomeIconView iconHome;
    public JFXTextField txtSearch;
    SearchOrderDAOImpl searchOrderDAOImpl =new SearchOrderDAOImpl();
    OrderBO orderBO= BOFactory.getInstance().getBO(BOTypes.ORDER);
    ArrayList<SearchOrderDTO> searchOrderDTOS=new ArrayList<>(orderBO.getAllOrderInformation());
    private ArrayList<SerchOrderTM> orders = new ArrayList<>();
    PreparedStatement pst;
    Connection connection= DBConnection.getInstance().getConnection();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCusId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colCusNm.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        colTot.setCellValueFactory(new PropertyValueFactory<>("total"));

        searchOrderDTOS.stream().forEach(searchOrderDTO -> {
            orders.add(new SerchOrderTM(searchOrderDTO.getOrderId(),searchOrderDTO.getDate(),searchOrderDTO.getCustomerId(),searchOrderDTO.getCustomerName(),searchOrderDTO.getTotal()));
        });



        tblOrders.getItems().addAll(orders);

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<SerchOrderTM> serchOrderTMS=FXCollections.observableList(tblOrders.getItems());
                serchOrderTMS.clear();
                orders.stream().forEach(serchOrderTM -> {
                    if ((serchOrderTM.getOrderid().contains(newValue)||
                            serchOrderTM.getCusId().contains(newValue) ||
                            serchOrderTM.getCusName().contains(newValue) ||
                            serchOrderTM.getDate().toString().contains(newValue))){

                        serchOrderTMS.add(serchOrderTM);
                    }
                });
            }
        });

    }

    private Double getTotal(ArrayList<OrderDetail> orderDetails) {
        double tot= orderDetails.stream().mapToDouble(orderDetail -> (orderDetail.getUnitPrice() * orderDetail.getQty())).sum();
        return tot;
    }


    public void navigate(MouseEvent mouseEvent) throws IOException {

        if (mouseEvent.getSource() instanceof FontAwesomeIconView){
            FontAwesomeIconView icon = (FontAwesomeIconView) mouseEvent.getSource();

            Parent root = null;

            switch(icon.getId()){
                case "iconHome":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/dep/sula/view/main.fxml"));
                    break;
                case "iconItem":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/dep/sula/view/itemView.fxml"));
                    break;
                case "iconPlaceOrder":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/dep/sula/view/PlaceOrderView.fxml"));
                    break;
                case "iconSearch":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/dep/sula/view/SearchOrderView.fxml"));
                    break;
            }

            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }
}
