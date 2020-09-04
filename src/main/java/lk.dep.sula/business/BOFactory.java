package lk.dep.sula.business;

import lk.dep.sula.business.custom.impl.CustomerBOImpl;
import lk.dep.sula.business.custom.impl.ItemBOImpl;
import lk.dep.sula.business.custom.impl.OrderBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance(){
        return (boFactory==null)? (boFactory=new BOFactory()) : boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boType){
        switch (boType){
            case ITEM:
                return (T) new ItemBOImpl();
            case ORDER:
                return (T) new OrderBOImpl();
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            default:
                return null;
        }
    }
}
