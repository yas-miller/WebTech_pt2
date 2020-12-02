package model.entities;

import java.io.Serializable;

public class Work implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private long time;
	private String address;
	private int idPetition;
	private int idBrigade;
	
	public Work() {}
	
	public Work(int id, long time, String address, int idPetition,
				int idBrigade) {
		this.id = id;
		this.time = time;
		this.address = address;
		this.idPetition = idPetition;
		this.idBrigade = idBrigade;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the idPetition
	 */
	public int getIdPetition() {
		return idPetition;
	}
	/**
	 * @param idPetition the idPetition to set
	 */
	public void setIdPetition(int idPetition) {
		this.idPetition = idPetition;
	}
	/**
	 * @return the idBrigade
	 */
	public int getIdBrigade() {
		return idBrigade;
	}
	/**
	 * @param idBrigade the idBrigade to set
	 */
	public void setIdBrigade(int idBrigade) {
		this.idBrigade = idBrigade;
	}
	
}
