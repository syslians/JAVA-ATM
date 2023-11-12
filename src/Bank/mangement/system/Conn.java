package Bank.mangement.system;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "root");
			s = c.createStatement();
			
			if (c != null) {
				System.out.println("데이터베이스 연결 성공");
			}
		} catch (Exception e){
		  System.out.println(e);
		  System.out.println("데이터베이스 연결 실패");
		  e.printStackTrace();
		}
	}
}
