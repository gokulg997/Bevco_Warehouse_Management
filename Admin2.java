package Bevco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Admin2 {

	public void login() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
System.out.println("Enter username");

String user=s.next();
System.out.println("Enter password");
String password=s.next();
Connection1 c3=new Connection1();

Statement st= (Statement) c3.getConnection().createStatement();
PreparedStatement pt= c3.getConnection().prepareStatement("insert into admin(username,password) values(?,?)");
pt.setString(1,user);
pt.setString(2,password);
pt.executeUpdate();
c3.getConnection().close();
pt.close();

	}

	public void signin() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
				System.out.println("Enter username");;
		String nuser=s.next();
		System.out.println("Enter password");
		String npassword=s.next();
		Connection1 c3=new Connection1();
		Statement st= (Statement) c3.getConnection().createStatement();
		
		ResultSet r1=st.executeQuery("select username from admin");
		int c=0,d=1;
		while(r1.next()) {
		String user=r1.getString(1);
		if(nuser.equals(user)) {
			ResultSet r=st.executeQuery("select password from admin");
	
			while(r.next()) {
			String password=r.getString(1);
			if(npassword.equals(password)){
				c=0;
			}
			else {
				c=1;
				}
		}
		}
		else {
			System.out.println("Wrong Password");
		}
		d++;
		}
		if(c==0) {
				System.out.println("Successfully login");
		 
				admin1 adm=new admin1();
				adm.log1();
				 
			}
			else {
				System.out.println("Wrong Password");
			}
		
		
		
c3.getConnection().close();
		
	}

}
