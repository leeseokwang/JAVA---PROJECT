package teamProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Buy_a_voucher extends JPanel {
	private JLabel pass, season_ticket;
	private JButton exit,previous,ffh,ohh,thfh,fhh,od,sd,td;
	private Start F;
	private String id;
	
	public Buy_a_voucher(Start f, String id){
		setSize(800, 1000);
		setLayout(null);
		F = f;

		pass = new JLabel("���ױ�");
		pass.setBounds(80,180,200,50);
		add(pass);
		
		ffh = new JButton("50�ð�");
		ffh.setBounds(80, 240, 300, 100);
		ffh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,5));
				f.Payment_Panel();
			}
		});
		add(ffh);
		
		ohh = new JButton("100�ð�");
		ohh.setBounds(420, 240, 300, 100);
		ohh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,6));
				f.Payment_Panel();
			}
		});
		add(ohh);
		
		thfh = new JButton("250�ð�");
		thfh.setBounds(80, 375, 300, 100);
		thfh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,7));
				f.Payment_Panel();
			}
		});
		add(thfh);
		
		fhh = new JButton("500�ð�");
		fhh.setBounds(420, 375, 300, 100);
		fhh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,8));
				f.Payment_Panel();
			}
		});
		add(fhh);
		
		
		
		season_ticket = new JLabel("�����");
		season_ticket.setBounds(80,500,200,50);
		add(season_ticket);
		
		od = new JButton("1�ϱ�");
		od.setBounds(80, 560, 200, 300);
		od.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,9));
				f.Payment_Panel();
			}
		});
		add(od);
		
		sd = new JButton("7�ϱ�");
		sd.setBounds(300, 560, 200, 300);
		sd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,10));
				f.Payment_Panel();
			}
		});
		add(sd);
		
		td = new JButton("30�ϱ�");
		td.setBounds(520, 560, 200, 300);
		td.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,11));
				f.Payment_Panel();
			}
		});
		add(td);
		
		previous = new JButton("���� ȭ��");
		previous.setBounds(80,100,100,30);
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
			}
		});
		add(previous);
		
		exit = new JButton("������");
		exit.setBounds(210,100,100,30);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.base_screen_Panel();
			}
		});
		add(exit);
	}
}
