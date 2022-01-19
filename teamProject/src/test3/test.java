package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2. DriverManager 클래스를 통해 DB에 연결한다.
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"hr",
					"1234");
			System.out.println("연결 생성 완료.");
			
			// 3. 생성된 연결을 통해 원하는 쿼리문을 전달한다.(;은 생략)
			
			// 3-1 구문 준비하기
			PreparedStatement fid = conn.prepareStatement("SELECT * FROM members");
			
			// 3-2 준비한 구문 실행 후 결과 받아오기
			ResultSet rs = fid.executeQuery();
//			member_id,member_pw,member_name,member_phone
			// 4. 받아온 쿼리 결과를 마음껏 사용한다.
			
			while (rs.next()){
				System.out.printf("%s\t%s\t%s\t%s\n",
						rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_PW"),
						rs.getString("MEMBER_NAME"),
						rs.getString("MEMBER_PHONE"));
			}
			
			// 5 . 다 사용한 연결은 반드시 닫아야 한다. 늦게 생성한 순서대로 객체를 당아준다.
			rs.close();
			fid.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
