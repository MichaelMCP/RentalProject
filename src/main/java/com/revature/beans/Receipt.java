package com.revature.beans;

import java.sql.Timestamp;

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

@Entity
@Table(name="receipts")
public class Receipt 
{
	@Id
	@Column(name="receipt_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="receipt")
	@SequenceGenerator(name="receipt", sequenceName="receipts_key", allocationSize=1)
	private int receiptId;
	@Column(name="payments_time")
	private Timestamp paymentsTime;
	@OneToOne(fetch=FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name="rent_user_id")
	private int renterUserId;
	@OneToOne(fetch=FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name="owner_user_id")
	private int ownerUserId;
	@Column(name="user_rating")
	private int userRating;
	private double amount;
	
	public Receipt(int receiptId, Timestamp paymentsTime, int renterUserId, int ownerUserId, int userRating,
			double amount) {
		super();
		this.receiptId = receiptId;
		this.paymentsTime = paymentsTime;
		this.renterUserId = renterUserId;
		this.ownerUserId = ownerUserId;
		this.userRating = userRating;
		this.amount = amount;
	}

	public Receipt() 
	{
		super();
	}

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public Timestamp getPaymentsTime() {
		return paymentsTime;
	}

	public void setPaymentsTime(Timestamp paymentsTime) {
		this.paymentsTime = paymentsTime;
	}

	public int getRenterUserId() {
		return renterUserId;
	}

	public void setRenter_user_id(int renterUserId) {
		this.renterUserId = renterUserId;
	}

	public int getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ownerUserId;
		result = prime * result + ((paymentsTime == null) ? 0 : paymentsTime.hashCode());
		result = prime * result + receiptId;
		result = prime * result + renterUserId;
		result = prime * result + userRating;
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
		Receipt other = (Receipt) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (ownerUserId != other.ownerUserId)
			return false;
		if (paymentsTime == null) {
			if (other.paymentsTime != null)
				return false;
		} else if (!paymentsTime.equals(other.paymentsTime))
			return false;
		if (receiptId != other.receiptId)
			return false;
		if (renterUserId != other.renterUserId)
			return false;
		if (userRating != other.userRating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Receipt [receiptId=");
		builder.append(receiptId);
		builder.append(", paymentsTime=");
		builder.append(paymentsTime);
		builder.append(", renterUserId=");
		builder.append(renterUserId);
		builder.append(", ownerUserId=");
		builder.append(ownerUserId);
		builder.append(", userRating=");
		builder.append(userRating);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
 
}
