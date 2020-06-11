package friend.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

public class FriendManager extends JFrame implements ActionListener, ListSelectionListener {

	private JLabel inputL, listL, numL, numL2, nameL, phoneL, phoneL2, phoneL3, sexL, hobbyL, analysisL;
	private JTextField nameT, phoneT1, phoneT2;
	private JComboBox phoneComboBox;
	private JRadioButton maleBtn, femaleBtn;
	private JCheckBox readBox, movieBox, musicBox, gameBox, shoppingBox;
	private JButton inputBtn, editBtn, deleteBtn, removeBtn;
	private JTextArea analysisT;
	private FriendDAO friendDAO = new FriendDAO();

	private JList<FriendDTO> list; // list는 view의 역할만 수행한다
	private DefaultListModel<FriendDTO> model; // 실제 데이터를 수정, 삭제 등을 model에서 해야한다.

	// -----------------------------------------------------------------
	public FriendManager() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		setLayout(null);

		inputL = new JLabel("개인정보입력");
		inputL.setBounds(145, 15, 80, 25);

		numL = new JLabel("번          호  :");
		numL.setBounds(5, 60, 110, 25);
		numL2 = new JLabel();
		numL2.setBounds(80, 60, 25, 25);
		numL2.setOpaque(true);
		numL2.setBackground(Color.WHITE);

		nameL = new JLabel("이          름  :");
		nameL.setBounds(5, 100, 80, 25);
		nameT = new JTextField();
		nameT.setBounds(80, 100, 130, 25);

		phoneL = new JLabel("전화 번호  :");
		phoneL.setBounds(5, 140, 80, 25);
		phoneComboBox = new JComboBox();
		phoneComboBox.setModel(new DefaultComboBoxModel(new String[] { "010", "019" }));
		phoneComboBox.setBounds(80, 140, 50, 25);
		phoneL2 = new JLabel("-");
		phoneL2.setBounds(135, 140, 20, 25);
		phoneT1 = new JTextField();
		phoneT1.setBounds(145, 140, 50, 25);
		phoneL3 = new JLabel("-");
		phoneL3.setBounds(200, 140, 20, 25);
		phoneT2 = new JTextField();
		phoneT2.setBounds(210, 140, 50, 25);

		sexL = new JLabel("성          별  :");
		sexL.setBounds(5, 180, 80, 25);
		maleBtn = new JRadioButton("남성", true);
		maleBtn.setBounds(80, 180, 60, 25);
		maleBtn.setBackground(new Color(35, 158, 175));
		femaleBtn = new JRadioButton("여성");
		femaleBtn.setBounds(140, 180, 60, 25);
		femaleBtn.setBackground(new Color(35, 158, 175));

		ButtonGroup bg = new ButtonGroup();
		bg.add(maleBtn);
		bg.add(femaleBtn);

		hobbyL = new JLabel("취          미  :");
		hobbyL.setBounds(5, 220, 80, 25);
		readBox = new JCheckBox("독서");
		readBox.setBounds(80, 220, 55, 25);
		readBox.setBackground(new Color(35, 158, 175));
		movieBox = new JCheckBox("영화");
		movieBox.setBounds(135, 220, 55, 25);
		movieBox.setBackground(new Color(35, 158, 175));
		musicBox = new JCheckBox("음악");
		musicBox.setBounds(190, 220, 55, 25);
		musicBox.setBackground(new Color(35, 158, 175));
		gameBox = new JCheckBox("게임");
		gameBox.setBounds(245, 220, 55, 25);
		gameBox.setBackground(new Color(35, 158, 175));
		shoppingBox = new JCheckBox("쇼핑");
		shoppingBox.setBounds(300, 220, 55, 25);
		shoppingBox.setBackground(new Color(35, 158, 175));
		// ButtonGroup bg2 = new ButtonGroup();
		// bg2.add(readBox); bg2.add(movieBox); bg2.add(musicBox); bg2.add(gameBox);
		// bg2.add(shoppingBox);

		inputBtn = new JButton("등록");
		inputBtn.setBounds(50, 270, 60, 30);
		editBtn = new JButton("수정");
		editBtn.setBounds(115, 270, 60, 30);
		deleteBtn = new JButton("삭제");
		deleteBtn.setBounds(180, 270, 60, 30);
		removeBtn = new JButton("지우기");
		removeBtn.setBounds(245, 270, 75, 30);

		editBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		removeBtn.setEnabled(false);

		listL = new JLabel("전체목록");
		listL.setBounds(450, 15, 70, 25);

		list = new JList<FriendDTO>(new DefaultListModel<FriendDTO>()); // list안에 모델을 넣는다.
		model = (DefaultListModel<FriendDTO>) list.getModel(); // 리스트안에 이미 생성되어 들어가있는 모델을 꺼낸다.

		list.setBounds(370, 50, 220, 260);

		analysisL = new JLabel("개인정보분석");
		analysisL.setBounds(250, 325, 80, 25);
		analysisT = new JTextArea();
		analysisT.setBounds(10, 360, 580, 180);

		Container c = this.getContentPane();
		c.add(inputL);
		c.add(numL);
		c.add(numL2);
		c.add(nameL);
		c.add(nameT);
		c.add(phoneL);
		c.add(phoneComboBox);
		c.add(phoneL2);
		c.add(phoneT1);
		c.add(phoneL3);
		c.add(phoneT2);
		c.add(sexL);
		c.add(maleBtn);
		c.add(femaleBtn);
		c.add(hobbyL);
		c.add(readBox);
		c.add(movieBox);
		c.add(musicBox);
		c.add(gameBox);
		c.add(shoppingBox);
		c.add(inputBtn);
		c.add(editBtn);
		c.add(deleteBtn);
		c.add(removeBtn);
		c.add(listL);
		c.add(list);
		c.add(analysisL);
		c.add(analysisT);

		c.setBackground(new Color(35, 158, 175));
		setSize(610, 580);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		// DB 모든 레코드(행)을 꺼내서 JList 뿌리기
		List<FriendDTO> arraylist = friendDAO.getFriendList();
		for (FriendDTO friendDTO : arraylist) {
			model.addElement(friendDTO); // 모델안에 데이터가 들어갔으니까, 리스트에도 데이터가 들어감.
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}// FriendManager()

	@Override
	public void valueChanged(ListSelectionEvent e) { //리스트 클릭할때 값을 두번 불러옴
		// 180줄에 list model에 들어간 데이터를 다시 불러옴.
		
		if(list.getSelectedIndex() == -1) return; //삭제되어 값이 없을때, index는 -1 와 //null포인트가 뜬다
		
		FriendDTO friendDTO = list.getSelectedValue(); // dto에 있는걸 불러와서 friendDTO에 다시 뿌려줌
		
		
			numL2.setText(friendDTO.getSeq() + "");
			nameT.setText(friendDTO.getName());
			phoneComboBox.setSelectedItem(friendDTO.getTel1());
			phoneT1.setText(friendDTO.getTel2());
			phoneT2.setText(friendDTO.getTel3());

			if (friendDTO.getGender() == 0)
				maleBtn.setSelected(true);
			else if (friendDTO.getGender() == 1)
				maleBtn.setSelected(false);

			readBox.setSelected(friendDTO.getRead() == 1 ? true : false);
			musicBox.setSelected(friendDTO.getRead() == 1 ? true : false);
			movieBox.setSelected(friendDTO.getRead() == 1 ? true : false);
			shoppingBox.setSelected(friendDTO.getRead() == 1 ? true : false);
			gameBox.setSelected(friendDTO.getRead() == 1 ? true : false);

			inputBtn.setEnabled(false);
			editBtn.setEnabled(true);
			deleteBtn.setEnabled(true);
			removeBtn.setEnabled(true);
		
	}

	private void delete() {
		int index = list.getSelectedIndex();
		FriendDTO friendDTO = model.get(index);
		friendDAO.friendDelete(friendDTO);

		String name = nameT.getText();
		analysisT.setText("\n\t" + name + "님이 삭제되었습니다.");
		model.remove(list.getSelectedIndex());
	}

	private void edit() {

		int index = list.getSelectedIndex();
		FriendDTO friendDTO = model.get(index);
		// ---------FRAME값을 가져옴
		int seq = friendDTO.getSeq();
		String name = nameT.getText();
		int gender = 0;
		if (femaleBtn.isSelected())
			gender = 1;
		String tel1 = (String) phoneComboBox.getSelectedItem();
		String tel2 = phoneT1.getText();
		String tel3 = phoneT2.getText();
		int read = readBox.isSelected() ? 1 : 0;
		int movie = movieBox.isSelected() ? 1 : 0;
		int music = musicBox.isSelected() ? 1 : 0;
		int game = gameBox.isSelected() ? 1 : 0;
		int shopping = shoppingBox.isSelected() ? 1 : 0;
		// --------friendDTO에 넣음
		friendDTO.setSeq(seq);
		friendDTO.setName(name);
		friendDTO.setTel1(tel1);
		friendDTO.setTel2(tel2);
		friendDTO.setTel3(tel3);
		friendDTO.setGender(gender);
		friendDTO.setRead(read);
		friendDTO.setMovie(movie);
		friendDTO.setMusic(music);
		friendDTO.setGame(game);
		friendDTO.setShopping(shopping);

		model.set(index, friendDTO); //내가 가지고 있는 list에 덮어씌우기
		// ------------DB
		int su = friendDAO.friendUpdate(friendDTO);
		analysisT.setText("\n\t" + su + "명을 등록하였습니다.");
		remove();

	}

	public void remove() {

		numL2.setText("");
		nameT.setText("");
		phoneT1.setText("");
		phoneT2.setText("");
		phoneComboBox.setSelectedIndex(0);
		maleBtn.setSelected(true);
		femaleBtn.setSelected(false);
		readBox.setSelected(false);
		movieBox.setSelected(false);
		musicBox.setSelected(false);
		gameBox.setSelected(false);
		shoppingBox.setSelected(false);

		analysisT.setText("");

		inputBtn.setEnabled(true);
		editBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		removeBtn.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inputBtn) {
			int seq = friendDAO.getSeq();
			System.out.println(seq);
			// 데이터
			String name = nameT.getText();

			int gender = 0;
			if (femaleBtn.isSelected())
				gender = 1;

			String tel1 = (String) phoneComboBox.getSelectedItem();
			String tel2 = phoneT1.getText();
			String tel3 = phoneT2.getText();

			// 조건연산자
			// 조건 ? 참 : 거짓;
			// readBox.isSelected() ? 1:0;

			int read = readBox.isSelected() ? 1 : 0;
			int movie = movieBox.isSelected() ? 1 : 0;
			int music = musicBox.isSelected() ? 1 : 0;
			int game = gameBox.isSelected() ? 1 : 0;
			int shopping = shoppingBox.isSelected() ? 1 : 0;

			FriendDTO friendDTO = new FriendDTO();
			friendDTO.setSeq(seq);
			friendDTO.setName(name);
			friendDTO.setTel1(tel1);
			friendDTO.setTel2(tel2);
			friendDTO.setTel3(tel3);
			friendDTO.setGender(gender);
			friendDTO.setRead(read);
			friendDTO.setMovie(movie);
			friendDTO.setMusic(music);
			friendDTO.setGame(game);
			friendDTO.setShopping(shopping);

			// DB
			int su = friendDAO.friendWrite(friendDTO);

			// 응답
			remove();// 초기화 removeBtn.

			analysisT.setText("\n\t" + su + "명을 등록하였습니다.");
			model.addElement(friendDTO);

		} else if (e.getSource() == editBtn) {// 수정
			System.out.println("aa");
			edit();
		} else if (e.getSource() == deleteBtn) {// 삭제
			delete();
		} else if (e.getSource() == removeBtn) {// 초기화
			remove();
		}

	}

	public void event() {
		inputBtn.addActionListener(this);
		list.addListSelectionListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		removeBtn.addActionListener(this);

	}

	public static void main(String[] args) {
		new FriendManager().event();
	}

}
