package com.revature.beans;

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
@Table(name="payment_info")
public class PaymentInfo 
{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payment")
	@SequenceGenerator(name="payment", sequenceName="payment_info_key", allocationSize=1)
	private int id;
	private double cost;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_Id")
	private int user_Id;
	private int credit_Card_Number;
	
	public PaymentInfo() 
	{
		super();
	}

	public PaymentInfo(int id, double cost, int userId, int creditCardNumber) {
		super();
		this.id = id;
		this.cost = cost;
		this.user_Id = userId;
		this.credit_Card_Number = creditCardNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getUserId() {
		return user_Id;
	}

	public void setUserId(int userId) {
		this.user_Id = userId;
	}

	public int getCreditCardNumber() {
		return credit_Card_Number;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.credit_Card_Number = creditCardNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + credit_Card_Number;
		result = prime * result + id;
		result = prime * result + user_Id;
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
		PaymentInfo other = (PaymentInfo) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (credit_Card_Number != other.credit_Card_Number)
			return false;
		if (id != other.id)
			return false;
		if (user_Id != other.user_Id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentInfo [id=" + id + ", cost=" + cost + ", userId=" + user_Id + ", creditCardNumber="
				+ credit_Card_Number + "]";
	}
}
