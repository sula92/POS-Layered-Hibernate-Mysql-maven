package lk.dep.sula.dao.custom;

import lk.dep.sula.dao.CrudDAO;
import lk.dep.sula.dao.SuperDAO;
import lk.dep.sula.entity.Item;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item,String> {

    public int updateQty(int qty,String icode) throws SQLException;

    public abstract String getLastItemId() throws SQLException;

}
