package lk.dep.sula.dao.custom.impl;


import lk.dep.sula.dao.CrudDAOImpl;
import lk.dep.sula.dao.custom.CustomerDAO;
import lk.dep.sula.entity.Customer;

import java.sql.*;


public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO  {

    public CustomerDAOImpl() {
    }

    @Override
    public String getLastCustomerId() throws SQLException {
        return (String) session.createNativeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1").uniqueResult();
    }
}
