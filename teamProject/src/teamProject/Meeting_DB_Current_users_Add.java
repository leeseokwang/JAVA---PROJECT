package teamProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import teamProject.DBConnector;

public class Meeting_DB_Current_users_Add {
   //entry_time에는 입실시간(현재시간)을 넣어서 퇴실할 때 빼준다.
   public static void c_user_add(String seat_number, String id, int m_or_nm) {
      // current_users의 pk를 넣기 위해 총 row를 구하는 것
	  boolean empty;
//      String sql1 = "SELECT COUNT(*) FROM current_users";
//      int user_num = 0;
//      try(
//         Connection conn = DBConnector.getConnection();
//         PreparedStatement pstmt = conn.prepareStatement(sql1);
//         ResultSet rs = pstmt.executeQuery();
//      ){
//         int rowcount = 0;
//         if(rs.next()) user_num = rs.getInt(1) + 1;         
//         
//         rs.close();
//         pstmt.close();
//         conn.close();         
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
      
      
      // current_users의 phone을 넣기위한 것
      // 비회원일 경우에는 실행안되게 
      String sql2 = "SELECT * FROM members WHERE member_id = '"+id+"'";
      String user_phone = "";
      String sql4 = "SELECT * FROM non_members Where non_member_phone = '"+id+"'";
      String non_user_phone = "";
      String phone = "";
      int user_vc_code = 0;
      if(m_or_nm == 0) {
      try(
         Connection conn = DBConnector.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql2);
         ResultSet rs = pstmt.executeQuery();
      ){
         while(rs.next()) {
            user_phone = rs.getString("member_phone");
            phone = user_phone;
            
         }
         rs.close();
         pstmt.close();
         conn.close();         
      } catch (SQLException e) {
         e.printStackTrace();
      }
      String sql5 = "SELECT * FROM members WHERE member_id = '"+id+"'";
		
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql5);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				user_vc_code = rs.getInt("G_voucher_code");
			}
			rs.close();
			pstmt.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
      
      
      }
      if(m_or_nm == 1) {
          try(
             Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql4);
             ResultSet rs = pstmt.executeQuery();
          ){
             while(rs.next()) {
            	 phone = rs.getString("non_member_phone");
            	 
            	 
            	 
             }
             rs.close();
             pstmt.close();
             conn.close();         
          } catch (SQLException e) {
             e.printStackTrace();
          }
          String sql6 = "SELECT * FROM non_members WHERE non_member_phone = '"+id+"'";
  		
  		try(
  			Connection conn = DBConnector.getConnection();
  			PreparedStatement pstmt = conn.prepareStatement(sql6);
  			ResultSet rs = pstmt.executeQuery();
  		){
  			while(rs.next()) {
  				user_vc_code = rs.getInt("G_voucher_code");
  			}
  			rs.close();
  			pstmt.close();
  			conn.close();			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
          
          }
      
      
     
     
      
      
      // current_users DB에 추가하기
      int user_num = Integer.parseInt(seat_number);
      String sql = "INSERT INTO current_users VALUES('"+user_num+"','"+phone+"',"
            + "'"+seat_number+"',TO_CHAR(SYSDATE, 'HH24:MI'), '"+user_vc_code+"')";
      try(
         // DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
         Connection conn = DBConnector.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
      ){
         int insert = pstmt.executeUpdate();
         System.out.println("성공적으로 추가되었습니다.");
         empty = true;
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
    	  empty = false;
         JOptionPane.showConfirmDialog(null, id+ "님은 자리가 있습니다");
         e.printStackTrace();
      } 
      
      if(empty) {
      String sql3 = "UPDATE seats SET seat_condition = 'using_seat' WHERE seat_number ='"+seat_number+"'";      
      try (
         Connection conn = DBConnector.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql3);
      ){
         int update = pstmt.executeUpdate();
         System.out.printf("%d행이 변경되었습니다.", update);
         
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      }
   }
   public static void c_user_del(String id) {
		// current_users의 phone을 넣기위한 것
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
			System.out.printf("%d행이 변경되었습니다.", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users의 남은 시간(end_date)을 가져옴
		String sql5 = "SELECT * FROM current_users WHERE user_phone = ?";
		String chk_in = "";
		int usage_time = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql5);
		){
			pstmt.setString(1, user_phone);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				chk_in = rs.getString("entry_time");
			}
			
			LocalTime str1 = LocalTime.now();
			int hour_a = str1.getHour() * 60;
			int min_a = str1.getMinute();
			int after = hour_a + min_a;
			System.out.println(after);
			
			String hour_b = ""+chk_in.charAt(0) + chk_in.charAt(1);
			String min_b = ""+chk_in.charAt(3) + chk_in.charAt(4);
			int before = Integer.parseInt(hour_b)*60 + Integer.parseInt(min_b);
			System.out.println(before);
			
			if(after > before) {
				usage_time = after - before;
			} else {
				usage_time = 1440 + after - before;
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		// user의 남은 시간(end_date)을 가져옴
		String sql6 = "SELECT * FROM members WHERE member_id = '"+id+"'";
		String end_date = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql6);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				end_date = rs.getString("end_date");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		int end_date_int = Integer.parseInt(end_date) - usage_time;		
		end_date = Integer.toString(end_date_int);
		
		// 현재시간 - 퇴실시간 값을 구해 원래 있던 DB 남은시간에서 빼내줌
		String sql7 = "UPDATE members SET end_date = ? WHERE member_id = ?";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql7);
		){
			pstmt.setString(1, end_date);
			pstmt.setString(2, id);
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET end_date]%d행이 변경되었습니다.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 퇴실버튼을 눌러 필요없어진 current_users DB를 삭제함
		String sql1 = "DELETE FROM current_users WHERE user_phone = ?";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			pstmt.setString(1, user_phone);
			
			int delete = pstmt.executeUpdate();			
			System.out.printf("%d행이 변경되었습니다.", delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
