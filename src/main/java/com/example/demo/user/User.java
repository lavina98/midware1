package com.example.demo.user;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    private int id;
//    @NotNull
    private String uname;
//    @NotNull
    private String password;
//    @NotNull
    private int networth;
    public User() {
		super();
	}
	public User(int id, String uname, String password,  int networth) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
		this.networth = networth;
	}
//	public User(User users) {
//		this.networth = users.getNetworth();
//        this.uname = users.getUname();
//        this.id = users.getId();
//        this.password = users.getPassword();
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNetworth() {
		return networth;
	}
	public void setNetworth(int networth) {
		this.networth = networth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", password=" + password +   ", networth="
				+ networth + "]";
	}
   
}