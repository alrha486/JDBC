public class JdbcTest2{
	public static void main(String[] args) throws java.sql.SQLException{
		DBBean db = new DBBean();
		db.loadDriver();
		db.setConnection();
		db.createStatement();
		String sql = "SELECT * FROM phone_book WHERE name='이미자'";
		java.sql.ResultSet rs = db.getResultSet(sql);
		rs.next();
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String phoneno = rs.getString(3);
		System.out.println(name + ", " + age + ", " + phoneno);
		db.rsClose();   db.stmtClose();  db.connClose();
	}
}
