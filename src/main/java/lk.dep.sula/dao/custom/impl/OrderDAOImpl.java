package lk.dep.sula.dao.custom.impl;

import lk.dep.sula.dao.CrudDAOImpl;
import lk.dep.sula.dao.CrudUtil;
import lk.dep.sula.dao.custom.OrderDAO;
import lk.dep.sula.entity.Order;

public class OrderDAOImpl extends CrudDAOImpl<Order,String> implements OrderDAO {


    @Override
    public String getLastOrderId() {
        return (String) session.createNativeQuery("select id from `order` order by id DESC LIMIT 1").uniqueResult();
    }
}
