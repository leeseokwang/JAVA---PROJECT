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
			System.out.println("�ε� �Ϸ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2. DriverManager Ŭ������ ���� DB�� �����Ѵ�.
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"hr",
					"1234");
			System.out.println("���� ���� �Ϸ�.");
			
			// 3. ������ ������ ���� ���ϴ� �������� �����Ѵ�.(;�� ����)
			
			// 3-1 ���� �غ��ϱ�
			PreparedStatement fid = conn.prepareStatement("SELECT * FROM members");
			
			// 3-2 �غ��� ���� ���� �� ��� �޾ƿ���
			ResultSet rs = fid.executeQuery();
//			member_id,member_pw,member_name,member_phone
			// 4. �޾ƿ� ���� ����� ������ ����Ѵ�.
			
			while (rs.next()){
				System.out.printf("%s\t%s\t%s\t%s\n",
						rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_PW"),
						rs.getString("MEMBER_NAME"),
						rs.getString("MEMBER_PHONE"));
			}
			
			// 5 . �� ����� ������ �ݵ�� �ݾƾ� �Ѵ�. �ʰ� ������ ������� ��ü�� ����ش�.
			rs.close();
			fid.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
