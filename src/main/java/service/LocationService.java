package service;

import DAO.DAOImpl.DailyReportDaoImpl;
import DAO.DAOImpl.LocationDaoImpl;
import com.sun.xml.internal.stream.events.LocationImpl;
import models.DailyReport;
import models.Location;

import java.util.List;

public class LocationService {

    public List<Location> findAllLocation() {
        return new LocationDaoImpl().findAll();
    }
    public Location findLocationById(int id) {
        return new LocationDaoImpl().findById(id);
    }
    public void createLocation(Location location) {
        new LocationDaoImpl().create(location);
    }
    public void updateLocation(Location location) {
        new LocationDaoImpl().update(location);
    }
    public void deleteLocation(Location location) {
        new LocationDaoImpl().delete(location);
    }
}
