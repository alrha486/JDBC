public class DBBean{
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost/test";
	private java.sql.Connection conn = null;
	private java.sql.Statement stmt = null;
	private java.sql.ResultSet rs = null;
	public void loadDriver(){
		try{
			Class.forName(DRIVER);
		}catch(ClassNotFoundException ex){
			System.out.println("Class Not Found");
		}
	}
	public void setConnection(){
		try{
			this.conn = java.sql.DriverManager.getConnection(DBURL, "root", "jdbc");
		}catch(java.sql.SQLException ex){
			System.out.println("Cannot Connect MySql");
		}
	}
	public void createStatement(){
		try{
			this.stmt = this.conn.createStatement();
		}catch(java.sql.SQLException ex){
			System.out.println("Cannot Create Statement Object");
		}
	}
	public java.sql.ResultSet getResultSet(String sql){
		try{
			this.rs = this.stmt.executeQuery(sql);
		}catch(java.sql.SQLException ex){
			System.out.println("Query Error");
		}
		return this.rs;
	}
	public void rsClose(){
		try{
			if(this.rs != null) this.rs.close();
		}catch(java.sql.SQLException ex){
			System.out.println("Cannot ResultSet Close.");
		}
	}
	public void stmtClose(){
		try{
			if(this.stmt != null) this.stmt.close();
		}catch(java.sql.SQLException ex){
			System.out.println("Cannot Statement Close.");
		}
	}
	public void connClose(){
		try{
			if(this.conn != null) this.conn.close();
		}catch(java.sql.SQLException ex){
			System.out.println("Cannot Connection Close.");
		}
	}
}
