package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="services")
@Component
public class Service {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="service")
	@SequenceGenerator(name="service", sequenceName="services_key", allocationSize=1)
	private int id;
	@Column(name="service_name")
	private String serviceName;
	@Column(name="service_cost")
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
