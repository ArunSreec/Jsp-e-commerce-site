package com.mangat.ecommproject.model;

public class Bill extends Order{
	
	public Bill() {
		
	}
	private String bname;
	private String bAddress;
	private String bphonenumber;
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getbAddress() {
		return bAddress;
	}
	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}
	public String getBphonenumber() {
		return bphonenumber;
	}
	public void setBphonenumber(String bphonenumber) {
		this.bphonenumber = bphonenumber;
	}
	public Bill(int orderId, int uid, int quantity, String odate, String bname, String bAddress, String bphonenumber) {
		super(orderId, uid, quantity, odate);
		this.bname = bname;
		this.bAddress = bAddress;
		this.bphonenumber = bphonenumber;
	}
	public Bill(int orderId, int uid, int quantity, String odate) {
		super(orderId, uid, quantity, odate);
	}
	
	
	

}
