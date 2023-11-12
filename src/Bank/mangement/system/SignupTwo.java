package Bank.mangement.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class SignupTwo extends JFrame implements ActionListener{
	
	JTextField pan, aadhar;
	JLabel additonalDetails, name, fname, dab, gender, email, marital, address, city, state, pincode;
	JRadioButton syes, sno, eyes, eno;
	JButton next;
	JComboBox religion, category, occupation, education, income;
	String formno;
	
	
	SignupTwo(String formno) {
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		setLayout(null);
		
		additonalDetails = new JLabel("Page 2 : 추가 정보");
		additonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additonalDetails.setBounds(290, 80, 600, 30);
		add(additonalDetails);
		
		name = new JLabel("종교 :");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		String valReligion[] = {"기독교", "불교" , "무교", "기타"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		
		fname = new JLabel("카테고리 :");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		String valcategory[] = {"사회취약계층", "청년", "중장년", "국가유공자", "기타"}; 
		category = new JComboBox(valcategory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		dab = new JLabel("월 수입 :");
		dab.setFont(new Font("Raleway", Font.BOLD, 20));
		dab.setBounds(100, 240, 200, 30);
		add(dab);
		
		String incomecategory[] = {"Null", "<  150만원", "< 250만원", "< 500만원", "1000만원 이상"}; 
		income = new JComboBox(incomecategory);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
		
		email = new JLabel("학력 :");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 315, 200, 30);
		add(email);
		
		String educationValues[] = {"고등학교 졸업", "대학 졸업 예정", "대학교 졸업", "석사", "박사"}; 
		education = new JComboBox(educationValues);
		education.setBounds(300, 315, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
		
		marital = new JLabel("직종 :");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		String ocupationValues[] = {"근로자", "자영업", "비즈니스", "학생", "은퇴", "기타"}; 
		occupation = new JComboBox(ocupationValues);
		occupation.setBounds(300, 390, 400, 30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		address = new JLabel("주민번호 :");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		city = new JLabel("사업자번호: :");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		state = new JLabel("60세 이상이십니까?: ");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		syes = new JRadioButton("네");
		syes.setFont(new Font("Raleway", Font.BOLD, 14));
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("아니오");
		sno.setFont(new Font("Raleway", Font.BOLD, 14));
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(syes);
		maritalGroup.add(sno);
		
		pincode = new JLabel("기존계좌 여부 :");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		eyes = new JRadioButton("네");
		eyes.setFont(new Font("Raleway", Font.BOLD, 14));
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("아니오");
		eno.setFont(new Font("Raleway", Font.BOLD, 14));
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup emaritalGroup = new ButtonGroup();
		emaritalGroup.add(eyes);
		emaritalGroup.add(eno);
		
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
		
		String sreligion = (String) religion.getSelectedItem(); //setText
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		String seniorcitizen = null;
		if (syes.isSelected()) {
			seniorcitizen = "네";
		} else if (sno.isSelected()){
			seniorcitizen = "아니오";
		}
		
		String existingcount = null;
		if (eyes.isSelected()) {
			existingcount = "네";
		} else if (eno.isSelected()) {
			existingcount = "아니오";
		} 
		
		String span = pan.getText();
		String saadhar = aadhar.getText();

		System.out.println("양식 번호:" +  formno);
		System.out.println("종교:" + sreligion);
		System.out.println("카테고리: " + scategory);
		System.out.println("월 수입:" + sincome);
		System.out.println("학력: " + seducation);
		System.out.println("직종:" + soccupation);
		System.out.println("주민 번호: " + span);
		System.out.println("사업자번호: " + saadhar);
		System.out.println("60세이상:" + seniorcitizen);
		System.out.println("기존계좌여부:" + existingcount);
		
		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "필수 항목을 체크해주세요. ");
			} else {
				Conn c = new Conn();
				String query = "INSERT INTO signuptwo (formno, 종교, 카테고리, 월수입, 학력, 직종, 주민번호, 사업자번호, 60세이상, 기존계좌여부) VALUES " +
					    "('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" +
					    span + "','" + saadhar + "','" + seniorcitizen + "','" + seniorcitizen + "')";
				c.s.executeUpdate(query);
				
				 new SignupThree(formno).setVisible(true);
	             setVisible(false);
			}
		} catch (Exception e){
			System.out.println(e);
		}		
	}
	
	public static void main(String[] args) {
		new SignupTwo("").setVisible(true);
	}

}
