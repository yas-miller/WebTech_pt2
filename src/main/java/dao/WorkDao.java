package dao;

import java.util.List;

import model.entities.Work;

public interface WorkDao {
    void create(  Work  work );
    Work find( int id );
    List<Work> findAll();
    void update(int id, Work work);
    void delete (int id);
}
