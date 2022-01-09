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
	
	public SeatButton(int x, int y, String seat_number) {
		
		if(DB_Seats.seats_num_arr(seat_number)) {
			setText(seat_number);
			setLocation(x, y);
			setSize(60, 60);		
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
						Start start = new Start();
						// �ʱ�ȭ�ϸ鼭 ����� �Ǵ°� ������ ������ ������ ����
						// �ϳ��� ���� �޼ҵ�δ� dispose�� ����
						// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); �̷������� ���
					}					
				}
			});
			
		} else {
			setText(seat_number);
			setLocation(x, y);
			setSize(60, 60);		
			setFont(new Font("MapoDPP", Font.PLAIN, 18));
			setForeground(new Color(0xdedede));
			setOpaque(true);
			setBackground(new Color(0x545454));
			setHorizontalAlignment(JLabel.CENTER);
			setVerticalAlignment(JLabel.CENTER);
			setEnabled(false);
		}
		
	};
	
}
