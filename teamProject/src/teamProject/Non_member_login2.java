package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

public class Non_member_login2 extends JPanel{
	private JTextField ph;
	private JPasswordField pw;
	private JLabel chk;
	private JButton confirm,previous;
	private Start F;
	
	Non_member_login2(Start f){
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel("  ��ȸ�� �α���");
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		
		JLabel string1 = new JLabel("��ȸ�� �α���");
		add(string1);
		string1.setFont(new Font("���� ���", Font.BOLD, 90));
		string1.setBounds(0, 230, 800, 100);
		string1.setHorizontalAlignment(JLabel.CENTER);
		
		ph = new JTextField("��ȭ��ȣ");
		ph.addFocusListener(new FocusAdapter() {		
			@Override
			public void focusGained(FocusEvent e) {
				ph.setText("");
				ph.setForeground(new Color(0x000000));
			}
		});
		add(ph);
		ph.setFont(new Font("���� ���", Font.PLAIN, 40));
		ph.setForeground(new Color(0xd0d0d0));
		ph.setBounds(115, 400, 560, 70);
		ph.setText("��ȭ��ȣ �Է�");
		
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
					
					PreparedStatement find_id = conn.prepareStatement("SELECT * FROM NON_MEMBERS");
					boolean chk_member = false;
					ResultSet rs = find_id.executeQuery();
				
					
					while (rs.next()){
						if(rs.getString("NON_MEMBER_PHONE").equals(ph.getText())&&rs.getString("NON_MEMBER_PW").equals(pw.getText())) {
							
							chk_member = true;
							System.out.println("����");
							f.add("main_screen",new Main_screen(f,ph.getText(),1));// ȸ�� = 0 ��ȸ�� = 1
							f.main_screen_Panel();	
							ph.setText("��ȭ��ȣ");
							pw.setText("�н�����");
							break;
						}						
					}	
					if (chk_member == false) {
						chk.setText("��ȭ��ȣ Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
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
				ph.setText("��ȭ��ȣ");
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
	}
}
