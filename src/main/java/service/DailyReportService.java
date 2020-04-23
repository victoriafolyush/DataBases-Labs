package service;

import DAO.DAOImpl.DailyReportDaoImpl;
import models.DailyReport;

import java.util.List;

public class DailyReportService {
    public List<DailyReport> findAllDailyReports() {
    return new DailyReportDaoImpl().findAll();
}
    public DailyReport findDailyReportById(int id) {
        return new DailyReportDaoImpl().findById(id);
    }
    public void createDailyReport(DailyReport dailyReport) {
        new DailyReportDaoImpl().create(dailyReport);
    }
    public void updateDailyReport(DailyReport dailyReport) {
        new DailyReportDaoImpl().update(dailyReport);
    }
    public void deleteDailyReport(DailyReport dailyReport) {
        new DailyReportDaoImpl().delete(dailyReport);
    }

}
