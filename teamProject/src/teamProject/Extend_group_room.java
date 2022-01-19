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

public class Extend_group_room extends JPanel {
	
	private JLabel pass,time_remaining;
	private Start F;
	private JButton ohb,thb,shb,twehb,previous;
	private String[] price = new String[4];
	private String tr;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Extend_group_room(Start f,String id, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		setBackground(new Color(0xFFFFFF));
		F = f;
		
		for(int i = 0,j=12;i<price.length;++i,++j) {
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
				int t_hour = rs.getInt("g_end_date") / 60;
				int t_minute = rs.getInt("g_end_date") % 60;
				tr = "남은 시간 : "+t_hour+"시간 "+t_minute+"분";
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
		
		pass = new JLabel("단체실 연장 시간 선택");
		add(pass);
		pass.setBounds(80,160,400,50);
		pass.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 30));
		
		ohb = new JButton("<html><body style='text-align:center;'>1시간<br>"+price[0]+"</html>");		
		ohb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,12,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(ohb);
		ohb.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
		ohb.setForeground(new Color(0xf5f6f7));
		ohb.setOpaque(true);
		ohb.setBackground(new Color(0x00c850));
		ohb.setBounds(80, 220, 300, 130);
		
		thb = new JButton("<html><body style='text-align:center;'>2시간<br>"+price[1]+"</html>");
		thb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,13,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(thb);
		thb.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
		thb.setForeground(new Color(0xf5f6f7));
		thb.setOpaque(true);
		thb.setBackground(new Color(0x00c850));
		thb.setBounds(420, 220, 300, 130);
		
		shb = new JButton("<html><body style='text-align:center;'>4시간<br>"+price[2]+"</html>");
		shb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,14,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(shb);
		shb.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
		shb.setForeground(new Color(0xf5f6f7));
		shb.setOpaque(true);
		shb.setBackground(new Color(0x00c850));
		shb.setBounds(80, 380, 300, 130);
		
		twehb = new JButton("<html><body style='text-align:center;'>8시간<br>"+price[3]+"</html>");
		twehb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,15,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(twehb);
		twehb.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
		twehb.setForeground(new Color(0xf5f6f7));
		twehb.setOpaque(true);
		twehb.setBackground(new Color(0x00c850));
		twehb.setBounds(420, 380, 300, 130);
		
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