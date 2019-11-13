package DAO.IDAO;

import models.VendingMachineHasMenu;

import java.util.List;

public interface IVMachineHasMenuDao {
    VendingMachineHasMenu findById (int id);
    List<VendingMachineHasMenu> findAll ();
    void create (VendingMachineHasMenu vendingMachineHasMenu);
    void update (VendingMachineHasMenu vendingMachineHasMenu);
    void delete (VendingMachineHasMenu vendingMachineHasMenu);

}
