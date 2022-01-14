package teamProject;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import seatSection_component.DB_Current_users_Add;

public class Main_screen extends JPanel implements ActionListener{
	JButton b1, b2, b3, b4, b5, b6, prev_btn;
	
	
	JLabel j, j1, j2, j3 , j4, j5, j6;
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "hr";
	private static String password = "1234";
	private Start F;
	
	
	
	
	static {
		try {
			
			Class.forName(driverName);
			System.out.println("driver loaded");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Main_screen(Start f,String id, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		setBackground(new Color(0xFFFFFF));
		F = f;
		setBackground(new Color(255,255,255));
		
		
		JLabel header = new JLabel(" MAIN");
		
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0x000000));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 100);
		header.setBackground(new Color(0xBFFFD9));
		
		
		// ���� �̿���� �ܿ��ð� �� ������ ������ ����
		if(DB_Members.mb_vc_type(id) >= 9 && 
				DB_Members.mb_vc_type(id) <= 11) {
			System.out.println("���� ���� �˻�..");
			if(DB_Members.mb_rd_cal(id) <= 0) {
				DB_Members.mb_vc_del(id);
				JOptionPane.showMessageDialog(null, "�Ⱓ���� ����Ǿ����ϴ�.", "�Ⱓ�� ����", JOptionPane.PLAIN_MESSAGE);
			}
		} else if(DB_Members.mb_vc_type(id) == 0) {
			System.out.println("�̿�� ���� ����..");
		} else {
			System.out.println("�ð� ���� �˻�..");
			int deferred_payment = (Integer.parseInt(DB_Members.mb_ed_arr(id)) * -1) * 50;
			if(Integer.parseInt(DB_Members.mb_ed_arr(id)) <= 0) {
				DB_Members.mb_vc_del(id);
				JOptionPane.showMessageDialog(null, "<html>���ױ��� ����Ǿ����ϴ�.<br>�����Ͻ� ��� : "+deferred_payment+"��</html>", "���ױ� ����", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		LocalDate str = LocalDate.now();
		LocalTime str1 = LocalTime.now();
		int hour = str1.getHour();
		int min = str1.getMinute();
		String sql = "SELECT COUNT(SEAT_TYPE) FROM seats where seat_type = 'private_room'";
		String sql1 = "SELECT COUNT(SEAT_TYPE) FROM seats where seat_type = 'meeting_room'";
		String sql2 = "SELECT COUNT(SEAT_TYPE) FROM seats where seat_type = 'common_room'";
		String sql3 = "SELECT COUNT(SEAT_CONDITION) FROM seats where seat_type = 'private_room' and SEAT_CONDITION != 'empty_seat'";
		String sql4 = "SELECT COUNT(SEAT_CONDITION) FROM seats where seat_type = 'meeting_room' and SEAT_CONDITION != 'empty_seat'";
		String sql5 = "SELECT COUNT(SEAT_CONDITION) FROM seats where seat_type = 'common_room' and SEAT_CONDITION != 'empty_seat'";
		
		
		
		try (
				
				Connection conn = DriverManager.getConnection(url, user, password);
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);
				PreparedStatement pstmt4 = conn.prepareStatement(sql4);
				PreparedStatement pstmt5 = conn.prepareStatement(sql5);
				){	
			System.out.println("������ ���̽� ���� ����");
			ResultSet rs = pstmt.executeQuery();
			ResultSet rs1 = pstmt1.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
			ResultSet rs3 = pstmt3.executeQuery();
			ResultSet rs4 = pstmt4.executeQuery();
			ResultSet rs5 = pstmt5.executeQuery();
			
			while(rs.next()) 
			while(rs1.next())
				while(rs2.next())
					while(rs3.next())
						while(rs4.next())
							while(rs5.next())
				
				{
	
		// JButton ����
		b1 = new JButton(new ImageIcon("teamProject/src/icons/���ϱǱ���.jpg"));
		b2 = new JButton(new ImageIcon("teamProject/src/icons/���ױǱ���.jpg"));
		b3 = new JButton(new ImageIcon("teamProject/src/icons/���ױ�����ǻ��.jpg"));
		b4 = new JButton(new ImageIcon("teamProject/src/icons/�ð�����.jpg"));		
		b5 = new JButton(new ImageIcon("teamProject/src/icons/�ڸ��̵�.jpg"));
		b6 = new JButton(new ImageIcon("teamProject/src/icons/���.jpg"));

		prev_btn = new JButton("������");
	

		
		// Jlabel ���� ĭ ����
		j = new JLabel("<html>" + "<div style='text-align:center'>" + "1�ν� ��� �¼�" + "<br>" + rs3.getInt("COUNT(SEAT_CONDITION)") + "/" + rs.getInt("COUNT(SEAT_TYPE)") + "<html>");
		j1 = new JLabel("<html>" + "<div style='text-align:center'>" + "��ü�� ��� �¼�"  + "<br>"+ rs4.getInt("COUNT(SEAT_CONDITION)") + "/" + rs1.getInt("COUNT(SEAT_TYPE)"));
		j2 = new JLabel("<html>" + "<div style='text-align:center'>" + "����� ��� �¼�" + "<br>"+ rs5.getInt("COUNT(SEAT_CONDITION)") + "/" + rs2.getInt("COUNT(SEAT_TYPE)"));
		j3 = new JLabel("<html>" + "<div style='text-align:center'>" + "���� �ð�  " + "<br>"+ str + "  "+ hour + "��" + min + "��" );
		j4 = new JLabel("�� �̿����ȳ� ��");
		j5 = new JLabel("<html><body> ���ϱ� �̿���"
				+ "<br>"
				+ "&nbsp;&nbsp;1) ���ϱ� ���� ����" 
				+ "<br>"
				+ "&nbsp;&nbsp;2) ���ϴ� �ð� ����"
				+ "<br>"
				+ "&nbsp;&nbsp;3) ���ϴ� �� �¼� ����"
				+ "<br>"
				+ "&nbsp;&nbsp;4) ����"
				+"<br>"
				+"<br>"
				+ "����� �̿���"
				+ "<br>"
				+ "&nbsp;&nbsp;1) ȭ���� ����� ��� ����"
				+ "<br>"
				+ "&nbsp;&nbsp;2) �¼� ���� "
				+"<br>"
				+"<br>"
				+"���ױ� ���Թ��"
				+ "<br>"
				+ "&nbsp;&nbsp;1) ȭ���� ���ױ� ���� ����"
				+ "<br>"
				+ "&nbsp;&nbsp;2) �ð� ���� "
				+"<br>"
				+"<br>"
				);
		
		j6 = new JLabel("<html><body> �¼� �̵����"		
				+ "<br>"
				+ "&nbsp;&nbsp;1) ȭ���� �¼� �̵� ����"
				+ "<br>"
				+ "&nbsp;&nbsp;2) �̵��� �¼� ���� "
				+"<br>"
				+"<br>"
				+"<br>"
				+"<br>"
				+"�ð� ������"
				+ "<br>"
				+ "&nbsp;&nbsp;1) ȭ���� �ð� ���� ����"
				+ "<br>"
				+ "&nbsp;&nbsp;2) ������ �ð� ���� "
				+"<br>"
				+"<br>"
				);
		
		
		// Jlabel �ֺ� border ����
		Border border = BorderFactory.createLineBorder(Color.pink);
		j.setBorder(border);
		j1.setBorder(border);
		j2.setBorder(border);
		j3.setBorder(border);
		j.setPreferredSize(new Dimension(150, 100));
		
		j.setHorizontalAlignment(JLabel.CENTER);
		j1.setHorizontalAlignment(JLabel.CENTER);
		j2.setHorizontalAlignment(JLabel.CENTER);
		j3.setHorizontalAlignment(JLabel.CENTER);
		j4.setHorizontalAlignment(JLabel.CENTER);
		
		
		// font �� ���� , ��ġ ����
		b1.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 20 ));
		b1.setBackground(new Color(0xEEF4F6));
		b2.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 20 ));
		b2.setBackground(new Color(0xEEF4F6));
		b3.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 20 ));
		b3.setBackground(new Color(0xEEF4F6));
		b4.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 15 ));
		b4.setBackground(new Color(0xEEF4F6));
		b5.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 20 ));
		b5.setBackground(new Color(0xEEF4F6));
		b6.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 20 ));
		b6.setBackground(new Color(0xEEF4F6));
		j.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 18));
		j1.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 18 ));
		j2.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 18 ));
		j3.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 13 ));
		j4.setFont(new Font("���� ���", Font.BOLD, 25 ));
		j5.setFont(new Font("���� ���", Font.BOLD, 15 ));
		j6.setFont(new Font("���� ���", Font.BOLD, 15 ));
		
		j.setBackground(new Color(0x1DCBEE));
		j1.setBackground(new Color(0x1DCBEE));
		j2.setBackground(new Color(0x1DCBEE));
		j3.setBackground(new Color(0x1DCBEE));

		
		
		prev_btn.setFont(new Font("���� ���", Font.PLAIN, 35));
        prev_btn.setForeground(new Color(0x222222));
        prev_btn.setOpaque(true);
        prev_btn.setBackground(new Color(0xd0d0d0));
        prev_btn.setBounds(530, 850, 200, 90);

		b1.setBounds(80, 260, 200, 100);
		b2.setBounds(290, 260, 200, 100);
		b3.setBounds(500, 260, 200, 100);
		b4.setBounds(80, 370, 200, 100);
		b5.setBounds(290, 370, 200, 100);
		b6.setBounds(500, 370, 200, 100);
		j.setBounds(0, 100, 200, 100);
		j1.setBounds(200, 100, 200, 100);
		j2.setBounds(400, 100, 200, 100);
		j3.setBounds(600, 100, 200, 100);
		j4.setBounds(-10, 280, 800, 500);
		j5.setBounds(130, 460, 800, 500);
		j6.setBounds(480, 430, 800, 500);
		
		

		add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(j);add(j1);add(j2);add(j3);add(prev_btn);add(j4);add(j5);add(j6);

	
		
		
		

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		setLayout(null);
		setVisible(true);

		if (m_or_nm == 1) {               //��ȸ���� ���ױ�/����� ���� ���� �Ұ�      (0 = ȸ�� 1 = ��ȸ��)
			b2.setEnabled(false);
			b3.setEnabled(false);
		}
		

		
		// ��ư Ŭ���� �ٸ� ��� Ȯ��
		b1.addActionListener(new ActionListener() {	//���ϱ� ����	
			@Override
			public void actionPerformed(ActionEvent e) {

				f.add("daily_pass_ticket", new daily_pass_ticket(f,id,m_or_nm));
				f.daily_pass_ticket_Panel();
				
			}
		});
		b2.addActionListener(new ActionListener() {	//�����/���ױ� ����
			@Override
			public void actionPerformed(ActionEvent e) {

				f.add("Buy_a_voucher",  new Buy_a_voucher(f,id));
				f.Buy_a_voucher_Panel();
			}
		});
		b3.addActionListener(new ActionListener() {	// ���ױ�/����� ���
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("Use_PassOrSeasnTicket",new Use_PassOrSeasnTicket(f,id));
				f.use_post_Panel();
			}
		});
		b4.addActionListener(new ActionListener() {	//�ð� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Part();
				setVisible(false);
			}
		});
		b5.addActionListener(new ActionListener() {	//�ڸ��̵�
			@Override
			public void actionPerformed(ActionEvent e) {
				String c_user_seat = DB_Current_users_Add.c_user_seat(id);
				if(c_user_seat.equals("0")) {
					JOptionPane.showMessageDialog(null, "�̿� ���� �ڸ��� �����ϴ�.");
				} else {
					f.add("seat_change",new Seat_change(f,id));
					f.seat_change_Panel();					
				}
			}
		});
		b6.addActionListener(new ActionListener() {	//���
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "��� �Ͻðڽ��ϱ�?", "confirm", JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION) {
					if(DB_Members.mb_vc_type(id) >= 9 && 
							DB_Members.mb_vc_type(id) <= 11) {
						DB_Current_users_Add.c_season_user_del(id);
						System.out.println("���� ������ ����");
						F.base_screen_Panel();
					} else if(DB_Members.mb_vc_type(id) == 0) {
						System.out.println("�̿�Ǿ��� ������ ����");
						F.base_screen_Panel();
					} else {
						if(DB_Current_users_Add.c_user_seat(id).equals("0")) {
							System.out.println("�ð� ������ ����");
							F.base_screen_Panel();				
						} else {
							DB_Current_users_Add.c_user_del(id);
							System.out.println("�ð� ������ ����");
							F.base_screen_Panel();
						}
					}
				}
			}
		});
		prev_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.base_screen_Panel();
				
			}
		});
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

