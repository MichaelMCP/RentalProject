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
	@SequenceGenerator(name="prop_id", sequenceName="prop_seq", allocationSize=1)
	private int propertyId;
	@ManyToOne(fetch=FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name="owner_id")
	private int ownerId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zipcode;
	@Column(name="current_Rent_Price")
	private double currentRentPrice;
	private double rating;
	
	public Property() 
	{
		super();
	}
	public Property(int propertyId, int ownerId, String address1, String address2, String city, String state,
			int zipcode, double currentRentPrice, double rating) 
	{
		super();
		this.propertyId = propertyId;
		this.ownerId = ownerId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.currentRentPrice = currentRentPrice;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Property [property_id=" + propertyId + ", ownerId=" + ownerId + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", currentRentPrice=" + currentRentPrice + ", rating=" + rating + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		long temp;
		temp = Double.doubleToLongBits(currentRentPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ownerId;
		result = prime * result + propertyId;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + zipcode;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (Double.doubleToLongBits(currentRentPrice) != Double.doubleToLongBits(other.currentRentPrice))
			return false;
		if (ownerId != other.ownerId)
			return false;
		if (propertyId != other.propertyId)
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipcode != other.zipcode)
			return false;
		return true;
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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
}
