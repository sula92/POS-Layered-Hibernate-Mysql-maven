package lk.dep.sula.util;


import javafx.scene.control.Button;

public class PlaceOrderTM {

    String code;
    String des;
    String qty;
    String uprice;
    String tot;
    Button button;

    public PlaceOrderTM() {
    }

    public PlaceOrderTM(String code, String des, String qty, String uprice, String tot, Button button) {
        this.code = code;
        this.des = des;
        this.qty = qty;
        this.uprice = uprice;
        this.tot = tot;
        this.button = button;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUprice() {
        return uprice;
    }

    public void setUprice(String uprice) {
        this.uprice = uprice;
    }

    public String getTot() {
        return tot;
    }

    public void setTot(String tot) {
        this.tot = tot;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "PlaceOrderTM{" +
                "code='" + code + '\'' +
                ", des='" + des + '\'' +
                ", qty='" + qty + '\'' +
                ", uprice='" + uprice + '\'' +
                ", tot='" + tot + '\'' +
                ", button=" + button +
                '}';
    }
}
