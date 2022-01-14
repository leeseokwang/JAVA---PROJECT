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
	
	public basic_screen() { // �⺻ ������ ����
		
		setSize(800, 1000);
		setTitle("�⺻ ������");
		
		Container ct = getContentPane(); // ��� �� ����
		ct.setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		JLabel header = new JLabel("  ��ȸ�� �α���");
		// JButton ���� ( ��ġ , ����, ���)
		b1 = new JButton("ȸ�� �α���");
		b2 = new JButton("��ȸ�� �α���");
		b3 = new JButton("ȸ�� ����");
		b1.setBounds(100, 190, 600, 200);
		b2.setBounds(100, 440, 600, 200);
		b3.setBounds(100, 690, 600, 200);
		b1.setFont(new Font("���� ���", Font.PLAIN | Font.BOLD, 65 ));
		b1.setForeground(new Color(0xffffff));
		b1.setBackground(new Color(0x5777ff));
		b2.setFont(new Font("���� ���", Font.PLAIN | Font.BOLD, 65 ));
		b2.setForeground(new Color(0xffffff));
		b2.setBackground(new Color(0x5777ff));
		b3.setFont(new Font("���� ���", Font.PLAIN | Font.BOLD, 65 ));
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
				//new Part(); ���⿡ �޼��常 ���� ��
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
		header.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 35));
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
