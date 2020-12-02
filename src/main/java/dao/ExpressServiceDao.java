package dao;

import java.util.List;

import model.entities.ExpressService;

public interface ExpressServiceDao {
    void create(  ExpressService expressService );
    ExpressService find(int id );
    int find(String name);
    List<ExpressService> findAll();
    void delete(int id);
}
