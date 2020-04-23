package controller;

import DAO.DAOImpl.*;
import models.*;
import service.*;

import java.util.List;

public class Controller {

    private DailyReportService dailyReportService;
    private DailyReportHasProductService dailyReportHasProductService;
    private LocationService locationService;
    private ManufacturerService manufacturerService;
    private MechanicService mechanicService;
    private MenuService menuService;
    private ProductService productService;
    private VendingMachineService vendingMachineService;
    private VendingMachineHasMenuService vendingMachineHasMenuService;
    private VendingMachineHasProductService vendingMachineHasProductService;


    public Controller() {
        dailyReportService = new DailyReportService();
        dailyReportHasProductService = new DailyReportHasProductService();
        locationService = new LocationService();
        manufacturerService = new ManufacturerService();
        mechanicService = new MechanicService();
        menuService = new MenuService();
        productService = new ProductService();
        vendingMachineService = new VendingMachineService();
        vendingMachineHasMenuService = new VendingMachineHasMenuService();
        vendingMachineHasProductService = new VendingMachineHasProductService();
    }

    public DailyReport findDailyReportById(Integer id) {
        return dailyReportService.findDailyReportById(id);
    }
    public List<DailyReport> findDailyReportAll() {
        return dailyReportService.findAllDailyReports();
    }
    public void createDailyReport(DailyReport dailyReport) {
        dailyReportService.createDailyReport(dailyReport);
    }
    public void updateDailyReport(DailyReport dailyReport) {
        dailyReportService.updateDailyReport(dailyReport);
    }
    public void deleteDailyReport(DailyReport dailyReport) {
        dailyReportService.deleteDailyReport(dailyReport);

    }


    public DailyReportHasProduct findDailyReportHasProductById(int id){return dailyReportHasProductService.findDailyReportHasProductById(id);}
    public List<DailyReportHasProduct> findAllDailyReportsHasProduct(){return  dailyReportHasProductService.findAllDailyReportsHasProduct();}
    public void createDailyReportHasProduct(DailyReportHasProduct dailyReportHasProduct){dailyReportHasProductService.createDailyReportHasProduct(dailyReportHasProduct);}
    public void updateDailyReportHasProduct(DailyReportHasProduct dailyReportHasProduct){dailyReportHasProductService.updateDailyReportHasProduct(dailyReportHasProduct);}
    public void deleteDailyReportHasProduct(DailyReportHasProduct dailyReportHasProduct){
        dailyReportHasProductService.deleteDailyReportHasProduct(dailyReportHasProduct);
    }


    public Location findLocationById (int id){return locationService.findLocationById(id);}
    public List<Location> findAllLocation (){return locationService.findAllLocation();}
    public void createLocation (Location location){locationService.createLocation(location);}
    public void updateLocation (Location location){locationService.updateLocation(location);}
    public void deleteLocation (Location location){locationService.deleteLocation(location);}


    public Manufacturer findManufacturerById(int id) {
        return manufacturerService.findManufacturerById(id);
    }
    public List<Manufacturer> findAllManufacturer() {
        return manufacturerService.findAllManufacturer();
    }
    public void createManufacturer(Manufacturer manufacturer) {
        manufacturerService.createManufacturer(manufacturer);
    }
    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerService.updateManufacturer(manufacturer);
    }
    public void deleteManufacturer(Manufacturer manufacturer) {
        manufacturerService.deleteManufacturer(manufacturer);
    }



    public Mechanic findMechanicById(int id) {
        return mechanicService.findMechanicById(id);
    }
    public List<Mechanic> findAllMechanic() {
        return mechanicService.findAllMechanic();
    }
    public void createMechanic(Mechanic mechanic) {
        mechanicService.createMechanic(mechanic);    }
    public void updateMechanic(Mechanic mechanic) {
        mechanicService.updateMechanic(mechanic);    }
    public void deleteMechanic(Mechanic mechanic) {
        mechanicService.deleteMechanic(mechanic);
    }


    public Menu findMenuById(int id) {
        return menuService.findMenuById(id);
    }
    public List<Menu> findAllMenu() {
       return menuService.findAllMenu();
    }
    public void createMenu(Menu menu) {
        menuService.createMenu(menu);
    }
    public void updateMenu(Menu menu) {
        menuService.updateMenu(menu);
    }
    public void deleteMenu(Menu menu) {
        menuService.deleteMenu(menu);
    }


    public Product findProductById(int id) {
        return productService.findProductById(id);
    }
    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }
    public void createProduct(Product product) {
        productService.createProduct(product);
    }
    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }
    public void deleteProduct(Product product) {
        productService.deleteProduct(product);
    }


    public VendingMachine findVendingMachineById(int id) {
        return vendingMachineService.findVendingMachineById(id);
    }
    public List<VendingMachine> findAllVendingMachine() {
        return vendingMachineService.findAllVendingMachine();
    }
    public void createVendingMachine(VendingMachine vendingMachine) {
        vendingMachineService.createVendingMachine(vendingMachine);
    }
    public void updateVendingMachine(VendingMachine vendingMachine) {
        vendingMachineService.updateVendingMachine(vendingMachine);
    }
    public void deleteVendingMachine(VendingMachine vendingMachine) {
        vendingMachineService.deleteVendingMachine(vendingMachine);
    }


    public VendingMachineHasMenu findVendingMachineHasMenuById(int id) {
        return vendingMachineHasMenuService.findVendingMachineHasMenuById(id);
    }
    public List<VendingMachineHasMenu> findAllVendingMachineHasMenu() {
return vendingMachineHasMenuService.findAllVendingMachineHasMenu();
    }
    public void createVendingMachineHasMenu(VendingMachineHasMenu vendingMachineHasMenu) {
        vendingMachineHasMenuService.createVendingMachineHasMenu(vendingMachineHasMenu);    }
    public void updateVendingMachineHasMenu(VendingMachineHasMenu vendingMachineHasMenu) {
        vendingMachineHasMenuService.updateVendingMachineHasMenu(vendingMachineHasMenu);
    }
    public void deleteVendingMachineHasMenu(VendingMachineHasMenu vendingMachineHasMenu) {
        vendingMachineHasMenuService.deleteVendingMachineHasMenu(vendingMachineHasMenu);
    }


    public List<VendingMachineHasProduct> findAllVendingMachineHasProduct() {
        return vendingMachineHasProductService.findAllVendingMachineHasProduct();
    }
    public VendingMachineHasProduct findVendingMachineHasProductById(int id) {
        return vendingMachineHasProductService.findVendingMachineHasProductById(id);
    }
    public void createVendingMachineHasProduct(VendingMachineHasProduct vendingMachineHasProduct) {
        vendingMachineHasProductService.createVendingMachineHasProduct(vendingMachineHasProduct);
    }
    public void updateVendingMachineHasProduct(VendingMachineHasProduct vendingMachineHasProduct) {
        vendingMachineHasProductService.updateVendingMachineHasProduct(vendingMachineHasProduct);
    }
    public void deleteVendingMachineHasProduct(VendingMachineHasProduct vendingMachineHasProduct) {
        vendingMachineHasProductService.deleteVendingMachineHasProduct(vendingMachineHasProduct);
    }

}
