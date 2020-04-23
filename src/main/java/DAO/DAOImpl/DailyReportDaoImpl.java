package DAO.DAOImpl;

import DAO.IDAO.IDailyReportDao;

import com.mysql.cj.Query;
import models.DailyReport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DailyReportDaoImpl implements IDailyReportDao {

    public DailyReportDaoImpl() {

    }

    @Override
    public DailyReport findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(DailyReport.class, id);
    }

    @Override
    public List<DailyReport> findAll() {
        List<DailyReport> dailyReportList = (List<DailyReport>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From DailyReport").list();
        return dailyReportList;
    }

    @Override
    public void create(DailyReport dailyReport) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dailyReport);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(DailyReport dailyReport) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(dailyReport);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(DailyReport dailyReport) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(dailyReport);
        tx1.commit();
        session.close();
    }
}
