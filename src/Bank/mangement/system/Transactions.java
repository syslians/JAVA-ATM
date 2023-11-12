package Bank.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdraw, ministatement, pinchange, fastcash, exit, balanceenquiry;
	String pinnumber;
	
	Transactions(String pinnumber) {
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 20, 900, 900);
		add(image);
		
		JLabel text = new JLabel("원하시는 서비스를 선택해주세요");
		text.setBounds(215, 300, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		deposit = new JButton("예금");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("출금");
		withdraw.setBounds(355, 415, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		fastcash = new JButton("빠른 현금서비스");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("전자명세서");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Pin번호 변경");
		pinchange.setBounds(355, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("잔액조회");
		balanceenquiry.setBounds(170, 485, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
				
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exit) {
			System.exit(0);
		} else if (ae.getSource() == deposit) {
			new Deposit(pinnumber).setVisible(true);
		} else if (ae.getSource() == withdraw) {
			setVisible(false);
			new Withdraw(pinnumber).setVisible(true);
		} else if(ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		} else if(ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		} else if (ae.getSource() == balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		} else if (ae.getSource() == ministatement) {
			setVisible(false);
			new MiniStatement(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Transactions("");
	}

}
