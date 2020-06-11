package MemberFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class MyPage extends JPanel implements ActionListener {

	final static String PASSWORD = "1234"; // 임시비번
	private JButton correctBtn;
	private JButton askBtn;
	private DefaultTableModel model;
	private JTextField[] textField;
	private boolean fieldCheck = false;
	private boolean correctCheck = true;

	public MyPage() {
		this.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(249, 115, 570, 175);
		add(panel_7);
		panel_7.setLayout(new GridLayout(3, 2, 0, 0));

		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);
		
		textField = new JTextField[8];
		
		for(int i=0; i<7; i++) {
			textField[i] = new JTextField(12);
		}

		JLabel nameL = new JLabel("이름 :");
		panel_12.add(nameL);

		panel_12.add(textField[0]); //이름 필드
		textField[0].setSize(144, 34);
		textField[0].setEditable(fieldCheck);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);

		JLabel lblNewLabel_1 = new JLabel("생년월일 :");
		panel_9.add(lblNewLabel_1);

		panel_9.add(textField[1]);
		textField[1].setColumns(12);
		textField[1].setEditable(fieldCheck);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);

		JLabel lblNewLabel = new JLabel("닉네임 :");
		panel_10.add(lblNewLabel);

		panel_10.add(textField[2]);
		textField[2].setColumns(12);
		textField[2].setEditable(fieldCheck);

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);

		JLabel lblNewLabel_1_1 = new JLabel("이메일 :");
		panel_8.add(lblNewLabel_1_1);

		textField[3].setColumns(12);
		panel_8.add(textField[3]);
		textField[3].setEditable(fieldCheck);

		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);

		JLabel lblNewLabel_2 = new JLabel("핸드폰 번호 :");
		panel_11.add(lblNewLabel_2);

		panel_11.add(textField[4]);
		textField[4].setColumns(12);
		textField[4].setEditable(fieldCheck);

		JPanel panel_13 = new JPanel();
		panel_13.setBounds(249, 290, 570, 79);
		add(panel_13);
		panel_13.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("주소 : ");
		lblNewLabel_4.setBounds(47, 10, 57, 15);
		panel_13.add(lblNewLabel_4);

		textField[5].setBounds(114, 7, 179, 21);
		panel_13.add(textField[5]);
		textField[5].setColumns(15);
		textField[5].setEditable(fieldCheck);

		textField[6].setBounds(114, 38, 335, 21);
		panel_13.add(textField[6]);
		textField[6].setColumns(10);
		textField[6].setEditable(fieldCheck);
		// ----------------------------------------------------- 내가 빌린책들 리스트 테이블

		Vector<String> v = new Vector<String>();
		v.add("도서코드");
		v.add("도서명");
		v.add("저자");
		v.add("출판사");
		v.add("장르");
		v.add("반납여부");
		model = new DefaultTableModel(v, 0);
		JTable table = new JTable(model);

		// JScrollPanedp table 추가
		JScrollPane scroll = new JScrollPane(table);
		// scroll.setPreferredSize(new Dimension(400, 400));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(200, 400, 700, 280);
		add(scroll);

		// ---------------------------------------------------- 하단- 수정, 문의 버튼
		correctBtn = new JButton("수정"); // 수정버튼
		correctBtn.setBounds(433, 700, 109, 39);
		add(correctBtn);

		askBtn = new JButton("문의"); // 문의버튼
		askBtn.setBounds(564, 700, 109, 39);
		add(askBtn);

		// ----------------------------------------------

		correctBtn.addActionListener(this);
		askBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (correctBtn == e.getSource()) {
			if (correctCheck == true) {
				String pwd = JOptionPane.showInputDialog(this, "비밀번호를 입력해주세요.", "회원 정보 수정",
						JOptionPane.INFORMATION_MESSAGE);
				if(pwd != null) {

					if (pwd.equals(PASSWORD)) {
						fieldCheck = true;
						
						for(int i=0; i<7; i++) {
							textField[i].setEditable(fieldCheck);
							
						}
						correctBtn.setText("수정완료");
						
						
	
					} else if (!pwd.equals(PASSWORD)) {
						JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다.", "회원 정보 수정", JOptionPane.INFORMATION_MESSAGE);
	
					}
				}
				
				correctCheck = false;
			}else {
				
				fieldCheck = false;

				for(int i=0; i<7; i++) {
					textField[i].setEditable(fieldCheck);
					
				}
				correctBtn.setText("수정");
				correctCheck = true;
			}

		}

	}

}
