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

import seatSection_component.DB_Current_users_Add;
import seatSection_component.Seat_Change_Button;
import seatSection_component.Seat_Change_Button;

public class Seat_change extends JPanel {
	
	private Start F;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Seat_change(Start f,String id, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		String c_user_seat = "";
		if(m_or_nm == 0) {
			c_user_seat = DB_Current_users_Add.m_c_user_seat(id); // ȸ��			
		} else if (m_or_nm == 1) {
			c_user_seat = DB_Current_users_Add.nm_c_user_seat(id); // ��ȸ��
		}
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/���.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		JLabel string1 = new JLabel("���� �̿� ���� �ڸ� : "+c_user_seat+"�� ��");
		JButton seat1 = new Seat_Change_Button(10, 155, "1", F, id, m_or_nm);
		JButton seat2 = new Seat_Change_Button(10, 235, "2", F, id, m_or_nm);
		JButton seat3 = new Seat_Change_Button(10, 315, "3", F, id, m_or_nm);
		JButton seat4 = new Seat_Change_Button(10, 395, "4", F, id, m_or_nm);
		JButton seat5 = new Seat_Change_Button(10, 475, "5", F, id, m_or_nm);
		JButton seat6 = new Seat_Change_Button(10, 555, "6", F, id, m_or_nm);
		JButton seat7 = new Seat_Change_Button(10, 635, "7", F, id, m_or_nm);
		JButton seat8 = new Seat_Change_Button(10, 715, "8", F, id, m_or_nm);
		JButton seat9 = new Seat_Change_Button(150, 155, "9", F, id, m_or_nm);
		JButton seat10 = new Seat_Change_Button(220, 155, "10", F, id, m_or_nm);
		JButton seat11 = new Seat_Change_Button(290, 155, "11", F, id, m_or_nm);
		JButton seat12 = new Seat_Change_Button(360, 155, "12", F, id, m_or_nm);
		JButton seat13 = new Seat_Change_Button(430, 155, "13", F, id, m_or_nm);
		JButton seat14 = new Seat_Change_Button(500, 155, "14", F, id, m_or_nm);
		JButton seat15 = new Seat_Change_Button(570, 155, "15", F, id, m_or_nm);
		JButton seat16 = new Seat_Change_Button(150, 295, "16", F, id, m_or_nm);
		JButton seat17 = new Seat_Change_Button(220, 295, "17", F, id, m_or_nm);
		JButton seat18 = new Seat_Change_Button(290, 295, "18", F, id, m_or_nm);
		JButton seat19 = new Seat_Change_Button(360, 295, "19", F, id, m_or_nm);
		JButton seat20 = new Seat_Change_Button(430, 295, "20", F, id, m_or_nm);
		JButton seat21 = new Seat_Change_Button(500, 295, "21", F, id, m_or_nm);
		JButton seat22 = new Seat_Change_Button(570, 295, "22", F, id, m_or_nm);
		JButton seat23 = new Seat_Change_Button(150, 365, "23", F, id, m_or_nm);
		JButton seat24 = new Seat_Change_Button(220, 365, "24", F, id, m_or_nm);
		JButton seat25 = new Seat_Change_Button(290, 365, "25", F, id, m_or_nm);
		JButton seat26 = new Seat_Change_Button(360, 365, "26", F, id, m_or_nm);
		JButton seat27 = new Seat_Change_Button(430, 365, "27", F, id, m_or_nm);
		JButton seat28 = new Seat_Change_Button(500, 365, "28", F, id, m_or_nm);
		JButton seat29 = new Seat_Change_Button(570, 365, "29", F, id, m_or_nm);
		JButton seat30 = new Seat_Change_Button(150, 505, "30", F, id, m_or_nm);
		JButton seat31 = new Seat_Change_Button(220, 505, "31", F, id, m_or_nm);
		JButton seat32 = new Seat_Change_Button(290, 505, "32", F, id, m_or_nm);
		JButton seat33 = new Seat_Change_Button(360, 505, "33", F, id, m_or_nm);
		JButton seat34 = new Seat_Change_Button(430, 505, "34", F, id, m_or_nm);
		JButton seat35 = new Seat_Change_Button(500, 505, "35", F, id, m_or_nm);
		JButton seat36 = new Seat_Change_Button(570, 505, "36", F, id, m_or_nm);
		JButton seat37 = new Seat_Change_Button(150, 575, "37", F, id, m_or_nm);
		JButton seat38 = new Seat_Change_Button(220, 575, "38", F, id, m_or_nm);
		JButton seat39 = new Seat_Change_Button(290, 575, "39", F, id, m_or_nm);
		JButton seat40 = new Seat_Change_Button(360, 575, "40", F, id, m_or_nm);
		JButton seat41 = new Seat_Change_Button(430, 575, "41", F, id, m_or_nm);
		JButton seat42 = new Seat_Change_Button(500, 575, "42", F, id, m_or_nm);
		JButton seat43 = new Seat_Change_Button(570, 575, "43", F, id, m_or_nm);
		JButton seat44 = new Seat_Change_Button(150, 715, "44", F, id, m_or_nm);
		JButton seat45 = new Seat_Change_Button(220, 715, "45", F, id, m_or_nm);
		JButton seat46 = new Seat_Change_Button(290, 715, "46", F, id, m_or_nm);
		JButton seat47 = new Seat_Change_Button(360, 715, "47", F, id, m_or_nm);
		JButton seat48 = new Seat_Change_Button(430, 715, "48", F, id, m_or_nm);
		JButton seat49 = new Seat_Change_Button(500, 715, "49", F, id, m_or_nm);
		JButton seat50 = new Seat_Change_Button(570, 715, "50", F, id, m_or_nm);
		JButton seat51 = new Seat_Change_Button(710, 155, "51", F, id, m_or_nm);
		JButton seat52 = new Seat_Change_Button(710, 235, "52", F, id, m_or_nm);
		JButton seat53 = new Seat_Change_Button(710, 315, "53", F, id, m_or_nm);
		JButton seat54 = new Seat_Change_Button(710, 395, "54", F, id, m_or_nm);
		JButton seat55 = new Seat_Change_Button(710, 475, "55", F, id, m_or_nm);
		JButton seat56 = new Seat_Change_Button(710, 555, "56", F, id, m_or_nm);
		JButton seat57 = new Seat_Change_Button(710, 635, "57", F, id, m_or_nm);
		JButton seat58 = new Seat_Change_Button(710, 715, "58", F, id, m_or_nm);
		JButton prev_btn = new JButton("���� ȭ��");
		
		prev_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
			};
		});
		
		add(string1);
		string1.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 35));
		string1.setForeground(new Color(0x545454));
		string1.setBounds(20, 830, 600, 50);
		add(seat1);
		add(seat2);
		add(seat3);
		add(seat4);
		add(seat5);
		add(seat6);
		add(seat7);
		add(seat8);
		add(seat9);
		add(seat10);
		add(seat11);
		add(seat12);
		add(seat13);
		add(seat14);
		add(seat15);
		add(seat16);
		add(seat17);
		add(seat18);
		add(seat19);
		add(seat20);
		add(seat21);
		add(seat22);
		add(seat23);
		add(seat24);
		add(seat25);
		add(seat26);
		add(seat27);
		add(seat28);
		add(seat29);
		add(seat30);
		add(seat31);
		add(seat32);
		add(seat33);
		add(seat34);
		add(seat35);
		add(seat36);
		add(seat37);
		add(seat38);
		add(seat39);
		add(seat40);
		add(seat41);
		add(seat42);
		add(seat43);
		add(seat44);
		add(seat45);
		add(seat46);
		add(seat47);
		add(seat48);
		add(seat49);
		add(seat50);
		add(seat51);
		add(seat52);
		add(seat53);
		add(seat54);
		add(seat55);
		add(seat56);
		add(seat57);
		add(seat58);
		add(prev_btn);
		prev_btn.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
		prev_btn.setForeground(new Color(0xf5f6f7));
		prev_btn.setOpaque(true);
		prev_btn.setBackground(new Color(0x8e8e8e));
		prev_btn.setBounds(530, 810, 200, 90);
	}
}
