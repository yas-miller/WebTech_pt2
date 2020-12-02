package model.entities;

public enum ScaleWork {
PART_OF_THE_ROOM(1), ROOM(2), FLAT(3);

	private int scaleOfWork;

	private ScaleWork(int scaleOfWork) {
		this.scaleOfWork = scaleOfWork;
	}

	/**
	 * @return the scale
	 */
	public int getScaleOfWork() {
		return scaleOfWork;
	}

	/**
	 * @param scaleOfWork the scale to set
	 */
	public void setScaleOfWork(int scaleOfWork) {
		this.scaleOfWork = scaleOfWork;
	}
}
