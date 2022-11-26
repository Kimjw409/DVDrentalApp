package eecs3311proj;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {
    private JFrame frame;

    public StartScreen(JFrame frame) {
        this.frame = frame; // Setting main frame equal to this frame
        setLayout(new GridLayout(5,1)); // Setting layout of login screen
        frame.setSize(500, 200);
        initialize(); // Initializing the view
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

   
    public void initialize() {
        frame.setTitle("Movie Rentals"); // Setting frame title
        
        
        JButton userButton = new JButton("User Login");
        add(userButton);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Removing login screen and showing user login screen
            	
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new UserLoginScreen(frame));
                frame.pack();
                frame.getContentPane().setVisible(true);
            }
        });

        
        
        JButton newUser = new JButton("Register");
        add(newUser);
        
        newUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new RegisterScreen(frame));
                frame.pack();
                frame.getContentPane().setVisible(true);
            }
        });
        
        
    

        JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        
        JButton adminButton = new JButton("Admin Login");
        add(adminButton);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new AdminLoginScreen(frame));
                frame.pack();
                frame.getContentPane().setVisible(true);
            }
        });
    }
}
