package seatSection_component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import teamProject.DBConnector;

public class DB_Seats {
	
	public static boolean seats_num_arr(String keyword) {
		// 공석이면 true 아니면 false
		String sql = "SELECT * FROM seats";
		ArrayList<Seat> seats = new ArrayList<>();
		Integer seat_n = Integer.parseInt(keyword) - 1;
		boolean empty_seat = false;
		
		try(
			// DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				seats.add(new Seat(rs));
			}

			if(seats.get(seat_n).seat_condition.equals("empty_seat")) {
				empty_seat = true;
			} else {
				empty_seat = false;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empty_seat;
	}
}

class Seat{
	Integer seat_number;
	String seat_type;
	String seat_condition;
	
	public Seat(ResultSet rs) throws SQLException {
		seat_number = rs.getInt("seat_number");
		seat_type = rs.getString("seat_type");
		seat_condition = rs.getString("seat_condition");
	}
	
	@Override
	public String toString() {
		return String.format("%d, %s, %s\n",
				seat_number, seat_type, seat_condition);		
	}
}