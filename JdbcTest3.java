import java.io.*;
public class JdbcTest3{
	public static void main(String[] args) {
		JdbcTest3  jt = new JdbcTest3();
		String dongName = jt.getDong();
		try{
			jt.processDB(dongName);
		}catch(java.sql.SQLException ex){}
	}
	void processDB(String dongName) throws java.sql.SQLException{
		DBBean db = new DBBean();     db.loadDriver();
		db.setConnection();       db.createStatement();
		String sql = "SELECT zipcode, sido, gugun, dong, bunji ";
		sql += "FROM zipcode ";
		sql += "WHERE dong LIKE '%" + dongName + "%' ";
		java.sql.ResultSet rs = db.getResultSet(sql);
		while(rs.next()){
			String zipcode = rs.getString(1); 
			String sido = rs.getString(2);
			String gugun = rs.getString(3);
			String dong = rs.getString(4);
			String bunji = rs.getString(5);
			String address = "(" + zipcode + ") " + sido + " " + gugun;
			address += " " + dong + " " + bunji;
			System.out.println(address);
		}
		db.rsClose();  db.stmtClose();   db.connClose();
	}
	String getDong(){
		String dongName = null;  BufferedReader br;
		System.out.print("찾고자 하시는 동이름 : ");
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			dongName = br.readLine().trim();
		}catch(IOException ex){}
		return dongName;
	}
}
