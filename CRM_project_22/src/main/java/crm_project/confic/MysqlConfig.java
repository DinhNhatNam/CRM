package crm_project.confic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConfig {
 public static Connection getConnection() {
	 //tạo kết nối csdl
	 Connection connection = null;
	 //khai báo driver sử dụng cho csdl tương ứng
	 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=  DriverManager.getConnection("jdbc:mysql://localhost:3308/crm"
			,"root", "admin123");
		
		
	} catch (ClassNotFoundException |SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Lỗi kết nối CSDL "+ e.getLocalizedMessage());
	}  
	 return connection;
 }
 
}
