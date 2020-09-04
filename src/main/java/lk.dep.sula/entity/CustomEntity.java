package lk.dep.sula.entity;

import java.time.LocalDate;

public class CustomEntity implements SuperEntity {

    private String orderId;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private double total;

    public CustomEntity() {
    }

    public CustomEntity(String orderId, LocalDate date, String customerId, String customerName, double total) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.customerName = customerName;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CustomEntity{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", total=" + total +
                '}';
    }
}
