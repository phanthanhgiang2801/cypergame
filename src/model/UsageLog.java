package model;

import java.util.Date;

public class UsageLog {
	private int id;
	private int customerId;
	private String customerName;
	private int computerId;
	private String computerName;
	private Date startTime;
	private Date endTime;
	
	public UsageLog() {};
	public UsageLog(int id, int customerId, int computerId, Date startTime, Date endTime) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.computerId = computerId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public UsageLog(int id, int customerId, String customerName, int computerId, String computerName, Date startTime,
			Date endTime) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.computerId = computerId;
		this.computerName = computerName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public UsageLog(int customerId, int computerId, Date startTime) {
		super();
		this.customerId = customerId;
		this.computerId = computerId;
		this.startTime = startTime;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	
	
}
