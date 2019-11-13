package DAO.IDAO;

import models.VendingMachineHasMenu;
import models.VendingMachineHasProduct;

import java.util.List;

public interface IVMachineHasProductDao {
    VendingMachineHasProduct findById (int id);
    List<VendingMachineHasProduct> findAll ();
    void create (VendingMachineHasProduct vendingMachineHasProduct);
    void update (VendingMachineHasProduct vendingMachineHasProduct);
    void delete (VendingMachineHasProduct vendingMachineHasProduct);
}
