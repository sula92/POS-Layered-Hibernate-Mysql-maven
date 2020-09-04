package lk.dep.sula.dao.custom.impl;

import lk.dep.sula.dao.CrudDAO;
import lk.dep.sula.dao.CrudDAOImpl;
import lk.dep.sula.dao.CrudUtil;
import lk.dep.sula.dao.custom.ItemDAO;
import lk.dep.sula.entity.Item;

import java.sql.SQLException;

public class ItemDAOImpl extends CrudDAOImpl<Item,String> implements ItemDAO {


    @Override
    public int updateQty(int qty, String icode) throws SQLException {
        try {
            Item item=session.get(Item.class, icode);
            item.setQtyOnHand(qty);
            session.merge(icode,item);
            session.getTransaction().commit();
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }

    }

    @Override
    public String getLastItemId() throws SQLException {
        return (String) session.createNativeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1").uniqueResult();
    }
}
