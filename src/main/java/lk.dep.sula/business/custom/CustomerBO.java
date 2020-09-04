package lk.dep.sula.business.custom;

import lk.dep.sula.business.SuperBO;
import lk.dep.sula.dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBO {

    void saveCustomer(CustomerDTO customer)throws Exception;

    void updateCustomer(CustomerDTO customer)throws Exception;

    void deleteCustomer(String customerId) throws Exception;

    List<CustomerDTO> findAllCustomers() throws Exception;

    String getLastCustomerId()throws Exception;

    CustomerDTO findCustomer(String customerId) throws Exception;

    List<String> getAllCustomerIDs() throws Exception;

}
