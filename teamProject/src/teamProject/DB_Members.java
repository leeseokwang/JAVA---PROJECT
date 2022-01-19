package teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DB_Members {
	
	// ������ ������ ������� ����� �߰���
	public static void mb_id_add(String id, String pw, String name, String ph) {
		String sql = "INSERT INTO members VALUES(?, ?, ?, ?, null, null, null, null, null)";
		try(
			// DBConnector Ŭ�������� DB�� �������� ���� �⺻������ ������.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, ph);
			
			int insert = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET] %d���� ����Ǿ����ϴ�.\n", insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//����� ���̵� �߿� Ű���尡 �ִ��� Ȯ��, ������ ���� ������ Ʈ��
	public static boolean mb_id_arr(String keyword) {
		String sql = "SELECT * FROM members";
		ArrayList<String> member_id = new ArrayList<>();
		try(
			// DBConnector Ŭ�������� DB�� �������� ���� �⺻������ ������.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				member_id.add(rs.getString("member_id"));
			}
			for(int i = 0; i < member_id.size(); i++) {
				if(member_id.get(i).equals(keyword)) return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	// ����� �ڵ��� ��ȣ �߿� Ű���尡 �ִ��� Ȯ��, ������ ���� ������ Ʈ��
	public static boolean mb_phone_arr(String keyword) {
		String sql = "SELECT * FROM members";
		ArrayList<String> member_phone = new ArrayList<>();
		try(
			// DBConnector Ŭ�������� DB�� �������� ���� �⺻������ ������.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				// ������ �ڵ��� ��ȣ�� non_member_phones ����Ʈ�� ����.
				member_phone.add(rs.getString("member_phone"));
			}
			for(int i = 0; i < member_phone.size(); i++) {
				if(member_phone.get(i).equals(keyword)) return false;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	// ����� id���� Ű����� ������ �� ����� �ٿ���_Ÿ�� + �ٿ���_������ ���� 
	public static String mb_code_arr(String keyword) {
		String sql = "SELECT * FROM members INNER JOIN voucher USING (voucher_code) "
				+ "WHERE member_id = '"+keyword+"'";
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
	
	// ����� ���̵� Ű����� �޾��� �� �� ����� �ٿ����ڵ带 ����
	public static int mb_vc_type(String keyword) {
		String sql = "SELECT * FROM members WHERE member_id = '"+keyword+"'";
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
	
	// ����� ���̵� Ű����� �ٵ�� �� ����� ���� ������ ����
	public static String mb_rd_arr(String keyword) {
		String sql = "SELECT * FROM members WHERE member_id = '"+keyword+"'";
		String temp = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				temp = rs.getString("remaining_days");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	// ����� ���̵� Ű����� ������ ����� ���� �ð��� ����
	public static String mb_ed_arr(String keyword) {
		String sql = "SELECT * FROM members WHERE member_id = '"+keyword+"'";
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
	
	// ����� ���� ��¥ ���
	public static int mb_rd_cal(String keyword) {
		String sql = "SELECT * FROM members WHERE member_id = '"+keyword+"'";
		String temp = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				temp = rs.getString("remaining_days");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		long calDate = 0;
		String r_date = ""+temp.charAt(0)+temp.charAt(1)+temp.charAt(2)+temp.charAt(3)+
				"-"+temp.charAt(5)+temp.charAt(6)+"-"+temp.charAt(8)+temp.charAt(9);
		String n_date = ""+LocalDate.now();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date date1 = format.parse(r_date);
			Date date2 = format.parse(n_date);
			calDate = date1.getTime() - date2.getTime();
			System.out.println(calDate);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return (int)calDate;
	}
	
	
	// ���� Ȥ�� �ð��� �ٵ� ����� �ٿ����ڵ带 �η� �ٲ���
	public static void mb_vc_del(String keyword) {
		String sql1 = "UPDATE members SET voucher_code = null, "
				+ "remaining_days = null, end_date = null WHERE member_id = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET] %d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	// ��ü�� ��ǽ� �ʱ�ȭ
	public static void mb_gvc_del(String keyword) {
		String sql1 = "UPDATE members SET G_VOUCHER_CODE = null, "
				+ "G_END_DATE = null WHERE member_id = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET] %d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users�� phone�� �ֱ����� ��
		String sql2 = "SELECT * FROM members WHERE member_id = '"+keyword+"'";
		String user_phone = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				user_phone = rs.getString("member_phone");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users�� seat_number�� �������� ���� ��
		String sql4 = "SELECT * FROM current_users WHERE user_phone = '"+user_phone+"'";
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
			pstmt.setString(1, user_phone);
			
			int delete = pstmt.executeUpdate();			
			System.out.printf("[DELETE FROM current_users]%d���� ����Ǿ����ϴ�.\n", delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
