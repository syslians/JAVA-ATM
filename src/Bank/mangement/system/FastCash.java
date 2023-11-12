package Bank.mangement.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit, withdraw, ministatement, pinchange, fastcash, back, balanceenquiry;
	String pinnumber;
	
	FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 20, 900, 900);
		add(image);
		
		JLabel text = new JLabel("출금할 금액을 선택해주세요");
		text.setBounds(215, 300, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		deposit = new JButton("1만원");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("5만원");
		withdraw.setBounds(355, 415, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		fastcash = new JButton("10만원");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("20만원");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("50만원");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("100만원");
		balanceenquiry.setBounds(355, 485, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		back = new JButton("뒤로");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
				
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			new Transactions(pinnumber).setVisible(true);
		} else {
			String amount = ((JButton)ae.getSource()).getText();
			int Amount = 0;
			   // 선택된 금액에 따라서 amount 값을 설정
	        if (amount.equals("1만원")) {
	        	Amount = 10000;
	        } else if (amount.equals("5만원")) {
	        	Amount = 50000;
	        } else if (amount.equals("10만원")) {
	        	Amount = 100000;
	        } else if (amount.equals("50만원")) {
	        	Amount = 500000;
	        } else if (amount.equals("100만원")) {
	        	Amount = 1000000;
	        }
			System.out.println(Amount);
			
			Conn c = new Conn();
			try {
				ResultSet won = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"' ");
				int balance = 0;
				while(won.next()) {
                    /* 잔액을 데이터베이스에서 조회 */
						  balance = Integer.parseInt(won.getString("잔액"));
						  System.out.println("잔액" + balance);
					}
				System.out.println("잔액:" + balance);
				
				if (ae.getSource() != back && balance < Amount) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다");
					return;
				}
				balance -= Amount;
				System.out.println("출금후 잔액:" + balance);
				Date date = new Date();
				String query = "INSERT INTO bank(pin, 날짜, 유형, 금액, 잔액) VALUES" + 
						"('" + pinnumber + "', '"+ date + "', '출금', '"+ Amount +"', '"+balance+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, + Amount + "원이 성공적으로 출금되었습니다");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		} 
	}
	
	public static void main(String[] args) {
		new FastCash("");
	}

}
