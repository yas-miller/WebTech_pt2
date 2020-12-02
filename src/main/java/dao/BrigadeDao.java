package dao;

import java.util.List;

import model.entities.Brigade;

public interface BrigadeDao {
    void create(  Brigade  brigade );
    Brigade find( int id );
    List<Brigade> findAll();
    void update(int id, Brigade brigade);
    void delete (int id);
}
