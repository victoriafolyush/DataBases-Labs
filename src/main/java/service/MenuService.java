package service;

import DAO.DAOImpl.ManufacturerDaoImpl;
import DAO.DAOImpl.MenuDaoImpl;
import models.Manufacturer;
import models.Menu;

import java.util.List;

public class MenuService {

    public List<Menu> findAllMenu() {
        return new MenuDaoImpl().findAll();
    }
    public Menu findMenuById(int id) {
        return new MenuDaoImpl().findById(id);
    }
    public void createMenu(Menu menu) {
        new MenuDaoImpl().create(menu);
    }
    public void updateMenu(Menu menu) {
        new MenuDaoImpl().update(menu);
    }
    public void deleteMenu(Menu menu) {
        new MenuDaoImpl().delete(menu);
    }
}
