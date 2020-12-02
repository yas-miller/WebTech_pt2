package model.entities;

import java.io.Serializable;

public class Petition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private ExpressService expressService;//נמה נאבמע
	private ScaleWork scaleWork;//לאסרעאב נאבמע
	private long time;
	private int idTenant;
	
	public Petition(int id, ExpressService expressService, ScaleWork scaleWork,
					long time, int idTenant) {
		this.id = id;
		this.expressService = expressService;
		this.scaleWork = scaleWork;
		this.time = time;
		this.idTenant = idTenant;
	}

	public Petition() {}
	
	/**
	 * @return the idTenant
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
	 * @return the ExpressService
	 */
	public int getIdTenant() {
		return idTenant;
	}
	/**
	 * @param idTenant the idTenant to set
	 */
	public void setIdTenant(int idTenant) {
		this.idTenant = idTenant;
	}
	/**
	 * @return the id
	 */
	public ExpressService getExpressService() {
		return expressService;
	}
	/**
	 * @param expressService the ExpressService to set
	 */
	public void setExpressService(ExpressService expressService) {
		this.expressService = expressService;
	}
	/**
	 * @return the ScaleWork
	 */
	public ScaleWork getScaleWork() {
		return scaleWork;
	}
	/**
	 * @param scaleWork the ScaleWork to set
	 */
	public void setScaleWork(ScaleWork scaleWork) {
		this.scaleWork = scaleWork;
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
	
}
