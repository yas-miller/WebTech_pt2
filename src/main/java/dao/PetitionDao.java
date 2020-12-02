package dao;

import java.util.List;

import model.entities. Petition;

public interface PetitionDao {
    void create(  Petition  petition );
    Petition find( int id );
    List<Petition> findAll();
    void update(Petition petition);
    void delete (int id);
}
