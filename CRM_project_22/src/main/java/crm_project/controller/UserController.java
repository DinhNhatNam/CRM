package crm_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project.entity.CongViecNguoiDung;
import crm_project.entity.LoaiThanhVien;
import crm_project.entity.NguoiDung;
import crm_project22.service.RoleService;
import crm_project22.service.UserService;



@WebServlet(name = "UserController", urlPatterns = { "/user-table", "/user-add","/user-detail","/user-update"})
public class UserController extends HttpServlet {
	private UserService uService = new UserService();
	private RoleService rService = new RoleService();
	boolean isSuccess;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getServletPath();
		String ct = req.getContextPath();
		
		
		switch (url) {
		case "/user-table":
			List<NguoiDung> list = new ArrayList<NguoiDung>();
			list = uService.ReadAllNguoiDung();
			req.setAttribute("listUser", list);
			req.getRequestDispatcher("user-table.jsp").forward(req, resp);
			break;
		case "/user-add":
			req.getRequestDispatcher("user-add.jsp").forward(req, resp);
			break;
		case "/user-detail":
			List<CongViecNguoiDung> list_detail = new ArrayList<CongViecNguoiDung>();
			String raw_id = req.getParameter("id-user");
			int id = Integer.parseInt(raw_id);
			list_detail = uService.viewDetailUser(id);
			req.setAttribute("listInfo", list_detail);
			if (list_detail.isEmpty()){
				String Message = "Nhân viên này hiện tại không có Job nào !!";
				req.setAttribute("msg", Message);
				req.getRequestDispatcher("blank.jsp").forward(req, resp);
			}			
			req.getRequestDispatcher("user-detail.jsp").forward(req, resp);
			break;
		case "/user-update":
			List<LoaiThanhVien> list_ltv = new ArrayList<LoaiThanhVien>();
			list_ltv = rService.ReadRoleService();
			req.setAttribute("listRole", list_ltv);
			String id_raw = req.getParameter("id-user");
			req.setAttribute("id-user", id_raw);
			req.getRequestDispatcher("user-update.jsp").forward(req, resp);
			break;
		default:
			break;
		}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath();
		String ct = req.getContextPath();
		String fullname = new String(req.getParameter("fullname").getBytes("ISO-8859-1"), "UTF-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phoneNum = req.getParameter("phone-num");
		String diaChi = new String(req.getParameter("diachi").getBytes("ISO-8859-1"), "UTF-8");
		int id_ltv;
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		switch (url) {
		case "/user-add":
			id_ltv = 3;
			isSuccess = uService.insert(email, password, fullname, diaChi, phoneNum, id_ltv);
			req.setAttribute("isSuccess", isSuccess);			
			req.getRequestDispatcher("user-add.jsp").forward(req, resp);
			break;
		case "/user-update":
			String id_raw = req.getParameter("id-user");
			int id = Integer.parseInt(id_raw);
			id_ltv = Integer.parseInt(req.getParameter("id_role"));
			isSuccess = uService.update(id, email, password, fullname, diaChi, phoneNum, id_ltv);
			req.setAttribute("isSuccess", isSuccess);
			req.getRequestDispatcher("user-update.jsp").forward(req, resp);
			break;			
		default:
			break;
		}
	}
}