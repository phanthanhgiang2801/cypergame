package model;

import java.util.Date;


public class Payment {
	private int id;
	private int usageId;
	private Date paymentDate;
	private double amount;
	public Payment(int id, int usageId, Date paymentDate, double amount) {
		super();
		this.id = id;
		this.usageId = usageId;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	public Payment() {};
	
	public Payment(int usageId, Date paymentDate, double amount) {
		super();
		this.usageId = usageId;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsageId() {
		return usageId;
	}
	public void setUsageId(int usageId) {
		this.usageId = usageId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
