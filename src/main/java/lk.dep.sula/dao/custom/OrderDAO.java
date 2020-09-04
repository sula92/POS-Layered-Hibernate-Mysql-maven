package lk.dep.sula.dao.custom;

import lk.dep.sula.dao.CrudDAO;
import lk.dep.sula.dao.SuperDAO;
import lk.dep.sula.entity.Order;

public interface OrderDAO extends CrudDAO<Order,String> {

    public String getLastOrderId();

}
