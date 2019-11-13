package DAO.DAOImpl;

import DAO.IDAO.ILocationDao;
import models.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;


import java.util.List;

public class LocationDaoImpl implements ILocationDao {

    public LocationDaoImpl() {
    }


    @Override
    public Location findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Location.class, id);
    }

    @Override
    public List<Location> findAll() {
        List<Location> locationList = (List<Location>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Location ").list();
        return locationList;
    }

    @Override
    public void create(Location location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(location);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Location location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(location);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(Location location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(location);
        tx1.commit();
        session.close();
    }
}
