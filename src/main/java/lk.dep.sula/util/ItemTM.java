package lk.dep.sula.util;


import javafx.scene.control.Button;

public class ItemTM {

    String itemCode;
    String description;
    String qty;
    String uprice;
    Button button;

    public ItemTM() {
    }

    public ItemTM(String itemCode, String description, String qty, String uprice, Button button) {
        this.itemCode = itemCode;
        this.description = description;
        this.qty = qty;
        this.uprice = uprice;
        this.button = button;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "ItemTM{" +
                "itemCode='" + itemCode + '\'' +
                ", description='" + description + '\'' +
                ", qty='" + qty + '\'' +
                ", uprice='" + uprice + '\'' +
                ", button=" + button +
                '}';
    }
}
