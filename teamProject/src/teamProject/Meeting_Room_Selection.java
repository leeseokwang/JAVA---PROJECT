package teamProject;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;

public class Meeting_Room_Selection extends JPanel {
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "hr";
	private static String password = "1234";
	
	private Start F;
	
		
	static {
		try {
			
			Class.forName(driverName);
			System.out.println("driver loaded");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Meeting_Room_Selection(Start f,String id) {
		setSize(800, 1000);
	      setLayout(null);
	      F = f;
	      
	      JLabel header = new JLabel(" �¼� ���� (��ü��)");
	      JLabel string0 = new JLabel("�Ա���");
	      JLabel string1 = new JLabel(": ���� ����");
	      JLabel string1_square = new JLabel();
	      JLabel string2 = new JLabel(": ���� �Ұ���");
	      JLabel string2_square = new JLabel();
	      JButton seat1 = new Meeting_SeatButton(110, 200, "1", F, id);
	      JButton seat2 = new Meeting_SeatButton(410, 200, "2", F, id);
	      JButton seat3 = new Meeting_SeatButton(110, 500, "3", F, id);
	      JButton seat4 = new Meeting_SeatButton(410, 500, "4", F, id);
	      JButton prev_btn = new JButton("���� ȭ��");
	      
	      prev_btn.addActionListener(new ActionListener() {
				
	    	  @Override
			public void actionPerformed(ActionEvent e) {
					
			f.daily_pass_ticket_Panel();
			}
	      });
	      add(header);
	      header.setFocusable(true);
	      header.setFont(new Font("���� ����", Font.ITALIC | Font.BOLD, 35));
	      header.setForeground(new Color(0xdedede));
	      header.setOpaque(true);
	      header.setBounds(0, 0, 800, 130);
	      header.setBackground(new Color(0x545454));
	      add(string0);
	      string0.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 20));
	      string0.setForeground(new Color(0x545454));
	      string0.setBounds(360, 155, 100, 30);
	      add(string1);
	      string1.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 25));
	      string1.setForeground(new Color(0x545454));
	      string1.setBounds(100, 810, 200, 40);
	      add(string1_square);
	      string1_square.setOpaque(true);
	      string1_square.setBounds(50, 820, 25, 25);
	      string1_square.setBackground(new Color(0xcccccc));
	      add(string2);
	      string2.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 25));
	      string2.setForeground(new Color(0x545454));
	      string2.setBounds(100, 850, 200, 40);
	      add(string2_square);
	      string2_square.setOpaque(true);
	      string2_square.setBounds(50, 860, 25, 25);
	      string2_square.setBackground(new Color(0x545454));
	      prev_btn.setFont(new Font("MapoDPP", Font.PLAIN, 35));
	      prev_btn.setForeground(new Color(0x222222));
	      prev_btn.setOpaque(true);
	      prev_btn.setBackground(new Color(0xd0d0d0));
	      prev_btn.setBounds(530, 800, 200, 90);
	      
	      add(seat1);
	      add(seat2);
	      add(seat3);
	      add(seat4);
	      add(prev_btn);
	      
		
	}
}