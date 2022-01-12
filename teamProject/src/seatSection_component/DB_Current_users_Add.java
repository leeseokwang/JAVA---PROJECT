package seatSection_component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import teamProject.DBConnector;

public class DB_Current_users_Add {
	//entry_time���� �Խǽð�(����ð�)�� �־ ����� �� ���ش�.
	public static void c_user_add(String seat_number, String id) {
		// current_users�� pk�� �ֱ� ���� �� row�� ���ϴ� ��
		boolean empty;
		String sql1 = "SELECT COUNT(*) FROM current_users";
		int user_num = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
		){
			int rowcount = 0;
			if(rs.next()) user_num = rs.getInt(1) + 1;			
			
			rs.close();
			pstmt.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users�� phone�� �ֱ����� ��
		String sql2 = "SELECT * FROM members WHERE member_id = '"+id+"'";
		String user_phone = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				user_phone = rs.getString("member_phone");
			}
			rs.close();
			pstmt.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users DB�� �߰��ϱ�
		String sql = "INSERT INTO current_users VALUES('"+user_num+"','"+user_phone+"',"
				+ "'"+seat_number+"',SYSDATE)";
		try(
			// DBConnector Ŭ�������� DB�� �������� ���� �⺻������ ������.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			int insert = pstmt.executeUpdate();
			System.out.println("���������� �߰��Ǿ����ϴ�.");
			empty = true;
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			empty = false;
			JOptionPane.showMessageDialog(null, id+"���� �ڸ��� �ֽ��ϴ�!");
		}
		if(empty) {
			String sql3 = "UPDATE seats SET seat_condition = 'using_seat' WHERE seat_number ='"+seat_number+"'";		
			try (
					Connection conn = DBConnector.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql3);
					){
				int update = pstmt.executeUpdate();
				System.out.printf("%d���� ����Ǿ����ϴ�.", update);
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
}
