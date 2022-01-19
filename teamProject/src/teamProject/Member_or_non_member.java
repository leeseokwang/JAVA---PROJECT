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

public class Member_or_non_member extends JPanel {
	
	private JButton member,non_member,previous;
	private Start F;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Member_or_non_member(Start f) {
		
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		member = new JButton("회원 로그인");
		member.setBounds(150,300,500,150);
		member.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 40 ));
		member.setForeground(new Color(0xffffff));
		member.setBackground(new Color(0x00c850));
		member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.member_login_Panel();
				
			}
		});
		add(member);
		
		
		non_member = new JButton("비회원 로그인");
		non_member.setBounds(150,500,500,150);
		non_member.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 40 ));
		non_member.setForeground(new Color(0xffffff));
		non_member.setBackground(new Color(0x00c850));
		non_member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.Non_member_login2_Panel();
				
			}
		});
		add(non_member);
		
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.base_screen_Panel();
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
