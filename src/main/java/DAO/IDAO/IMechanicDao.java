package DAO.IDAO;

import models.Mechanic;

import java.util.List;

public interface IMechanicDao {
    Mechanic findById (int id);
    List<Mechanic> findAll ();
    void create (Mechanic mechanic);
    void update (Mechanic mechanic);
    void delete (Mechanic mechanic);
}
