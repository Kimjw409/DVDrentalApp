package eecs3311proj;

import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UserDB {
	
	private ArrayList<User> Users;
	public String path = "src/Users.csv";
	
	public UserDB() throws Exception {
		this.Users = new ArrayList<User>();
	}
	
	
	public ArrayList<User> getUsers() {
		return this.Users;
	}
	
	public void addUser(String id, String password, String email) throws Exception {
		if (userCheck(id, email)) {
			
			JOptionPane.showMessageDialog(
                    null,
                    "ID/Email Already Exists !",
                    "MovieService",
                    JOptionPane.PLAIN_MESSAGE
            );
			return;
		} else {
		User a = new User(id, password, email);
		getUsers().add(a);
	
		}
		update();
		
	
	}
	
	public Boolean deleteUser(String id) throws Exception {
		for (User u: Users) {
			if (u.getUserID().equals(id)) {
				User deleted = u;
				int a = getUsers().indexOf(deleted);
				getUsers().remove(a);
				update();
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean userCheck(String id, String email) {
		User check = new User(id, email);
		
		if(getUsers().contains(check)) {
			return true;
		}
		
		return false;
	}
	
	public Boolean userLogin(String id, String password) {
		String email = "dummy";
		
		User a = new User(id, password, email);
		
		if(this.getUsers().contains(a)) {
			int b = getUsers().indexOf(a);
			
			if (getUsers().get(b).getPassword().equals(a.getPassword())) {
			CentralSystem.getInstance().setCurrentUser(getUsers().get(b));
			return true;
			}
		}
		
		return false;
	} 
	
	public void load() throws Exception{
		
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();
		
		while (reader.readRecord()) {
			
			CentralSystem.getInstance().addUser(reader.get("UserID"), reader.get("Password"), reader.get("Email"));
		}
	}
	
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');

				csvOutput.write("UserID");
				csvOutput.write("Password");
		    	csvOutput.write("Email");
				csvOutput.endRecord();

			
				for(User u: Users){
					csvOutput.write(u.getUserID());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getEmail());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}
