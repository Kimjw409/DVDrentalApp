package eecs3311proj;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


	public class SearchByScreen extends JPanel{
		
		private JFrame frame;
	    private String title, genre;
	    
	    private static JLabel titleLB;
	    private static JLabel genreLB;
	 


	    private static JTextField titlefield;
	    private static JTextField genrefield;
	    
	    
		
		
		
		public SearchByScreen(JFrame frame) {
	        this.frame = frame; // Setting frame equal to this frame
	        setLayout(new GridLayout(9,2));
	        frame.setSize(500, 200);
	        initialize(); // Initializing the view
	        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	    }
		
		
		 private void initialize() {
		        frame.setTitle("Search Movies"); // Setting frame title


		        titleLB = new JLabel("Title");
		        add(titleLB);
		        titlefield = new JTextField();
		        titlefield.setColumns(10);
		        add(titlefield);
		        
		        JButton titleButton = new JButton("Search Title");
		        add(titleButton);
		        titleButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	title = titlefield.getText();
		            	genre = genrefield.getText();
		            	
		            	searchTitle(title);
		        
		            }
		        });
		        
		        genreLB = new JLabel("Genre");
		        add(genreLB);
		        genrefield = new JTextField();
		        genrefield.setColumns(10);
		        add(genrefield);
		        
		        
		   
		        
		        JButton genreButton = new JButton("Search Genre");
		        add(genreButton);
		        genreButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	title = titlefield.getText();
		            	genre = genrefield.getText();
		            	
		            	searchGenre(genre);
		        
		            }
		        });

		        
		        JButton cancelButton = new JButton("Cancel");
		        add(cancelButton);
		        cancelButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	
		                frame.getContentPane().removeAll();
		                frame.getContentPane().add(new SearchMovieScreen(frame));
		                frame.pack();
		                frame.getContentPane().setVisible(true);
		            }
		        });

		        
		 }
		 
		 public void searchTitle(String title) {
			 
			 ArrayList<Movie> result = CentralSystem.getInstance().getMovieDB().searchTitle(title);
			 
			 if (result.size() == 0) {
				 JOptionPane.showMessageDialog(
	                        frame,
	                        "No Match Found !",
	                        "MovieService",
	                        JOptionPane.PLAIN_MESSAGE
	                );
			 } else {
				
			                frame.getContentPane().removeAll();
			                frame.getContentPane().add(new SearchByTitle(frame, result));
			                frame.pack();
			                frame.getContentPane().setVisible(true);
			       
		 }
		 }
		
		 public void searchGenre(String genre) {
			 
			 ArrayList<Movie> result = CentralSystem.getInstance().getMovieDB().searchGenre(genre);
			 
			 if (result.size() == 0) {
				 JOptionPane.showMessageDialog(
	                        frame,
	                        "No Match Found !",
	                        "MovieService",
	                        JOptionPane.PLAIN_MESSAGE
	                );
			 } else {
				
			                frame.getContentPane().removeAll();
			                frame.getContentPane().add(new SearchByGenre(frame, result));
			                frame.pack();
			                frame.getContentPane().setVisible(true);
			       
		 }
			 
		 }
}
