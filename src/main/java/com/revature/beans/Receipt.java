package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
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
@Table(name="receipts")
@Component
public class Receipt 
{
	@Id
	@Column(name="receipt_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="receipt")
	@SequenceGenerator(name="receipt", sequenceName="receipts_key", allocationSize=1)
	private int receiptId;
	@Column(name="payments_time")
	private Timestamp paymentsTime;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="renter_user_id")
	private User user;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="owner_user_id")
	private User owner;
	@Column(name="user_rating")
	private int userRating;
	private double amount;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="property_id")
	private Property property;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
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
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((paymentsTime == null) ? 0 : paymentsTime.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + receiptId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (paymentsTime == null) {
			if (other.paymentsTime != null)
				return false;
		} else if (!paymentsTime.equals(other.paymentsTime))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (receiptId != other.receiptId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userRating != other.userRating)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Receipt [receiptId=" + receiptId + ", paymentsTime=" + paymentsTime + ", user=" + user + ", owner="
				+ owner + ", userRating=" + userRating + ", amount=" + amount + ", property=" + property + "]";
	}
	public Receipt(int receiptId, Timestamp paymentsTime, User user, User owner, int userRating, double amount,
			Property property) {
		super();
		this.receiptId = receiptId;
		this.paymentsTime = paymentsTime;
		this.user = user;
		this.owner = owner;
		this.userRating = userRating;
		this.amount = amount;
		this.property = property;
	}
	public Receipt() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}
