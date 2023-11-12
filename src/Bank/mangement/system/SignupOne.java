package Bank.mangement.system;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameTextField, fnameTextField, dabTextField, emailTextField, addressTextField, cityTextField, stateTextField ,pinTextField;
	JLabel formno, personDetails, name, fname, dab, gender, email, marital, address, city, state, pincode;
	JDateChooser dateChooser;
	JRadioButton male, female, other, married, unmarried;
	JButton next;
	
	Random ran = new Random();
	long first4 = (ran.nextLong() % 9000L) + 1000L;
	String first = "" + Math.abs(first4);
	
	SignupOne() {
		
		setLayout(null);
		
		
//		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		System.out.println(first);
	
		formno = new JLabel("Application Form No. " + first);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		personDetails = new JLabel("Page 1: 개인상세 정보");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(290, 80, 600, 30);
		add(personDetails);
		
		name = new JLabel("성명 :");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		fname = new JLabel("부성명 :");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		dab = new JLabel("생일 :");
		dab.setFont(new Font("Raleway", Font.BOLD, 20));
		dab.setBounds(100, 240, 200, 30);
		add(dab);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);
		
		gender = new JLabel("성별 :");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("남성");
		male.setBounds(300, 290, 80, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("여성");
		female.setBounds(450, 290, 80, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		
		email = new JLabel("이메일 주소 :");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		marital = new JLabel("기혼여부 :");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		married = new JRadioButton("기혼");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("미혼");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("기타");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		address = new JLabel("주소 :");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		city = new JLabel("시 :");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		state = new JLabel("구 :");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
//		pincode = new JLabel("핀 번호 :");
//		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
//		pincode.setBounds(100, 590, 200, 30);
//		add(pincode);
		
//		pinTextField = new JTextField();
//		pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//		pinTextField.setBounds(300, 590, 400, 30);
//		add(pinTextField);
		
		next = new JButton("다음");
		next.setBackground(Color.WHITE);
		next.setForeground(Color.BLACK);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		add(next);
		next.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		long formno = random; //long
		String name = nameTextField.getText(); //setText
		String fname = fnameTextField.getText();
		String dab = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "남성";
		} else if (female.isSelected()){
			gender = "여성";
		}
		
		String email = emailTextField.getText();
		String marital = null;
		if (married.isSelected()) {
			marital = "기혼";
		} else if (unmarried.isSelected()) {
			marital = "미혼";
		} else if (other.isSelected()) {
			marital = "기타";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
//		String pin = pinTextField.getText();
		
		System.out.println("양식 번호:" +  formno);
		System.out.println("성명:" + name);
		System.out.println("부성명:" + fname);
		System.out.println("생일:" + dab);
		System.out.println("성별: " + gender);
		System.out.println("이메일 주소:" + email);
		System.out.println("기혼 여부: " + marital);
		System.out.println("주소지: " + address);
		System.out.println("시:" + city);
		System.out.println("구:" + state);
//		System.out.println("pin 번호: " + pin);
		
		
		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "이름을 적어주셔야 합니다.");
			} else {
				Conn c = new Conn();
				String query = "INSERT INTO signup (formno, name, father_name, dab, gender, email, marital_status, address, city, state) VALUES " +
					    "('" + random + "','" + name + "','" + fname + "','" + dab + "','" + gender + "','" + email + "','" + marital + "','" +
					    address + "','" + city + "','" + state + "')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupTwo(first).setVisible(true);
			}
		} catch (Exception e){
			System.out.println(e);
		}		
	}
	
	public static void main(String[] args) {
		new SignupOne();
	}

}
