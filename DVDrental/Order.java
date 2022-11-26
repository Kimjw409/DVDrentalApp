package eecs3311proj;

import javax.swing.JOptionPane;

public class Order {
	
	
	private String UserID;
	private String Movie1;
	private String Movie2;
	private String Movie3;
	private String Movie4;
	private String Movie5;
	
	
	public Order(String ID) {
		this.UserID = ID;
		this.Movie1 = "";
		this.Movie2 = "";
		this.Movie3 = "";
		this.Movie4 = "";
		this.Movie5 = "";
	}
	
	public Order (String userID, String M1, String M2, String M3, String M4, String M5) {
		
		
	
		this.UserID = userID;
		this.Movie1 = M1;
		this.Movie2 = M2;
		this.Movie3 = M3;
		this.Movie4 = M4;
		this.Movie5 = M5;
	
	}
	

	public String getUserID() {
		return this.UserID;
	}

	public String getMovie1() {
		return this.Movie1;
	}
	
	public void setMovie1(String s) {
		this.Movie1 = s;
	}
	
	public String getMovie2() {
		return this.Movie2;
	}
	public void setMovie2(String s) {
		this.Movie2 = s;
	}
	
	public String getMovie3() {
		return this.Movie3;
	}
	
	public void setMovie3(String s) {
			this.Movie3 = s;
	}
	
	public String getMovie4() {
		return this.Movie4;
	}
	
	public void setMovie4(String s) {
		this.Movie4 = s;
	}
	
	public String getMovie5() {
		return this.Movie5;
	}
	
	public void setMovie5(String s) {
		this.Movie5 = s;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null) {
			return false;
		}
		
		if (!(o instanceof Movie)) {
			return false;
		}
		
		Order or = (Order) o;
		
		return (this.getUserID().equals(or.getUserID()));
		
	}

	public void addOrder(String movieT) {
		if (getMovie1().length() == 0) {
			setMovie1(movieT);
			return;
		} else if (getMovie2().length() == 0) {
			setMovie2(movieT);
			return;
		} else if (getMovie3().length() == 0) {
			setMovie3(movieT);
			return;
		} else if (getMovie4().length() == 0) {
			setMovie4(movieT);
			return;
		} else if (getMovie5().length() == 0) {
			setMovie5(movieT);
			return;
		} else {
			JOptionPane.showMessageDialog(
                    null,
                    "Maximum Number of Order Exceeded !",
                    "MovieCo",
                    JOptionPane.PLAIN_MESSAGE
            );
			
		}
		
		
	}

}
