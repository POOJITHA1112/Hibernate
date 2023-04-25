package com.entity;

import javax.persistence.Embeddable;

@Embeddable
public class LeaveTracker {
	
	private int id;
	
	private int sickleaves;
	
	private int earnedLeaves;
	
	private int maternityLeave;
	
	private int emergencyLeaves;
	
	public LeaveTracker() {

	}

	public LeaveTracker(int sickleaves, int earnedLeaves, int maternityLeave, int emergencyLeaves) {
		super();
		this.sickleaves = sickleaves;
		this.earnedLeaves = earnedLeaves;
		this.maternityLeave = maternityLeave;
		this.emergencyLeaves = emergencyLeaves;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSickleaves() {
		return sickleaves;
	}

	public void setSickleaves(int sickleaves) {
		this.sickleaves = sickleaves;
	}

	public int getEarnedLeaves() {
		return earnedLeaves;
	}

	public void setEarnedLeaves(int earnedLeaves) {
		this.earnedLeaves = earnedLeaves;
	}

	public int getMaternityLeave() {
		return maternityLeave;
	}

	public void setMaternityLeave(int maternityLeave) {
		this.maternityLeave = maternityLeave;
	}

	public int getEmergencyLeaves() {
		return emergencyLeaves;
	}

	public void setEmergencyLeaves(int emergencyLeaves) {
		this.emergencyLeaves = emergencyLeaves;
	}

	
	
	

}
