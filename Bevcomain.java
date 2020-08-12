package Bevco;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import Shopping_Application.Connection2;
import Shopping_Application.admin;

public class Bevcomain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
 int op;
 Connection1 c3=new Connection1();
 
 do {
	 System.out.println("1.Admin login");
	 System.out.println("2.Agent login");
	 System.out.println("3.Exit");
	 System.out.println("Enter your choice");
	 op=s.nextInt();
	 switch(op) {
	 case 1:
		 Admin2 adm2=new Admin2();
		System.out.println("WELCOME TO ADMIN PANEL \n 1.)ALREADY HAVE AN ACCOUNT \n 2.)NEW USER ");
		int opt=s.nextInt();
		switch(opt) {
		case 1:
			adm2.signin();
			break;
		case 2:
		 adm2.login();
		 break;
		}
		 break;
	 case 2:
		agent1 log1=new agent1();
		log1.aglog();
		 break;
	 }
	 
 }
 while(op!=3);{
	 
 }
 c3.getConnection();
	}


}
