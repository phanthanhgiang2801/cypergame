
package model;

public class Computer {
    private int id;
    private String name;
    private int status;
    private String statusName;
    private double cost;
    private String customerName;
    
    
	public Computer(int id, String name, int status, String statusName, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.statusName = statusName;
		this.cost = cost;
		
	}
	
	public Computer(int id, String name, int status, String statusName, double cost, String customerName) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.statusName = statusName;
		this.cost = cost;
		this.customerName = customerName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
     
    
    
}


