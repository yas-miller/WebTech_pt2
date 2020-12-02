package dao;

import java.util.List;

import model.entities.Tenant;

public interface TenantDao {
    void create( Tenant tenant );
    Tenant find( int id );
    List<Tenant> findAll();
    void update(Tenant tenant);
    void delete (int id);
    String getNameWithLoginAndPassword(String login, String password);
	public int getId(String login, String password);
}
