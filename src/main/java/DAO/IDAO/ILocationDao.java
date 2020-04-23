package DAO.IDAO;

import models.Location;
import java.util.List;

public interface ILocationDao {
    Location findById (int id);
    List<Location> findAll ();
    void create (Location location);
    void update (Location location);
    void delete (Location location);
}
