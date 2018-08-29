//CallableStatement object
import java.sql.*;
public class CallableTest{
	public static void main(String[] args) {
		DBBean db = new DBBean();
		Connection conn = null;
		try{
			db.loadDriver();    db.setConnection();
			conn = db.getConnection();
			String sql = "{call spTest(?)}";
			CallableStatement  cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "설운도");
			ResultSet rs = cstmt.executeQuery();
			rs.next();
			System.out.printf("%s, %d, %s\n", rs.getString("name"),
				                                                 rs.getInt("age"),
				                                                 rs.getString("phoneno"));
		}catch(SQLException ex){ ex.printStackTrace(); 
		}finally{
			db.connClose();
		}
	}
}
