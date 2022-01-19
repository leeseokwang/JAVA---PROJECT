package teamProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Base_screen extends JPanel {
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	private JButton member_btn,non_member_btn,sign_up_btn;
	private Start F;
	
	
	public Base_screen(Start f) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		member_btn = new JButton("회원/비회원 로그인");
		non_member_btn = new JButton("비회원 이용");
		sign_up_btn = new JButton("회원 가입");
		
		member_btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				F.member_or_non_member_Panel();
			}
		});
		
		non_member_btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				F.non_member_login_Panel();
			}
		});
		
		sign_up_btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				F.sign_up_Panel();
			}
		});
		
		member_btn.setBounds(150,250,500,150);
		member_btn.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 40 ));
		member_btn.setForeground(new Color(0xf5f6f7));
		member_btn.setBackground(new Color(0x00c850));
		non_member_btn.setBounds(150,440,500,150);
		non_member_btn.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 40 ));
		non_member_btn.setForeground(new Color(0xf5f6f7));
		non_member_btn.setBackground(new Color(0x00c850));
		sign_up_btn.setBounds(150,630,500,150);
		sign_up_btn.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 40 ));
		sign_up_btn.setForeground(new Color(0xf5f6f7));
		sign_up_btn.setBackground(new Color(0x00c850));
		
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		add(member_btn);
		add(non_member_btn);
		add(sign_up_btn);
		
		setVisible(true);
	} 
}
