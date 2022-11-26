package eecs3311proj;

import java.util.ArrayList;

public class AdminDB {

	private ArrayList<Admin> Admins = new ArrayList<Admin>();
	
	public AdminDB() {
		
	}
	
	public void addAdmin(String id, String pssword) {
		Admin a = new Admin(id, pssword);
		this.Admins.add(a);
	}
	
	public ArrayList<Admin> getAdmins() {
		return this.Admins;
	}
}
