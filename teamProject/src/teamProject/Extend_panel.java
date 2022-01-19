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

public class Extend_panel extends JPanel {

	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "hr";
	private static String password = "1234";
	
	private Start F;
	private JButton proom,groom,previous;
	private int grr,voucod;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}

	public Extend_panel(Start f , String id , int m_or_nm) {
		F = f;
		setSize(800, 1000);
		setLayout(null);
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		try {
			Connection conn = DriverManager.getConnection(
					url,
					user,
					password);
			System.out.println("연결 생성 완료.");
			String lt = "";
			if (m_or_nm == 0) {
				lt = "SELECT * FROM members Where member_id = '"+id+"'";						
			}else {
				lt = "SELECT * FROM non_members Where NON_MEMBER_PHONE = '"+id+"'";
			}
			PreparedStatement memtble = conn.prepareStatement(lt);
			ResultSet rs = memtble.executeQuery();
			while(rs.next()) {
				grr = rs.getInt("G_VOUCHER_CODE");
				voucod = rs.getInt("VOUCHER_CODE");
			}
			rs.close();
			memtble.close();
			conn.close();
			
		} catch (SQLException a) {
			a.printStackTrace();
		}

		proom = new JButton("개인실 연장");
		if (m_or_nm == 0) {
			proom.setText("이용권 연장");
		}
		proom.setBounds(150,300,500,150);
		proom.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 40 ));
		proom.setForeground(new Color(0xffffff));
		proom.setBackground(new Color(0x00c850));
		proom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(voucod >= 1 && voucod <=4) {
					f.add("daily_ticket_extend",new Extend_daily_ticket(f,id,m_or_nm));
					f.daily_ticket_extend_Panel();
				}else if (voucod >= 5 && voucod <=8) {
					f.add("pass_ticket_extend",new Extend_pass_ticket(f,id,m_or_nm));
					f.pass_ticket_extend_Panel();
				}else if(voucod >= 9 && voucod <=11) {
					f.add("season_ticket_extend",new Extend_season_ticket(f,id,m_or_nm));
					f.season_ticket_extend_Panel();
				}else if (voucod >= 12 && voucod <=14) {
					f.add("group_room_extend",new Extend_group_room(f,id,m_or_nm));
					f.group_room_extend_Panel();
				}
			}
		});
		add(proom);
		
		groom = new JButton("단체실 연장");
		groom.setBounds(150,500,500,150);
		groom.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 40 ));
		groom.setForeground(new Color(0xffffff));
		groom.setBackground(new Color(0x00c850));
		groom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("group_room_extend",new Extend_group_room(f,id,m_or_nm));
				f.group_room_extend_Panel();	
			}
		});
		add(groom);
		if(grr == 0) {
		groom.setEnabled(false);
		}
		
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
		previous.setForeground(new Color(0xf5f6f7));
		previous.setOpaque(true);
		previous.setBackground(new Color(0x8e8e8e));
		previous.setBounds(530, 810, 200, 90);
	}
}
