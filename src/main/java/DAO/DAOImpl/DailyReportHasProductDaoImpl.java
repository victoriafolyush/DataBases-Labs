package DAO.DAOImpl;

import DAO.IDAO.IDailyReportHasProductDao;
import models.DailyReportHasProduct;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DailyReportHasProductDaoImpl implements IDailyReportHasProductDao {

    public DailyReportHasProductDaoImpl() {
    }


    @Override
    public DailyReportHasProduct findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(DailyReportHasProduct.class, id);
    }

    @Override
    public List<DailyReportHasProduct> findAll() {
        List<DailyReportHasProduct> dailyReportHasProductsList = (List<DailyReportHasProduct>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From DailyReportHasProduct ").list();
        return dailyReportHasProductsList;
    }

    @Override
    public void create(DailyReportHasProduct dailyReportHasProduct) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dailyReportHasProduct);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(DailyReportHasProduct dailyReportHasProduct) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(dailyReportHasProduct);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(DailyReportHasProduct dailyReportHasProduct) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(dailyReportHasProduct);
        tx1.commit();
        session.close();
    }

}
