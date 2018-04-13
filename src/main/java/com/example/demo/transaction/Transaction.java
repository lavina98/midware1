package com.example.demo.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.portfolio.Portfolio;
import com.example.demo.user.User;

@Entity
public class Transaction {

	@Id  @GeneratedValue(strategy=GenerationType.AUTO) 
	private int tId;
	private String type;
	private int portfolioId;
	private String sName;
	private int price;
	private int quantity;
	@ManyToOne
	private User user;
	
	
	public Transaction() {
		super();
	}
	public Transaction(int tId, String type, int portfolioId, String sName, int price, int quantity, int uid) {
		super();
		this.tId = tId;
		this.type = type;
		this.portfolioId = portfolioId;
		this.sName = sName;
		this.price = price;
		this.quantity = quantity;
		this.user = new User(uid," "," ",0);
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Transaction [tId=" + tId + ", type=" + type + ", portfolioId=" + portfolioId + ", sName=" + sName
				+ ", price=" + price + ", quantity=" + quantity + ", user=" + user + "]";
	}
	
}
