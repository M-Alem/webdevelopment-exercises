package edu.ap.ws;

import java.util.ArrayList;


import edu.ap.jdbc.JDBConnection;

public class WSJDBC {
	public WSJDBC() {}
	
	public String[] selectAll() {
		JDBConnection c = JDBConnection.getJDBConnection();
		c.openConnection("Students", "root", "root");
		ArrayList<String> arr = c.selectAll("SELECT * FROM STUDENTS;");
		
		String[] t = new String[arr.size()];
		arr.toArray();
		
		c.closeConnection();
		
		return t;
	}
}
