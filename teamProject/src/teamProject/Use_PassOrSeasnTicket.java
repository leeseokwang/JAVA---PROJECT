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

public class Use_PassOrSeasnTicket extends JPanel {
	
	private Start F;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Use_PassOrSeasnTicket(Start f,String id, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		String ticket; // Ƽ�� ���� + Ƽ�� �̸�		
		String remaining_days;
		String end_date;
		int t_hour;
		int t_minute;
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/���.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		JLabel string1 = new JLabel("!");
		JLabel string2 = new JLabel("?");
		JButton seat_selection = new JButton("�Խ� : �¼� �����ϱ�");
		JButton prev_btn = new JButton("���� ȭ��");
		if(m_or_nm == 0) {
			ticket = DB_Members.mb_code_arr(id); // Ƽ�� ���� + Ƽ�� �̸�
			if(ticket.equals("")) {
				string1.setText("<html><body style='text-align:center;'>"
						+ "���� ��� ���� Ƽ�� :<br>��� ���� Ƽ���� �����ϴ�.</html>");
				string2.setText("<html><body style='text-align:center;'>"
						+ "Ƽ���� �����Ͻ÷���,<br>����ȭ�� ��ư�� �����ּ���.</html>");
				seat_selection.setEnabled(false);
			} else {
				remaining_days = DB_Members.mb_rd_arr(id);
				end_date = DB_Members.mb_ed_arr(id);
				string1.setText("<html><body style='text-align:center;'>"
						+ "���� ��� ���� Ƽ�� :<br>"+ticket+"</html>");
				if(ticket.contains("daily_ticket") || ticket.contains("pass_ticket")) {
					t_hour = Integer.parseInt(end_date) / 60;
					t_minute = Integer.parseInt(end_date) % 60;
					string2.setText("���� �ð� : "+t_hour+"�ð� "+t_minute+"��");
				} else if(ticket.contains("season_ticket")) {
					string2.setText("��� ���� : "+remaining_days);
				}
				seat_selection.setEnabled(true);
			}			
		} else if(m_or_nm == 1) {
			ticket = DB_Non_Members.nmb_code_arr(id); // Ƽ�� ���� + Ƽ�� �̸�
			if(ticket.equals("")) {
				string1.setText("<html><body style='text-align:center;'>"
						+ "���� ��� ���� Ƽ�� :<br>��� ���� Ƽ���� �����ϴ�.</html>");
				string2.setText("<html><body style='text-align:center;'>"
						+ "Ƽ���� �����Ͻ÷���,<br>����ȭ�� ��ư�� �����ּ���.</html>");
				seat_selection.setEnabled(false);
			} else {
				end_date = DB_Non_Members.nmb_ed_arr(id);
				string1.setText("<html><body style='text-align:center;'>"
						+ "���� ��� ���� Ƽ�� :<br>"+ticket+"</html>");
				if(ticket.contains("daily_ticket") || ticket.contains("pass_ticket")) {
					t_hour = Integer.parseInt(end_date) / 60;
					t_minute = Integer.parseInt(end_date) % 60;
					string2.setText("���� �ð� : "+t_hour+"�ð� "+t_minute+"��");
				}
				seat_selection.setEnabled(true);
			}	
		}
		
		seat_selection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.add("seat_selection",new Seat_Selection(F, id, m_or_nm));
				F.seat_selection_Panel();
			};
		});
		prev_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.main_screen_Panel();
			};
		});
		
		add(string1);
		string1.setFont(new Font("NanumGothic", Font.BOLD, 50));
		string1.setBounds(0, 200, 800, 200);
		string1.setHorizontalAlignment(JLabel.CENTER);
		string1.setVerticalAlignment(JLabel.CENTER);
		add(string2);
		string2.setFont(new Font("NanumGothic", Font.BOLD, 50));
		string2.setBounds(0, 400, 800, 200);
		string2.setHorizontalAlignment(JLabel.CENTER);
		string2.setVerticalAlignment(JLabel.CENTER);
		add(seat_selection);
		seat_selection.setFont(new Font("NanumGothic", Font.PLAIN, 40));
		seat_selection.setForeground(new Color(0xf5f6f7));
		seat_selection.setOpaque(true);
		seat_selection.setBackground(new Color(0x00c850));
		seat_selection.setBounds(115, 670, 560, 94);
		add(prev_btn);
		prev_btn.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
		prev_btn.setForeground(new Color(0xf5f6f7));
		prev_btn.setOpaque(true);
		prev_btn.setBackground(new Color(0x8e8e8e));
		prev_btn.setBounds(530, 810, 200, 90);
	}
}
