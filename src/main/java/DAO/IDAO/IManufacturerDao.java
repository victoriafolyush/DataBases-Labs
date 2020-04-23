package DAO.IDAO;

import models.Location;
import models.Manufacturer;

import java.sql.SQLException;
import java.util.List;

public interface IManufacturerDao {
    Manufacturer findById (int id);
    List<Manufacturer> findAll ();
    void create (Manufacturer manufacturer);
    void update (Manufacturer manufacturer);
    void delete (Manufacturer manufacturer);
}
