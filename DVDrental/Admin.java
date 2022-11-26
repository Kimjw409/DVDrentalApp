package eecs3311proj;

public class Admin {
	
	private String AdminID;
	private String Password;
	
	public Admin (String id, String pssword) {
		
		this.AdminID = id;
		this.Password = pssword;
		
	}
	
	
	public String getID() {
		return this.AdminID;
	}
	
	public String getPassword() {
		return this.Password;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null) {
			return false;
		}
		
		if (!(o instanceof Admin)) {
			return false;
		}
		
		Admin m = (Admin) o;
		
		return (this.getID().equals(m.getID()) && this.Password.equals(m.getPassword()));
		
	}
	
	@Override
	public String toString() {
		return this.AdminID;
	}

}
