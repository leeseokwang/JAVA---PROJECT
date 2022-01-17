package teamProject;
import java.awt.CardLayout;

import javax.swing.JFrame;

public class Start extends JFrame{
	
	private CardLayout cards = new CardLayout();
	static String nmid;
	
	public Start() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε� �Ϸ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		setBounds(600,20,800, 1000);
		
		getContentPane().setLayout(cards);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	
		// ������ ���ο� �г� �߰�
		
		getContentPane().add("base_screen", new Base_screen(this));		
		getContentPane().add("member_login", new Member_login(this));		
		getContentPane().add("find_id", new Find_id(this));
		getContentPane().add("find_pw", new Find_password(this));
		getContentPane().add("non_member_login", new Non_Member_Login(this));
		getContentPane().add("member_or_non_member", new Member_or_non_member(this));
		getContentPane().add("non_member_login2", new Non_member_login2(this));
		
		setVisible(true);
	} 
	
	// Ư�� �г� (ȭ��) ����
	public void base_screen_Panel() {  //�⺻ ȭ�� 
		cards.show(this.getContentPane(),"base_screen"); 
	} 
	public void main_screen_Panel() {  // ���� ȭ�� 
		cards.show(this.getContentPane(),"main_screen"); 
	}
	public void member_login_Panel() {  //ȸ�� �α��� 
		cards.show(this.getContentPane(),"member_login"); 
	} 
	public void find_id_Panel() {  //ȸ�� ���̵� ã��
		cards.show(this.getContentPane(), "find_id");
	}
	public void find_pw_Panel() { //ȸ�� ��й�ȣ ã��
		cards.show(this.getContentPane(), "find_pw");
	}
	public void non_member_login_Panel() { //��ȸ�� ���� �� �α���
		cards.show(this.getContentPane(),"non_member_login"); 
	}
	public void member_or_non_member_Panel() { //ȸ������ �α������� ��ȸ������ ���� Ȯ��
		cards.show(this.getContentPane(),"member_or_non_member");
	}
	public void Non_member_login2_Panel() {  //��ȸ�� �α��� ȭ��
		cards.show(this.getContentPane(),"non_member_login2");
	}
	public void daily_pass_ticket_Panel() { //���ϱ� ����
		cards.show(this.getContentPane(),"daily_pass_ticket");
	}
	public void Buy_a_voucher_Panel() { //�̿�� ����
		cards.show(this.getContentPane(),"Buy_a_voucher");
	}
	public void Payment_Panel() {  // ����
		cards.show(this.getContentPane(), "payment");
	}

	public void Private_Seat_Selection_Panel() { //���ν� �¼� ����
		cards.show(this.getContentPane(),"Private_Seat_Selection"); 
	}
	public void Meeting_Room_Selection_Panel() { //��ü�� �¼� ����
		cards.show(this.getContentPane(),"Meeting_Room_Selection"); 
	}

	public void use_post_Panel() { // �̿�� ���
		cards.show(this.getContentPane(),"Use_PassOrSeasnTicket"); 
	}
	public void seat_selection_Panel() { // �̿�� �¼�����
		cards.show(this.getContentPane(),"seat_selection"); 
	}
	public void seat_change_Panel() { // �̿�� �¼�����
		cards.show(this.getContentPane(),"seat_change"); 
	}
	
	public void daily_ticket_extend_Panel() { // ���� ���ϱ� ����
		cards.show(this.getContentPane(),"daily_ticket_extend"); 
	}
	public void group_room_extend_Panel() { // �׷� ���ϱ� ����
		cards.show(this.getContentPane(),"group_room_extend"); 
	}
	public void pass_ticket_extend_Panel() { // ���ױ� ����
		cards.show(this.getContentPane(),"pass_ticket_extend"); 
	}
	public void season_ticket_extend_Panel() { // ����� ����
		cards.show(this.getContentPane(),"season_ticket_extend"); 
	}
	public void Extend_payment_Panel() { // ���� ����
		cards.show(this.getContentPane(),"extend_payment"); 
	}


	
	public static void main(String[] args) {
		
		
		new Start();
	}
}