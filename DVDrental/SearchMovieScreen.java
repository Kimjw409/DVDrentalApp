package eecs3311proj;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SearchMovieScreen extends JPanel {
	
	private JFrame frame;
	
	public SearchMovieScreen(JFrame frame) {
        this.frame = frame; // Setting main frame equal to this frame
        setLayout(new GridLayout(5,1)); // Setting layout of login screen
        frame.setSize(500, 200);
        initialize(); // Initializing the view
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
	
	public void initialize() {
		
		JButton ShowAll = new JButton("Show All Movies");
        add(ShowAll);
        ShowAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new ShowAllScreen(frame));
                //frame.pack();
                frame.getContentPane().setVisible(true);
       
            }
        });
        
        JButton SearchM = new JButton("By Title/Genre");
        add(SearchM);
        SearchM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frame.getContentPane().removeAll();
                frame.getContentPane().add(new SearchByScreen(frame));
                //frame.pack();
                frame.getContentPane().setVisible(true);
                
            }
        });
        
        JButton placeOrder = new JButton("Place Order");
        add(placeOrder);
        placeOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.getContentPane().removeAll();
                frame.getContentPane().add(new PlaceOrderScreen(frame));
                frame.pack();
                frame.getContentPane().setVisible(true);
                
            }
        });
        
        JButton cancelB = new JButton("Cancel");
        add(cancelB);
        cancelB.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	                frame.getContentPane().removeAll();
	                frame.getContentPane().add(new UserScreen(frame));
	                //frame.pack();
	                frame.getContentPane().setVisible(true);
	            }
	        });
	}

}
