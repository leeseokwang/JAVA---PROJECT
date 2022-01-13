package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Use_PassOrSeasnTicket extends JPanel {
	
	private Start F;
	
	public Use_PassOrSeasnTicket(Start f,String id) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		String ticket = DB_Members.mb_code_arr(id); // Ƽ�� ���� + Ƽ�� �̸�		
		String remaining_days;
		String end_date;
		int t_hour;
		int t_minute;
		JLabel header = new JLabel(" ���ױ�/����� ���");
		JLabel string1 = new JLabel("!");
		JLabel string2 = new JLabel("?");
		JButton seat_selection = new JButton("�Խ� : �¼� �����ϱ�");
		JButton prev_btn = new JButton("���� ȭ��");
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
		
		seat_selection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.add("seat_selection",new Seat_Selection(F, id));
				F.seat_selection_Panel();
			};
		});
		prev_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.main_screen_Panel();
			};
		});
		
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("���� ���", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		add(string1);
		string1.setFont(new Font("MapoDPP", Font.BOLD, 50));
		string1.setBounds(0, 200, 800, 200);
		string1.setHorizontalAlignment(JLabel.CENTER);
		string1.setVerticalAlignment(JLabel.CENTER);
		add(string2);
		string2.setFont(new Font("MapoDPP", Font.BOLD, 50));
		string2.setBounds(0, 400, 800, 200);
		string2.setHorizontalAlignment(JLabel.CENTER);
		string2.setVerticalAlignment(JLabel.CENTER);
		add(seat_selection);
		seat_selection.setFont(new Font("MapoDPP", Font.PLAIN, 46));
		seat_selection.setForeground(new Color(0xffffff));
		seat_selection.setOpaque(true);
		seat_selection.setBackground(new Color(0x5777ff));
		seat_selection.setBounds(115, 670, 560, 94);
		add(prev_btn);
		prev_btn.setFont(new Font("MapoDPP", Font.PLAIN, 35));
		prev_btn.setForeground(new Color(0x222222));
		prev_btn.setOpaque(true);
		prev_btn.setBackground(new Color(0xd0d0d0));
		prev_btn.setBounds(530, 810, 200, 90);
	}
}
