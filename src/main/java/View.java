import controller.Controller;
import models.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class View {
    private Controller controller = new Controller();

    public void interactMenu() throws SQLException, ParseException {
        showMenu();
        System.out.println("\n");
        int point = new Scanner(System.in).nextInt();
        switch (point) {
            case 1:
                dailyReportSubMenu();
                break;
            case 2:
                dailyReportHasProductSubMenu();
                break;
            case 3:
                locationSubMenu();
                break;
            case 4:
                manufacturerSubMenu();
                break;
            case 5:
                mechanicSubMenu();
                break;
            case 6:
                menuSubMenu();
                break;
            case 7:
                productSubMenu();
                break;
            case 8:
                vendingMachineSubMenu();
                break;
            case 9:
                vendingMachineHasMenuSubMenu();
                break;
            case 10:
                vendingMachineHasProductSubMenu();
                break;
            case 0:
                break;

            default:
                System.out.println("End..)");
        }

    }

    public void showMenu() {
        System.out.println("\n");
        System.out.println("Choose your menu point:");
        System.out.println("1:  Daily report");
        System.out.println("2:  Daily report has product");
        System.out.println("3:  Location");
        System.out.println("4:  Manufacturer");
        System.out.println("5:  Mechanic");
        System.out.println("6:  Menu");
        System.out.println("7:  Product");
        System.out.println("8:  Vending machine");
        System.out.println("9:  Vending machine has menu");
        System.out.println("10: Vending machine has product");
        System.out.println("0:  Exit");
    }

    public void dailyReportSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Daily Report SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all daily reports:");
        System.out.println("2:  Find daily report by ID:");
        System.out.println("3:  Create new daily report:");
        System.out.println("4:  Update daily report:");
        System.out.println("5:  Delete daily report by ID:");
        System.out.println("0:  Go back to main menu:");


        int point = new Scanner(System.in).nextInt();


        switch (point) {
            case 1:
                System.out.println("All daily reports:");
                for (DailyReport dailyReport : controller.findDailyReportAll()) {
                    System.out.println(dailyReport);
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of report you are looking for: ");
                System.out.println(controller.findDailyReportById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                DailyReport dailyReport;
                dailyReport = new DailyReport();

                System.out.print("Enter time: ");
                dailyReport.setTimeOfReport(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));
                System.out.print("Enter currency from: ");
                dailyReport.setCurrencyLoadedFrom(new Scanner(System.in).nextDouble());
                System.out.print("Enter quantity from: ");
                dailyReport.setQuantityProductLoadedFrom(new Scanner(System.in).nextDouble());
                System.out.print("Enter quantity to: ");
                dailyReport.setQuantityProductLoadedTo(new Scanner(System.in).nextDouble());
                System.out.print("Enter mechanic id: ");
                dailyReport.setMechanicId(new Scanner(System.in).nextInt());
                System.out.print("Enter venching id: ");
                dailyReport.setVendingMachineId(new Scanner(System.in).nextInt());

                controller.createDailyReport(dailyReport);
                interactMenu();
                break;
            case 4:
                dailyReport = new DailyReport();

                System.out.print("Enter id: ");
                dailyReport.setId(new Scanner(System.in).nextInt());
                System.out.print("Enter time: ");
                dailyReport.setTimeOfReport(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));
                System.out.print("Enter currency from: ");
                dailyReport.setCurrencyLoadedFrom(new Scanner(System.in).nextDouble());
                System.out.print("Enter quantity from: ");
                dailyReport.setQuantityProductLoadedFrom(new Scanner(System.in).nextDouble());
                System.out.print("Enter quantity to: ");
                dailyReport.setQuantityProductLoadedTo(new Scanner(System.in).nextDouble());
                System.out.print("Enter mechanic id: ");
                dailyReport.setMechanicId(new Scanner(System.in).nextInt());
                System.out.print("Enter venching id: ");
                dailyReport.setVendingMachineId(new Scanner(System.in).nextInt());

                controller.updateDailyReport(dailyReport);
                interactMenu();
                break;
            case 5:
                dailyReport = new DailyReport();

                System.out.print("Enter id: ");
                dailyReport.setId(new Scanner(System.in).nextInt());
                dailyReport.setTimeOfReport(java.sql.Timestamp.valueOf("2019-09-09 11:11:11"));
                dailyReport.setCurrencyLoadedFrom(100.0);
                dailyReport.setQuantityProductLoadedFrom(100.0);
                dailyReport.setQuantityProductLoadedTo(100.0);
                dailyReport.setMechanicId(2);
                dailyReport.setVendingMachineId(2);

                controller.deleteDailyReport(dailyReport);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void dailyReportHasProductSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Daily Report has Product SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all daily reports has product:");
        System.out.println("2:  Find daily reports has product by ID:");
        System.out.println("3:  Create new daily reports has product:");
        System.out.println("4:  Update daily reports has product by ID:");
        System.out.println("5:  Delete daily reports has product by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();

        switch (point) {
            case 1:
                System.out.println("All daily reports has product:");
                for (DailyReportHasProduct dailyReportHasProduct : controller.findAllDailyReportsHasProduct()) {
                    System.out.println(dailyReportHasProduct);
                }                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of daily reports has product you are looking for: ");
                controller.findDailyReportHasProductById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                DailyReportHasProduct dailyReportHasProduct;

                dailyReportHasProduct = new DailyReportHasProduct();

                System.out.println("Enter the daily report ID: ");
                dailyReportHasProduct.setDailyReportId(new Scanner(System.in).nextInt());
                System.out.println("Enter the product ID: ");
                dailyReportHasProduct.setProductId(new Scanner(System.in).nextInt());
                System.out.println("Enter the quantity product: ");
                dailyReportHasProduct.setQuantityProduct(new Scanner(System.in).nextInt());

                controller.createDailyReportHasProduct(dailyReportHasProduct);
                interactMenu();
                break;
            case 4:
                dailyReportHasProduct = new DailyReportHasProduct();

                System.out.println("Enter the ID: ");
                dailyReportHasProduct.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the daily report ID: ");
                dailyReportHasProduct.setDailyReportId(new Scanner(System.in).nextInt());
                System.out.println("Enter the product ID: ");
                dailyReportHasProduct.setProductId(new Scanner(System.in).nextInt());
                System.out.println("Enter the quantity product: ");
                dailyReportHasProduct.setQuantityProduct(new Scanner(System.in).nextInt());

                controller.updateDailyReportHasProduct(dailyReportHasProduct);
                interactMenu();
                break;
            case 5:
                dailyReportHasProduct = new DailyReportHasProduct();

                System.out.println("Enter the ID of daily reports has product that you want to delete: ");
                dailyReportHasProduct.setId(new Scanner(System.in).nextInt());
                dailyReportHasProduct.setDailyReportId(2);
                dailyReportHasProduct.setProductId(2);
                dailyReportHasProduct.setQuantityProduct(2);
                controller.deleteDailyReportHasProduct(dailyReportHasProduct);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");

        }
    }

    public void locationSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Location SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all locations:");
        System.out.println("2:  Find location by ID:");
        System.out.println("3:  Create new location:");
        System.out.println("4:  Update location by ID:");
        System.out.println("5:  Delete location by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();
        switch (point) {
            case 1:
                System.out.println("All locations:");
                for (Location location : controller.findAllLocation()) {
                    System.out.println(location);
                }                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of location you are looking for: ");
                controller.findLocationById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                Location location;

                location = new Location();

                System.out.println("Enter the country: ");
                location.setCountry(new Scanner(System.in).nextLine());
                System.out.println("Enter the city: ");
                location.setCity(new Scanner(System.in).nextLine());
                System.out.println("Enter the street: ");
                location.setStreet(new Scanner(System.in).nextLine());
                System.out.println("Enter the number: ");
                location.setNumber(new Scanner(System.in).nextLine());
                System.out.println("Enter the X coordinate: ");
                location.setxCoordinate(new Scanner(System.in).nextLine());
                System.out.println("Enter the Y coordinate: ");
                location.setyCoordinate(new Scanner(System.in).nextLine());

                controller.createLocation(location);
                interactMenu();
                break;
            case 4:
                location = new Location();

                System.out.println("Enter the ID: ");
                location.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the country: ");
                location.setCountry(new Scanner(System.in).nextLine());
                System.out.println("Enter the city: ");
                location.setCity(new Scanner(System.in).nextLine());
                System.out.println("Enter the street: ");
                location.setStreet(new Scanner(System.in).nextLine());
                System.out.println("Enter the number: ");
                location.setNumber(new Scanner(System.in).nextLine());
                System.out.println("Enter the X coordinate: ");
                location.setxCoordinate(new Scanner(System.in).nextLine());
                System.out.println("Enter the Y coordinate: ");
                location.setyCoordinate(new Scanner(System.in).nextLine());


                controller.updateLocation(location);
                interactMenu();
                break;
            case 5:
                location = new Location();

                System.out.println("Enter the ID of location that you want to delete: ");
                location.setId(new Scanner(System.in).nextInt());
                location.setCountry("default");
                location.setCity("default");
                location.setStreet("default");
                location.setNumber("default");
                location.setxCoordinate("default");
                location.setyCoordinate("default");
                controller.deleteLocation(location);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void manufacturerSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Manufacturer SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all manufacturers:");
        System.out.println("2:  Find manufacturer by ID:");
        System.out.println("3:  Create new manufacturer:");
        System.out.println("4:  Update manufacturer by ID:");
        System.out.println("5:  Delete manufacturer by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();

        switch (point) {
            case 1:
                System.out.println("All manufacturers:");
                for (Manufacturer manufacturer : controller.findAllManufacturer()) {
                    System.out.println(manufacturer);
                }                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of manufacturer you are looking for: ");
                controller.findManufacturerById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                Manufacturer manufacturer;

                manufacturer = new Manufacturer();

                System.out.println("Enter the name: ");
                manufacturer.setName(new Scanner(System.in).nextLine());
                System.out.println("Enter the country: ");
                manufacturer.setCountry(new Scanner(System.in).nextLine());

                controller.createManufacturer(manufacturer);
                interactMenu();
                break;
            case 4:
                manufacturer = new Manufacturer();

                System.out.println("Enter the ID: ");
                manufacturer.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the name: ");
                manufacturer.setName(new Scanner(System.in).nextLine());
                System.out.println("Enter the country: ");
                manufacturer.setCountry(new Scanner(System.in).nextLine());

                controller.updateManufacturer(manufacturer);
                interactMenu();
                break;
            case 5:
                manufacturer = new Manufacturer();

                System.out.println("Enter the ID of manufacturer that you want to delete: ");
                manufacturer.setId(1);
                manufacturer.setName("default");
                manufacturer.setCountry("default");

                controller.deleteManufacturer(manufacturer);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void mechanicSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Mechanic SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all mechanics:");
        System.out.println("2:  Find mechanic by ID:");
        System.out.println("3:  Create new mechanic:");
        System.out.println("4:  Update mechanic by ID:");
        System.out.println("5:  Delete mechanic by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();

        switch (point) {
            case 1:
                System.out.println("All mechanics:");
                for (Mechanic mechanic : controller.findAllMechanic()) {
                    System.out.println(mechanic);
                }                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of mechanic you are looking for: ");
                controller.findMechanicById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                Mechanic mechanic;

                mechanic = new Mechanic();

                System.out.println("Enter the first name: ");
                mechanic.setFirstName(new Scanner(System.in).nextLine());
                System.out.println("Enter the last name: ");
                mechanic.setLastName(new Scanner(System.in).nextLine());

                controller.createMechanic(mechanic);
                interactMenu();
                break;
            case 4:
                mechanic = new Mechanic();

                System.out.println("Enter the ID: ");
                mechanic.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the first name: ");
                mechanic.setFirstName(new Scanner(System.in).nextLine());
                System.out.println("Enter the last name: ");
                mechanic.setLastName(new Scanner(System.in).nextLine());

                controller.updateMechanic(mechanic);
                interactMenu();
                break;
            case 5:
                mechanic = new Mechanic();

                System.out.println("Enter the ID of mechanic that you want to delete: ");
                mechanic.setId(new Scanner(System.in).nextInt());
                mechanic.setFirstName("default");
                mechanic.setLastName("default");
                controller.deleteMechanic(mechanic);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void menuSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Menu SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all menus:");
        System.out.println("2:  Find menu by ID:");
        System.out.println("3:  Create new menu:");
        System.out.println("4:  Update menu by ID:");
        System.out.println("5:  Delete menu by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();

        switch (point) {
            case 1:
                System.out.println("All menus:");
                for (Menu menu : controller.findAllMenu()) {
                    System.out.println(menu);
                }                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of menu you are looking for: ");
                controller.findMenuById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                Menu menu;
                menu = new Menu();

                System.out.println("Enter the date of creation: ");
                menu.setDateOfCreation(java.sql.Date.valueOf(new Scanner(System.in).nextLine()));

                controller.createMenu(menu);
                interactMenu();
                break;
            case 4:
                menu = new Menu();

                System.out.println("Enter the ID: ");
                menu.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the date in format (yyyy-mm-dd): ");
                menu.setDateOfCreation(java.sql.Date.valueOf(new Scanner(System.in).nextLine()));

                controller.updateMenu(menu);
                interactMenu();
                break;
            case 5:
                menu = new Menu();
                System.out.println("Enter the ID of menu that you want to delete: ");
                menu.setId(new Scanner(System.in).nextInt());
                menu.setDateOfCreation(java.sql.Date.valueOf("2019-09-09"));

                controller.deleteMenu(menu);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void productSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Product SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all products:");
        System.out.println("2:  Find product by ID:");
        System.out.println("3:  Create new product:");
        System.out.println("4:  Update product by ID:");
        System.out.println("5:  Delete product by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();


        switch (point) {
            case 1:
                System.out.println("All products:");
                for (Product product : controller.findAllProduct()) {
                    System.out.println(product);
                }                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of product you are looking for: ");
                controller.findProductById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                Product product;
                product = new Product();

                System.out.println("Enter the name: ");
                product.setName(new Scanner(System.in).nextLine());
                System.out.println("Enter the size: ");
                product.setSize(new Scanner(System.in).nextLine());
                System.out.println("Enter the price: ");
                product.setPrice(new Scanner(System.in).nextDouble());
                System.out.println("Enter the type:");
                product.setType(new Scanner(System.in).nextLine());
                System.out.println("Enter the expiration date:");
                product.setExpirationDate(java.sql.Date.valueOf(new Scanner(System.in).nextLine()));
                System.out.println("Enter the menu ID:");
                product.setMenuId(new Scanner(System.in).nextInt());
                System.out.println("Enter the manufacturer ID:");
                product.setManufacturerId(new Scanner(System.in).nextInt());

                controller.createProduct(product);
                interactMenu();
                break;
            case 4:
                product = new Product();

                System.out.println("Enter the ID: ");
                product.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the name: ");
                product.setName(new Scanner(System.in).nextLine());
                System.out.println("Enter the size: ");
                product.setSize(new Scanner(System.in).nextLine());
                System.out.println("Enter the price: ");
                product.setPrice(new Scanner(System.in).nextDouble());
                System.out.println("Enter the type:");
                product.setType(new Scanner(System.in).nextLine());
                System.out.println("Enter the expiration date:");
                product.setExpirationDate(java.sql.Date.valueOf(new Scanner(System.in).nextLine()));
                System.out.println("Enter the menu ID:");
                product.setMenuId(new Scanner(System.in).nextInt());
                System.out.println("Enter the manufacturer ID:");
                product.setManufacturerId(new Scanner(System.in).nextInt());

                controller.updateProduct(product);
                interactMenu();
                break;
            case 5:
                product = new Product();

                System.out.println("Enter the ID of product that you want to delete: ");
                product.setId(new Scanner(System.in).nextInt());
                product.setName("default");
                product.setSize("default");
                product.setPrice(0.0);
                product.setType("default");
                product.setExpirationDate(java.sql.Date.valueOf("2019-09-09"));
                product.setMenuId(2);
                product.setManufacturerId(2);

                controller.deleteProduct(product);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void vendingMachineSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Vending Machine SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all vending machines:");
        System.out.println("2:  Find vending machine by ID:");
        System.out.println("3:  Create new vending machine:");
        System.out.println("4:  Update vending machine by ID:");
        System.out.println("5:  Delete vending machine by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();

        switch (point) {
            case 1:
                System.out.println("All vending machines:");
                for (VendingMachine vendingMachine : controller.findAllVendingMachine()) {
                    System.out.println(vendingMachine);
                }                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of vending machine you are looking for: ");
                controller.findVendingMachineById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                VendingMachine vendingMachine;
                vendingMachine = new VendingMachine();

                System.out.println("Enter the model: ");
                vendingMachine.setModel(new Scanner(System.in).nextLine());
                System.out.println("Enter the is it empty: ");
                vendingMachine.setIsEmpty(new Scanner(System.in).nextByte());
                System.out.println("Enter the location ID: ");
                vendingMachine.setLocationId(new Scanner(System.in).nextInt());

                controller.createVendingMachine(vendingMachine);
                interactMenu();
                break;
            case 4:
                vendingMachine = new VendingMachine();

                System.out.println("Enter the ID: ");
                vendingMachine.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the model: ");
                vendingMachine.setModel(new Scanner(System.in).nextLine());
                System.out.println("Enter the is it empty: ");
                vendingMachine.setIsEmpty(new Scanner(System.in).nextByte());
                System.out.println("Enter the location ID: ");
                vendingMachine.setLocationId(new Scanner(System.in).nextInt());

                controller.updateVendingMachine(vendingMachine);
                interactMenu();
                break;
            case 5:
                vendingMachine = new VendingMachine();

                System.out.println("Enter the ID of vending machine that you want to delete: ");
                vendingMachine.setId(new Scanner(System.in).nextInt());
                vendingMachine.setModel("default");
                vendingMachine.setIsEmpty((byte) 0);
                vendingMachine.setLocationId(2);

                controller.deleteVendingMachine(vendingMachine);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void vendingMachineHasMenuSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Vending Machine Has Menu SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all vending machines has menus:");
        System.out.println("2:  Find vending machine has menu by ID:");
        System.out.println("3:  Create new vending machine has menu:");
        System.out.println("4:  Update vending machine has menu by ID:");
        System.out.println("5:  Delete vending machine has menu by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();


        switch (point) {
            case 1:
                System.out.println("All vending machines has menus:");
                for (VendingMachineHasMenu vendingMachineHasMenu : controller.findAllVendingMachineHasMenu()) {
                    System.out.println(vendingMachineHasMenu);
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of vending machine has menu you are looking for: ");
                controller.findVendingMachineHasMenuById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                VendingMachineHasMenu vendingMachineHasMenu;
                vendingMachineHasMenu = new VendingMachineHasMenu();

                System.out.println("Enter the vending machine ID: ");
                vendingMachineHasMenu.setVendingMachineId(new Scanner(System.in).nextInt());
                System.out.println("Enter the menu ID: ");
                vendingMachineHasMenu.setMenuId(new Scanner(System.in).nextInt());

                controller.createVendingMachineHasMenu(vendingMachineHasMenu);
                interactMenu();
                break;
            case 4:
                vendingMachineHasMenu = new VendingMachineHasMenu();

                System.out.println("Enter the ID: ");
                vendingMachineHasMenu.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the vending machine ID: ");
                vendingMachineHasMenu.setVendingMachineId(new Scanner(System.in).nextInt());
                System.out.println("Enter the menu ID: ");
                vendingMachineHasMenu.setMenuId(new Scanner(System.in).nextInt());

                controller.updateVendingMachineHasMenu(vendingMachineHasMenu);
                interactMenu();
                break;
            case 5:
                vendingMachineHasMenu = new VendingMachineHasMenu();

                System.out.println("Enter the ID of vending machine has menu that you want to delete: ");
                vendingMachineHasMenu.setId(new Scanner(System.in).nextInt());
                vendingMachineHasMenu.setVendingMachineId(2);
                vendingMachineHasMenu.setMenuId(2);

                controller.deleteVendingMachineHasMenu(vendingMachineHasMenu);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void vendingMachineHasProductSubMenu() throws SQLException, ParseException {
        System.out.println("\n");
        System.out.println("Welcome to the Vending Machine Has Product SubMenu!");
        System.out.println("Enter what you want to do now: ");

        System.out.println("1:  Find all vending machines has products:");
        System.out.println("2:  Find vending machine has product by ID:");
        System.out.println("3:  Create new vending machine has product:");
        System.out.println("4:  Update vending machine has product by ID:");
        System.out.println("5:  Delete vending machine has product by ID:");
        System.out.println("0:  Go back to main menu:");

        int point = new Scanner(System.in).nextInt();


        switch (point) {
            case 1:
                System.out.println("All vending machines has products:");
                for (VendingMachineHasProduct vendingMachineHasProduct : controller.findAllVendingMachineHasProduct()) {
                    System.out.println(vendingMachineHasProduct);
                }                interactMenu();
                break;
            case 2:
                System.out.println("Enter the ID of vending machine has product you are looking for: ");
                controller.findVendingMachineHasProductById(new Scanner(System.in).nextInt());
                interactMenu();
                break;
            case 3:
                VendingMachineHasProduct vendingMachineHasProduct;
                vendingMachineHasProduct = new VendingMachineHasProduct();

                System.out.println("Enter the vending machine ID: ");
                vendingMachineHasProduct.setVendingMachineId(new Scanner(System.in).nextInt());
                System.out.println("Enter the product ID: ");
                vendingMachineHasProduct.setProductId(new Scanner(System.in).nextInt());
                System.out.println("Enter the sold time: ");
                vendingMachineHasProduct.setSoldTime(java.sql.Time.valueOf(new Scanner(System.in).nextLine()));

                controller.createVendingMachineHasProduct(vendingMachineHasProduct);
                interactMenu();
                break;
            case 4:
                vendingMachineHasProduct = new VendingMachineHasProduct();

                System.out.println("Enter the ID: ");
                vendingMachineHasProduct.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter the vending machine ID: ");
                vendingMachineHasProduct.setVendingMachineId(new Scanner(System.in).nextInt());
                System.out.println("Enter the product ID: ");
                vendingMachineHasProduct.setProductId(new Scanner(System.in).nextInt());
                System.out.println("Enter the sold time: ");
                vendingMachineHasProduct.setSoldTime(java.sql.Time.valueOf(new Scanner(System.in).nextLine()));

                controller.updateVendingMachineHasProduct(vendingMachineHasProduct);
                interactMenu();
                break;
            case 5:
                vendingMachineHasProduct = new VendingMachineHasProduct();

                System.out.println("Enter the ID of vending machine has product that you want to delete: ");
                vendingMachineHasProduct.setId(new Scanner(System.in).nextInt());
                vendingMachineHasProduct.setVendingMachineId(2);
                vendingMachineHasProduct.setProductId(2);
                vendingMachineHasProduct.setSoldTime(java.sql.Time.valueOf("09:09:09"));

                controller.deleteVendingMachineHasProduct(vendingMachineHasProduct);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}
