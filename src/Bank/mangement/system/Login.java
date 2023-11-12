package Bank.mangement.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login() {
		
		setTitle("현금자동입출기");
		
		setLayout(null);
		
		/*GUI 요소 초기*/
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		/*로그인 텍스트*/
 		JLabel text = new JLabel("ATM");
 		text.setFont(new Font("Osward", Font.BOLD, 38));
 		text.setBounds(200, 40, 400, 40);
 		add(text);
 		
 		/*카드 번호 텍스트*/
 		JLabel cardno = new JLabel("카드 번호:");
 		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
 		cardno.setBounds(120, 150, 150, 30);
 		add(cardno);
 		
 		/*카드 번호 필드*/
 		cardTextField = new JTextField();
 		cardTextField.setBounds(300, 150, 230, 30);
 		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
 		add(cardTextField);
 		
 		/*핀 번호 텍스*/
 		JLabel pin = new JLabel("PIN 번호:");
 		pin.setFont(new Font("Raleway", Font.BOLD, 28));
 		pin.setBounds(120, 220, 250, 40);
 		add(pin);
 		
 		/*핀 번호 비밀번호 텍스트*/
 		pinTextField = new JPasswordField();
 		pinTextField.setBounds(300, 220, 230, 30);
 		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
 		add(pinTextField);
 		
 		/*로그인 버튼*/
 		login = new JButton("SIGN IN");
 		login.setBounds(300, 300, 100, 30);
 		login.setBackground(Color.BLACK);
 		login.addActionListener(this);
 		add(login);
 		
 		/*필드 초기화 버튼*/
 		clear = new JButton("CLEAR");
 		clear.setBounds(430, 300, 100, 30);
 		clear.setBackground(Color.BLACK);
 		clear.addActionListener(this);
 		add(clear);
 		
 		/*등록 버튼*/
 		signup = new JButton("SIGN UP");
 		signup.setBounds(300, 350, 230, 30);
 		signup.setBackground(Color.BLACK);
 		signup.addActionListener(this);
 		add(signup);
 		
		/*전체 GUI 색상, 사이즈 및 위치*/
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800, 480);
		setVisible(true);
		setLocation(350, 200);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} else if (ae.getSource() == login) {
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query =  "select * from login where 카드번호 = '"+ cardnumber +"' and pin ='"+ pinnumber +"' ";
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "카드번호나 pin번호가 올바르지 않습니다.");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
		} else if (ae.getSource() == signup) {
			setVisible(false);
            new SignupOne().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Login();
		
	}
	
}
