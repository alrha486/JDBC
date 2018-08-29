import java.sql.*;     //1. import 하자
public class JdbcTest1{
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost/test";
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//2. JDBC Driver 등록하자.
		try{
			Class.forName(DRIVER);
		}catch(ClassNotFoundException ex){
			System.out.println("Class Not Found");
		}
		//3. DB Connection 하자.
		//jdbc protocal ==> jdbc:subprotocol://hostname/database
		try{
			conn = DriverManager.getConnection(DBURL, "root", "jdbc");
		}catch(SQLException ex){
			System.out.println("Can't Connect...");
		}
		//4. Statement 객체 생성
		try{
			stmt = conn.createStatement();
			String sql = "SELECT name, age, phoneno FROM phone_book";
		//5. DB에 질의어 사용하기
			rs = stmt.executeQuery(sql);
			rs.next();
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String phoneno = rs.getString(3);
			System.out.println(name + ", " + age + ", " + phoneno);
		}catch(SQLException ex){
			System.out.println("SQL Exception 발생");
		}
		//6. Close 하자.
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(SQLException ex){
			System.out.println("Can't Close");
		}
	}
}
