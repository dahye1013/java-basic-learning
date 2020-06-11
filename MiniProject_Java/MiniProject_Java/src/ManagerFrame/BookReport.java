package ManagerFrame;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class BookReport extends JPanel implements ActionListener {
	private JLabel monthL;
	private JButton leftBtn, rightBtn;
	SimpleDateFormat sdf;
	int mon;

	public BookReport() {
		setLayout(null);
		setBackground(Color.WHITE);
		sdf = new SimpleDateFormat("M");
		mon = Integer.parseInt(sdf.format(new Date()));

		monthL = new JLabel();
		monthL.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		monthL.setText(sdf.format(new Date()) + "월");
		monthL.setBounds(441, 62, 124, 51);
		add(monthL);

		JLabel totBookL = new JLabel("전체 도서:");
		totBookL.setBounds(383, 188, 80, 25);
		add(totBookL);

		JLabel totBookNumL = new JLabel("0");
		totBookNumL.setBounds(485, 196, 57, 15);
		add(totBookNumL);

		JLabel totLendL = new JLabel("전체 대여:");
		totLendL.setBounds(383, 231, 80, 25);
		add(totLendL);

		JLabel totLendNumL = new JLabel("0");
		totLendNumL.setBounds(485, 236, 57, 15);
		add(totLendNumL);

		JLabel lenPosL = new JLabel("대여 가능 도서:");
		lenPosL.setBounds(361, 266, 112, 25);
		add(lenPosL);

		JLabel lenPosNumL = new JLabel("0");
		lenPosNumL.setBounds(485, 277, 57, 15);
		add(lenPosNumL);

		JLabel delBookL = new JLabel("삭제 도서:");
		delBookL.setBounds(383, 347, 80, 25);
		add(delBookL);

		JLabel delBookNumL = new JLabel("0");
		delBookNumL.setBounds(485, 352, 57, 15);
		add(delBookNumL);

		JLabel addBookL = new JLabel("추가 도서:");
		addBookL.setBounds(383, 309, 80, 25);
		add(addBookL);

		JLabel addBookNumL = new JLabel("0");
		addBookNumL.setBounds(485, 314, 57, 15);
		add(addBookNumL);

		JLabel mOverBookL = new JLabel("이달 연체 도서 수:");
		mOverBookL.setBounds(338, 417, 112, 25);
		add(mOverBookL);

		JLabel mOverBookNumL = new JLabel("0");
		mOverBookNumL.setBounds(485, 420, 57, 15);
		add(mOverBookNumL);

		JLabel mLendBookL = new JLabel("이달 도서 대출 수:");
		mLendBookL.setBounds(338, 382, 103, 25);
		add(mLendBookL);

		JLabel mLendBookNumL = new JLabel("0");
		mLendBookNumL.setBounds(485, 387, 57, 15);
		add(mLendBookNumL);

		leftBtn = new JButton(new ImageIcon("left.png"));
		leftBtn.setBounds(277, 62, 84, 62);
		leftBtn.setBorderPainted(false);
		leftBtn.setDisabledIcon(new ImageIcon("비활성.png"));
		leftBtn.addActionListener(this);
		if (mon == 1)
			leftBtn.setEnabled(false);
		add(leftBtn);

		rightBtn = new JButton(new ImageIcon("right.png"));
		rightBtn.setBounds(594, 62, 84, 62);
		rightBtn.setBorderPainted(false);
		rightBtn.setDisabledIcon(new ImageIcon("비활성오.png"));
		rightBtn.addActionListener(this);
		rightBtn.setEnabled(false);
		add(rightBtn);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == leftBtn) {
			rightBtn.setEnabled(true);
			mon -= 1;
			if (mon == 1) {
				leftBtn.setEnabled(false);
			}
			monthL.setText(mon + "월");

		} else if (e.getSource() == rightBtn) {
			leftBtn.setEnabled(true);

			mon += 1;
			if (mon == Integer.parseInt(sdf.format(new Date())) || mon == 12) {
				rightBtn.setEnabled(false);
			}
			monthL.setText(mon + "월");

		}

	}
}
