package com.example.demo.userstock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.portfolio.Portfolio;
import com.example.demo.user.User;
@Entity
public class Userstock {

	@Id  @GeneratedValue(strategy=GenerationType.AUTO) 
	private int sId;
	private String sName;
	private int quantity;
	private int buyingPrice;
	@ManyToOne
	private Portfolio portfolio;
	
	
	public Userstock(String sName, int quantity, int buyingPrice, int pid,int uid) {
		super();
		this.sName = sName;
		this.quantity = quantity;
		this.buyingPrice = buyingPrice;
		this.portfolio=new Portfolio(pid," ",0,uid);
	}
	
	public Userstock() {
		super();
	}

	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	
}
