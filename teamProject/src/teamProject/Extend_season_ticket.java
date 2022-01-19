package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Extend_season_ticket extends JPanel{
	
	private JLabel pass,time_remaining;
	private Start F;
	private JButton odb,sdb,thdb,previous;
	private String[] price = new String[3];
	private String tr;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Extend_season_ticket(Start f,String id, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		setBackground(new Color(0xFFFFFF));
		F = f;
		
		for(int i = 0,j=9;i<price.length;++i,++j) {
			try {
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:XE",
						"hr",
						"1234");
				System.out.println("연결 생성 완료.");
				
				PreparedStatement voucher_tp_t = conn.prepareStatement("SELECT * FROM Voucher Where voucher_code = "+String.valueOf(j));

				ResultSet rs = voucher_tp_t.executeQuery();
				
				while(rs.next()) {
					String money = String.format("%,d", rs.getInt("VOUCHER_PRICE"));
					price[i] = money+"원";
				}
				
				
				rs.close();
				voucher_tp_t.close();
				conn.close();
				
			} catch (SQLException a) {
				a.printStackTrace();
			}
		}
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"hr",
					"1234");
			System.out.println("연결 생성 완료.");
			String lt ="";
			if(m_or_nm == 0) {
				lt = "SELECT * FROM MEMBERS WHERE member_id = '"+id+"'";
			}else {
				lt = "SELECT * FROM non_members WHERE non_member_phone = '"+id+"'";
			}
			PreparedStatement trt = conn.prepareStatement(lt);

			ResultSet rs = trt.executeQuery();
			
			while(rs.next()) {
				String remaining_days = rs.getString("REMAINING_DAYS");
				tr = "기간권 종료일 : "+remaining_days;
			}					
			rs.close();
			trt.close();
			conn.close();
			
		} catch (SQLException a) {
			a.printStackTrace();
		}
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		pass = new JLabel("정기권 연장 기간 선택");
		add(pass);
		pass.setBounds(80,160,400,50);
		pass.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 30));
		
		odb = new JButton("<html><body style='text-align:center;'>1일권<br>"+price[0]+"</html>");
		odb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,9,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(odb);
		odb.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
		odb.setForeground(new Color(0xf5f6f7));
		odb.setOpaque(true);
		odb.setBackground(new Color(0x00c850));
		odb.setBounds(80, 220, 200, 160);
		
		sdb = new JButton("<html><body style='text-align:center;'>7일권<br>"+price[1]+"</html>");
		sdb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,10,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(sdb);
		sdb.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
		sdb.setForeground(new Color(0xf5f6f7));
		sdb.setOpaque(true);
		sdb.setBackground(new Color(0x00c850));
		sdb.setBounds(300, 220, 200, 160);
		
		thdb = new JButton("<html><body style='text-align:center;'>30일권<br>"+price[2]+"</html>");
		thdb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,11,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(thdb);
		thdb.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
		thdb.setForeground(new Color(0xf5f6f7));
		thdb.setOpaque(true);
		thdb.setBackground(new Color(0x00c850));
		thdb.setBounds(520, 220, 200, 160);
		
		time_remaining = new JLabel(tr);
		add(time_remaining);
		time_remaining.setFont(new Font("NanumGothic", Font.BOLD, 50));
		time_remaining.setBounds(0, 550, 800, 200);
		time_remaining.setHorizontalAlignment(JLabel.CENTER);
		time_remaining.setVerticalAlignment(JLabel.CENTER);
		
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("NanumGothic", Font.PLAIN, 35));
		previous.setForeground(new Color(0x222222));
		previous.setOpaque(true);
		previous.setBackground(new Color(0xd0d0d0));
		previous.setBounds(530, 810, 200, 90);
	}
}