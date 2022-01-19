package teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB_Non_Members_Add {
	
	public static void nmb_phone_add(String ph, String pw) {
		String sql = "INSERT INTO non_members VALUES('"+ph+"','"+pw+"', null, null, null, null)";
		try(
			// DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			int insert = pstmt.executeUpdate();
			System.out.println("성공적으로 추가되었습니다.");
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
