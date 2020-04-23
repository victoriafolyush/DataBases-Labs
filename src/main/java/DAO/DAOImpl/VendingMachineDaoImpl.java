package DAO.DAOImpl;

import DAO.IDAO.IVendingMachineDao;
import models.VendingMachine;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class VendingMachineDaoImpl implements IVendingMachineDao {

    public VendingMachineDaoImpl() {
    }

    @Override
    public VendingMachine findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(VendingMachine.class, id);
    }

    @Override
    public List<VendingMachine> findAll() {
        List<VendingMachine> vendingMachineList = (List<VendingMachine>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From VendingMachine ").list();
        return vendingMachineList;
    }

    @Override
    public void create(VendingMachine vendingMachine) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(vendingMachine);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(VendingMachine vendingMachine) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(vendingMachine);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(VendingMachine vendingMachine) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(vendingMachine);
        tx1.commit();
        session.close();
    }
}
