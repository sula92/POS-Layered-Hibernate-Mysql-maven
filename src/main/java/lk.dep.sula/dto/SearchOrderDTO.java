package lk.dep.sula.dto;

import java.time.LocalDate;

public class SearchOrderDTO {

    private String orderId;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private Double total;

    public SearchOrderDTO() {
    }

    public SearchOrderDTO(String orderId, LocalDate date, String customerId, String customerName, Double total) {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SearchOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", total=" + total +
                '}';
    }
}
