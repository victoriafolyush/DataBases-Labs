package DAO.IDAO;

import models.Location;
import models.Menu;

import java.sql.SQLException;
import java.util.List;

public interface IMenuDao {
    Menu findById (int id);
    List<Menu> findAll ();
    void create (Menu menu);
    void update (Menu menu);
    void delete (Menu menu);
}
