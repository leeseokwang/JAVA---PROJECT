package teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB_Non_Members_Add {
	
	public static void nmb_phone_add(String ph, String pw) {
		String sql = "INSERT INTO non_members VALUES('"+ph+"','"+pw+"', null)";
		try(
			// DBConnector Ŭ�������� DB�� �������� ���� �⺻������ ������.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			int insert = pstmt.executeUpdate();
			System.out.println("���������� �߰��Ǿ����ϴ�.");
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
