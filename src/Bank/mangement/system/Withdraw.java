package Bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdraw, back;
	String pinnumber;

	Withdraw(String pinnumber) {
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 20, 900, 900);
		add(image);
		
		JLabel text = new JLabel("출금하실 금액을 입력하세요");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170, 300, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 350, 320,  20);
		image.add(amount);
		
		withdraw= new JButton("출금");
		withdraw.setBounds(355, 485, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("뒤로");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		System.out.println("핀번호: " + pinnumber);
		
		try {
			if (ae.getSource() == withdraw) {
				//사용자가 입력한 출금금액 변수 number
				String number = amount.getText();
				Date date = new Date();
				
				if (number.equals("")) {
					JOptionPane.showMessageDialog(null, "출금하실 금액을 입력해주세요");
				} else {
					Conn c = new Conn();
					/* 로그인한 계정의 pin 번호를 기준으로 bank 테이블의 컬럼을 모두 가져와서 resultset으로 저 */
					/* pin, 날짜, 유형, 금액, 잔액 */
					ResultSet won = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"' ");
					/* 잔액 초기화 */
					int balance = 0;
					
					/* ResultSet을 한행씩 읽으면서 내려간다.다 읽으면 next()함수에서 false 반환.루프탈 */
					while(won.next()) {
                       /* 잔액을 데이터베이스에서 조회 */
						  balance = Integer.parseInt(won.getString("잔액"));
						  System.out.println("잔액" + balance);
					}	
					/* 출금하고자 하는 금액이 잔액보다 많다면 */
					if (balance < Integer.parseInt(number)) {
						JOptionPane.showMessageDialog(null, "잔액이 부족합니다");
						return;
					} else {
						/* 잔액 - 출금금액 = 잔액 */
						balance -= Integer.parseInt(number);
						System.out.println("출금후 잔액:" + balance);
						
						/* 출금한 내용 데이터베이스에 인서트 */
						String query = "INSERT INTO bank(pin, 날짜, 유형, 금액, 잔액) VALUES" + 
								 "('" + pinnumber + "', '"+ date + "', '출금', '"+ number +"', '"+balance+"')";
						c.s.executeUpdate(query);
						JOptionPane.showMessageDialog(null, " '"+ number +"'원이 출금되었습니다. ");
					}

				}
			} else if (ae.getSource() == back) {
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Withdraw("");
	}
}
