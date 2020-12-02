package dao;

import java.util.List;

import model.entities.UtilityWorker;

public interface UtilityWorkerDao {
    void create(  UtilityWorker utilityWorker );
    UtilityWorker find(int id );
    int find( String name );
    List<UtilityWorker> findAll();
    void delete (int id);
}
