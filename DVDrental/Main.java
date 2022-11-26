package eecs3311proj;

import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;


public class Main extends JFrame {

	public static void main(String[] args) throws Exception {
		
		Main frame = new Main();
		frame.setVisible(true);
		
	}
	
	public Main() throws Exception {
		
		CentralSystem system = CentralSystem.getInstance();
		
		system.setMovieDB();
		system.setUserDB();
		system.setOrderDB();
		system.setAdminDB();
		system.setPaymentSystem();
		
		initializeAdmin();
		
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        JFrame myFrame = this;
        
        
        getContentPane().removeAll();
        getContentPane().add(new StartScreen(myFrame), BorderLayout.CENTER);
        
        pack();
        getContentPane().setVisible(true);
        
       
	}
	
	
	
	public void initializeAdmin() throws Exception {
		
		String path = "src/Admin.csv";
		
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();
		
		while (reader.readRecord()) {
			
			CentralSystem.getInstance().addAdmin(reader.get("AdminID"), reader.get("Password"));
		}
		
		
	} 

}
