package Bevco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

class Connection1{
	 private Connection NULL;
		public Connection getConnection() throws SQLException, ClassNotFoundException  {
			// TODO Auto-generated method stub
			Class.forName("com.mysql.jdbc.Driver");
			Connection ins=null;
			ins= DriverManager.getConnection("jdbc:mysql://localhost:3306/bevco","root","");
			if(ins!=null)
		     return ins;
			else
				return null ;
		}
		
		

}