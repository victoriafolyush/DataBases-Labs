import DAO.DAOImpl.DailyReportDaoImpl;
import models.DailyReport;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {


    public static void main(final String[] args) throws SQLException, ParseException {
        View view = new View();
        view.interactMenu();
    }

}