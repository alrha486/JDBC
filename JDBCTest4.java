import java.sql.*;
import java.util.Properties;
public class JDBCTest4{
	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql://localhost/test";
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Driver driver = DriverManager.getDriver(url);
		//boolean isTrue = driver.acceptsURL(url);
		//System.out.println(isTrue);
		//System.out.printf("%d.%d\n", driver.getMajorVersion(),
		//	                                            driver.getMinorVersion());
		Properties  info = new Properties();
		info.put("user", "root");
		info.put("password", "jdbc");
		Connection conn = driver.connect(url, info);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT now()");
		rs.next();
		System.out.println(rs.getString(1));
		conn.close();
	}
}
