package DAO.DAOImpl;

import DAO.IDAO.IMechanicDao;
import models.Mechanic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;


import java.util.List;

public class MechanicDaoImpl implements IMechanicDao {


    public MechanicDaoImpl() {
    }


    @Override
    public Mechanic findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Mechanic.class, id);
    }

    @Override
    public List<Mechanic> findAll() {
        List<Mechanic> mechanicList = (List<Mechanic>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Mechanic ").list();
        return mechanicList;
    }

    @Override
    public void create(Mechanic mechanic) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(mechanic);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Mechanic mechanic) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(mechanic);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(Mechanic mechanic) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(mechanic);
        tx1.commit();
        session.close();
    }
}
