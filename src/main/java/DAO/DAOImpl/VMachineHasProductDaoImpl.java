package DAO.DAOImpl;

import DAO.IDAO.IVMachineHasProductDao;
import models.VendingMachineHasMenu;
import models.VendingMachineHasProduct;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class VMachineHasProductDaoImpl implements IVMachineHasProductDao {

    public VMachineHasProductDaoImpl() {
    }

    @Override
    public VendingMachineHasProduct findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(VendingMachineHasProduct.class, id);
    }

    @Override
    public List<VendingMachineHasProduct> findAll() {
        List<VendingMachineHasProduct> vendingMachineHasProductList = (List<VendingMachineHasProduct>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From VendingMachineHasProduct ").list();
        return vendingMachineHasProductList;
    }

    @Override
    public void create(VendingMachineHasProduct vendingMachineHasProduct) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(vendingMachineHasProduct);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(VendingMachineHasProduct vendingMachineHasProduct) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(vendingMachineHasProduct);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(VendingMachineHasProduct vendingMachineHasProduct) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(vendingMachineHasProduct);
        tx1.commit();
        session.close();
    }
}
