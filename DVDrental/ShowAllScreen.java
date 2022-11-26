package eecs3311proj;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowAllScreen extends JPanel {

	
private JFrame frame;
	
	public ShowAllScreen(JFrame frame) {
        this.frame = frame; // Setting main frame equal to this frame
        frame.setTitle("Showing All Movies");
        frame.setSize(500, 200);
        initialize(); // Initializing the view
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        frame.setVisible(true);
    }
	
	public void initialize() {
		
		int numb = CentralSystem.getInstance().getMovieDB().getMoviesDB().size();
		int fields = 3;
		String[][] data = new String[numb][fields] ;
		
		for (int i = 0; i < numb; i++) {
			data[i][0] = CentralSystem.getInstance().getMovieDB().getMoviesDB().get(i).getTitle();
			data[i][1] = CentralSystem.getInstance().getMovieDB().getMoviesDB().get(i).getGenre();
			data[i][2] = CentralSystem.getInstance().getMovieDB().getMoviesDB().get(i).getDescription();
		}
		
		
		String[] names = {"Title", "Genre", "Description"};
		
		JTable j = new JTable(data, names) {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
	       
		j.setBounds(30, 40, 200, 300);
		
		JScrollPane sp = new JScrollPane(j);
		add(sp);
		
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
