package DAO.IDAO;

import models.VendingMachine;

import java.util.List;

public interface IVendingMachineDao {
    VendingMachine findById (int id);
    List<VendingMachine> findAll ();
    void create (VendingMachine vendingMachine);
    void update (VendingMachine vendingMachine);
    void delete (VendingMachine vendingMachine);
}
