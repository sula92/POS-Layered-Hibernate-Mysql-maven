package lk.dep.sula.dao.custom;

import lk.dep.sula.dao.CrudDAO;
import lk.dep.sula.entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer,String> {

    public abstract String getLastCustomerId() throws SQLException;

}
