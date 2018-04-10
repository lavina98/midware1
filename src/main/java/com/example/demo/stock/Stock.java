package com.example.demo.stock;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
	@Id
	private String symbol;
	private String name;
	private String market;
	private String category;
	private int currprice;
	private int refprice;
	public Stock() {
		super();
	}
	
	public Stock(String symbol, String name, String market, String category, int currprice, int refprice) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.market = market;
		this.category = category;
		this.currprice = currprice;
		this.refprice = refprice;
	}

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCurrprice() {
		return currprice;
	}
	public void setCurrprice(int currprice) {
		this.currprice = currprice;
	}
	public int getRefprice() {
		return refprice;
	}
	public void setRefprice(int refprice) {
		this.refprice = refprice;
	}
	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", name=" + name + ", market=" + market + ", category=" + category
				+ ", currprice=" + currprice + ", refprice=" + refprice + "]";
	}
	
		
	
}
