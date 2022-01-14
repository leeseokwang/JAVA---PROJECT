package teamProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Member_login extends JPanel {
	private JTextField id;
	private JButton confirm,previous,f_id,f_pw;
	private Start F;
	private JLabel chk,pw2;
	private JPasswordField pw;
	
	
	public Member_login(Start f) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel("  ȸ�� �α���");
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		
		JLabel string1 = new JLabel("ȸ�� �α���");
		add(string1);
		string1.setFont(new Font("���� ���", Font.BOLD, 90));
		string1.setBounds(0, 230, 800, 100);
		string1.setHorizontalAlignment(JLabel.CENTER);
		
		id = new JTextField("���̵�");
		id.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				id.setText("");
			}
		});
		add(id);
		id.setFont(new Font("���� ���", Font.PLAIN, 40));
		id.setForeground(new Color(0xd0d0d0));
		id.setBounds(115, 400, 560, 70);
		id.setText("���̵� �Է�");
		id.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				id.setText("");
				id.setForeground(new Color(0x000000));
			}
		});	
		
		
		pw = new JPasswordField("��й�ȣ");
		pw.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pw.setText("");
				pw.setForeground(new Color(0x000000));
			}
		});
		add(pw);
		pw.setFont(new Font("���� ���", Font.PLAIN, 40));
		pw.setForeground(new Color(0xd0d0d0));
		pw.setBounds(115, 500, 560, 70);
		
		chk = new JLabel("");
		chk.setBounds(115,670,600,100);
		add(chk);
	
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
					boolean chk_member = false;
					ResultSet rs = find_id.executeQuery();
				
					
					while (rs.next()){
						if(rs.getString("MEMBER_ID").equals(id.getText())&&rs.getString("MEMBER_PW").equals(pw.getText())) {

							chk_member = true;
							
							System.out.println("����");
							f.add("main_screen",new Main_screen(f,id.getText(),0)); // ȸ�� = 0 ��ȸ�� = 1
							f.main_screen_Panel();	

							id.setText("���̵�");
							pw.setText("�н�����");
							break;
						}						
					}	
					if (chk_member == false) {
						chk.setText("���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
					}
					chk_member =false;
					
					rs.close();
					find_id.close();
					conn.close();
					
				} catch (SQLException a) {
					a.printStackTrace();
				}
				
				
			}
		});
		add(confirm);
		confirm.setFont(new Font("���� ���", Font.PLAIN, 46));
		confirm.setForeground(new Color(0xffffff));
		confirm.setOpaque(true);
		confirm.setBackground(new Color(0x5777ff));
		confirm.setBounds(115, 610, 560, 94);
		
		previous = new JButton("���� ȭ��");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("�ƾƵ�");
				pw.setText("��й�ȣ");
				chk.setText("");
				f.member_or_non_member_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("���� ���", Font.PLAIN, 35));
		previous.setForeground(new Color(0x222222));
		previous.setOpaque(true);
		previous.setBackground(new Color(0xd0d0d0));
		previous.setBounds(530, 810, 200, 90);
		
		f_id = new JButton("���̵� ã��");
		f_id.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("�ƾƵ�");
				pw.setText("��й�ȣ");
				chk.setText("");
				F.find_id_Panel();
			}
		});
		add(f_id);
		f_id.setFont(new Font("���� ���", Font.PLAIN, 18));
		f_id.setForeground(new Color(0x222222));
		f_id.setOpaque(true);
		f_id.setBackground(new Color(0xc3cdf8));
		f_id.setBounds(355, 735, 150, 50);
		
		f_pw = new JButton("��й�ȣ ã��");
		f_pw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("�ƾƵ�");
				pw.setText("��й�ȣ");
				chk.setText("");
				F.find_pw_Panel();
			}
		});
		add(f_pw);
		f_pw.setFont(new Font("���� ���", Font.PLAIN, 18));
		f_pw.setForeground(new Color(0x222222));
		f_pw.setOpaque(true);
		f_pw.setBackground(new Color(0xc3cdf8));
		f_pw.setBounds(525, 735, 150, 50);
		
		
		setVisible(true);
	}
	public static String idm(String idd) {
		return idd;
	}
}
