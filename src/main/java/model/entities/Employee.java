package model.entities;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private UtilityWorker utilityWorker;
	
	public Employee() {
	}
	
	public Employee(int id, String name, UtilityWorker utilityWorker) {
		this.id = id;
		this.name = name;
		this.utilityWorker = utilityWorker;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the UtilityWorker
	 */
	public UtilityWorker getUtilityWorker() {
		return utilityWorker;
	}
	/**
	 * @param utilityWorker the UtilityWorker to set
	 */
	public void setUtilityWorker(UtilityWorker utilityWorker) {
		this.utilityWorker = utilityWorker;
	}
}
