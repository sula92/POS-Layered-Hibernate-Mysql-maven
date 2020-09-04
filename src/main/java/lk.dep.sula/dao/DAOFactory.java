package lk.dep.sula.dao;

import lk.dep.sula.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory==null)? new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch (daoType){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ORDER:
                return (T) new OrderDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case ORDERDETAIL:
                return (T) new OrderDetailDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }

}
