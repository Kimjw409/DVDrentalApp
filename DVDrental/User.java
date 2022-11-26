package eecs3311proj;

import java.util.ArrayList;

public class User {
	private String userID;
	private String password;
	private String Name;
	private String email;
	

	private Order MyOrder;
	
	
	public User (String id, String password, String email) {
		this.userID = id;
		this.password = password;
		this.email = email;
		this.MyOrder = new Order(id);
	}
	
	public User (String id, String email) {
		this.userID = id;
		this.email = email;
		this.password = "dummy";
		this.MyOrder = new Order(id);
		
	}
	
	public void setMyOrder (Order o) {
		this.MyOrder = o;
	}
	
	public Order getMyOrder() {
		return this.MyOrder;
	}
	public String getUserID() {
		return this.userID;
	}
	
	
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String PW) {
		this.password = PW;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public void setEmail (String email) {
		this.email = email;
	} 
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null) {
			return false;
		}
		
		if (!(o instanceof User)) {
			return false;
		}
		
		User u = (User) o;
		
		return (this.getUserID().equals(u.getUserID()) || this.getEmail().equals(u.getEmail()));
		
	}
	
}
