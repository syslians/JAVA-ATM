package Bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin, repin;
	JButton change, back;
	String pinnumber;
	
	PinChange(String pinnumber) {
		this.pinnumber = pinnumber;
		System.out.println("핀번호변경 클래스:" +pinnumber);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 20, 900, 900);
		add(image);
		
		JLabel text = new JLabel("PIN 번호 변경: ");
		text.setBounds(250, 280, 500, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		JLabel pintext = new JLabel("새 PIN 번호: ");
		pintext.setBounds(165, 320, 180, 25);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setForeground(Color.WHITE);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 25));
		pin.setBounds(320, 320, 180, 25);
		pin.addActionListener(this);
		image.add(pin);
		
		JLabel repintext = new JLabel("새 PIN 번호 확인: ");
		repintext.setBounds(165, 360, 180, 25);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setForeground(Color.WHITE);
		image.add(repintext);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 25));
		repin.setBounds(320, 360, 180, 25);
		repin.addActionListener(this);
		image.add(repin);
		
		change = new JButton("변경");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("뒤로");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = repin.getText();
				System.out.println(npin);
				System.out.println(rpin);
				
				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "PIN 번호가 일치하지 않습니다");
					return;
				}
				
				if (npin.equals("")) {
					JOptionPane.showMessageDialog(null, "새 PIN 번호를 입력해주세요");
					return;
				}				
				
				if (rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "새 PIN 번호를 확인해주세요");
					return;
				}
				
				Conn c = new Conn();
				String query1 = "UPDATE bank SET pin = '"+rpin+"' WHERE pin= '"+pinnumber+"' ";
				String query2 = "UPDATE login SET pin = '"+rpin+"' WHERE pin= '"+pinnumber+"' ";
				String query3 = "UPDATE signupthree SET pin = '"+rpin+"' WHERE pin= '"+pinnumber+"' ";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN 번호가 성공적으로 변경되었습니다!");
						
				setVisible(false);
				new Transactions(rpin).setVisible(true);
			} catch (Exception e){
				System.out.println(e);
			}
		} else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}
}
