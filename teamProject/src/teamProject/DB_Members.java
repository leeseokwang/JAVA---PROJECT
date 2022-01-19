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
	
	// 정보를 받으면 정보대로 멤버에 추가됨
	public static void mb_id_add(String id, String pw, String name, String ph) {
		String sql = "INSERT INTO members VALUES(?, ?, ?, ?, null, null, null, null, null)";
		try(
			// DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, ph);
			
			int insert = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET] %d행이 변경되었습니다.\n", insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//멤버의 아이디 중에 키워드가 있는지 확인, 있으면 폴스 없으면 트루
	public static boolean mb_id_arr(String keyword) {
		String sql = "SELECT * FROM members";
		ArrayList<String> member_id = new ArrayList<>();
		try(
			// DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
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
	
	// 멤버의 핸드폰 번호 중에 키워드가 있는지 확인, 있으면 폴스 없으면 트루
	public static boolean mb_phone_arr(String keyword) {
		String sql = "SELECT * FROM members";
		ArrayList<String> member_phone = new ArrayList<>();
		try(
			// DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				// 논멤버의 핸드폰 번호를 non_member_phones 리스트에 담음.
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
	
	// 멤버의 id값을 키워드로 받으면 그 멤버의 바우쳐_타입 + 바우쳐_네임을 리턴 
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
	
	// 멤버의 아이디를 키워드로 받았을 때 그 멤버의 바우쳐코드를 리턴
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
	
	// 멤버의 아이디를 키워드로 바드면 그 멤버의 남은 기한을 리턴
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
	
	// 멤버의 아이디를 키워드로 받으면 멤버의 남은 시간을 리턴
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
	
	// 멤버의 남은 날짜 계산
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
	
	
	// 기한 혹은 시간이 다된 멤버의 바우쳐코드를 널로 바꿔줌
	public static void mb_vc_del(String keyword) {
		String sql1 = "UPDATE members SET voucher_code = null, "
				+ "remaining_days = null, end_date = null WHERE member_id = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET] %d행이 변경되었습니다.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	// 단체실 퇴실시 초기화
	public static void mb_gvc_del(String keyword) {
		String sql1 = "UPDATE members SET G_VOUCHER_CODE = null, "
				+ "G_END_DATE = null WHERE member_id = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET] %d행이 변경되었습니다.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users의 phone을 넣기위한 것
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
		
		// current_users의 seat_number를 가져오기 위한 것
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
			pstmt.setString(1, user_phone);
			
			int delete = pstmt.executeUpdate();			
			System.out.printf("[DELETE FROM current_users]%d행이 변경되었습니다.\n", delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
