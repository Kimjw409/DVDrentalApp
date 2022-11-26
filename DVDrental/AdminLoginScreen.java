package eecs3311proj;

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


public class AdminLoginScreen extends JPanel {
	
	private JFrame frame;
    private String adminIDvalue, passwordvalue;
    
    private static JLabel adminIDLB;
    private static JLabel passwordLB;
 


    private static JTextField adminIDfield;
    private static JTextField passwordfield;
    
    
	
	public AdminLoginScreen(JFrame frame) {
		
        this.frame = frame; // Setting frame equal to this frame
        setLayout(new GridLayout(9,2));
        initialize(); // Initializing the view
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
	
	
	 private void initialize() {
	        frame.setTitle("Admin Login"); // Setting frame title


	        adminIDLB = new JLabel("ID");
	        add(adminIDLB);
	        adminIDfield = new JTextField();
	        adminIDfield.setColumns(10);
	        add(adminIDfield);
	        
	        passwordLB = new JLabel("Password");
	        add(passwordLB);
	        passwordfield = new JTextField();
	        passwordfield.setColumns(10);
	        add(passwordfield);
	        
	        JButton signinButton = new JButton("Sign In");
	        add(signinButton);
	        signinButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	adminIDvalue = adminIDfield.getText();
	            	passwordvalue = passwordfield.getText();
	            	
	            	if (CentralSystem.getInstance().adminCheck(adminIDvalue, passwordvalue))
	            	{
	                frame.getContentPane().removeAll();
	                frame.getContentPane().add(new AdminScreen(frame));
	                frame.pack();
	                frame.getContentPane().setVisible(true);
	            	} else {
	            		JOptionPane.showMessageDialog(
	    	                    frame,
	    	                    "Wrong ID/Password!",
	    	                    "MovieService",
	    	                    JOptionPane.PLAIN_MESSAGE
	    	            );
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
	                frame.pack();
	                frame.getContentPane().setVisible(true);
	            }
	        });

	        
	 }
	 
}