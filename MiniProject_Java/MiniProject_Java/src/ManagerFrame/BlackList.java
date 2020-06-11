package ManagerFrame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class BlackList extends JPanel implements ActionListener {
	private JButton sendBtn, sendAllBtn, updateBtn;

	private JLabel titleL;

	private JComboBox<String> combo;
	private DefaultTableModel model;
	private JTable table;

	private JPanel p, p1, p2, p3, p4, labelP, btnP;

	public BlackList() {

		this.setLayout(null);
		
		titleL = new JLabel("BlackList");
		titleL.setFont(new Font("고딕체", Font.BOLD, 20));

		// 버튼 생성
		sendBtn = new JButton("문자 보내기");
		sendAllBtn = new JButton("모두 보내기");
		updateBtn = new JButton("새로 고침");

		// Table 생성
		Vector<String> v = new Vector<String>();
		v.add("ID");
		v.add("이름");
		v.add("번호");
		v.add("도서코드");
		v.add("도서이름");
		v.add("연체일");
		model = new DefaultTableModel(v, 0);
		table = new JTable(model);

		// JScrollPanedp table 추가
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(1000, 500));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// 배치
		labelP = new JPanel();
		labelP.add(titleL); // 블랙리스트 title

		// 테이블
		scroll.setBounds(50,200,1000,500);
		add(scroll);

		// 추가,삭제,수정 버튼
		btnP = new JPanel(new GridLayout(1, 3, 5, 0));
		btnP.add(updateBtn);
		btnP.add(sendBtn);
		btnP.add(sendAllBtn);
		
		
		btnP.setBounds(650,150,400,40);
		add(btnP);


		// 이벤트
		updateBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		sendAllBtn.addActionListener(this);

		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == updateBtn) {
			JOptionPane.showMessageDialog(this, "새로고침을 완료하였습니다.", "대여 완료", JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == sendBtn) {
			JOptionPane.showMessageDialog(this, "연체 회원에게 문자를 보내시겠습니까?", "문자 보내기", JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == sendAllBtn) {
			JOptionPane.showMessageDialog(this, "연체 회원둘에게 단체 문자를 보내시겠습니까?", "단체문자 보내기", JOptionPane.INFORMATION_MESSAGE);

		}
		// JOptionPane.showMessageDialog(this, "이미 대여중인 책입니다", "대여 불가",
		// JOptionPane.WARNING_MESSAGE);
		// JOptionPane.showMessageDialog(this, "도서 대여는 3권만 가능합니다", "대여 불가",
		// JOptionPane.WARNING_MESSAGE);
		// JOptionPane.showMessageDialog(this, "대여가 완료된 책입니다", "대여 불가",
		// JOptionPane.WARNING_MESSAGE);
	}// actionPerformed()

}
