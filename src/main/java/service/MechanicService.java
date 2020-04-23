package service;

import DAO.DAOImpl.ManufacturerDaoImpl;
import DAO.DAOImpl.MechanicDaoImpl;
import models.Manufacturer;
import models.Mechanic;

import java.util.List;

public class MechanicService {

    public List<Mechanic> findAllMechanic() {
        return new MechanicDaoImpl().findAll();
    }
    public Mechanic findMechanicById(int id) {
        return new MechanicDaoImpl().findById(id);
    }
    public void createMechanic(Mechanic mechanic) {
        new MechanicDaoImpl().create(mechanic);
    }
    public void updateMechanic(Mechanic mechanic) {
        new MechanicDaoImpl().update(mechanic);
    }
    public void deleteMechanic(Mechanic mechanic) {
        new MechanicDaoImpl().delete(mechanic);
    }
}
