package teamProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		
		// JButton ���� ( ��ġ , ����, ���)
		b1 = new JButton("ȸ�� �α���");
		b2 = new JButton("��ȸ�� �α���");
		b3 = new JButton("ȸ�� ����");
		b1.setBounds(200, 150, 400, 200);
		b2.setBounds(200, 400, 400, 200);
		b3.setBounds(200, 650, 400, 200);
		b1.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 40 ));
		b1.setBackground(new Color(0xF2F0F1));
		b2.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 40 ));
		b2.setBackground(new Color(0xF2F0F1));
		b3.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 40 ));
		b3.setBackground(new Color(0xF2F0F1));
		
		
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
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public static void main(String[] args) {
		new basic_screen();
	}
}
