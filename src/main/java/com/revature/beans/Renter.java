package com.revature.beans;

public class Renter {
	private int renterId;
	private int role;
	private String full_name;
	private String email;
	private String password;
	public Renter(int renterId, int role, String full_name, String email, String password) {
		super();
		this.renterId = renterId;
		this.role = role;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
	}
	public int getRenterId() {
		return renterId;
	}
	public void setRenterId(int renterId) {
		this.renterId = renterId;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((full_name == null) ? 0 : full_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + renterId;
		result = prime * result + role;
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
		Renter other = (Renter) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (full_name == null) {
			if (other.full_name != null)
				return false;
		} else if (!full_name.equals(other.full_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (renterId != other.renterId)
			return false;
		if (role != other.role)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Renter [renterId=" + renterId + ", role=" + role + ", full_name=" + full_name + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	

}
