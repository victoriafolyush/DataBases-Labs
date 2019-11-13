package service;

import DAO.DAOImpl.MenuDaoImpl;
import DAO.DAOImpl.VendingMachineDaoImpl;
import models.Menu;
import models.VendingMachine;

import java.util.List;

public class VendingMachineService {

    public List<VendingMachine> findAllVendingMachine() {
        return new VendingMachineDaoImpl().findAll();
    }
    public VendingMachine findVendingMachineById(int id) {
        return new VendingMachineDaoImpl().findById(id);
    }
    public void createVendingMachine(VendingMachine vendingMachine) {
        new VendingMachineDaoImpl().create(vendingMachine);
    }
    public void updateVendingMachine(VendingMachine vendingMachine) {
        new VendingMachineDaoImpl().update(vendingMachine);
    }
    public void deleteVendingMachine(VendingMachine vendingMachine) {
        new VendingMachineDaoImpl().delete(vendingMachine);
    }
}
