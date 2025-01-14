package model;

public class ServiceLog {
	private int id;
	private int usageId;
	private String computerName;
	private String customerName;
	private int serviceId;
	private String serviceName;
	private int quantity;
	private double total;
	
	public ServiceLog() {
		super();
	}
	
	public ServiceLog(int id, int usageId, int serviceId,int quantity) {
		super();
		this.id = id;
		this.usageId = usageId;
		this.serviceId = serviceId;	
		this.quantity = quantity;

		}
	
	public ServiceLog(int usageId, int serviceId,int quantity) {
		super();
		this.usageId = usageId;
		this.serviceId = serviceId;
		this.quantity = quantity;
		
	}

	
	public ServiceLog(String serviceName, int quantity ,double total) {
		super();
		this.serviceName = serviceName;
		this.quantity = quantity;
		this.total = total;
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

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
	
}
