package model;

public class Customer {
	private int id;
	private int phonenumber;
	private String name;
	
	public Customer() {
	}
	public Customer(int id, int phonenumber, String name) {
		this.id = id;
		this.phonenumber = phonenumber;
		this.name = name;
	}
	
	public Customer(int phonenumber, String name) {
		this.phonenumber = phonenumber;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   
}
