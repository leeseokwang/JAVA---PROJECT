package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Meeting_SeatButton extends JButton{
	private Start F;
	
	
	public Meeting_SeatButton(int x, int y, String seat_number, Start f, String id) {
		F = f;
		if(DB_Seats.seats_num_arr(seat_number)) {
	         setText("��ü ���̳���" + seat_number);
	         setLocation(x, y);
	         setSize(250, 250);      
	         setFont(new Font("MapoDPP", Font.PLAIN, 18));
	         setForeground(new Color(0x545454));
	         setOpaque(true);
	         setBackground(new Color(0xdedede));
	         setHorizontalAlignment(JLabel.CENTER);
	         setVerticalAlignment(JLabel.CENTER);
	         
	         this.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               int answer = JOptionPane.showConfirmDialog(null, ""+seat_number+"�� �ڸ��� ����Ͻðڽ��ϱ�?", "confirm", JOptionPane.YES_NO_OPTION );
	               if(answer==JOptionPane.YES_OPTION) {
	                  Meeting_DB_Current_users_Add.c_user_add(seat_number, id);
	                  F.base_screen_Panel();
	               }               
	            }
	         });
	         
	      } else {
	         setText("��ü ���̳��� " +seat_number);
	         setLocation(x, y);
	         setSize(250, 250);      
	         setFont(new Font("MapoDPP", Font.PLAIN, 18));
	         setForeground(new Color(0xdedede));
	         setOpaque(true);
	         setBackground(new Color(0x545454));
	         setHorizontalAlignment(JLabel.CENTER);
	         setVerticalAlignment(JLabel.CENTER);
	         setEnabled(false);
	      }
	}
}
