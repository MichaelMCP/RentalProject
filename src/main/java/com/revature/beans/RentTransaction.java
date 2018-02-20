package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="rent_transaction")
@Component
public class RentTransaction 
{
	@Id
	@Column(name="rent_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rt")
	@SequenceGenerator(name="rt", sequenceName="rent_transaction_key", allocationSize=1)
	private int rentId;
	@Column(name="start_date")
	private String startdate;
	@Column(name="end_date")
	private String enddate;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="renter_id")
	private User renter;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="property_id")
	private Property property;
	private int approval;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="payment_info_id")
	private PaymentInfo payment;
	public RentTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RentTransaction(int rentId, String startdate, String enddate, User renter, Property property, int approval,
			PaymentInfo payment) {
		super();
		this.rentId = rentId;
		this.startdate = startdate;
		this.enddate = enddate;
		this.renter = renter;
		this.property = property;
		this.approval = approval;
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "RentTransaction [rentId=" + rentId + ", startdate=" + startdate + ", enddate=" + enddate + ", renter="
				+ renter + ", property=" + property + ", approval=" + approval + ", payment=" + payment + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + approval;
		result = prime * result + ((enddate == null) ? 0 : enddate.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + rentId;
		result = prime * result + ((renter == null) ? 0 : renter.hashCode());
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
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
		RentTransaction other = (RentTransaction) obj;
		if (approval != other.approval)
			return false;
		if (enddate == null) {
			if (other.enddate != null)
				return false;
		} else if (!enddate.equals(other.enddate))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (rentId != other.rentId)
			return false;
		if (renter == null) {
			if (other.renter != null)
				return false;
		} else if (!renter.equals(other.renter))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		return true;
	}
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public User getRenter() {
		return renter;
	}
	public void setRenter(User renter) {
		this.renter = renter;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public int getApproval() {
		return approval;
	}
	public void setApproval(int approval) {
		this.approval = approval;
	}
	public PaymentInfo getPayment() {
		return payment;
	}
	public void setPayment(PaymentInfo payment) {
		this.payment = payment;
	}

	
	

}
