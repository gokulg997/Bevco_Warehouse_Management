package Bevco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//import java.sql.Statement; 

import com.mysql.jdbc.Statement;



public class admin1 {
	

	public void log1() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		int op2;
		 Addproduct add=new Addproduct();
		do {
		System.out.println("1.Add");
		System.out.println("2.dispalay");
		System.out.println("3.Remove");
		System.out.println("4.Update");
		System.out.println("5.logout");
		op2=s.nextInt();
		switch(op2) {
		case 1:
			
			add.insertproduct1();
			break;
		case 2:
			
			add.disp();
			break;
		case 3:
			
			add.remove();
			break;
		case 4:
			
			add.update();
			break;
			default:
				System.out.println("Choose correct option");
		}
	}
		while(op2!=5);
		
}
	}
	class Addproduct
	{
		Connection1 c3=new Connection1();
		

		public void insertproduct1() throws ClassNotFoundException, SQLException {
			
			c3.getConnection();
				
			Scanner s=new Scanner(System.in);
			System.out.printf("enter your product ID");
			int ID=s.nextInt();
			System.out.println("enter your product name");
			String NAME=s.next();
			System.out.println("enter quantity");
			int qua=s.nextInt();
			System.out.println("enter priceltr");
			int pricel=s.nextInt();
			System.out.println("enter pricehalf");
			int priceh=s.nextInt();
			System.out.println("enter priceqtr");
			int priceq=s.nextInt();
			System.out.println("enter pricefull");
			int pricef=s.nextInt();
			PreparedStatement st1=  c3.getConnection().prepareStatement("insert into management(id,productname,quantity,priceltr,pricehalf,priceqtr,pricefull) values(?,?,?,?,?,?,?)");

			st1.setInt(1,ID);
			st1.setString(2,NAME);
			st1.setInt(3,qua);
			st1.setInt(4,pricel);
			st1.setInt(5,priceh);
			st1.setInt(6,priceq);
			st1.setInt(7,pricef);
			st1.executeUpdate();
			System.out.println("Successfully inserted");
			
			 c3.getConnection().close();


		}
	




public void disp() throws ClassNotFoundException, SQLException {
			c3.getConnection();
           
	        Statement st=  (Statement) c3.getConnection().createStatement();
			ResultSet r=st.executeQuery("select * from management");
			while(r.next())
			{
				System.out.println("########################################");
				System.out.println(r.getInt(1)+" "+r.getString(2)+" ("+r.getInt(3)+" )"+r.getInt(4)+" "+r.getInt(5)+" "+r.getInt(6)+" "+r.getInt(7));
				System.out.println("########################################");
			}
			c3.getConnection().close();
		}
public void remove() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	Scanner s=new Scanner(System.in);
	c3.getConnection();
	Statement st=(Statement) c3.getConnection().createStatement();
	System.out.println("Enter the row to be delete");
	int a=s.nextInt();
	PreparedStatement st1=(PreparedStatement) c3.getConnection().prepareStatement("DELETE FROM management WHERE id=?");
	st1.setInt(1, a);
	st1.executeUpdate();
	System.out.println("successfully deleted");
	 c3.getConnection().close();
	

	
}
public void update() throws ClassNotFoundException, SQLException {
	
	// TODO Auto-generated method stub
	Scanner s=new Scanner(System.in);
	System.out.println("enter the id");
	int id1=s.nextInt();
	System.out.printf("enter your product ID");
	int ID=s.nextInt();
	System.out.println("enter your product name");
	String NAME=s.next();
	System.out.println("enter quantity");
	int qua=s.nextInt();
	System.out.println("enter priceltr");
	int pricel=s.nextInt();
	System.out.println("enter pricehalf");
	int priceh=s.nextInt();
	System.out.println("enter priceqtr");
	int priceq=s.nextInt();
	System.out.println("enter pricefull");
	int pricef=s.nextInt();
	
	PreparedStatement pt=c3.getConnection().prepareStatement("update management set id=?,productname=?,quantity=?,priceltr=?,pricehalf=?,priceqtr=?,pricefull=? where id=?");
	pt.setInt(1, ID);
	pt.setString(2, NAME);
	pt.setInt(3, qua);
	pt.setInt(4,pricel);
	pt.setInt(5,priceh);
	pt.setInt(6,priceq);
	pt.setInt(7,pricef);
	pt.setInt(8,id1);
	pt.executeUpdate();
}
		
	}


