package com.revature.beans;

import java.sql.Timestamp;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="receipt")
	@SequenceGenerator(name="receipt", sequenceName="receipts_key", allocationSize=1)
	private int receipt_id;
	private Timestamp payments_time;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="rent_user_id")
	private int renter_user_id;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner_user_id")
	private int owner_user_id;
	private int user_rating;
	private double amount;
	
	public Receipt(int receipt_id, Timestamp payments_time, int renter_user_id, int owner_user_id, int user_rating,
			double amount) {
		super();
		this.receipt_id = receipt_id;
		this.payments_time = payments_time;
		this.renter_user_id = renter_user_id;
		this.owner_user_id = owner_user_id;
		this.user_rating = user_rating;
		this.amount = amount;
	}

	public Receipt() 
	{
		super();
	}

	public int getReceipt_id() {
		return receipt_id;
	}

	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}

	public Timestamp getPayments_time() {
		return payments_time;
	}

	public void setPayments_time(Timestamp payments_time) {
		this.payments_time = payments_time;
	}

	public int getRenter_user_id() {
		return renter_user_id;
	}

	public void setRenter_user_id(int renter_user_id) {
		this.renter_user_id = renter_user_id;
	}

	public int getOwner_user_id() {
		return owner_user_id;
	}

	public void setOwner_user_id(int owner_user_id) {
		this.owner_user_id = owner_user_id;
	}

	public int getUser_rating() {
		return user_rating;
	}

	public void setUser_rating(int user_rating) {
		this.user_rating = user_rating;
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
		result = prime * result + owner_user_id;
		result = prime * result + ((payments_time == null) ? 0 : payments_time.hashCode());
		result = prime * result + receipt_id;
		result = prime * result + renter_user_id;
		result = prime * result + user_rating;
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
		if (owner_user_id != other.owner_user_id)
			return false;
		if (payments_time == null) {
			if (other.payments_time != null)
				return false;
		} else if (!payments_time.equals(other.payments_time))
			return false;
		if (receipt_id != other.receipt_id)
			return false;
		if (renter_user_id != other.renter_user_id)
			return false;
		if (user_rating != other.user_rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Receipt [receipt_id=");
		builder.append(receipt_id);
		builder.append(", payments_time=");
		builder.append(payments_time);
		builder.append(", renter_user_id=");
		builder.append(renter_user_id);
		builder.append(", owner_user_id=");
		builder.append(owner_user_id);
		builder.append(", user_rating=");
		builder.append(user_rating);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
 
}
