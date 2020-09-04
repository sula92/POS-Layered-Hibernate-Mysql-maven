package lk.dep.sula.entity;



import javax.persistence.*;

@Entity
public class OrderDetail implements SuperEntity {

    @EmbeddedId
    private OrderDetailPk orderDetailPK;
    private int qty;
    @Column(name="unit_price")
    private double unitPrice;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="order_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="item_code",referencedColumnName = "code",insertable = false, updatable = false)
    private Item item;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPk orderDetailPK, int qty, double unitPrice) {
        this.orderDetailPK = orderDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(String orderId, String itemCode, int qty, double unitPrice) {
        this.orderDetailPK = new OrderDetailPk(orderId, itemCode);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetailPk getOrderDetailPk() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPk orderDetailPk) {
        this.orderDetailPK = orderDetailPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Order getOrder() {
        return order;
    }

    // Cascading purposes...
    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    // Cascading purposes...
    public void setItem(Item item) {
        this.item = item;
    }
}
