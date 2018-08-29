import java.sql.*;
import java.util.Properties;
public class JDBCTest5{
	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql://localhost/test";
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//java.util.Enumeration enums = DriverManager.getDrivers();
		//while(enums.hasMoreElements()){
		//	System.out.println(enums.nextElement());	
		//}

	}
}
