package Bank.mangement.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import java.sql.*;

public class SignupThree extends JFrame implements ActionListener{
	
	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;

	SignupThree(String formno) {
		this.formno = formno;
		setLayout(null);
		
		JLabel l1 = new JLabel("Page3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		JLabel type = new JLabel("계좌유형");
		type.setFont(new Font("Raleway", Font.BOLD, 22));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		r1 = new JRadioButton("저축성예금");
		r1.setFont(new Font("Raleway", Font.BOLD, 16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100, 180, 180, 20);
		add(r1);
		
		r2 = new JRadioButton("정기예금계좌");
		r2.setFont(new Font("Raleway", Font.BOLD, 16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 180, 240, 20);
		add(r2);
		
		r3 = new JRadioButton("당좌예금");
		r3.setFont(new Font("Raleway", Font.BOLD, 16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100, 220, 250, 20);
		add(r3);
		
		r4 = new JRadioButton("주택청약종합저축");
		r4.setFont(new Font("Raleway", Font.BOLD, 16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350, 220, 280, 20);
		add(r4);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		JLabel card = new JLabel("카드 번호");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100, 300, 200, 30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4134");
		number.setFont(new Font("Raleway", Font.BOLD, 22));
		number.setBounds(330, 300, 300, 30);
		add(number);
		
		JLabel carddetail = new JLabel("카드 16자리 고유번호");
		carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
		carddetail.setBounds(100, 330, 300, 20);
		add(carddetail);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 370, 200, 30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pnumber.setBounds(330, 370, 300, 30);
		add(pnumber);
		
		JLabel pinDetail = new JLabel("핀 4자리 고유번호");
		pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		pinDetail.setBounds(100, 400, 300, 20);
		add(pinDetail);
		
		JLabel services = new JLabel("서비스 유형:");
		services.setFont(new Font("Raleway", Font.BOLD, 22));
		services.setBounds(100, 450, 400, 30);
		add(services);
		
		c1 = new JCheckBox("ATM 카드");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBounds(100, 500, 200, 30);
		add(c1);
		
		c2 = new JCheckBox("인터넷 뱅킹");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBounds(350, 500, 200, 30);
		add(c2);
		
		c3 = new JCheckBox("모바일 뱅킹");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBounds(100, 550, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("이메일 & SMS 알람 서비스");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBounds(350, 550, 200, 30);
		add(c4);
		
		c5 = new JCheckBox("지불 명령서");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBounds(100, 600, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("전자 명세서");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBounds(350, 600, 200, 30);
		add(c6);
		
		c7 = new JCheckBox("상기 개인정보수집에 동의합니다.");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBounds(100, 680, 600, 30);
		add(c7);
		
		submit = new JButton("제출");
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(250, 720, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("취소");
		cancel.setForeground(Color.BLACK);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(420, 720, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 820);
		setLocation(320, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String accountType = null;
			if (r1.isSelected()) {
				accountType = "저축성 예금";
			} else if (r2.isSelected()) {
				accountType = "정기예금계좌";
			} else if (r3.isSelected()) {
				accountType = "당좌예금";
			} else if (r4.isSelected()) {
				accountType = "주택청약종합저축";
			}
			
			Random random = new Random();
			long cardnumber = (random.nextLong() % 90000000L) + 5040936000000000L;
			String cardno = "" + Math.abs(cardnumber);
			
			long pinnumber = (random.nextLong() % 9000L) + 1000L;
			String pin = "" + Math.abs(pinnumber);
			
			 String facility = "";
		        if(c1.isSelected()){ 
		            facility = facility + "ATM 카드";
		        }
		        if(c2.isSelected()){ 
		            facility = facility + "인터넷 뱅킹";
		        }
		        if(c3.isSelected()){ 
		            facility = facility + "모바일 뱅킹";
		        }
		        if(c4.isSelected()){ 
		            facility = facility + "이메일 알람";
		        }
		        if(c5.isSelected()){ 
		            facility = facility + "지불 명령서";
		        }
		        if(c6.isSelected()){ 
		            facility = facility + "전자 명세서";
		        }
		        
		        System.out.println("formno: " + formno);
		        System.out.println("계좌유형: " + accountType);
		        System.out.println("카드번호: " + cardno);
		        System.out.println("핀번호 : " + pin);
		        System.out.println("서비스유형 : " + facility);
;
		        
		        try {
		        	if (accountType.equals("")) {
		        		JOptionPane.showMessageDialog(null, "계좌 유형을 선택해주세요");
		        	} else {
		        		Conn c = new Conn();
		        		String query = "INSERT INTO signupthree (formno, 계좌유형, 카드번호, pin, 서비스유형) VALUES " +
							    "('" + formno + "','" + accountType + "','" + cardno + "','" + pin + "','" + facility + "')";
		        		String query2 = "INSERT INTO login (formno, 카드번호, pin) VALUES" + 
							    "('" + formno + "', '"+ cardno + "', '"+ pin + "')";
						c.s.executeUpdate(query);
						c.s.executeUpdate(query2);
						
						JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
						
						setVisible(false);
						new Deposit(pin).setVisible(false);
		        	}
		        } catch (Exception e){
		        	System.out.println(e);
		        }
			
		} else if (ae.getSource() == cancel){
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new SignupThree("");
	}
}
