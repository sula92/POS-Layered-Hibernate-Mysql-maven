package lk.dep.sula.dao.custom;

import lk.dep.sula.dao.CrudDAO;
import lk.dep.sula.dao.SuperDAO;
import lk.dep.sula.entity.CustomEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {

    public ArrayList<CustomEntity> getALLOrderInformation() throws SQLException;

}
