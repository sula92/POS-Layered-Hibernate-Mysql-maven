package lk.dep.sula.dao;

import lk.dep.sula.entity.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlaceOrderDAOImpl {
    public PlaceOrderDAOImpl() {
    }

   /* public ArrayList<Item> loadAllItems() throws SQLException {
        ArrayList<Item> items=new ArrayList<>();
        ResultSet r=CrudUtil.execute("SELECT * from item");
        while (r.next()) {
            items.add(new Item(r.getString(1),r.getString(2),Double.valueOf(r.getString(4)),Integer.valueOf(r.getString(3))));
        }
        return items;
    }*/

    public ArrayList<Customer> loadAllCustomers(){
        ArrayList<Customer> customers =new ArrayList<>();
        try {
            ResultSet r=CrudUtil.execute("SELECT * from customer");
            while (r.next()) {
                customers.add(new Customer(r.getString(1),r.getString(2),r.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public int saveOrder(String oid, String cid) throws SQLException {

        return CrudUtil.execute("INSERT INTO `Order` VALUES (?,?,?)",oid,LocalDate.now(),cid);
    }

    public int saveOrderDetail(String oid,String icode, String qty, String uprice) throws SQLException {

        return CrudUtil.execute("INSERT INTO OrderDetail VALUES (?,?,?,?)",oid,icode,qty,uprice);
    }

    public void updateQtyOnDB(String code, String newQtyonHand){
        try {

            int i=CrudUtil.execute("update item set qtyOnHand=? where code=?",newQtyonHand,code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getQty(String code) throws SQLException {

        ResultSet r=CrudUtil.execute("select qtyOnHand from item where code=?",code);
        r.next();
        return  r.getString(1);
    }
}
