package teamProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class basic_screen extends JFrame implements ActionListener{
	JButton b1, b2, b3;
	
	public basic_screen() { // 기본 페이지 설정
		
		setSize(800, 1000);
		setTitle("기본 페이지");
		
		Container ct = getContentPane(); // 배경 색 설정
		ct.setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		JLabel header = new JLabel("  비회원 로그인");
		// JButton 설정 ( 위치 , 색상, 배경)
		b1 = new JButton("회원 로그인");
		b2 = new JButton("비회원 로그인");
		b3 = new JButton("회원 가입");
		b1.setBounds(100, 190, 600, 200);
		b2.setBounds(100, 440, 600, 200);
		b3.setBounds(100, 690, 600, 200);
		b1.setFont(new Font("맑은 고딕", Font.PLAIN | Font.BOLD, 65 ));
		b1.setForeground(new Color(0xffffff));
		b1.setBackground(new Color(0x5777ff));
		b2.setFont(new Font("맑은 고딕", Font.PLAIN | Font.BOLD, 65 ));
		b2.setForeground(new Color(0xffffff));
		b2.setBackground(new Color(0x5777ff));
		b3.setFont(new Font("맑은 고딕", Font.PLAIN | Font.BOLD, 65 ));
		b3.setForeground(new Color(0xffffff));
		b3.setBackground(new Color(0x5777ff));
		
		
		add(b1);add(b2);add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setLayout(null);
		setVisible(true);
		
		b1.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Part(); 여기에 메서드만 들어가면 끝
				setVisible(false);
			}
		});
		b2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Part();
				setVisible(false);
			}
		});
		b3.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Part();
				setVisible(false);
			}
		});
		
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("맑은 고딕", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public static void main(String[] args) {
		new basic_screen();
	}
}
