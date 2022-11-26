package eecs3311proj;

import java.io.FileWriter;
import java.util.ArrayList;

public class OrderDB {
	
	private String path = "src/Orders.csv";
	
	
	private ArrayList<Order> Orders = new ArrayList<Order>();
	
	
	
	
	public OrderDB() {
		
	}
	
	
	
	public void addOrder(String ID, String movieT) throws Exception {
		
		for (Movie ms: CentralSystem.getInstance().getMovieDB().getMoviesDB()) {
			if (ms.getTitle().equals(movieT)) {
				if (ms.checkAV()) {
					for (Order o : Orders) {
						if (o.getUserID().equals(ID)) {
							o.addOrder(movieT);
							ms.setAV();
							update();
					
							return;
					}  
			}
				
				Order newOrder = new Order(ID);
				CentralSystem.getInstance().getCurrentUser().setMyOrder(newOrder);
				newOrder.addOrder(movieT);
				ms.setAV();
				getOrders().add(newOrder);
				update();
				
		}
		}
		}
	}
 	
	
	public ArrayList<Order> getOrders() {

		return this.Orders;
	}



	public void loadOrder(String ID, String M1, String M2, String M3, String M4, String M5) {
		Order newOrder = new Order(ID, M1, M2, M3, M4, M5);
		Orders.add(newOrder);
	}
	
	
public void maintainOrder() throws Exception{
		
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();
		
		while (reader.readRecord()) {
			
			loadOrder(reader.get("User"), reader.get("Movie1"), reader.get("Movie2"), reader.get("Movie3"), reader.get("Movie4")
					, reader.get("Movie5"));
		}
		
		for (User u: CentralSystem.getInstance().getUserDB().getUsers()) {
			
		for (Order o: Orders) {
			if (o.getUserID().equals(u.getUserID())) {
				u.setMyOrder(o);
			}
		}
		
		}
		
	}
	
	public void load() throws Exception{
		
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();
		
		while (reader.readRecord()) {
			
			loadOrder(reader.get("User"), reader.get("Movie1"), reader.get("Movie2"), reader.get("Movie3"), reader.get("Movie4")
					, reader.get("Movie5"));
		}
		
		for (User u: CentralSystem.getInstance().getUserDB().getUsers()) {
			
		for (Order o: Orders) {
			if (o.getUserID().equals(u.getUserID())) {
				u.setMyOrder(o);
			}
		}
		
		}
		
		updateMovieAV();
	}
	
	public void updateMovieAV() {
		for (Order o: Orders) {
			for (Movie m: CentralSystem.getInstance().getMovieDB().getMoviesDB()) {
				if (o.getMovie1().equals(m.getTitle())) {
					m.setUser1(o.getUserID());
					m.setAV();
				}
				
				if (o.getMovie2().equals(m.getTitle())) {
					m.setUser1(o.getUserID());
					m.setAV();
				}
				
				if (o.getMovie3().equals(m.getTitle())) {
					m.setUser1(o.getUserID());
					m.setAV();
				}
				
				if (o.getMovie4().equals(m.getTitle())) {
					m.setUser1(o.getUserID());
					m.setAV();
				}
				
				if (o.getMovie5().equals(m.getTitle())) {
					m.setUser1(o.getUserID());
					m.setAV();
				}
			}
		}
		

	}
	
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');

				csvOutput.write("User");
		    	csvOutput.write("Movie1");
		    	csvOutput.write("Movie2");
		    	csvOutput.write("Movie3");
		    	csvOutput.write("Movie4");
		    	csvOutput.write("Movie5");
				csvOutput.endRecord();

			
				for(Order u: Orders){
	
					csvOutput.write(u.getUserID());
					csvOutput.write(u.getMovie1());
					csvOutput.write(u.getMovie2());
					csvOutput.write(u.getMovie3());
					csvOutput.write(u.getMovie4());
					csvOutput.write(u.getMovie5());

					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	

}
