package eecs3311proj;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLoginScreen extends JPanel{
	
	private JFrame frame;
    private String userIDvalue, passwordvalue;
    
    private static JLabel userIDLB;
    private static JLabel passwordLB;
 


    private static JTextField userIDfield;
    private static JTextField passwordfield;
    
    
	
	
	
	public UserLoginScreen(JFrame frame) {
        this.frame = frame; // Setting frame equal to this frame
        setLayout(new GridLayout(9,2));
        frame.setSize(500, 200);
        initialize(); // Initializing the view
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
	
	
	 private void initialize() {
	        frame.setTitle("Login"); // Setting frame title


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
	        
	        
	   
	        
	        JButton signinButton = new JButton("Sign In");
	        add(signinButton);
	        signinButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	userIDvalue = userIDfield.getText();
	            	passwordvalue = passwordfield.getText();
	            	if(CentralSystem.getInstance().getUserDB().userLogin(userIDvalue, passwordvalue))
	            	{
	            		
	                frame.getContentPane().removeAll();
	                frame.getContentPane().add(new UserScreen(frame));
	                //frame.pack();
	                frame.getContentPane().setVisible(true);
	            } else {
	            	
	            	JOptionPane.showMessageDialog(
	                        frame,
	                        "Wrong ID/Password !",
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
	                //frame.pack();
	                frame.getContentPane().setVisible(true);
	            }
	        });

	        
	 }
	
	
	
	
	
	

}
