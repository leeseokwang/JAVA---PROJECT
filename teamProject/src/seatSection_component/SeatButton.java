package seatSection_component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import teamProject.Start;

public class SeatButton extends JButton {
	
	private Start F;
	
	public SeatButton(int x, int y, String seat_number, Start f, String id) {
		
		F = f;
		
		if(DB_Seats.seats_num_arr(seat_number)) {
			setText(seat_number);
			setLocation(x, y);
			setSize(60, 60);		
			setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 18));
			setForeground(new Color(0x545454));
			setOpaque(true);
			setBackground(new Color(0xdedede));
			setHorizontalAlignment(JLabel.CENTER);
			setVerticalAlignment(JLabel.CENTER);
			
			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int answer = JOptionPane.showConfirmDialog(null, ""+seat_number+"번 자리를 사용하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION );
					if(answer==JOptionPane.YES_OPTION) {
						if(DB_Current_users_Add.m_c_user_add(seat_number, id)) F.base_screen_Panel();
					}					
				}
			});			
		} else {
			setText(seat_number);
			setLocation(x, y);
			setSize(60, 60);		
			setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 18));
			setForeground(new Color(0xdedede));
			setOpaque(true);
			setBackground(new Color(0x545454));
			setHorizontalAlignment(JLabel.CENTER);
			setVerticalAlignment(JLabel.CENTER);
			setEnabled(false);
		}		
	}
	
}
