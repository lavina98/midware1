package com.example.demo.portfolio;
import javax.persistence.*;
import java.util.*;

import com.example.demo.user.User;

@Entity
public class Portfolio {

	@Id  @GeneratedValue(strategy=GenerationType.AUTO) 
	private int pId;
	
	private String pName;
	private int pWorth;
	@ManyToOne
	private User user;
	
	public Portfolio() {
		super();
	}
	public Portfolio(int pId, String pName, int pWorth,int uid) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pWorth = pWorth;
		this.user=new User(uid," ","",0);
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpWorth() {
		return pWorth;
	}
	public void setpWorth(int pWorth) {
		this.pWorth = pWorth;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Portfolio [pId=" + pId + ", pName=" + pName + ", pWorth=" + pWorth + "]";
	}
	
	
}
