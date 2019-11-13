package service;

import DAO.DAOImpl.ManufacturerDaoImpl;
import models.Location;
import models.Manufacturer;

import java.util.List;

public class ManufacturerService {

    public List<Manufacturer> findAllManufacturer() {
        return new ManufacturerDaoImpl().findAll();
    }
    public Manufacturer findManufacturerById(int id) {
        return new ManufacturerDaoImpl().findById(id);
    }
    public void createManufacturer(Manufacturer manufacturer) {
        new ManufacturerDaoImpl().create(manufacturer);
    }
    public void updateManufacturer(Manufacturer manufacturer) {
        new ManufacturerDaoImpl().update(manufacturer);
    }
    public void deleteManufacturer(Manufacturer manufacturer) {
        new ManufacturerDaoImpl().delete(manufacturer);
    }
}
