package service;

import DAO.DAOImpl.DailyReportHasProductDaoImpl;
import models.DailyReportHasProduct;

import java.util.List;

public class DailyReportHasProductService {
    public List<DailyReportHasProduct> findAllDailyReportsHasProduct() {
        return new DailyReportHasProductDaoImpl().findAll();
    }
    public DailyReportHasProduct findDailyReportHasProductById(int id) {
        return new DailyReportHasProductDaoImpl().findById(id);
    }
    public void createDailyReportHasProduct(DailyReportHasProduct dailyReportHasProduct) {
        new DailyReportHasProductDaoImpl().create(dailyReportHasProduct);
    }
    public void updateDailyReportHasProduct(DailyReportHasProduct dailyReportHasProduct) {
        new DailyReportHasProductDaoImpl().update(dailyReportHasProduct);
    }
    public void deleteDailyReportHasProduct(DailyReportHasProduct dailyReportHasProduct) {
        new DailyReportHasProductDaoImpl().delete(dailyReportHasProduct);
    }
}
