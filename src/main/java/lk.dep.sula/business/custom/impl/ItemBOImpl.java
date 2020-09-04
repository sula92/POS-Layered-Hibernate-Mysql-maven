package lk.dep.sula.business.custom.impl;

import lk.dep.sula.business.custom.ItemBO;
import lk.dep.sula.dao.DAOFactory;
import lk.dep.sula.dao.DAOTypes;
import lk.dep.sula.dao.custom.ItemDAO;
import lk.dep.sula.db.HibernateUtil;
import lk.dep.sula.dto.ItemDTO;
import lk.dep.sula.entity.Item;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO= DAOFactory.getInstance().getDAO(DAOTypes.ITEM);


    @Override
    public void saveItem(ItemDTO item) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemDAO.setSession(session);
            session.beginTransaction();
            System.out.println("eeee"+item.getQty());
            itemDAO.save(new Item(item.getItemCode(),
                    item.getDescription(), Integer.valueOf(item.getQty()), Double.valueOf(item.getUprice())));
            session.getTransaction().commit();
        }

    }

    @Override
    public void updateItem(ItemDTO item) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemDAO.setSession(session);
            session.beginTransaction();
            itemDAO.update(new Item(item.getItemCode(),
                    item.getDescription(), Integer.valueOf(item.getQty()), Double.valueOf(item.getUprice())));
            session.getTransaction().commit();
        }

    }

    @Override
    public void deleteItem(String itemCode) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemDAO.setSession(session);

            session.beginTransaction();

            itemDAO.delete(itemCode);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<ItemDTO> findAllItems() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemDAO.setSession(session);
            session.beginTransaction();
            System.out.println("sfsgsh");
            List<Item> allItems = itemDAO.findAll();
            List<ItemDTO> dtos = new ArrayList<>();
            for (Item item : allItems) {
                dtos.add(new ItemDTO(item.getCode(),
                        item.getDescription(),
                        String.valueOf(item.getQtyOnHand()),
                        String.valueOf(item.getUnitPrice())));
            }
            session.getTransaction().commit();
            return dtos;
        }
    }

    @Override
    public String getLastItemCode() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemDAO.setSession(session);
            session.beginTransaction();
            String lastItemCode = itemDAO.getLastItemId();
            session.getTransaction().commit();
            return lastItemCode==null ? "I000" : lastItemCode;
        }
    }

    @Override
    public ItemDTO findItem(String itemCode) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemDAO.setSession(session);
            session.beginTransaction();
            Item item = itemDAO.find(itemCode);
            session.getTransaction().commit();
            return new ItemDTO(item.getCode(),
                    item.getDescription(),
                    String.valueOf(item.getQtyOnHand()),
                    String.valueOf(item.getUnitPrice()));
        }
    }

    @Override
    public List<String> getAllItemCodes() throws Exception {
        return null;
    }
}
