package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

	
	public static void main(String[] args) throws SQLException 
	
	{
		String host="localhost";
		String url="jdbc:Mysql://"+host+":"+3306+" /demo";
		String username="root";
		String password="Balkrushna@1995";
		Connection con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		ResultSet result=stmt.executeQuery("Select*from employee where dept='computer'");
		if(result.next())
		{
			System.out.println(result.getString("empname"));
		}
		
		

	}

}
