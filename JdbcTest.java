import java.sql.*;    //1. import 하자.

public class JdbcTest{
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost";
		Connection conn = null;
		Statement stmt = null;
		String sql= "SELECT NOW()";
		ResultSet rs = null;
		try{
			Class.forName(driver);
			System.out.println("Driver Loading Success");
		}catch(ClassNotFoundException ex){
			System.out.println("Class Not Found");
		}
		try{
			conn = DriverManager.getConnection(url, "root", "jdbc");
			System.out.println("Connection Success");
		}catch(SQLException ex){
			System.out.println("Connection Failure");
		}
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			String str = rs.getString(1);
			System.out.println(str);
		}catch(SQLException ex){
			System.out.println(ex);
		}
	}
}
