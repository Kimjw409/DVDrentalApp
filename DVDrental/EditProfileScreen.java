package eecs3311proj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class EditProfileScreen extends JPanel {
	
	    private JFrame frame;
	    
	    
	    // Path for the text file to save new user information
	    //private String path = "Users/UserLoginInfo.txt";
	    
	    private static JLabel nameLB;
	    private static JLabel passwordLB;
	    private static JLabel emailLB;


	    private static JTextField namefield;
	    private static JTextField passwordfield;
	    private static JTextField emailfield;
	    
	    private static String namevalue, passwordvalue, emailvalue;
	    

	    public EditProfileScreen(JFrame frame) {
	        this.frame = frame; // Setting main frame equal to this frame
	        setLayout(new GridLayout(9,2));
	        frame.setSize(500, 200);
	        initialize(); // Initializing the view
	        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	    }

	    private void initialize() {
	        frame.setTitle("VideoCo"); // Setting the title of the frame
	        
	       
	        nameLB = new JLabel("Name");
	        add(nameLB);
	        namefield = new JTextField();
	        namefield.setColumns(10);
	        add(namefield);
	        
	        JLabel dummy1 = new JLabel("");
	        add(dummy1);
	        
	        JButton EditName = new JButton("Edit Name");
	        add(EditName);
	        EditName.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	
	            }
	        }); 
	        
	        passwordLB = new JLabel("Password");
	        add(passwordLB);
	        passwordfield = new JTextField();
	        passwordfield.setColumns(10);
	        add(passwordfield);
	        
	        JLabel dummy2 = new JLabel("");
	        add(dummy2);
	        
	        JButton EditPW = new JButton("Edit Password");
	        add(EditPW);
	        EditPW.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	passwordvalue = passwordfield.getText();
	            	CentralSystem.getInstance().getCurrentUser().setPassword(passwordvalue);
	            	try {
						CentralSystem.getInstance().getUserDB().update();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	
	            	JOptionPane.showMessageDialog(
		                    frame,
		                    "Password Changed !",
		                    "VideoCo",
		                    JOptionPane.PLAIN_MESSAGE
		            );
	               
	            }
	        }); 
	        
	        emailLB = new JLabel("Email");
	        add(emailLB);
	        emailfield = new JTextField();
	        emailfield.setColumns(10);
	        add(emailfield);
	        
	        JLabel dummy3 = new JLabel("");
	        add(dummy3);
	        
	        JButton EditEM = new JButton("Edit Email");
	        add(EditEM);
	        EditEM.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               emailvalue = emailfield.getText();
	               CentralSystem.getInstance().getCurrentUser().setEmail(emailvalue);
	               try {
					CentralSystem.getInstance().getUserDB().update();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	               JOptionPane.showMessageDialog(
		                    frame,
		                    "Email Info Changed !",
		                    "VideoCo",
		                    JOptionPane.PLAIN_MESSAGE
		            );
	               
	            }
	         
	        }); 
	        
	        
	        
	        JButton cancelButton = new JButton("Cancel");
	        add(cancelButton);
	        cancelButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	                frame.getContentPane().removeAll();
	                frame.getContentPane().add(new UserScreen(frame));
	                frame.pack();
	                frame.getContentPane().setVisible(true);
	            }
	        });

	 

	    }
}
	    
	    