package DAO.DAOImpl;

import DAO.IDAO.IMenuDao;
import models.Menu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class MenuDaoImpl implements IMenuDao {

    public MenuDaoImpl() {
    }


    @Override
    public Menu findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Menu.class, id);
    }

    @Override
    public List<Menu> findAll() {
        List<Menu> menuList = (List<Menu>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Menu").list();
        return menuList;
    }

    @Override
    public void create(Menu menu) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(menu);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Menu menu) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(menu);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(Menu menu) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(menu);
        tx1.commit();
        session.close();
    }
}
