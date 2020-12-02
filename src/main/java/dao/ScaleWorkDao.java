package dao;

import java.util.List;

import model.entities.ScaleWork;

public interface ScaleWorkDao {
    void create(  ScaleWork scaleWork );
    ScaleWork find(int id );
    int find(String name);
    List<ScaleWork> findAll();
    void delete (int id);
}
