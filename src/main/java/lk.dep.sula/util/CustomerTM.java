package lk.dep.sula.util;

import lk.dep.sula.entity.Customer;
import javafx.scene.control.Button;


public class CustomerTM {

    String id;
    String name;
    String address;
    Button button;

    public CustomerTM() {
    }

    public CustomerTM(String id, String name, String address, Button button) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.button = button;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", button=" + button +
                '}';
    }
}
