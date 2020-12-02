package model.entities;

import java.io.Serializable;

public class Brigade implements Serializable{ // бригада
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int idEmployee;
	
	public Brigade() {
	}

	public Brigade(int id, int idEmployee) {
		this.id = id;
		this.idEmployee = idEmployee;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idEmployee;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brigade other = (Brigade) obj;
		if (id != other.id)
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		return true;
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
	 * @return the idEmployee
	 */
	public int getIdEmployee() {
		return idEmployee;
	}

	/**
	 * @param idEmployee the idEmployee to set
	 */
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	
}
