package crm_project.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
/*
 * 
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import crm_project.confic.MysqlConfig;
import crm_project.entity.NguoiDung;
import crm_project.reposivetory.NguoiDungReposivetory;
import crm_project22.service.LoginService;

@WebServlet(name = "LoginController" , urlPatterns = {"/login","/logout"})
public class LoginController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String path = req.getServletPath();
	switch (path) {
	case "/login":{
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
		
		break;
	case "/logout":
		req.getSession().invalidate();
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		break;
	default:
		break;
	}
	
	
	
}
/*
 * xác định chức năng giao diện
 * xác định query cho chức năng 
 * kiểm tra câu query
 * nhận tham số bằng số liệu query cần
 * chuẩn bị query ở servlet
 * mở kết nối đến csdl
 * truyền query cbi vào connection(thêm tham số nếu có )
 * thực thi câu query
 * lấy kết quả từ query đã thực thi
 * xử lý logic code tương ứng 
 * 
 * 
 */
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	String email = req.getParameter("email");
//	String pass = req.getParameter("password");
//	List<NguoiDung> list = new ArrayList<NguoiDung>();
//	
//	String query = "Select * from NguoiDung nd where nd.email = ? and nd.matkhau= ? ";
//	
//	//? là giá trị của tham số sẽ đc truyền vào sau
//	
//	// mở kết nối đến csdl
//	Connection connection = MysqlConfig.getConnection();
//	
//	// truyền query vào connection
//	
//	try {
//		PreparedStatement statement = connection.prepareStatement(query);
//		// truyền giá trị vào query nếu có
//		statement.setString(1, email);// lưu ý setString setInt p tùy vào kiểu dữ liệu của cột
//		statement.setString(2, pass);
//		/*
//		 * excuteQuery; dùng khi câu truy vấn trả ra dữ liệu 
//		 * excuteUpdate; truy vấn ko trả dữ liệu
//		 * 
//		 */
//		 ResultSet resultSet = statement.executeQuery();
//		 while (resultSet.next()) {
//			NguoiDung ng = new NguoiDung();
//			
//			ng.setId(resultSet.getInt("id"));
//			ng.setFullname(resultSet.getString("fullname"));
//			ng.setEmail(resultSet.getString("matkhau"));
//			list.add(ng);
//		}
//		 if(list.size()>0) {
//			 System.out.println("login thành công");
//		 }else {
//			System.out.println("login thất cmn bại ");
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		System.err.println("lỗi thực thi"+ e.getLocalizedMessage());
//	}finally {
//		if(connection!=null)
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.err.println("lỗi thực thi"+ e.getLocalizedMessage());
//			}
//	}
//	
//	req.getRequestDispatcher("task.html").forward(req, resp);
//	}
	
	String email = req.getParameter("email");
	String pass = req.getParameter("password");
	
	LoginService loginService = new LoginService();
	List<NguoiDung> nd = loginService.checkLogin(email, pass);

		
	HttpSession Session = req.getSession();
	if(nd.size()>0) {		
		Session.setAttribute("email", email);
		Session.setAttribute("pass", pass);
		Session.setAttribute("id_nguoidung", nd.get(0).getId());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}else {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
}
}
