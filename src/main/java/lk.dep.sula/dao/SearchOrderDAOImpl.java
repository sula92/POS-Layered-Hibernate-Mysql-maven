package lk.dep.sula.dao;

import lk.dep.sula.db.DBConnection;
import lk.dep.sula.util.SerchOrderTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderDAOImpl  {

    PreparedStatement pst;
    Connection connection= DBConnection.getInstance().getConnection();

    public ArrayList<SerchOrderTM> getOrders(){
       ArrayList<SerchOrderTM> serchOrderTMS=new ArrayList<>();

        try {
            pst=connection.prepareStatement("select O.id, O.date, O.customerId, C.name, SUM(OD.qty*OD.unitPrice) from (`order` O INNER JOIN customer C on O.customerId = C.customerId INNER JOIN orderdetail OD on O.id = OD.orderId) group by o.id");
            ResultSet rst=pst.executeQuery();
            while (rst.next()) {
                SerchOrderTM serchOrderTM=new SerchOrderTM(rst.getString(1), rst.getDate(2).toLocalDate(),rst.getString(3),rst.getString(4),rst.getDouble(5));
                serchOrderTMS.add(serchOrderTM);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serchOrderTMS;
    }



}
