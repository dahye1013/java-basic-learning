package ManagerFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class  LendBookManage extends JPanel implements ActionListener{
	private JLabel idL,mNameL,mBirthL,mPhoneL,bCodeL,bNameL,bWriterL,bPressL ;
	private JTextField idT,mNameT,mBirthT,mPhoneT,bCodeT,bNameT,bWriterT,bPressT;
	private JButton mSearchBtn,bSearchBtn,lendBtn,returnBtn,delBtn;
	private JTable table;
	private JScrollPane scroll;
	private Vector<String> vector;
	private DefaultTableModel model;

		public void paintComponent(Graphics g) {
    	Dimension d = getSize();
    	ImageIcon img = new ImageIcon("배경2.jpg");
        g.drawImage(img.getImage(),0,0,d.width,d.height, null);
}
		public LendBookManage(){
			setLayout(null);
			
			idL = new JLabel("회원아이디");				idT =new JTextField(20);
			idL.setBounds(100, 166, 105, 37); 		idT.setBounds(171, 166, 144, 34);
			mNameL = new JLabel("이름");  			mNameT =new JTextField(20);
			mNameL.setBounds(121, 222, 57, 30);		mNameT.setBounds(171, 222, 144, 34);
			mBirthL = new JLabel("생년월일");  		mBirthT =new JTextField(20);	
			mBirthL.setBounds(370, 217, 57, 37); 	mBirthT.setBounds(444, 221, 144, 34);
			mPhoneL = new JLabel("핸드폰번호");  		mPhoneT =new JTextField(20);
			mPhoneL.setBounds(645, 222, 84, 30);	mPhoneT.setBounds(744, 220, 144, 34);

			bCodeL = new JLabel("도서코드");			bCodeT =new JTextField(20);
			bCodeL.setBounds(96, 322, 88, 60);		bCodeT.setBounds(172, 332, 144, 34);
			bNameL = new JLabel("도서명");			bNameT =new JTextField(20);
			bNameL.setBounds(99, 374, 48, 60);		bNameT.setBounds(172, 387, 144, 34);
			bWriterL = new JLabel("저자");  			bWriterT =new JTextField(20);
			bWriterL.setBounds(381, 379, 50, 55);	bWriterT.setBounds(444, 388, 144, 34);
			bPressL = new JLabel("출판사");	 		bPressT =new JTextField(20);
			bPressL.setBounds(694, 384, 80, 40);	bPressT.setBounds(758, 388, 144, 34);

			
			mSearchBtn = new JButton(new ImageIcon("버튼.png"));
			mSearchBtn.setBorderPainted(false);
			mSearchBtn.setLocation(347, 166);
			mSearchBtn.setSize(80, 37);
			bSearchBtn = new JButton(new ImageIcon("버튼.png"));
			bSearchBtn.setBorderPainted(false);
			bSearchBtn.setLocation(347, 334);
			bSearchBtn.setSize(80, 37);
			lendBtn = new JButton(new ImageIcon("대여버튼.png"));
			lendBtn.setBorderPainted(false);
			lendBtn.setBounds(649, 330, 80, 37);
			lendBtn.addActionListener(this);
			returnBtn = new JButton(new ImageIcon("반납버튼.png"));
			returnBtn.setBorderPainted(false);
			returnBtn.setBounds(746, 330, 80, 37);
			delBtn = new JButton(new ImageIcon("지우기버튼.png"));
			delBtn.setBorderPainted(false);
			delBtn.setBounds(847, 330, 80, 37);
	
			
			add(idL); add(idT);
			add(mNameL); add(mNameT);
			add(mBirthL); add(mBirthT);
			add(mPhoneL); add(mPhoneT);
			add(bCodeL); add(bCodeT);
			add(bNameL); add(bNameT);
			add(bWriterL); add(bWriterT);
			add(bPressL); add(bPressT);
			
			add(bCodeL); add(bCodeT);
			add(bNameL); add(bNameT);
			add(bWriterL); add(bWriterT);
			add(bPressL); add(bPressT);
			
			add(mSearchBtn);
			add(bSearchBtn);
			add(lendBtn);
			add(returnBtn);
			add(delBtn);
			
			vector = new Vector<String>();
			vector.addElement("회원ID");
			vector.addElement("이름");
			vector.add("책코드");
			vector.add("책제목");
			vector.add("대여일");
			vector.add("반납일");

			model = new DefaultTableModel(vector,0);
			table = new JTable(model);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setBounds(121, 481, 813, 204);
			add(scroll);
			
			
			
			
	
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == lendBtn) {
				int result =JOptionPane.showConfirmDialog(this,
						"선택된 책을 대여하시겠습니까?","대여",JOptionPane.OK_CANCEL_OPTION);
				if(result == 0) JOptionPane.showMessageDialog(this, "대여 완료되었습니다");
			}
			
		}

}

		  
		
	


