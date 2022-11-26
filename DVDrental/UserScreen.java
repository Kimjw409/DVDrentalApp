package eecs3311proj;


import javax.swing.JPanel;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserScreen extends JPanel{
	
	
	
	private JFrame frame;
	
	public UserScreen(JFrame frame) {
        this.frame = frame; // Setting main frame equal to this frame
        setLayout(new GridLayout(5,1)); // Setting layout of login screen
        frame.setSize(500, 200);
        initialize(); // Initializing the view
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
	
	public void initialize() {
		
		JButton SearchMButton = new JButton("Search Movie");
        add(SearchMButton);
        SearchMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new SearchMovieScreen(frame));
                frame.pack();
                frame.getContentPane().setVisible(true);
                
            }
        });
        
        JButton CheckOrderButton = new JButton("My Orders");
        add(CheckOrderButton);
        CheckOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frame.getContentPane().removeAll();
                frame.getContentPane().add(new MyOrderScreen(frame));
                frame.pack();
                frame.getContentPane().setVisible(true);
                
                
            }
        });
        
        JButton editProfile = new JButton("Edit Profile");
        add(editProfile);
        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	 frame.getContentPane().removeAll();
                 frame.getContentPane().add(new EditProfileScreen(frame));
                 frame.pack();
                 frame.getContentPane().setVisible(true);
                 
                
            }
        });
        
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
