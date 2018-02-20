package com.revature.beans;

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
@Table(name="payment_info")
@Component
public class PaymentInfo 
{

	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payment")
	@SequenceGenerator(name="payment", sequenceName="payment_info_key", allocationSize=1)
	private int id;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="credit_card_number")
	private int cc;
	private String experationDate;
	private int cvv;
	public PaymentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentInfo(int id, User user, int cc, String experationDate, int cvv) {
		super();
		this.id = id;
		this.user = user;
		this.cc = cc;
		this.experationDate = experationDate;
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "PaymentInfo [id=" + id + ", user=" + user + ", cc=" + cc + ", experationDate=" + experationDate
				+ ", cvv=" + cvv + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cc;
		result = prime * result + cvv;
		result = prime * result + ((experationDate == null) ? 0 : experationDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (cc != other.cc)
			return false;
		if (cvv != other.cvv)
			return false;
		if (experationDate == null) {
			if (other.experationDate != null)
				return false;
		} else if (!experationDate.equals(other.experationDate))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public String getExperationDate() {
		return experationDate;
	}
	public void setExperationDate(String experationDate) {
		this.experationDate = experationDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
}