package lk.dep.sula.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item implements SuperEntity{

    @Id
    private String code;
    private String description;
    @Column(name = "qtyOnHand")
    private int qtyOnHand;
    @Column(name = "unitPrice")
    private double unitPrice;
    @OneToMany(mappedBy = "item",cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Item() {
    }

    public Item(String code, String description, int qtyOnHand, double unitPrice) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public void addOrderDetail(OrderDetail orderDetail){
        orderDetails.add(orderDetail);
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}

