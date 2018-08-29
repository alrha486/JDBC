import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
public class JDBCTest6{
	public static void main(String[] args) 
		       throws SQLException, IOException, ClassNotFoundException{
		Properties info = new Properties();
		info.load(new FileInputStream("C:\\Downloads\\dbinfo.dat"));
		String driver = info.getProperty("DBDRIVER");
		Class.forName(driver);
		String url = info.getProperty("DBURL");
		String user = info.getProperty("USER");
		String passwd = info.getProperty("PASSWORD");
		Connection conn = DriverManager.getConnection(url, user, passwd);
		DatabaseMetaData dbmd = conn.getMetaData();
		System.out.printf("Database Version = %d.%d\n",
			dbmd.getDatabaseMajorVersion(),
			dbmd.getDatabaseMinorVersion());
		System.out.printf("Database Product Version = %s\n",
			dbmd.getDatabaseProductVersion());
		System.out.printf("Database Product Name = %s\n",
			dbmd.getDatabaseProductName());
		System.out.printf("Driver Version = %d.%d\n",
			dbmd.getDriverMajorVersion(),
			dbmd.getDriverMinorVersion());
		System.out.printf("Driver Version2 = %s\n",
			dbmd.getDriverVersion());
		System.out.printf("Driver Name = %s\n",
			dbmd.getDriverName());
		System.out.printf("JDBC Version = %d.%d\n",
			dbmd.getJDBCMajorVersion(),
			dbmd.getJDBCMinorVersion());
		conn.close();
	}
}
