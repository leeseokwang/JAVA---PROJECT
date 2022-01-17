package teamProject;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Find_id extends JPanel {
	private Start F;
	private JTextField name,ph;
	private JButton confirm,previous;
	private JLabel look_id;
	
	private CardLayout cards = new CardLayout();
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Find_id(Start f) {
		
		
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/���.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		JLabel string1 = new JLabel("���̵� ã��");
		add(string1);
		string1.setFont(new Font("NanumBarunGothic", Font.BOLD, 50));
		string1.setForeground(new Color(0x222222));
		string1.setBounds(0, 230, 800, 100);
		string1.setHorizontalAlignment(JLabel.CENTER);
		
		look_id = new JLabel("");
		look_id.setBounds(115,540,600,100);
		add(look_id);
		
		name = new JTextField("�̸�");
		name.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});
		add(name);
		name.setFont(new Font("NanumGothic", Font.PLAIN, 40));
//		name.setForeground(new Color(0xd0d0d0));
		name.setBounds(115, 400, 560, 70);

		ph = new JTextField("�ڵ��� ��ȣ");
		ph.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				ph.setText("");
			}
		});
		add(ph);
		ph.setFont(new Font("NanumGothic", Font.PLAIN, 40));
//		ph.setForeground(new Color(0xd0d0d0));
		ph.setBounds(115, 500, 560, 70);
		
		confirm = new JButton("Ȯ��");
		confirm.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@127.0.0.1:1521:XE",
							"hr",
							"1234");
					System.out.println("���� ���� �Ϸ�.");
					
					PreparedStatement find_id = conn.prepareStatement("SELECT * FROM MEMBERS");
					boolean fid = false;
					ResultSet rs = find_id.executeQuery();
				
					
					while (rs.next()){
						if(rs.getString("MEMBER_NAME").equals(name.getText())&&rs.getString("MEMBER_PHONE").equals(ph.getText())) {
							System.out.println(rs.getString("MEMBER_ID"));
							look_id.setText("������ ���̵�� : "+rs.getString("MEMBER_ID") +" �Դϴ�.");		
							fid = true;
							break;
						}						
					}	
					if (fid == false) {
						look_id.setText("�̸� Ȥ�� ��ȭ��ȣ�� �ùٸ��� �ʽ��ϴ�.");
					}
					fid =false;
					
					rs.close();
					find_id.close();
					conn.close();
					
				} catch (SQLException a) {
					a.printStackTrace();
				}
				
				
			}
		});
		add(confirm);
		confirm.setFont(new Font("NanumGothic", Font.PLAIN, 40));
		confirm.setForeground(new Color(0xffffff));
		confirm.setOpaque(true);
		confirm.setBackground(new Color(0x00c850));
		confirm.setBounds(115, 610, 560, 94);
		
		previous = new JButton("���� ȭ��");
		previous.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText("�̸�");
				ph.setText("�ڵ��� ��ȣ");
				look_id.setText("");
				f.member_login_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
		previous.setForeground(new Color(0xf5f6f7));
		previous.setOpaque(true);
		previous.setBackground(new Color(0x8e8e8e));
		previous.setBounds(530, 810, 200, 90);
		
		
		
		setVisible(true);
	}
}
