package model;

public class ServiceLog {
	private int id;
	private int usageId;
	private int serviceId;
	public ServiceLog(int id, int usageId, int serviceId) {
		super();
		this.id = id;
		this.usageId = usageId;
		this.serviceId = serviceId;
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
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
}
