package teamProject;

import java.awt.CardLayout;
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
import javax.swing.JTextField;

public class Find_id extends JPanel {
	private Start F;
	private JTextField name,ph;
	private JButton confirm,previous;
	private JLabel look_id;
	
	private CardLayout cards = new CardLayout();
	
	public Find_id(Start f) {
		
		
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		look_id = new JLabel("");
		look_id.setBounds(100,350,600,100);
		look_id.setHorizontalAlignment(JLabel.CENTER);
		add(look_id);
		
		name = new JTextField("�̸�");
		name.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});
		name.setBounds(100,100,600,100);
		add(name);

		ph = new JTextField("�ڵ��� ��ȣ");
		ph.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				ph.setText("");
			}
		});
		ph.setBounds(100,250,600,100);
		add(ph);
		
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
		confirm.setBounds(100,450,270,200);
		add(confirm);
		
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
		previous.setBounds(430,450,270,200);
		add(previous);
		
		
		
		setVisible(true);
	}
}
