package model;

import java.util.Date;

public class UsageLog {
	private int id;
	private int customerId;
	private int computerId;
	private Date startTime;
	private Date endTime;
	public UsageLog(int id, int customerId, int computerId, Date startTime, Date endTime) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.computerId = computerId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getComputerId() {
		return computerId;
	}
	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
