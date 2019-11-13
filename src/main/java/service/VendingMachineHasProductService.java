package service;

import DAO.DAOImpl.MenuDaoImpl;
import DAO.DAOImpl.VMachineHasProductDaoImpl;
import models.Menu;
import models.VendingMachineHasProduct;

import java.util.List;

public class VendingMachineHasProductService {

    public List<VendingMachineHasProduct> findAllVendingMachineHasProduct() {
        return new VMachineHasProductDaoImpl().findAll();
    }
    public VendingMachineHasProduct findVendingMachineHasProductById(int id) {
        return new VMachineHasProductDaoImpl().findById(id);
    }
    public void createVendingMachineHasProduct(VendingMachineHasProduct vendingMachineHasProduct) {
        new VMachineHasProductDaoImpl().create(vendingMachineHasProduct);
    }
    public void updateVendingMachineHasProduct(VendingMachineHasProduct vendingMachineHasProduct) {
        new VMachineHasProductDaoImpl().update(vendingMachineHasProduct);
    }
    public void deleteVendingMachineHasProduct(VendingMachineHasProduct vendingMachineHasProduct) {
        new VMachineHasProductDaoImpl().delete(vendingMachineHasProduct);
    }
}
