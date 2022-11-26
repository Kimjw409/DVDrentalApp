package eecs3311proj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SearchByGenre extends JPanel {

	
private JFrame frame;
private ArrayList<Movie> results;
	
	public SearchByGenre(JFrame frame, ArrayList<Movie> result) {
        this.frame = frame; // Setting main frame equal to this frame
        this.results = result;
        frame.setTitle("Search Results");
        frame.setSize(500, 200);
        initialize(); // Initializing the view
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        frame.setVisible(true);
    }
	
	public void initialize() {
		
		int numb = results.size();
		if (numb == 0) {
			JOptionPane.showMessageDialog(
                    frame,
                    "No Match Found !",
                    "MovieCo",
                    JOptionPane.PLAIN_MESSAGE
            );
			return;
		}
		int fields = 3;
		String[][] data = new String[numb][fields] ;
		
		for (int i = 0; i < numb; i++) {
			data[i][0] = results.get(i).getTitle();
			data[i][1] = results.get(i).getGenre();
			data[i][2] = results.get(i).getDescription();
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