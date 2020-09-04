package lk.dep.sula.util;

import java.time.LocalDate;

public class SerchOrderTM {

    String orderid;
    LocalDate date;
    String cusId;
    String cusName;
    double total;

    public SerchOrderTM() {
    }

    public SerchOrderTM(String orderid, LocalDate date, String cusId, String cusName, double total) {
        this.orderid = orderid;
        this.date = date;
        this.cusId = cusId;
        this.cusName = cusName;
        this.total = total;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SerchOrderTM{" +
                "orderid='" + orderid + '\'' +
                ", date=" + date +
                ", cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", total=" + total +
                '}';
    }
}
