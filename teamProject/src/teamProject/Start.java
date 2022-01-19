package teamProject;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Start extends JFrame{
	
	private CardLayout cards = new CardLayout();
	static String nmid;
	
	public Start() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		setBounds(600,20,800, 1000);
		
		getContentPane().setLayout(cards);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	
		// 프레임 내부에 패널 추가
		
		getContentPane().add("base_screen", new Base_screen(this));
		getContentPane().add("sign_up", new Sign_up(this));
		getContentPane().add("member_login", new Member_login(this));		
		getContentPane().add("find_id", new Find_id(this));
		getContentPane().add("find_pw", new Find_password(this));
		getContentPane().add("non_member_login", new Non_Member_Login(this));
		getContentPane().add("member_or_non_member", new Member_or_non_member(this));
		getContentPane().add("non_member_login2", new Non_member_login2(this));
		
		setVisible(true);
	} 
	
	// 특정 패널 (화면) 보기
	public void base_screen_Panel() {  //기본 화면 
		cards.show(this.getContentPane(),"base_screen"); 
	}
	public void sign_up_Panel() {  //기본 화면 
		cards.show(this.getContentPane(),"sign_up"); 
	}
	public void main_screen_Panel() {  // 메인 화면 
		cards.show(this.getContentPane(),"main_screen"); 
	}
	public void member_login_Panel() {  //회원 로그인 
		cards.show(this.getContentPane(),"member_login"); 
	} 
	public void find_id_Panel() {  //회원 아이디 찾기
		cards.show(this.getContentPane(), "find_id");
	}
	public void find_pw_Panel() { //회원 비밀번호 찾기
		cards.show(this.getContentPane(), "find_pw");
	}
	public void non_member_login_Panel() { //비회원 가입 및 로그인
		cards.show(this.getContentPane(),"non_member_login"); 
	}
	public void member_or_non_member_Panel() { //회원으로 로그인할지 비회원으로 할지 확인
		cards.show(this.getContentPane(),"member_or_non_member");
	}
	public void Non_member_login2_Panel() {  //비회원 로그인 화면
		cards.show(this.getContentPane(),"non_member_login2");
	}
	public void daily_pass_ticket_Panel() { //당일권 구입
		cards.show(this.getContentPane(),"daily_pass_ticket");
	}
	public void daily_pass_ticket2_Panel() { //당일권 구입
		cards.show(this.getContentPane(),"daily_pass_ticket2");
	}
	public void Buy_a_voucher_Panel() { //이용권 구입
		cards.show(this.getContentPane(),"Buy_a_voucher");
	}
	public void Payment_Panel() {  // 결제
		cards.show(this.getContentPane(), "payment");
	}
	
	public void Private_Seat_Selection_Panel() { //개인실 좌석 선택
		cards.show(this.getContentPane(),"Private_Seat_Selection"); 
	}
	public void Meeting_Room_Selection_Panel() { //단체실 좌석 선택
		cards.show(this.getContentPane(),"Meeting_Room_Selection"); 
	}

	public void use_post_Panel() { // 이용권 사용
		cards.show(this.getContentPane(),"Use_PassOrSeasnTicket"); 
	}
	public void seat_selection_Panel() { // 이용권 좌석선택
		cards.show(this.getContentPane(),"seat_selection"); 
	}
	public void seat_change_Panel() { // 이용권 좌석선택
		cards.show(this.getContentPane(),"seat_change"); 
	}
	
	public void daily_ticket_extend_Panel() { // 개인 당일권 연장
		cards.show(this.getContentPane(),"daily_ticket_extend"); 
	}
	public void group_room_extend_Panel() { // 그룹 당일권 연장
		cards.show(this.getContentPane(),"group_room_extend"); 
	}
	public void pass_ticket_extend_Panel() { // 정액권 연장
		cards.show(this.getContentPane(),"pass_ticket_extend"); 
	}
	public void season_ticket_extend_Panel() { // 정기권 연장
		cards.show(this.getContentPane(),"season_ticket_extend"); 
	}
	public void Extend_payment_Panel() { // 연장 결제
		cards.show(this.getContentPane(),"extend_payment"); 
	}
	public void Extend_select_panel() {//연장 선택
		cards.show(this.getContentPane(), "Extend_panel");
	}

	
	public static void main(String[] args) {
		
		
		new Start();
	}
}