package teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB_Non_Members {
	
	public static boolean nmb_phone_arr(String keyword) {
		String sql = "SELECT * FROM non_members";
		ArrayList<String> non_member_phones = new ArrayList<>();
		try(
			// DBConnector Ŭ�������� DB�� �������� ���� �⺻������ ������.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				// ������ �ڵ��� ��ȣ�� non_member_phones ����Ʈ�� ����.
				non_member_phones.add(rs.getString("non_member_phone"));
			}
			for(int i = 0; i < non_member_phones.size(); i++) {
				if(non_member_phones.get(i).equals(keyword)) return false;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	// ������ ���̵� Ű����� �޾��� �� �� ����� �ٿ����ڵ带 ����
	public static int nmb_vc_type(String keyword) {
		String sql = "SELECT * FROM non_members WHERE non_member_phone = '"+keyword+"'";
		int temp = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				temp = rs.getInt("voucher_code");
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	// ������ ���̵� Ű����� ������ ������ ���� �ð��� ����
	public static String nmb_ed_arr(String keyword) {
		String sql = "SELECT * FROM non_members WHERE non_member_phone = '"+keyword+"'";
		String temp = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				temp = rs.getString("end_date");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	// ����� id���� Ű����� ������ �� ����� �ٿ���_Ÿ�� + �ٿ���_������ ���� 
	public static String nmb_code_arr(String keyword) {
		String sql = "SELECT * FROM non_members INNER JOIN voucher USING (voucher_code) "
				+ "WHERE non_member_phone = '"+keyword+"'";
		String temp = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				temp = rs.getString("voucher_type") +" "+rs.getString("voucher_name");
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	// ���� Ȥ�� �ð��� �ٵ� ������ �ٿ����ڵ带 �η� �ٲ���
	public static void nmb_vc_del(String keyword) {
		String sql1 = "UPDATE non_members SET voucher_code = null, "
				+ "end_date = null WHERE non_member_phone = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE non_members SET] %d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	// ��ü�� ��ǽ� �ʱ�ȭ
	public static void nmb_gvc_del(String keyword) {
		String sql1 = "UPDATE non_members SET G_VOUCHER_CODE = null, "
				+ "G_END_DATE = null WHERE non_member_phone = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET] %d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users�� seat_number�� �������� ���� ��
		String sql4 = "SELECT * FROM current_users WHERE user_phone = '"+keyword+"'";
		int seat_number = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql4);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				seat_number = rs.getInt("seat_number");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ��� �� seat_condition�� �ٽ� empty_seat�� �ٲ���
		String sql3 = "UPDATE seats SET seat_condition = 'empty_seat' WHERE seat_number = "+seat_number+"";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql3);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE seats SET seat_condition]%d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ��ǹ�ư�� ���� �ʿ������ current_users DB�� ������
		String sql5 = "DELETE FROM current_users WHERE user_phone = ?";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql5);
		){
			pstmt.setString(1, keyword);
			
			int delete = pstmt.executeUpdate();			
			System.out.printf("[DELETE FROM current_users]%d���� ����Ǿ����ϴ�.\n", delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
