package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Base_screen extends JPanel {

    private JButton member_btn,non_member_btn,sign_up_btn;
    private Start start;

    public Base_screen(Start f) { 

        setSize(800, 1000);
        setLayout(null);
        start = f;

        member_btn = new JButton("ȸ�� �α���");
        non_member_btn = new JButton("��ȸ�� �α���");
        sign_up_btn = new JButton("ȸ�� ����");

        non_member_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                start.non_member_login_panel();
            }
        });

        member_btn.setBounds(100,100,600,200);
        non_member_btn.setBounds(100,380,600,200);
        sign_up_btn.setBounds(100,650,600,200);

        add(member_btn);
        add(non_member_btn);
        add(sign_up_btn);

        setVisible(true);
    } 
}