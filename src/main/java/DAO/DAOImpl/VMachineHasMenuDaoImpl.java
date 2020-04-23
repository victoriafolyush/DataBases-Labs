package DAO.DAOImpl;

import DAO.IDAO.IVMachineHasMenuDao;
import models.VendingMachineHasMenu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class VMachineHasMenuDaoImpl implements IVMachineHasMenuDao {
    public VMachineHasMenuDaoImpl() {
    }



    @Override
    public VendingMachineHasMenu findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(VendingMachineHasMenu.class, id);
    }

    @Override
    public List<VendingMachineHasMenu> findAll() {
        List<VendingMachineHasMenu> vendingMachineHasMenuList = (List<VendingMachineHasMenu>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From VendingMachineHasMenu").list();
        return vendingMachineHasMenuList;
    }

    @Override
    public void create(VendingMachineHasMenu vendingMachineHasMenu) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(vendingMachineHasMenu);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(VendingMachineHasMenu vendingMachineHasMenu) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(vendingMachineHasMenu);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(VendingMachineHasMenu vendingMachineHasMenu) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(vendingMachineHasMenu);
        tx1.commit();
        session.close();
    }
}
