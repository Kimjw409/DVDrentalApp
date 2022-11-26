package eecs3311proj;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminScreen extends JPanel {
	
	private JFrame frame;
	
	//adding user
	private static JLabel userIDLB;
	private static JLabel passwordLB;
    private static JLabel emailLB;
    //deleting user
    private static JLabel deleteIDLB;
    
    //add movie
    private static JLabel movieLB;
    private static JLabel genreLB;
    private static JLabel descriptLB;
    //delete movie
    private static JLabel deleteMVLB;
    
    
    private static JTextField userIDfield;
    private static JTextField passwordfield;
    private static JTextField emailfield;
    
    private static JTextField deleteIDfield;
        
    private static JTextField moviefield;
    private static JTextField genrefield;
    private static JTextField descriptfield;
    private static JTextField deleteMVfield;
  
    
    private static String userIDvalue, passwordvalue, emailvalue, deleteIDvalue, 
    					  movievalue, genrevalue, descriptvalue, deleteMVvalue;
    					  
	
	public AdminScreen(JFrame frame) {
        this.frame = frame; 
        setLayout(new GridLayout(20,1)); 
        initialize(); 
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
	
	public void initialize() {
		
		frame.setTitle("Admin Only");
		
		userIDLB = new JLabel("ID");
        add(userIDLB);
        userIDfield = new JTextField();
        userIDfield.setColumns(10);
        add(userIDfield);
        
        passwordLB = new JLabel("Password");
        add(passwordLB);
        passwordfield = new JTextField();
        passwordfield.setColumns(10);
        add(passwordfield);
        
        emailLB = new JLabel("Email");
        add(emailLB);
        emailfield = new JTextField();
        emailfield.setColumns(10);
        add(emailfield);
		
		JButton adduserButton = new JButton("Add User");
        add(adduserButton);
        adduserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	userIDvalue = userIDfield.getText();
            	passwordvalue = passwordfield.getText();
            	emailvalue = emailfield.getText();
            	
            	try {
            		
            		int a = CentralSystem.getInstance().getUserDB().getUsers().size();
					CentralSystem.getInstance().addUser(userIDvalue, passwordvalue, emailvalue);
					
					if(CentralSystem.getInstance().getUserDB().getUsers().size() == a + 1) {
					JOptionPane.showMessageDialog(
		                    null,
		                    "Registration Succesful!",
		                    "MovieService",
		                    JOptionPane.PLAIN_MESSAGE
		            );
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        JLabel dummy1 = new JLabel("");
        add(dummy1);
        
        deleteIDLB = new JLabel("Delete ID");
        add(deleteIDLB);
        deleteIDfield = new JTextField();
        deleteIDfield.setColumns(10);
        add(deleteIDfield);
        
        JButton deleteuserButton = new JButton("Delete User");
        add(deleteuserButton);
        deleteuserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	deleteIDvalue = deleteIDfield.getText();
            	
            	try {
					if (CentralSystem.getInstance().getUserDB().deleteUser(deleteIDvalue)) {
						JOptionPane.showMessageDialog(
					            null,
					            "User Deleted !",
					            "MovieService",
					            JOptionPane.PLAIN_MESSAGE
					    );
					} else {
						
						JOptionPane.showMessageDialog(
					            null,
					            "No Such User Exists !",
					            "MovieService",
					            JOptionPane.PLAIN_MESSAGE
					    );
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
        
        JLabel dummy2 = new JLabel("");
        add(dummy2);
        
        movieLB = new JLabel("Title");
        add(movieLB);
        moviefield = new JTextField();
        moviefield.setColumns(10);
        add(moviefield);
        
        genreLB = new JLabel("genre");
        add(genreLB);
        genrefield = new JTextField();
        genrefield.setColumns(10);
        add(genrefield);
        
        descriptLB = new JLabel("Description");
        add(descriptLB);
        descriptfield = new JTextField();
        descriptfield.setColumns(10);
        add(descriptfield);
        
        JButton addmovieButton = new JButton("Add Movie");
        add(addmovieButton);
        addmovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	movievalue = moviefield.getText();
            	genrevalue = genrefield.getText();
            	descriptvalue = descriptfield.getText();
            	
            	try {
					if (CentralSystem.getInstance().getMovieDB().addMovie(movievalue, genrevalue, descriptvalue)) {
						
						JOptionPane.showMessageDialog(
					            null,
					            "Success !",
					            "MovieService",
					            JOptionPane.PLAIN_MESSAGE
					    );
					} else {
						
						JOptionPane.showMessageDialog(
					            null,
					            "Movie Already Exists !",
					            "MovieService",
					            JOptionPane.PLAIN_MESSAGE
					    );
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        JLabel dummy3 = new JLabel("");
        add(dummy3);
        
        deleteMVLB = new JLabel("Delete Title");
        add(deleteMVLB);
        deleteMVfield = new JTextField();
        deleteMVfield.setColumns(10);
        add(deleteMVfield);
        
        JButton deletemovieButton = new JButton("Delete Movie");
        add(deletemovieButton);
        deletemovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMVvalue = deleteMVfield.getText();
                
                try {
					if(CentralSystem.getInstance().getMovieDB().deleteMovie(deleteMVvalue)) {
						
						JOptionPane.showMessageDialog(
					            null,
					            "Movie Deleted !",
					            "MovieService",
					            JOptionPane.PLAIN_MESSAGE
					    );
					} else {
						
						JOptionPane.showMessageDialog(
					            null,
					            "Movie Does Not Exist !",
					            "MovieService",
					            JOptionPane.PLAIN_MESSAGE
					    );
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        JLabel dummy4 = new JLabel("");
        add(dummy4);
        
        JButton logOutButton = new JButton("Log Out");
        add(logOutButton);
        logOutButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	                frame.getContentPane().removeAll();
	                frame.getContentPane().add(new StartScreen(frame));
	                frame.pack();
	                frame.getContentPane().setVisible(true);
	            }
	        });
	}
}
