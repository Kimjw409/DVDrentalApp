package eecs3311proj;

public class Movie {
	
	private String Title;
	
	private String Genre;
	
	private String Description;
	
	private Boolean Availability = true;
	private String user1 = "";
	
	public Movie (String title, String genre, String description) {
		
		this.Title = title;
		this.Genre = genre;
		this.Description = description;

	}
	
	public String getTitle() {
		return this.Title;
	}
	
	public String getGenre() {
		return this.Genre;
	}
	
	public String getDescription() {
		return this.Description;
		
	}
	
	public void setGenre (String genre) {
		this.Genre = genre;
	}
	
	public void setDescription(String descript) {
		
		this.Description = descript;
	}
	
	public Boolean checkAV() {
		return this.Availability;
	}
	
	public void setAV() {
		if (this.Availability == true) {
			this.Availability = false;
		} else {
			this.Availability = true;
		}
	}
	
	public void setUser1(String ID) {
		this.user1 = ID;
	}
	
	public String getUser1() {
		return this.user1;
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
		
		Movie m = (Movie) o;
		
		return (this.getTitle().equals(m.getTitle()) && this.getGenre().equals(m.getGenre()) && 
				this.getDescription().equals(m.getDescription()));
		
	}
	
	@Override
	public String toString() {
		return this.Title;
	}

}
