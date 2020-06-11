package ManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertBook extends JFrame implements ActionListener {
    private JButton insertBtn, cancleBtn;
    private JTextField nameT, authorT, publisherT;
    private JLabel titleL;

    private JComboBox<String> combo;

    public InsertBook() {
        
        super("도서 추가");

        setLayout(null);

        // 라벨 생성
        titleL = new JLabel("Insert Book");
        titleL.setFont(new Font("고딕체", Font.BOLD, 20));
        titleL.setBounds(115, 40, 120, 25);

        // 텍스트필드 생성
        // codeT = new JTextField(10);
        nameT = new JTextField("도서명을 입력하세요");
        nameT.setForeground(new Color(150, 150, 150));
        nameT.setBounds(75, 93, 200, 36);
        authorT = new JTextField("저자를 입력하세요");
        authorT.setBounds(75, 139, 200, 35);
        authorT.setForeground(new Color(150, 150, 150));
        publisherT = new JTextField("출판사를 입력하세요");
        publisherT.setBounds(75, 184, 200, 35);
        publisherT.setForeground(new Color(150, 150, 150));

        // 버튼 생성
        insertBtn = new JButton("추가");
        insertBtn.setBounds(100, 300, 70, 30);
        cancleBtn = new JButton("취소");
        cancleBtn.setBounds(175, 300, 70, 30);

        // 콤보박스 생성
        String[] genre = { "소설", "시/에세이", "자기계발", "인문/교양/철학", "역사", "유아" };
        combo = new JComboBox<String>(genre);
        combo.setBounds(75, 229, 200, 35);

        // 배치
        add(titleL);
        add(nameT);
        add(authorT);
        add(publisherT);
        add(combo);
        add(insertBtn);
        add(cancleBtn);

        setBounds(1080, 250, 350, 420);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        insertBtn.addActionListener(this);
        cancleBtn.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertBtn) {
            JOptionPane.showMessageDialog(this, "도서가 추가되었습니다", "도서 추가 완료", JOptionPane.INFORMATION_MESSAGE);
            // JOptionPane.showMessageDialog(this, "도서 정보가 입력되지 않았습니다", "도서 정보 미입력",
            // JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == cancleBtn) {
            setVisible(false);
        }
    }// actionPerformed()

}
