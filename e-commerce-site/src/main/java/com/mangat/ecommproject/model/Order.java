package com.mangat.ecommproject.model;

public class Order extends Product{
	private int orderId;
	private int uid;
	private int quantity;
	private String odate;
	public Order(String pdtname, String pdtcategory, int pdtprice) {
		super(pdtname, pdtcategory, pdtprice);
		
	}
	public Order(int orderId, int uid, int quantity, String odate) {
		
		this.orderId = orderId;
		this.uid = uid;
		this.quantity = quantity;
		this.odate = odate;
	}
	public Order() {
		
	}
	public Order(int uid, int quantity, String odate) {
		
		this.uid = uid;
		this.quantity = quantity;
		this.odate = odate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", uid=" + uid + ", quantity=" + quantity + ", odate=" + odate + "]";
	}
	
	
	
}
