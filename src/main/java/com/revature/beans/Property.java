package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="properties")
public class Property 
{
	@Id
	@Column(name="property_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prop_id")
	@SequenceGenerator(name="prop_id", sequenceName="properties_key", allocationSize=1)
	private int propertyId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner_id")
	private User owner;
	@Column(name="address1")
	private String address1;
	@Column(name="address2")
	private String address2;
	@Column(name="city")
	private String city;
	@Column(name="states")
	private String state;
	@Column(name="zipcode")
	private int zipcode;
	@Column(name="current_Rent_Price")
	private double currentRentPrice;
	@Column(name="rating")
	private double rating;
	@Column(name="availability")
	private int availability;
	
	public Property() 
	{
		super();
	}

	public Property(int propertyId, User owner, String address1, String address2, String city, String state,
			int zipcode, double currentRentPrice, double rating, int availability) {
		super();
		this.propertyId = propertyId;
		this.owner = owner;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.currentRentPrice = currentRentPrice;
		this.rating = rating;
		this.availability = availability;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public double getCurrentRentPrice() {
		return currentRentPrice;
	}

	public void setCurrentRentPrice(double currentRentPrice) {
		this.currentRentPrice = currentRentPrice;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", owner=" + owner + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", currentRentPrice="
				+ currentRentPrice + ", rating=" + rating + ", availability=" + availability + "]";
	}
}
