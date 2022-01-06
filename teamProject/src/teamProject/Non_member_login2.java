package teamProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		ph = new JTextField("��ȭ��ȣ");
		ph.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				ph.setText("");
			}
		});
		ph.setBounds(100,100,600,100);
		add(ph);
		
		pw = new JPasswordField("��й�ȣ");
		pw.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				pw.setText("");
			}
		});

		pw.setBounds(100,250,600,100);
		add(pw);
		
		chk = new JLabel("");
		chk.setBounds(100,350,600,100);
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
							f.add("main_screen",new Main_screen(f,ph.getText()));
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
		
		confirm.setBounds(100,450,270,200);
		add(confirm);
		
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
		previous.setBounds(430,450,270,200);
		add(previous);
	}
}
