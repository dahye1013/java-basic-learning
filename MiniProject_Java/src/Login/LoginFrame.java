package Login;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
    static LoginFrame login ;
	public Login member;
	

    LoginFrame(){
        super("Login");
        
        Container c = this.getContentPane();
        
        member = new Login();
        
		JTabbedPane tab = new JTabbedPane(JTabbedPane.NORTH);
		tab.add(member, "일반회원" );
		
		c.add(tab);
		
        setBounds(700, 100, 300, 450);
        setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int result=  JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
                if(result == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        repaint();
        
    }
    

    
    
    public static void main(String[] args) {
        new LoginFrame();
    }
    
}
