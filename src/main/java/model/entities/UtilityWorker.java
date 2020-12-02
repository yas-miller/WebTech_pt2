package model.entities;

public enum UtilityWorker {//коммунальный работник
	SANITARY_TECHNICIAN(2700000), ELECTRICIAN(3600000), JOINER(1800000), DISPATCHER(0);
	
	private int timeForWork;

	private UtilityWorker(int timeForWork) {
		this.timeForWork = timeForWork;
	}

	/**
	 * @return the timeForWork
	 */
	public int getTimeForWork() {
		return timeForWork;
	}

	/**
	 * @param timeForWork the timeForWork to set
	 */
	public void setTimeForWork(int timeForWork) {
		this.timeForWork = timeForWork;
	}
}
