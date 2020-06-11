package MemberFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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

public class BookSearch extends JPanel implements ActionListener {
    
    private JButton searchBtn, rentBtn;
    
    private JTextField searchT, codeT, nameT, authorT, genreT, publisherT, rentT;
    private JLabel titleL, codeL, nameL, authorL, genreL, publisherL, rentL;
    
    private JComboBox<String> combo;
    private DefaultTableModel model;
    private JTable table;

    private JPanel p, p1, p2, p3, pp12, p4, p5, pp45;

    public BookSearch() { 
        
        //라벨 생성
        titleL = new JLabel("Book Search");
        titleL.setFont(new Font("고딕체", Font.BOLD , 20));
        
        codeL = new JLabel("도서코드");
        nameL = new JLabel("도서명");
        authorL = new JLabel("저자");
        publisherL = new JLabel("출판사");
        genreL = new JLabel("장르");
        rentL = new JLabel("대여");                
        
        //버튼 생성
        searchBtn = new JButton("검색");
        rentBtn = new JButton("대여");
        
        //텍스트필드 생성
        searchT = new JTextField("안녕하세요", 30);
        
        codeT = new JTextField(10);
        nameT = new JTextField(10);
        authorT = new JTextField(10);
        publisherT = new JTextField(10);
        genreT = new JTextField(10);
        rentT = new JTextField(10);        
       
        //콤보박스 생성
        String[] comboItem = {"도서명", "도서코드", "저자", "출판사", "장르"};
        combo = new JComboBox<String>(comboItem);
        
        //Table 생성
        Vector<String> v = new Vector<String>();
        v.add("도서코드");
        v.add("도서명");
        v.add("저자");
        v.add("출판사");
        v.add("장르");
        v.add("대여여부");
        model = new DefaultTableModel(v,0);
        table = new JTable(model);
        
        //JScrollPanedp table 추가
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(1000, 550));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //배치
        p1 = new JPanel();
        p1.add(titleL); //도서관리 title
        
        //검색창
        p2 = new JPanel();
        p2.add(combo);
        p2.add(searchT);
        p2.add(searchBtn);
        
        pp12 = new JPanel();
        pp12.setLayout(new BorderLayout());
        pp12.add("North" ,p1);
        pp12.add("South" ,p2);
        
        //테이블
        p3 = new JPanel();
        p3.add(scroll);
        
        //수정창
        p4 = new JPanel();
        p4.add(codeL); p4.add(codeT);
        p4.add(nameL); p4.add(nameT);
        p4.add(authorL); p4.add(authorT);
        p4.add(genreL); p4.add(genreT);
        p4.add(publisherL); p4.add(publisherT);
        p4.add(rentL); p4.add(rentT);
        
        //추가,삭제,수정 버튼
        p5 = new JPanel();
        p5.add(rentBtn);
        
        pp45 = new JPanel();
        pp45.setLayout(new BorderLayout());
        pp45.add("North" ,p4);
        pp45.add("South" ,p5);
        
        //big Panel
        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add("North" , pp12);
        p.add("Center" , p3);
        p.add("South" , pp45);
        
        add(p);   
     
        //이벤트
        rentBtn.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(this, "대여가 완료되었습니다", "대여 완료", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(this, "이미 대여중인 책입니다", "대여 불가", JOptionPane.WARNING_MESSAGE); 
        //JOptionPane.showMessageDialog(this, "도서 대여는 3권만 가능합니다", "대여 불가", JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(this, "대여가 완료된 책입니다", "대여 불가", JOptionPane.WARNING_MESSAGE);
    }//actionPerformed()

}

