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
	@Column(name="renter_id")
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="renter_id")
	private int renterId;
	@Column(name="property_id")
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="property_id")
	private int propId;
	private int approval;
	@Column(name="payment_info_id")
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="payment_info_id")
	private int paymentinfoId;
	
	public RentTransaction() {
		super();
	}

	

	public RentTransaction(int rentId, String startdate, String enddate, int renterId, int propId, int approval,
			int paymentinfoId) {
		super();
		this.rentId = rentId;
		this.startdate = startdate;
		this.enddate = enddate;
		this.renterId = renterId;
		this.propId = propId;
		this.approval = approval;
		this.paymentinfoId = paymentinfoId;
	}



	public int getRentId() {
		return rentId;
	}



	public void setRentId(int rentId) {
		this.rentId = rentId;
	}



	public int getRenterId() {
		return renterId;
	}



	public void setRenterId(int renterId) {
		this.renterId = renterId;
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
	
	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public int getPaymentinfoId() {
		return paymentinfoId;
	}

	public void setPaymentinfoId(int paymentinfoId) {
		this.paymentinfoId = paymentinfoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + approval;
		result = prime * result + ((enddate == null) ? 0 : enddate.hashCode());
		result = prime * result + paymentinfoId;
		result = prime * result + propId;
		result = prime * result + rentId;
		result = prime * result + renterId;
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
		if (paymentinfoId != other.paymentinfoId)
			return false;
		if (propId != other.propId)
			return false;
		if (rentId != other.rentId)
			return false;
		if (renterId != other.renterId)
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentTransaction [rentId=");
		builder.append(rentId);
		builder.append(", startdate=");
		builder.append(startdate);
		builder.append(", enddate=");
		builder.append(enddate);
		builder.append(", renterId=");
		builder.append(renterId);
		builder.append(", propId=");
		builder.append(propId);
		builder.append(", approval=");
		builder.append(approval);
		builder.append(", paymentinfoId=");
		builder.append(paymentinfoId);
		builder.append("]");
		return builder.toString();
	}
	
	

}
