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
			// DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				// 논멤버의 핸드폰 번호를 non_member_phones 리스트에 담음.
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
	
	// 논멤버의 아이디를 키워드로 받았을 때 그 멤버의 바우쳐코드를 리턴
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
	
	// 논멤버의 아이디를 키워드로 받으면 논멤버의 남은 시간을 리턴
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
	
	// 기한 혹은 시간이 다된 논멤버의 바우쳐코드를 널로 바꿔줌
	public static void nmb_vc_del(String keyword) {
		String sql1 = "UPDATE non_members SET voucher_code = null, "
				+ "end_date = null WHERE non_member_phone = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE non_members SET] %d행이 변경되었습니다.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	// 단체실 퇴실시 초기화
	public static void nmb_gvc_del(String keyword) {
		String sql1 = "UPDATE non_members SET G_VOUCHER_CODE = null, "
				+ "G_END_DATE = null WHERE non_member_phone = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET] %d행이 변경되었습니다.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users의 seat_number를 가져오기 위한 것
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
		
		// 퇴실 시 seat_condition을 다시 empty_seat로 바꿔줌
		String sql3 = "UPDATE seats SET seat_condition = 'empty_seat' WHERE seat_number = "+seat_number+"";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql3);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE seats SET seat_condition]%d행이 변경되었습니다.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 퇴실버튼을 눌러 필요없어진 current_users DB를 삭제함
		String sql5 = "DELETE FROM current_users WHERE user_phone = ?";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql5);
		){
			pstmt.setString(1, keyword);
			
			int delete = pstmt.executeUpdate();			
			System.out.printf("[DELETE FROM current_users]%d행이 변경되었습니다.\n", delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
