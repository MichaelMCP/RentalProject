package com.revature.beans;

public class Property {
	private int property_id;
	private int owner_id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zipcode;
	private double current_Rent_Price;
	private double rating;
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Property(int property_id, int owner_id, String address1, String address2, String city, String state,
			int zipcode, double current_Rent_Price, double rating) {
		super();
		this.property_id = property_id;
		this.owner_id = owner_id;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.current_Rent_Price = current_Rent_Price;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Property [property_id=" + property_id + ", owner_id=" + owner_id + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", current_Rent_Price=" + current_Rent_Price + ", rating=" + rating + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		long temp;
		temp = Double.doubleToLongBits(current_Rent_Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + owner_id;
		result = prime * result + property_id;
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
		if (Double.doubleToLongBits(current_Rent_Price) != Double.doubleToLongBits(other.current_Rent_Price))
			return false;
		if (owner_id != other.owner_id)
			return false;
		if (property_id != other.property_id)
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
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
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
	public double getCurrent_Rent_Price() {
		return current_Rent_Price;
	}
	public void setCurrent_Rent_Price(double current_Rent_Price) {
		this.current_Rent_Price = current_Rent_Price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
