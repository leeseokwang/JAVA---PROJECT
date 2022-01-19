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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class daily_pass_ticket extends JPanel{
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "hr";
	private static String password = "1234";
	private String[] price = new String[4];
	private int[] pricet = new int[4];
	
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
	
	 // 패널 생성
	 JPanel panel1 = new JPanel();
	 
	 JPanel null1 = new JPanel();
	 
	 // 버튼 생성
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
	 
	 

	

	public daily_pass_ticket(Start f , String id , int m_or_nm){
	//프레임 레이아웃 설정, 사이즈 설정
		F = f;
		setSize(800, 1000);
		setLayout(null);
		panel1.setLayout(null);
		
		
		panel1.setSize(800, 400);
		panel1.setBounds(0, 200, 800,400);
		
		
		String dpt = "UPDATE voucher SET VOUCHER_PRICE = ? WHERE VOUCHER_CODE = ?";
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		
		JLabel string1 = new JLabel("정액권 구매 선택 (개인실 기준)");
		string1.setBounds(100,160,500,50);
		string1.setFont(new Font("NanumBarunGothic", Font.PLAIN | Font.BOLD, 30));
		add(string1);
		
	  
	  
	// 라벨 설정  
	  JLabel label = new JLabel("시간을 선택해주세요");
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
	  
	  
	  panel1.add(btn10);
	  btn10.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
	  btn10.setForeground(new Color(0xf5f6f7));
	  btn10.setOpaque(true);
	  btn10.setBackground(new Color(0x00c850));
	  btn10.setBounds(100, 240, 250, 150);
	  panel1.add(btn11);
	  btn11.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
	  btn11.setForeground(new Color(0xf5f6f7));
	  btn11.setOpaque(true);
	  btn11.setBackground(new Color(0x00c850));
	  btn11.setBounds(450, 240, 250, 150);
	  panel1.add(btn12);
	  btn12.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
	  btn12.setForeground(new Color(0xf5f6f7));
	  btn12.setOpaque(true);
	  btn12.setBackground(new Color(0x00c850));
	  btn12.setBounds(100, 490, 250, 150);
	  panel1.add(btn13);
	  btn13.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
	  btn13.setForeground(new Color(0xf5f6f7));
	  btn13.setOpaque(true);
	  btn13.setBackground(new Color(0x00c850));
	  btn13.setBounds(450, 490, 250, 150);
	  
	  
	  for(int i = 0,j=1;i<price.length;++i,++j) {
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
					pricet[i] = rs.getInt("VOUCHER_PRICE");
				}
				
				
				rs.close();
				voucher_tp_t.close();
				conn.close();
				
			} catch (SQLException a) {
				a.printStackTrace();
			}
		}
	  
	  
	  
	 // 버튼 텍스트 입력 및 폰트 설정
	  btn3.setText("<html>" + "<div style='text-align:center'>" + "1시간" + "<br>" + price[0]);
	  btn4.setText("<html>" + "<div style='text-align:center'>" + "3시간" + "<br>" + price[1]);
	  btn5.setText("<html>" + "<div style='text-align:center'>" + "6시간" + "<br>" + price[2]);
	  btn6.setText("<html>" + "<div style='text-align:center'>" + "12시간" + "<br>" + price[3]);
	  btn7.setText("이전 화면");
	  btn8.setText("개인실 선택");
	  btn9.setText("단체실 선택");
	  String SQL = "UPDATE  members SET VOUCHER_CODE = ? , END_DATE = ? WHERE MEMBER_ID = ?";
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  // 버튼 클릭시 반응
	  btn3.addActionListener(new ActionListener() {
		  
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (id.equals("manager")) {
				String resultStr = JOptionPane.showInputDialog(null,"변동할 가격을 입력하세요","가격을 기입하세요");
				try (
						Connection conn = DriverManager.getConnection(url,user,password);
						PreparedStatement pstmt = conn.prepareStatement(dpt);
				){
					boolean isNumeric = false;
					if(resultStr != null){
						isNumeric =  resultStr.matches("[+-]?\\d*(\\.\\d+)?");							
					}
					if(resultStr != null && isNumeric == true) {
						pstmt.setInt(1, Integer.parseInt(resultStr));
						pstmt.setInt(2, 1);
						pstmt.executeUpdate();													
					}else {							
						pstmt.setInt(1, pricet[0]);
						pstmt.setInt(2, 1);
						pstmt.executeUpdate();
					}		
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}else {
				int voucher_code = 1;
				f.add("payment",new Payment(f, id, voucher_code, m_or_nm));
				f.Payment_Panel();				
			}
//			try (
//					Connection conn = DriverManager.getConnection(url, user, password);
//					PreparedStatement pstmt = conn.prepareStatement(SQL);	
//					){
//				pstmt.setInt(1, 1);
//				pstmt.setString(2, "60");
//				pstmt.setString(3, id);
//				System.out.println("값 들어감");
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
				if (id.equals("manager")) {
					String resultStr = JOptionPane.showInputDialog(null,"변동할 가격을 입력하세요","가격을 기입하세요");
					try (
							Connection conn = DriverManager.getConnection(url,user,password);
							PreparedStatement pstmt = conn.prepareStatement(dpt);
					){
						boolean isNumeric = false;
						if(resultStr != null){
							isNumeric =  resultStr.matches("[+-]?\\d*(\\.\\d+)?");							
						}
						if(resultStr != null && isNumeric == true) {
							pstmt.setInt(1, Integer.parseInt(resultStr));
							pstmt.setInt(2, 2);
							pstmt.executeUpdate();													
						}else {							
							pstmt.setInt(1, pricet[1]);
							pstmt.setInt(2, 2);
							pstmt.executeUpdate();
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}else{
					int voucher_code = 2;
					f.add("payment",new Payment(f, id, voucher_code, m_or_nm));
					f.Payment_Panel();				
				}
//				try (
//						Connection conn = DriverManager.getConnection(url, user, password);
//						PreparedStatement pstmt = conn.prepareStatement(SQL);	
//						){
//					pstmt.setInt(1, 2);
//					pstmt.setString(2, "180");
//					pstmt.setString(3, id);
//					System.out.println("값 들어감");	
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
				if (id.equals("manager")) {
					String resultStr = JOptionPane.showInputDialog(null,"변동할 가격을 입력하세요","가격을 기입하세요");
					try (
							Connection conn = DriverManager.getConnection(url,user,password);
							PreparedStatement pstmt = conn.prepareStatement(dpt);
					){
						boolean isNumeric = false;
						if(resultStr != null){
							isNumeric =  resultStr.matches("[+-]?\\d*(\\.\\d+)?");							
						}
						if(resultStr != null && isNumeric == true) {
							pstmt.setInt(1, Integer.parseInt(resultStr));
							pstmt.setInt(2, 3);
							pstmt.executeUpdate();													
						}else {							
							pstmt.setInt(1, pricet[2]);
							pstmt.setInt(2, 3);
							pstmt.executeUpdate();
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}else {
					int voucher_code = 3;
					f.add("payment",new Payment(f, id, voucher_code, m_or_nm));
					f.Payment_Panel();					
				}
				
//				try (
//						Connection conn = DriverManager.getConnection(url, user, password);
//						PreparedStatement pstmt = conn.prepareStatement(SQL);	
//						){
//					pstmt.setInt(1, 3);
//					pstmt.setString(2, "360");
//					pstmt.setString(3, id);
//					System.out.println("값 들어감");	
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
				if (id.equals("manager")) {
					String resultStr = JOptionPane.showInputDialog(null,"변동할 가격을 입력하세요","가격을 기입하세요");
					try (
							Connection conn = DriverManager.getConnection(url,user,password);
							PreparedStatement pstmt = conn.prepareStatement(dpt);
					){
						boolean isNumeric = false;
						if(resultStr != null){
							isNumeric =  resultStr.matches("[+-]?\\d*(\\.\\d+)?");							
						}
						if(resultStr != null && isNumeric == true) {
							pstmt.setInt(1, Integer.parseInt(resultStr));
							pstmt.setInt(2, 4);
							pstmt.executeUpdate();													
						}else {							
							pstmt.setInt(1, pricet[3]);
							pstmt.setInt(2, 4);
							pstmt.executeUpdate();
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}else {
					int voucher_code = 4;
					f.add("payment",new Payment(f, id, voucher_code, m_or_nm));
					f.Payment_Panel();					
				}
				
				
//				try (
//						Connection conn = DriverManager.getConnection(url, user, password);
//						PreparedStatement pstmt = conn.prepareStatement(SQL);	
//						){
//					pstmt.setInt(1, 4);
//					pstmt.setString(2, "720");
//					pstmt.setString(3, id);
//					System.out.println("값 들어감");	
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
	