package service;

import DAO.DAOImpl.MenuDaoImpl;
import DAO.DAOImpl.VMachineHasMenuDaoImpl;
import models.Menu;
import models.VendingMachine;
import models.VendingMachineHasMenu;

import java.util.List;

public class VendingMachineHasMenuService {

    public List<VendingMachineHasMenu> findAllVendingMachineHasMenu() {
        return new VMachineHasMenuDaoImpl().findAll();
    }
    public VendingMachineHasMenu findVendingMachineHasMenuById(int id) {
        return new VMachineHasMenuDaoImpl().findById(id);
    }
    public void createVendingMachineHasMenu(VendingMachineHasMenu vendingMachineHasMenu) {
        new VMachineHasMenuDaoImpl().create(vendingMachineHasMenu);
    }
    public void updateVendingMachineHasMenu(VendingMachineHasMenu vendingMachineHasMenu) {
        new VMachineHasMenuDaoImpl().update(vendingMachineHasMenu);
    }
    public void deleteVendingMachineHasMenu(VendingMachineHasMenu vendingMachineHasMenu) {
        new VMachineHasMenuDaoImpl().delete(vendingMachineHasMenu);
    }
}
