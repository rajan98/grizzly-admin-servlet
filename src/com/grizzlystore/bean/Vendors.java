package com.grizzlystore.bean;

public class Vendors {

	private String id;
	private String name;
	private String rating;
	private String contactNumber;
	private String address;
	
	public Vendors(String id, String name, String rating, String contactNumber, String address) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public Vendors() {
		super();
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
