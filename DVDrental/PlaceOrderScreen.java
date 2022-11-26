package eecs3311proj;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PlaceOrderScreen extends JPanel {

	
private JFrame frame;
private String titlevalue;
	
	public PlaceOrderScreen(JFrame frame) {
        this.frame = frame; 
        setLayout(new GridLayout(9,1));
        frame.setTitle("Your Basket");
        initialize(); 
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        frame.setVisible(true);
    }
	
	public void initialize() {
		
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		JScrollPane pane = new JScrollPane(list);
		add(pane);
		
		JTextField titlefield = new JTextField();
		add(titlefield);
		
		JButton addB = new JButton("Add Movie");
		add(addB);
		addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	titlevalue = titlefield.getText();
            	
            	for (Movie m: CentralSystem.getInstance().getMovieDB().getMoviesDB()) {
            		if (m.getTitle().equals(titlevalue)) {
            			listModel.addElement(titlevalue);
            			return;
            		}
            	}
       
            	JOptionPane.showMessageDialog(
	                    frame,
	                    "Please Check the title Again",
	                    "MovieCo",
	                    JOptionPane.PLAIN_MESSAGE
	            );
            }
        });
		
		
		JButton pay = new JButton ("Pay with Credit Card");
		add(pay);
		pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String movieT = (String) list.getSelectedValue();
                try {
					CentralSystem.getInstance().getMovieDB().placeOrder(movieT);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
		
		JButton payR = new JButton ("Pay with Royalty Points");
		add(payR);
	    payR.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	JOptionPane.showMessageDialog(
		                    frame,
		                    "Insufficient Royalty Points !",
		                    "MovieCo",
		                    JOptionPane.PLAIN_MESSAGE
		            );
	            
	            }
	        });
		
		JButton CancelB = new JButton("Cancel");
        add(CancelB);
        CancelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new SearchMovieScreen(frame));
                frame.pack();
                frame.getContentPane().setVisible(true);
        
            }
        });
}
}

