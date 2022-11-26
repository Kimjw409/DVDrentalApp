package eecs3311proj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class RegisterScreen extends JPanel {
	
	    private JFrame frame;
	    
	    
	    // Path for the text file to save new user information
	    //private String path = "Users/UserLoginInfo.txt";
	    
	    private static JLabel userIDLB;
	    private static JLabel passwordLB;
	    private static JLabel emailLB;


	    private static JTextField userIDfield;
	    private static JTextField passwordfield;
	    private static JTextField emailfield;
	    
	    private static String userIDvalue, passwordvalue, emailvalue;
	    

	    public RegisterScreen(JFrame frame) {
	        this.frame = frame; // Setting main frame equal to this frame
	        setLayout(new GridLayout(9,2));
	        frame.setSize(500, 200);
	        initialize(); // Initializing the view
	        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	    }

	    private void initialize() {
	        frame.setTitle("Registration"); // Setting the title of the frame
	        
	       
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
	        
	        
	        JButton registerButton = new JButton("Register");
	        add(registerButton);
	        registerButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
						registerUser();
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        }); 
	        
	        
	        
	        JButton cancelButton = new JButton("Cancel");
	        add(cancelButton);
	        cancelButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	                frame.getContentPane().removeAll();
	                frame.getContentPane().add(new StartScreen(frame));
	                //frame.pack();
	                frame.getContentPane().setVisible(true);
	            }
	        });

	 

	    }
	    
	    private void registerUser() throws HeadlessException, Exception {
	    	
	    	storeInpute();
	    	
	    	if (addUser(userIDvalue, passwordvalue, emailvalue)) {
	    		
	    		JOptionPane.showMessageDialog(
	                    frame,
	                    "Registration Succesful!",
	                    "MovieService",
	                    JOptionPane.PLAIN_MESSAGE
	            );
	    		
	    		frame.getContentPane().removeAll();
	            frame.getContentPane().add(new StartScreen(frame));
	            frame.pack();
	            frame.getContentPane().setVisible(true);
	    	} else {
	    		
	    		JOptionPane.showMessageDialog(
	                    frame,
	                    "Existing ID/Email!",
	                    "MovieService",
	                    JOptionPane.PLAIN_MESSAGE
	            );
	    		
	    	}
	    
        }
	    	
	 
	    
	    private void storeInpute() {
	    	
	    	userIDvalue = userIDfield.getText();
	    	passwordvalue = passwordfield.getText();
	    	emailvalue = emailfield.getText();
	    
	    }
	   
	    private Boolean addUser(String id, String pswd, String eml) throws Exception {
	    	
	    	if (!CentralSystem.getInstance().getUserDB().userCheck(id, eml)) {
	    		CentralSystem.getInstance().getUserDB().addUser(id, pswd, eml);
		    	return true;
	    	} else {
	    		
	    	return false;
	    }
	    }
	    
}
	    

