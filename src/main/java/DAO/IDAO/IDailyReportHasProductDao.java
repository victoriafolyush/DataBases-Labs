package DAO.IDAO;

import models.DailyReportHasProduct;


import java.util.List;

public interface IDailyReportHasProductDao {

    DailyReportHasProduct findById (int id);
    List<DailyReportHasProduct> findAll ();
    void create (DailyReportHasProduct dailyReportHasProduct);
    void update (DailyReportHasProduct dailyReportHasProduct);
    void delete (DailyReportHasProduct dailyReportHasProduct);
}
