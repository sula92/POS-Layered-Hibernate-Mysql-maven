package lk.dep.sula.controller;

import lk.dep.sula.business.BOFactory;
import lk.dep.sula.business.BOTypes;
import lk.dep.sula.business.custom.ItemBO;
import com.jfoenix.controls.JFXTextField;
import lk.dep.sula.db.DBConnection;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import lk.dep.sula.dto.ItemDTO;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.dep.sula.util.ItemTM;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class ItemViewController implements Initializable {

    public Button btnAdd;
    public AnchorPane root;
    public FontAwesomeIconView iconHome;
    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtUprice;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<ItemTM> tblItem;

    @FXML
    private JFXTextField txtSearch;

    PreparedStatement preparedStatement;
    Connection connection= DBConnection.getInstance().getConnection();
    ItemBO itemBO= BOFactory.getInstance().getBO(BOTypes.ITEM);

   // ItemDAOImpl itemDAOImpl =new ItemDAOImpl();


    @FXML
    void btnSaveOnAtion(ActionEvent event) throws Exception {


        if(btnSave.getText().equalsIgnoreCase("Save")){


            String code=txtItemCode.getText();
            String des=txtDescription.getText();
            String up=txtUprice.getText();
            String qty=txtQty.getText();


            try {

                itemBO.saveItem(new ItemDTO(code,des,qty,up));
                new Alert(Alert.AlertType.CONFIRMATION,"Item Added successfully").show();
                btnAddOnAction(event);
                btnAdd.setDisable(false);
                tblItem.getItems().clear();
                loadItems();

            }catch (Exception e) {
                new Alert((Alert.AlertType.ERROR), "Failed To Insert!").show();

                btnAddOnAction(event);
                btnAdd.setDisable(false);
                tblItem.getItems().clear();
                loadItems();
            }
        }
        else {


            String code=txtItemCode.getText();
            String des=txtDescription.getText();
            String up=txtUprice.getText();
            String qty=txtQty.getText();

            System.out.println(new ItemDTO(code,des,qty,up));
            itemBO.updateItem(new ItemDTO(code,des,qty,up));
            try{

                new Alert(Alert.AlertType.INFORMATION,"Updated").show();
                tblItem.getItems().clear();
            }
            catch (Exception e){

                new Alert(Alert.AlertType.ERROR,"Failed To Update").show();
            }
            loadItems();
            btnAdd.setDisable(false);
            tblItem.refresh();
            btnAddOnAction(event);
           }

    }

    @FXML
    void txtSaveKeyRelease(KeyEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("uprice"));
        tblItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("button"));

        try {
            loadItems();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            btnSave.setText("UPDATE");

            txtItemCode.setText(newValue.getItemCode());
            txtDescription.setText(newValue.getDescription());
            txtQty.setText(newValue.getQty());
            txtUprice.setText(newValue.getUprice());


        });



    }

    public void loadItems() throws Exception {

        ObservableList<ItemTM> itemTMS=tblItem.getItems();
        itemTMS.clear();
        tblItem.refresh();

        ArrayList<ItemDTO> items=new ArrayList<>(itemBO.findAllItems());
        for (ItemDTO item:items) {
            String code=item.getItemCode();
            String des=item.getDescription();
            String up=item.getUprice();
            String qty=item.getQty();

            Button btn=new Button("DELETE");
            btn.setStyle("-fx-background-color: red");
            itemTMS.add(new ItemTM(code,des,qty,up,btn));
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        deleteItem(code);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        btnAddOnAction(event);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    private void deleteItem(String code) throws SQLException {
        connection.setAutoCommit(false);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure You Want to Delete This Item?", ButtonType.YES,ButtonType.CANCEL);
        Optional<ButtonType> buttonType=alert.showAndWait();
        if (buttonType.get()==ButtonType.YES){
            try {
               itemBO.deleteItem(code);
                try {
                    connection.commit();
                    new Alert(Alert.AlertType.INFORMATION,"Customer Has Been Deleted Successfully").show();
                    loadItems();
                    tblItem.refresh();

                }catch (Exception e) {
                    connection.rollback();
                    new Alert(Alert.AlertType.INFORMATION,"Failed To Delete the Customer!").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void btnAddOnAction(ActionEvent event) throws SQLException {

        try {
            reset();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void reset() throws Exception {
        txtDescription.setText("");
        txtQty.setText("");
        txtUprice.setText("");
        btnSave.setText("SAVE");
        //btnSave.setDisable(true);

        int i=1;

        String x= itemBO.getLastItemCode();



        int id= Integer.valueOf(x.substring(1));
        System.out.println(id);
        int maxid=maxid=id+1;
        String newid;
        System.out.println(maxid);

        if(x.startsWith("I00")){

            newid="I00"+maxid;
            System.out.println(newid);
            txtItemCode.setText(newid);


        }
        else if(x.startsWith("I0")){

            newid="I0"+maxid;
            System.out.println(newid);
            txtItemCode.setText(newid);
        }
        else {

            newid="C"+maxid;
            System.out.println(newid);
            txtItemCode.setText(newid);
        }
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
