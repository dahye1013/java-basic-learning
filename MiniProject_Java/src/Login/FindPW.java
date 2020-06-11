package Login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FindPW extends JFrame implements ActionListener{
    private JFrame frame;
    private JTextField idT;
    private JTextField emailT;
    JButton findB, cancelB;
    JLabel title = new JLabel("");
    
    FindPW(){
        title.setText("PW찾기");
        setBounds(700, 200, 300, 250);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        
        title.setFont(new Font("굴림", Font.PLAIN, 19));
        title.setBounds(105, 10, 64, 21);
        getContentPane().add(title);

        JLabel lblNewLabel_1 = new JLabel("ID");
        lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(48, 62, 57, 15);
        getContentPane().add(lblNewLabel_1);

        idT = new JTextField();
        idT.setBounds(127, 60, 116, 21);
        getContentPane().add(idT);
        idT.setColumns(10);

        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("굴림", Font.PLAIN, 14));
        lblEmail.setBounds(48, 98, 57, 15);
        getContentPane().add(lblEmail);

        emailT = new JTextField();
        emailT.setColumns(10);
        emailT.setBounds(127, 96, 116, 21);
        getContentPane().add(emailT);

        findB = new JButton("찾기");
        findB.setBounds(37, 140, 97, 39);
        getContentPane().add(findB);

        cancelB = new JButton("취소");
        cancelB.setBounds(146, 140, 97, 39);
        getContentPane().add(cancelB);
        
        findB.addActionListener(this);
        cancelB.addActionListener(this);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==findB) {
        	if (SignUp.list.size() != 0) {
				for (int i = 0; i < SignUp.list.size(); i++) {
					if (idT.getText().equals(SignUp.list.get(i).getId())) {
						JOptionPane.showMessageDialog(this, "회원님의 비밀번호는 [" + SignUp.list.get(i).getPassword() + "] 입니다");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "등록된 회원정보가 없습니다.");
			}
        }else if(e.getSource()==cancelB) {
        	dispose();
        }
        
    }
    
    
}
