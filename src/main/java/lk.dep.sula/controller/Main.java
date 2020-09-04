package lk.dep.sula.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main {

    public AnchorPane root;
    public Label lblDescription;
    public Label lab1;
    @FXML
    private FontAwesomeIconView iconCustomer;

    @FXML
    private FontAwesomeIconView iconItem;

    @FXML
    private FontAwesomeIconView iconSearch;

    @FXML
    private FontAwesomeIconView iconPlaceOrder;

    @FXML
    void iconCustomerOnClicked(MouseEvent event) {

    }

    @FXML
    void iconCustomerOnEnter(MouseEvent event) {

    }

    @FXML
    void iconCustomerOnExit(MouseEvent event) {

    }

    @FXML
    void iconItemOnClicked(MouseEvent event) {

    }

    @FXML
    void iconItemOnEnter(MouseEvent event) {

    }

    @FXML
    void iconItemOnExit(MouseEvent event) {

    }

    @FXML
    void iconPlaceOrderOnClicked(MouseEvent event) {

    }

    @FXML
    void iconPlaceOrderOnEnter(MouseEvent event) {

    }

    @FXML
    void iconPlaceOrderOnExit(MouseEvent event) {

    }

    @FXML
    void iconSearchOnClicked(MouseEvent event) {

    }

    @FXML
    void iconSearchOnEnter(MouseEvent event) {

    }

    @FXML
    void iconSearchOnExit(MouseEvent event) {

    }

    FontAwesomeIconView i;

    public void initialize(){

        iconCustomer.setEffect(null);
        DropShadow glow = new DropShadow();
        glow.setColor(Color.BLUE);
        glow.setWidth(20.0D);
        glow.setHeight(20.0D);
        glow.setRadius(40.0D);
        iconCustomer.setEffect(glow);
        iconItem.setEffect(glow);
        iconPlaceOrder.setEffect(glow);
        iconSearch.setEffect(glow);

    }

    @FXML
    private void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof FontAwesomeIconView){
            FontAwesomeIconView icon = (FontAwesomeIconView) event.getSource();

            Parent root = null;

            switch(icon.getId()){
                case "iconCustomer":
                    root = FXMLLoader.load(this.getClass().getResource("/view/customerView.fxml"));
                    break;
                case "iconItem":
                    root = FXMLLoader.load(this.getClass().getResource("/view/itemView.fxml"));
                    break;
                case "iconPlaceOrder":
                    root = FXMLLoader.load(this.getClass().getResource("/view/placeOrderView.fxml"));
                    break;
                case "iconSearch":
                    root = FXMLLoader.load(this.getClass().getResource("/view/SearchOrderView.fxml"));
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

    public void img_mouseEnterence(MouseEvent mouseEvent) {
        FontAwesomeIconView icon = (FontAwesomeIconView) mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200.0D), icon);
        scaleT.setToX(1.2D);
        scaleT.setToY(1.2D);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.RED);
        glow.setWidth(20.0D);
        glow.setHeight(20.0D);
        glow.setRadius(40.0D);
        icon.setEffect(glow);

        String cat =icon.getId();
        switch (cat){
            case "iconCustomer":
                this.lab1.setText("Manage Customers");
                this.lblDescription.setText("Click to add, update or delete Customers");
                break;

            case "iconItem":
                this.lab1.setText("Manage Items");
                this.lblDescription.setText("Click to add, update or delete Items");
                break;

            case "iconPlaceOrder":
                this.lab1.setText("Place an Order");
                this.lblDescription.setText("Click to Place an Order");
                break;

            case "iconSearch":
                this.lab1.setText("Search Orders");
                this.lblDescription.setText("Click to Search Orders");
                break;

        }

    }



    public void img_mouseExit(MouseEvent mouseEvent) {
        FontAwesomeIconView icon = (FontAwesomeIconView) mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200.0D),icon);
        scaleT.setToX(1D);
        scaleT.setToY(1D);
        scaleT.play();
        icon.setEffect(null);
        DropShadow glow = new DropShadow();
        glow.setColor(Color.BLUE);
        glow.setWidth(20.0D);
        glow.setHeight(20.0D);
        glow.setRadius(40.0D);
        icon.setEffect(glow);

        lblDescription.setText("PLAY WITH THE BEST");
        lab1.setText("DARK TEC PC GAMES");
        lblDescription.setText("");

    }

}
