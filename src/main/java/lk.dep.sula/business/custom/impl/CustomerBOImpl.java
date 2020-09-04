package lk.dep.sula.business.custom.impl;

import lk.dep.sula.business.custom.CustomerBO;
import lk.dep.sula.dao.DAOFactory;
import lk.dep.sula.dao.DAOTypes;
import lk.dep.sula.dao.custom.CustomerDAO;
import lk.dep.sula.db.HibernateUtil;
import lk.dep.sula.dto.CustomerDTO;
import lk.dep.sula.entity.Customer;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO= DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);


    @Override
    public void saveCustomer(CustomerDTO customer) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDAO.setSession(session);
            session.beginTransaction();
            customerDAO.save(new Customer(customer.getId(), customer.getName(), customer.getAddress()));
            session.getTransaction().commit();
        }

    }

    @Override
    public void updateCustomer(CustomerDTO customer) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDAO.setSession(session);
            session.beginTransaction();
            customerDAO.update(new Customer(customer.getId(), customer.getName(), customer.getAddress()));
            session.getTransaction().commit();
        }

    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDAO.setSession(session);
            //check orders before delete a customer!!!
            session.beginTransaction();

            customerDAO.delete(customerId);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDAO.setSession(session);
            session.beginTransaction();
            List<Customer> alCustomers = customerDAO.findAll();
            List<CustomerDTO> dtos = new ArrayList<>();
            for (Customer customer : alCustomers) {
                dtos.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
            }
            session.getTransaction().commit();
            return dtos;
        }
    }

    @Override
    public String getLastCustomerId() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDAO.setSession(session);
            session.beginTransaction();
            String lastCustomerId = customerDAO.getLastCustomerId();
            session.getTransaction().commit();
            return lastCustomerId==null ? "C000" : lastCustomerId;
        }
    }

    @Override
    public CustomerDTO findCustomer(String customerId) throws Exception {
        return null;
    }

    @Override
    public List<String> getAllCustomerIDs() throws Exception {
        return null;
    }
}
