import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
public class DBBean1{
	private Properties info = null;
	private java.sql.Connection conn = null;
	public DBBean1(){
		info = new Properties();
		try{
			info.load(new FileInputStream("dbinfo.properties"));
		}catch(FileNotFoundException ex){	ex.printStackTrace(); 
		}catch(IOException ex){ ex.printStackTrace(); }
	}
	public void loadDriver(){
		try{
			Class.forName(info.getProperty("DBDRIVER"));
		}catch(ClassNotFoundException ex){
			System.out.println("Class Not Found");
		}
	}
	public void setConnection(){
		String url = info.getProperty("DBURL");
		String user = info.getProperty("DBUSER");
		String passwd = info.getProperty("DBPASSWORD");
		try{
			this.conn = java.sql.DriverManager.getConnection(url, user, passwd);
		}catch(java.sql.SQLException ex){
			System.out.println("Cannot Connect MySql");
		}
	}
	public java.sql.Connection getConnection(){
		if(conn != null) return this.conn;
		else return null;
	}
	public void setStatement(){
		try{
			this.stmt = this.conn.createStatement();
		}catch(java.sql.SQLException ex){
			ex.printStackTrace();
		}
	}
	public java.sql.Statement getStatement(){
		if(stmt != null) return this.stmt;
		else return null;
	}
	public java.sql.ResultSet getResultSet(String sql){
		try{
			this.rs = this.stmt.executeQuery(sql);
		}catch(java.sql.SQLException ex){
			System.out.println(ex.toString());
		}
		if(rs != null) return this.rs;
		else return null;
	}
	public void connClose(){
		try{
			if(this.conn != null) this.conn.close();
		}catch(java.sql.SQLException ex){
			System.out.println("Cannot Connection Close.");
		}
	}
}
