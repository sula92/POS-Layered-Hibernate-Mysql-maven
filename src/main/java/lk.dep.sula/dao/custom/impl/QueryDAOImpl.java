package lk.dep.sula.dao.custom.impl;

import lk.dep.sula.dao.CrudUtil;
import lk.dep.sula.dao.custom.QueryDAO;
import lk.dep.sula.entity.CustomEntity;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public ArrayList<CustomEntity> getALLOrderInformation() throws SQLException {
        System.out.println("fuck");
        ArrayList<CustomEntity> customEntities=new ArrayList<>();
        System.out.println("fuck2");
        NativeQuery nativeQuery = session.createNativeQuery("select O.id, O.date, O.customer_id, C.name, SUM(OD.qty*OD.unit_price) from (`order` O INNER JOIN customer C on O.customer_id = C.id INNER JOIN orderdetail OD on O.id = OD.orderID) group by o.id");


        List<Object[]> list = nativeQuery.list();
        list.forEach(objects -> {
            String oid=objects[0].toString();
            java.sql.Date date= (java.sql.Date) objects[1];
            LocalDate d=date.toLocalDate();
            String cid= String.valueOf(objects[2]);
            String cnm= String.valueOf(objects[3]);
            Double tot= (Double) objects[4];
            customEntities.add(new CustomEntity(oid,d,cid,cnm,tot));
            System.out.println("Order ID : " + objects[0]);
            System.out.println("Date : " + objects[1]);
            System.out.println("Customer ID : " +objects[2]);
            System.out.println("Customer Name : " + objects[3]);
            System.out.println("Total : " + objects[4]);
            System.out.println("--------------------------");

        });
        return customEntities;
    }


}
