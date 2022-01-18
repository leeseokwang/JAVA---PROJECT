package teamProject;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.File;
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
import javax.swing.JPanel;

public class daily_pass_ticket2 extends JPanel{
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "hr";
	private static String password = "1234";
	
	private Start F;
	private CardLayout cards = new CardLayout();
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
		
	
	
	static {
		try {
			
			Class.forName(driverName);
			System.out.println("driver loaded");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	 // �г� ����
	 JPanel panel1 = new JPanel();
	 
	 JPanel null1 = new JPanel();
	 
	 // ��ư ����
	 JButton btn3 = new JButton();
	 JButton btn4 = new JButton();
	 JButton btn5 = new JButton();
	 JButton btn6 = new JButton();
	 JButton btn7 = new JButton();
	 JButton btn8 = new JButton();
	 JButton btn9 = new JButton();
	 JButton btn10 = new JButton();
	 JButton btn11 = new JButton();
	 JButton btn12 = new JButton();
	 JButton btn13 = new JButton();
	 
	 
	//--------------------------------------------------------------------------------
	 
	 

	

	public daily_pass_ticket2(Start f , String id , int m_or_nm){
	//������ ���̾ƿ� ����, ������ ����
		F = f;
		setSize(800, 1000);
		setLayout(null);
		panel1.setLayout(null);
		
		
		panel1.setSize(800, 400);
		panel1.setBounds(0, 200, 800,400);
		
		
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/���.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		
		JLabel string1 = new JLabel("���ױ� ���� ���� (��ü�� ����)");
		string1.setBounds(100,160,500,50);
		string1.setFont(new Font("NanumBarunGothic", Font.PLAIN | Font.BOLD, 30));
		add(string1);
		
		
		
	  
	  
	// �� ����  
	  JLabel label = new JLabel("�ð��� �������ּ���");
	  add(label);
	  label.setHorizontalAlignment(JLabel.CENTER);
	  label.setFont(new Font("NanumGothic" , Font.BOLD, 20));
	  
	  add(btn3);
	  btn3.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
	  btn3.setForeground(new Color(0xf5f6f7));
	  btn3.setOpaque(true);
	  btn3.setBackground(new Color(0x00c850));
	  btn3.setBounds(100, 240, 250, 150);
	  add(btn4);
	  btn4.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
	  btn4.setForeground(new Color(0xf5f6f7));
	  btn4.setOpaque(true);
	  btn4.setBackground(new Color(0x00c850));
	  btn4.setBounds(450, 240, 250, 150);
	  add(btn5);
	  btn5.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
	  btn5.setForeground(new Color(0xf5f6f7));
	  btn5.setOpaque(true);
	  btn5.setBackground(new Color(0x00c850));
	  btn5.setBounds(100, 490, 250, 150);
	  add(btn6);
	  btn6.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
	  btn6.setForeground(new Color(0xf5f6f7));
	  btn6.setOpaque(true);
	  btn6.setBackground(new Color(0x00c850));
	  btn6.setBounds(450, 490, 250, 150);
	  add(btn7);
	  btn7.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
	  btn7.setForeground(new Color(0xf5f6f7));
	  btn7.setOpaque(true);
	  btn7.setBackground(new Color(0x8e8e8e));
	  btn7.setBounds(530, 810, 200, 90);
	  add(btn8);
	  btn8.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
	  btn8.setForeground(new Color(0xf5f6f7));
	  btn8.setOpaque(true);
	  btn8.setBackground(new Color(0x8e8e8e));
	  btn8.setBounds(70, 810, 200, 90);
	  add(btn9);
	  btn9.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
	  btn9.setForeground(new Color(0xf5f6f7));
	  btn9.setOpaque(true);
	  btn9.setBackground(new Color(0x8e8e8e));
	  btn9.setBounds(300, 810, 200, 90);
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 // ��ư �ؽ�Ʈ �Է� �� ��Ʈ ����
	  btn3.setText("<html>" + "<div style='text-align:center'>" + "1�ð�" + "<br>" + "6,000��");
	  btn4.setText("<html>" + "<div style='text-align:center'>" + "3�ð�" + "<br>" + "16,000��");
	  btn5.setText("<html>" + "<div style='text-align:center'>" + "6�ð�" + "<br>" + "30,000��");
	  btn6.setText("<html>" + "<div style='text-align:center'>" + "12�ð�" + "<br>" + "50,000��");
	  btn7.setText("���� ȭ��");
	  btn8.setText("���ν� ����");
	  btn9.setText("��ü�� ����");
	  
	  String SQL = "UPDATE  members SET VOUCHER_CODE = ? , END_DATE = ? WHERE MEMBER_ID = ?";
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  // ��ư Ŭ���� ����
	  btn3.addActionListener(new ActionListener() {
		  
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 int voucher_code = 12;
			f.add("payment",new Payment(f, id, voucher_code, m_or_nm));
	         f.Payment_Panel();
//			try (
//					Connection conn = DriverManager.getConnection(url, user, password);
//					PreparedStatement pstmt = conn.prepareStatement(SQL);	
//					){
//				pstmt.setInt(1, 1);
//				pstmt.setString(2, "60");
//				pstmt.setString(3, id);
//				System.out.println("�� ��");
//				int cnt = pstmt.executeUpdate();
//		}catch (SQLException ex) {
//			ex.printStackTrace();
//		}catch (Exception e1) {	
//			e1.printStackTrace();
//		}
		}
	  });
	  btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int voucher_code = 13;
				f.add("payment",new Payment(f, id, voucher_code, m_or_nm));
		         f.Payment_Panel();
//				try (
//						Connection conn = DriverManager.getConnection(url, user, password);
//						PreparedStatement pstmt = conn.prepareStatement(SQL);	
//						){
//					pstmt.setInt(1, 2);
//					pstmt.setString(2, "180");
//					pstmt.setString(3, id);
//					System.out.println("�� ��");	
//					int cnt = pstmt.executeUpdate();		
//				}catch (SQLException ex) {
//					ex.printStackTrace();
//				}catch (Exception e1) {	
//					e1.printStackTrace();
//				}
			}
		  });
	  btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int voucher_code = 14;
				f.add("payment",new Payment(f, id, voucher_code, m_or_nm));
		         f.Payment_Panel();
				
//				try (
//						Connection conn = DriverManager.getConnection(url, user, password);
//						PreparedStatement pstmt = conn.prepareStatement(SQL);	
//						){
//					pstmt.setInt(1, 3);
//					pstmt.setString(2, "360");
//					pstmt.setString(3, id);
//					System.out.println("�� ��");	
//					int cnt = pstmt.executeUpdate();		
//			}catch (SQLException ex) {
//				ex.printStackTrace();
//			}catch (Exception e1) {	
//				e1.printStackTrace();
//			}
			}
		  });
	  btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int voucher_code = 15;
				f.add("payment",new Payment(f, id, voucher_code, m_or_nm));
		         f.Payment_Panel();
				
				
//				try (
//						Connection conn = DriverManager.getConnection(url, user, password);
//						PreparedStatement pstmt = conn.prepareStatement(SQL);	
//						){
//					pstmt.setInt(1, 4);
//					pstmt.setString(2, "720");
//					pstmt.setString(3, id);
//					System.out.println("�� ��");	
//					int cnt = pstmt.executeUpdate();		
//			}catch (SQLException ex) {
//				ex.printStackTrace();
//			}catch (Exception e1) {	
//				e1.printStackTrace();
//			}
			}
		  });
	  btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
				
			}
		  });
	  btn8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("daily_pass_ticket", new daily_pass_ticket(f,id,m_or_nm));
				f.daily_pass_ticket_Panel();
				
			}
		  });
	  btn9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("daily_pass_ticket2", new daily_pass_ticket2(f,id,m_or_nm));
				f.daily_pass_ticket2_Panel();
			}
		  });
	  
	  
	
	  setVisible(true);
	  
	  }



	
}
	