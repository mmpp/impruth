package org.mmpp.impruth.model;

// Generated 2011/02/24 21:32:15 by Hibernate Tools 3.4.0.CR1

/**
 * OwnBook generated by hbm2java
 */
public class OwnBook implements java.io.Serializable {

	private int userId;
	private int releaseId;

	public OwnBook() {
	}

	public OwnBook(int userId, int releaseId) {
		this.userId = userId;
		this.releaseId = releaseId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReleaseId() {
		return this.releaseId;
	}

	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}

}
