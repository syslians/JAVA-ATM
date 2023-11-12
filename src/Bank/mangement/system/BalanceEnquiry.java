package Bank.mangement.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String pinnumber;
	
	BalanceEnquiry(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 20, 900, 900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		Conn c = new Conn();
		int balance = 0;
		try {
			ResultSet won = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"' ");
			
			/* resultset의 마지막 행의 잔액 컬럼값을 가져온다. */
		    while (won.next()) {
		        balance = won.getInt("잔액");
		    }
		    
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("잔액조회:" + balance);
		
		JLabel text = new JLabel("현재 잔액:" + balance + "원");
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400, 30);
		image.add(text);
		
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
}
