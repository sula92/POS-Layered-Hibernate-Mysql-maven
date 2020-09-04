package lk.dep.sula.dao;

import lk.dep.sula.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {

    public CrudUtil() {
    }

    public static  <T> T execute(String sql, Object...params) throws SQLException {
        PreparedStatement preparedStatement=DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i <params.length ; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T) preparedStatement.executeQuery();
        }
        else {
            return (T)((Integer) (preparedStatement.executeUpdate()));
        }

    }

}
