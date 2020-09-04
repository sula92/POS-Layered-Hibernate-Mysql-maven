package lk.dep.sula.test;

import lk.dep.sula.dao.DAOFactory;
import lk.dep.sula.dao.DAOTypes;
import lk.dep.sula.dao.custom.OrderDAO;
import lk.dep.sula.dao.custom.OrderDetailDAO;
import lk.dep.sula.db.HibernateUtil;
import lk.dep.sula.entity.Customer;
import lk.dep.sula.entity.Order;
import lk.dep.sula.entity.OrderDetail;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;

public class Test1 {

    public static void main(String[] args) {
        OrderDAO orderDAO= DAOFactory.getInstance().getDAO(DAOTypes.ORDER);
        OrderDetailDAO orderDetailDAO = DAOFactory.getInstance().getDAO(DAOTypes.ORDERDETAIL);

        Session session=HibernateUtil.getSessionFactory().openSession();
        orderDAO.setSession(session);
        orderDetailDAO.setSession(session);

        session.beginTransaction();

        LocalDate localDate=LocalDate.now();
        Date date=Date.valueOf(localDate);
        System.out.println(date);
        //List<OrderDetail> orderDetails= new ArrayList<>();
        OrderDetail detail=new OrderDetail("O030","I002",3,20.0);
        Customer customer=new Customer("C003","xxx","add");
        try {
            orderDAO.save(new Order("O030",date,customer));
            orderDetailDAO.save(detail);

        } catch (Exception e) {
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }




}
