package DAO.IDAO;

import models.DailyReport;
import java.util.List;

public interface IDailyReportDao {

    DailyReport findById (int id);
    List<DailyReport> findAll ();
    void create (DailyReport dailyReport);
    void update (DailyReport dailyReport);
    void delete (DailyReport dailyReport);

}
