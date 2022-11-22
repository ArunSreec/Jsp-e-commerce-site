package com.mangat.ecommproject.model;

public class Product {
	private int pid;
	private String pdtname;
	private String pdtcategory;
	private int pdtprice;
	private String pdtimage;
	
	
	public Product() {
		
	}


	public Product(String pdtname, String pdtcategory, int pdtprice) {
		
		
		this.pdtname = pdtname;
		this.pdtcategory = pdtcategory;
		this.pdtprice = pdtprice;
		
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPdtname() {
		return pdtname;
	}


	public void setPdtname(String pdtname) {
		this.pdtname = pdtname;
	}


	public String getPdtcategory() {
		return pdtcategory;
	}


	public void setPdtcategory(String pdtcategory) {
		this.pdtcategory = pdtcategory;
	}


	public int getPdtprice() {
		return pdtprice;
	}


	public void setPdtprice(int pdtprice) {
		this.pdtprice = pdtprice;
	}


	public String getPdtimage() {
		return pdtimage;
	}


	public void setPdtimage(String pdtimage) {
		this.pdtimage = pdtimage;
	}


	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pdtname=" + pdtname + ", pdtcategory=" + pdtcategory + ", pdtprice="
				+ pdtprice + ", pdtimage=" + pdtimage + "]";
	}
	
	
}
