package lk.dep.sula.business.custom;

import lk.dep.sula.business.SuperBO;
import lk.dep.sula.dto.OrderDTO;
import lk.dep.sula.dto.SearchOrderDTO;

import java.util.ArrayList;
import java.util.List;

public interface OrderBO extends SuperBO {

    String getLastOrderId() throws Exception;

    public void placeOrder(OrderDTO orderDTO) throws Exception;

    List<SearchOrderDTO> getOrderInfo(String query) throws Exception;

    ArrayList<SearchOrderDTO> getAllOrderInformation();
}
