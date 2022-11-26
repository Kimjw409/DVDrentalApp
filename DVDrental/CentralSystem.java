package eecs3311proj;

import java.util.ArrayList;

public class CentralSystem {
	
	private static final CentralSystem system = new CentralSystem();
	
	private MovieDB MovieBase;
	
	private UserDB UserBase;
	
	private AdminDB AdminBase;
	
	private OrderDB OrderBase;
	
	private PaymentSystem PaymentDB;
	
	private User CurrentUser;
	
	private CentralSystem() {
		
		String sample = "Sample";
		this.CurrentUser = new User (sample, sample, sample);
		
		
	}
	
	public static CentralSystem getInstance() {
		
		
		return system;
		
	}
	
	public void setCurrentUser(User current) {
		this.CurrentUser = current;
	}
	
	public User getCurrentUser() {
		return this.CurrentUser;
	}
	
	public void setOrderDB() throws Exception {
		this.OrderBase = new OrderDB();
		getOrderDB().load();
		
	}
	
	public OrderDB getOrderDB() {
		return this.OrderBase;
	}
	public void setMovieDB() throws Exception {
		
		this.MovieBase = new MovieDB();
		getMovieDB().load();
		
	}
	
	public void setUserDB() throws Exception {
		
		this.UserBase = new UserDB();
		getUserDB().load();
		
	}
	
	public void setAdminDB() {
		this.AdminBase = new AdminDB();
	}
	

	
	public MovieDB getMovieDB() {
		return this.MovieBase;
	}
	
	public UserDB getUserDB() {
		return this.UserBase;
	}
	
	public AdminDB getAdminDB() {
		return this.AdminBase;
	}
	
	
	
	public void addUser(String id, String pssw, String eml) throws Exception {
		try {
			getUserDB().addUser(id, pssw, eml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addMovie(String title, String genre, String descript) throws Exception {
		getMovieDB().addMovie(title, genre, descript);
	}
	
	public void addAdmin(String id, String password) {
		getAdminDB().addAdmin(id, password);
	}
	
	public Boolean adminCheck(String id, String password) {
		Admin check = new Admin(id, password); 
		if (getAdminDB().getAdmins().contains(check)) {
			return true;
		}
		return false;
	}
	
	public void setPaymentSystem() {
		this.PaymentDB = new PaymentSystem();
	}
	public void pay() {
		this.PaymentDB.validate();
		
	}
	
	

	

}
