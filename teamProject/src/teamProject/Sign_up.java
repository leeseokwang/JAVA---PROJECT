package teamProject;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sign_up extends JPanel {

	private Start F;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back3.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Sign_up(Start f) {
		F = f;
		setSize(800, 1000);
		setLayout(null);
//		setVisible(true);
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/ȸ������.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		JLabel string1 = new JLabel("ȸ�� ����");
		add(string1);
		string1.setFont(new Font("MapoDPP", Font.BOLD, 90));
		string1.setBounds(0, 200, 800, 100);
		
		JTextField su_id = new JTextField();
		JPasswordField su_pw = new JPasswordField();
		JLabel string2 = new JLabel("��й�ȣ�� �Է����ּ���.");
		JPasswordField su_pw_chk = new JPasswordField();
		JLabel string3 = new JLabel("��й�ȣ�� Ȯ�����ּ���.");
		JButton su_btn = new JButton("�����ϱ�");
	}
}














