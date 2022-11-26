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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyOrderScreen extends JPanel {

	
private JFrame frame;
	
	public MyOrderScreen(JFrame frame) {
		
        this.frame = frame; 
        setLayout(new GridLayout(9,1));
        frame.setTitle("My Orders");
        initialize(); 
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        frame.setVisible(true);
    }
	
	public void initialize() {
		
		String[] myOrders = new String[5]; 
		myOrders[0] = CentralSystem.getInstance().getCurrentUser().getMyOrder().getMovie1(); 
		myOrders[1] = CentralSystem.getInstance().getCurrentUser().getMyOrder().getMovie2(); 
		myOrders[2] = CentralSystem.getInstance().getCurrentUser().getMyOrder().getMovie3(); 
		myOrders[3] = CentralSystem.getInstance().getCurrentUser().getMyOrder().getMovie4(); 
		myOrders[4] = CentralSystem.getInstance().getCurrentUser().getMyOrder().getMovie5(); 
		JList list = new JList(myOrders);
		JScrollPane pane = new JScrollPane(list);
		add(pane);
		
		
		
		
		JButton addB = new JButton("Cancel Order");
		add(addB);
		
		;
		
		JButton CancelB = new JButton("Cancel");
        add(CancelB);
        CancelB.addActionListener(new ActionListener() {
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

