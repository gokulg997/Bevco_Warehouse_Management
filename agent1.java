package Bevco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class agent1 {

	public void aglog() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	Scanner s=new Scanner(System.in);
	int op;
	buyproduct buy=new buyproduct();
	do {
		System.out.println("1.buy");
		System.out.println("2.view");
		System.out.println("3.exit");
		System.out.println("Enter your choice");
		op=s.nextInt();
		switch(op) {
		case 1:
			buy.pro();
			break;
		case 2:
			buy.view();
			break;
			
		
		}
	}while(op!=3);
	}

}
class buyproduct{
	Connection1 c3=new Connection1();

	public void pro() throws SQLException, ClassNotFoundException {
		Scanner s=new Scanner(System.in);
		System.out.println(" Enter the Id");
		int op2=s.nextInt();
		System.out.println("Enter the Quantity");
		int op3=s.nextInt();
		System.out.println("Cost is:");
		c3.getConnection();
           
        Statement st= (Statement) c3.getConnection().createStatement();
		ResultSet r=st.executeQuery("select priceltr from mangement where id=?");
		
		ResultSet r1=st.executeQuery("select quantity from management where id=?");
		
		while(r.next())
		{
			int go=r.getInt(1);
			System.out.println(go*op3);
			
		}
		while(r1.next())
		{
			int c=r1.getInt(2);
			int d=c-op3;
			
		}
		c3.getConnection().close();
		
		System.out.println("Enter 1 to confirm Booking");
		int a=s.nextInt();
		if(a==1) {
			System.out.println("Your Booking is Confirmed\r\n" + 
					"Thank you...!!!");
		}
	}

	public void view() {
		
		// TODO Auto-generated method stub
		System.out.println("");
		}}
