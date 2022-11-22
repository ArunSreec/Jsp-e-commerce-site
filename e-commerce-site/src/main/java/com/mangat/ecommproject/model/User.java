package com.mangat.ecommproject.model;

public class User {
	private int id;
	
	private String usrname;
	private String usremail;
	private String passwrd;
	private String address;
	
	private String phonenumber;
	public User() {
		
	}
	public User(int id, String usrname, String usremail, String passwrd) {
		
		this.id = id;
		this.usrname = usrname;
		this.usremail = usremail;
		this.passwrd = passwrd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getUsremail() {
		return usremail;
	}
	public void setUsremail(String usremail) {
		this.usremail = usremail;
	}
	public String getPasswrd() {
		return passwrd;
	}
	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
}
