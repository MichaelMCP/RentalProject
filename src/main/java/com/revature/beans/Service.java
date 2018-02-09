package com.revature.beans;

public class Service {
	private int id;
	private String serviceName;
	private double serviceCost;
	
	public Service() {
		super();
	}
	public Service(int id, String serviceName, double serviceCost) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.serviceCost = serviceCost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(serviceCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
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
		Service other = (Service) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(serviceCost) != Double.doubleToLongBits(other.serviceCost))
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", serviceName=" + serviceName + ", serviceCost=" + serviceCost + "]";
	}
	
	

}
