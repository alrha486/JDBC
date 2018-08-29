import java.sql.*;
public class PrepareTest{
	public static void main(String[] args) {
		DBBean1 db = new DBBean1();
		Connection conn = null;
		try{
			db.loadDriver();    db.setConnection();
			conn = db.getConnection();
			String sql = "INSERT INTO phone_book(name, age, phoneno) ";
			sql += "VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			String [] nameArray = {"조용필", "조성모", "설운도"};
			int [] ageArray = {60, 34, 45};
			String [] phonenoArray = {"011-111-1111", "017-7877-8888",
			                                     "018-4444-5555"};
			for(int i = 0 ; i < 3 ; i++){
				pstmt.setString(1, nameArray[i]);
				pstmt.setInt(2, ageArray[i]);
				pstmt.setString(3, phonenoArray[i]);
				int rows = pstmt.executeUpdate();
				System.out.println(rows + "행 처리됐습니다");
			}
		}catch(Exception ex){   ex.printStackTrace();
		}finally{
			db.connClose();
		}
	}
}
