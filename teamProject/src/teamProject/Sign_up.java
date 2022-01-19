package teamProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sign_up extends JPanel {

	private Start F;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Sign_up(Start f) {
		F = f;
		setSize(800, 1000);
		setLayout(null);
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		JLabel string1 = new JLabel("회원 가입");
		add(string1);
		string1.setFont(new Font("NanumBarunGothic", Font.BOLD, 50));
		string1.setForeground(new Color(0x222222));
		string1.setBounds(0, 150, 800, 100);
		string1.setHorizontalAlignment(JLabel.CENTER);
		
		JTextField su_id = new JTextField();
		add(su_id);
		su_id.setFont(new Font("NanumGothic", Font.PLAIN, 35));
		su_id.setForeground(new Color(0xd0d0d0));
		su_id.setBounds(130, 280, 540, 60);
		su_id.setText("아이디를 입력해주세요");
		
		JLabel su_id_str = new JLabel("");
		add(su_id_str);
		su_id_str.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		su_id_str.setForeground(new Color(0x222222));
		su_id_str.setBounds(130, 340, 540, 20);
		su_id_str.setVerticalAlignment(su_id_str.CENTER);		
		
		JPasswordField su_pw = new JPasswordField("1234567");
		add(su_pw);
		su_pw.setFont(new Font("NanumGothic", Font.PLAIN, 35));
		su_pw.setForeground(new Color(0xd0d0d0));
		su_pw.setBounds(130, 360, 540, 60);
		
		JLabel su_pw_str = new JLabel("비밀번호를 입력해주세요.");
		add(su_pw_str);
		su_pw_str.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		su_pw_str.setForeground(new Color(0x222222));
		su_pw_str.setBounds(130, 420, 540, 20);
		su_pw_str.setVerticalAlignment(su_pw_str.CENTER);	
		
		JPasswordField su_pw_chk = new JPasswordField("7654321");
		add(su_pw_chk);
		su_pw_chk.setFont(new Font("NanumGothic", Font.PLAIN, 35));
		su_pw_chk.setForeground(new Color(0xd0d0d0));
		su_pw_chk.setBounds(130, 440, 540, 60);
		
		JLabel su_pw_chk_str = new JLabel("비밀번호를 확인해주세요.");
		add(su_pw_chk_str);
		su_pw_chk_str.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		su_pw_chk_str.setForeground(new Color(0x222222));
		su_pw_chk_str.setBounds(130, 500, 540, 20);
		su_pw_chk_str.setVerticalAlignment(su_pw_chk_str.CENTER);
		
		JTextField su_name = new JTextField();
		add(su_name);
		su_name.setFont(new Font("NanumGothic", Font.PLAIN, 35));
		su_name.setForeground(new Color(0xd0d0d0));
		su_name.setBounds(130, 520, 540, 60);
		su_name.setText("이름을 입력해주세요");
		
		JLabel su_name_str = new JLabel();
		add(su_name_str);
		su_name_str.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		su_name_str.setForeground(new Color(0x222222));
		su_name_str.setBounds(130, 580, 540, 20);
		su_name_str.setVerticalAlignment(su_name_str.CENTER);
		
		JTextField su_phone = new JTextField();
		add(su_phone);
		su_phone.setFont(new Font("NanumGothic", Font.PLAIN, 35));
		su_phone.setForeground(new Color(0xd0d0d0));
		su_phone.setBounds(130, 600, 540, 60);
		su_phone.setText("휴대폰 번호를 입력해주세요");
		
		JLabel su_phone_str = new JLabel();
		add(su_phone_str);
		su_phone_str.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		su_phone_str.setForeground(new Color(0x222222));
		su_phone_str.setBounds(130, 660, 540, 20);
		su_phone_str.setVerticalAlignment(su_phone_str.CENTER);
		
		JButton su_btn = new JButton("가입하기");
		add(su_btn);
		su_btn.setFont(new Font("NanumGothic", Font.PLAIN, 40));
		su_btn.setForeground(new Color(0xf5f6f7));
		su_btn.setOpaque(true);
		su_btn.setBackground(new Color(0x00c850));
		su_btn.setBounds(115, 690, 560, 94);
		
		JButton prev_btn = new JButton("이전 화면");
		add(prev_btn);
		prev_btn.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
		prev_btn.setForeground(new Color(0xf5f6f7));
		prev_btn.setOpaque(true);
		prev_btn.setBackground(new Color(0x8e8e8e));
		prev_btn.setBounds(530, 810, 200, 90);
		
		su_tf_ml(su_id);
		su_tf_ml(su_pw);
		su_tf_ml(su_pw_chk);
		su_tf_ml(su_name);
		su_tf_ml(su_phone);
		su_fl(su_id, "아이디를");
		su_fl(su_pw, "");
		su_fl(su_pw_chk, "");
		su_fl(su_name, "이름을");
		su_fl(su_phone, "휴대폰 번호를");
		
		su_btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int su_pass = 0;
				if(su_id.getText().equals("아이디를 입력해주세요")) {
					su_id_str.setText("아이디를 입력해주세요.");
				} else {
					if(su_id.getText().length() <= 20) {
						if(DB_Members.mb_id_arr(su_id.getText())) {
							su_id_str.setText("");
							su_pass++;
						} else {
							su_id_str.setText("이미 존재하는 아이디입니다.");					
						}					
					} else {
						su_id_str.setText("아이디는 20자 이내로 적어주세요.");
					}					
				}
				
				
				if(su_pw.getText().equals("1234567")) {
					su_pw_str.setText("비밀번호를 입력해주세요.");
				} else {
					if(su_pw.getText().length() <= 25) {
						su_pw_str.setText("");
						su_pass++;
					} else {
						su_pw_str.setText("비밀번호는 25자 이내로 적어주세요.");
					}					
				}
				
				
				if(su_pw_chk.getText().equals("7654321")) {
					su_pw_chk_str.setText("비밀번호 확인을 입력해주세요.");
				} else {
					if(su_pw.getText().equals(su_pw_chk.getText())) {
						su_pw_chk_str.setText("");
						su_pass++;
					} else {
						su_pw_chk_str.setText("비밀번호가 서로 다릅니다, 확인해주세요.");
					}
				}
				
				
				if(su_name.getText().equals("이름을 입력해주세요")) {
					su_name_str.setText("이름을 입력해주세요");
				} else {
					if(su_name.getText().length() <= 30) {
						su_name_str.setText("");
						su_pass++;
					} else {
						su_name_str.setText("이름은 30자 이내로 적어주세요.");
					}					
				}
				
				
				if(su_phone.getText().equals("휴대폰 번호를 입력해주세요")) {
					su_phone_str.setText("휴대폰 번호를 입력해주세요.");
				} else {
					if(su_phone.getText().length() >= 10 &&
							su_phone.getText().length() >= 11) {					
						int phone_err = 0;
						for(int i = 0; i < su_phone.getText().length(); i++) {
							if(!(su_phone.getText().charAt(i) >= '0' &&
									su_phone.getText().charAt(i) <= '9')) phone_err++;
							if(phone_err >= 1) break;
						}
						if(phone_err >= 1) {						
							su_phone_str.setText("휴대폰 번호는 숫자로만 입력해주세요.");
						} else {
							if(DB_Non_Members.nmb_phone_arr(su_phone.getText()) &&
									DB_Members.mb_phone_arr(su_phone.getText())) {
								su_phone_str.setText("");
								su_pass++;
							} else {
								su_phone_str.setText("이미 중복되는 휴대폰 번호가 있습니다.");
							}							
						}
					} else {
						su_phone_str.setText("휴대폰 번호는 10자리 또는 11자리 입니다.");
					}					
				}
				
				
				if(su_pass == 5) {
					DB_Members.mb_id_add(su_id.getText(), su_pw.getText(),
							su_name.getText(), su_phone.getText());
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.",
							"Message",JOptionPane.INFORMATION_MESSAGE );
					su_id.setForeground(new Color(0xd0d0d0));
					su_id.setText("아이디를 입력해주세요");
					su_id_str.setText("");
					su_pw.setForeground(new Color(0xd0d0d0));
					su_pw.setText("1234567");
					su_pw_str.setText("비밀번호를 입력해주세요.");
					su_pw_chk.setForeground(new Color(0xd0d0d0));
					su_pw_chk.setText("7654321");
					su_pw_chk_str.setText("비밀번호를 확인해주세요.");
					su_name.setForeground(new Color(0xd0d0d0));
					su_name.setText("이름을 입력해주세요");
					su_name_str.setText("");
					su_phone.setForeground(new Color(0xd0d0d0));
					su_phone.setText("휴대폰 번호를 입력해주세요");
					su_phone_str.setText("");
					F.base_screen_Panel();
				} else {
					JOptionPane.showMessageDialog(null, "<html>회원 정보가 올바르지 않습니다.<br>다시 확인해주세요.</html>", "Message",JOptionPane.INFORMATION_MESSAGE );
				}
			}
		});
		
		prev_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				su_id.setForeground(new Color(0xd0d0d0));
				su_id.setText("아이디를 입력해주세요");
				su_id_str.setText("");
				su_pw.setForeground(new Color(0xd0d0d0));
				su_pw.setText("1234567");
				su_pw_str.setText("비밀번호를 입력해주세요.");
				su_pw_chk.setForeground(new Color(0xd0d0d0));
				su_pw_chk.setText("7654321");
				su_pw_chk_str.setText("비밀번호를 확인해주세요.");
				su_name.setForeground(new Color(0xd0d0d0));
				su_name.setText("이름을 입력해주세요");
				su_name_str.setText("");
				su_phone.setForeground(new Color(0xd0d0d0));
				su_phone.setText("휴대폰 번호를 입력해주세요");
				su_phone_str.setText("");
				F.base_screen_Panel();
			};
		});
	}
	public static void su_tf_ml(JTextField jtf) {
		jtf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtf.setText("");
				jtf.setForeground(new Color(0x222222));
			}
		});		
	}
	public static void su_fl(JTextField jtf, String str) {	
		jtf.addFocusListener(new FocusListener() {			
			@Override
			public void focusLost(FocusEvent e) {
				if((jtf.getText()).equals("")) {
					jtf.setText(str + " 입력해주세요");
					jtf.setForeground(new Color(0xd0d0d0));
				}
			}			
			@Override
			public void focusGained(FocusEvent e) {
				jtf.setText("");
				jtf.setForeground(new Color(0x222222));
			}
		});
	}
}
