package DAO.DAOImpl;

import DAO.IDAO.IManufacturerDao;
import models.Manufacturer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ManufacturerDaoImpl implements IManufacturerDao {

    public ManufacturerDaoImpl() {
    }

    @Override
    public Manufacturer findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Manufacturer.class, id);
    }

    @Override
    public List<Manufacturer> findAll() {
        List<Manufacturer> manufacturerList = (List<Manufacturer>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Manufacturer ").list();
        return manufacturerList;
    }

    @Override
    public void create(Manufacturer manufacturer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(manufacturer);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Manufacturer manufacturer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(manufacturer);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(Manufacturer manufacturer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(manufacturer);
        tx1.commit();
        session.close();
    }
}
