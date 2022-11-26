package eecs3311proj;

import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MovieDB {

	private ArrayList<Movie> Movies;
	public String path = "src/MovieList.csv";
	
	
	public MovieDB() throws Exception {
		
		this.Movies = new ArrayList<Movie>();
		
	}
	
	public Boolean addMovie (String title, String genre, String descript) throws Exception {
		
		Movie movie = new Movie(title, genre, descript);
		
		
		if (!Movies.contains(movie)) {
			Movies.add(movie);
			update();
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Movie> getMoviesDB() {
		return this.Movies;
	}
	
	public Boolean deleteMovie (String title) throws Exception {
		
		for (Movie m: Movies) {
			if (m.getTitle().equals(title)) {
				Movie deleted = m;
				int a = getMoviesDB().indexOf(m);
				getMoviesDB().remove(a);
				update();
				return true;
			}
		}
		
		return false;
		
	}
	
	public ArrayList<Movie> searchTitle(String title) {
		
		ArrayList<Movie> result = new ArrayList<Movie>();
		
		for (Movie m: Movies) {
			if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
				result.add(m);
			}
			
		}
		
		return result;
	}
	
	public ArrayList<Movie> searchGenre(String genre) {
		
		ArrayList<Movie> result = new ArrayList<Movie>();
		
		for (Movie m: Movies) {
			if (m.getGenre().toLowerCase().contains(genre.toLowerCase())) {
				result.add(m);
			}
		}
		
		return result;
	}
	
	public void placeOrder(String movieT) throws Exception {
		for (Movie m: Movies) {
			if (m.getTitle().equals(movieT)) {
				if (m.checkAV()) {
					CentralSystem.getInstance().getOrderDB().addOrder(CentralSystem.getInstance().getCurrentUser().getUserID(), movieT);
					CentralSystem.getInstance().pay();
				} else {
					
					JOptionPane.showMessageDialog(
		                    null,
		                    "Movie Out of Stock !",
		                    "MovieCo",
		                    JOptionPane.PLAIN_MESSAGE
		            );
					
				}
			}
		}
		
	}
	
	public void load() throws Exception{
		
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();
		
		while (reader.readRecord()) {
			
			CentralSystem.getInstance().addMovie(reader.get("Title"), reader.get("Genre"), reader.get("Description"));
		}
	}
	
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');

				csvOutput.write("Title");
				csvOutput.write("Genre");
		    	csvOutput.write("Description");
		    	csvOutput.write("Order#");
				csvOutput.endRecord();

			
				for(Movie m: Movies){
					csvOutput.write(m.getTitle());
					csvOutput.write(m.getGenre());
					csvOutput.write(m.getDescription());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
