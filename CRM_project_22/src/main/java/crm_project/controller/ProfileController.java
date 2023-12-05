package crm_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crm_project.entity.CongViecNguoiDung;
import crm_project.entity.GroupWork;
import crm_project22.service.GroupWorkService;
import crm_project22.service.UserService;



@WebServlet(name = "ProfileController", urlPatterns = {"/profile","/profile-edit"})
public class ProfileController extends HttpServlet {
	private UserService uService = new UserService();
	private GroupWorkService daService = new GroupWorkService();
	boolean isSuccess;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath();
		String ct = req.getContextPath();
		switch (url) {
		case "/profile":
			List<CongViecNguoiDung> list = new ArrayList<CongViecNguoiDung>();
			List<GroupWork> listDuAn = new ArrayList<GroupWork>();
			HttpSession session = req.getSession();
			int id = (int) session.getAttribute("id_nguoidung");			
			list = uService.viewDetailUser(id);
			listDuAn = daService.FindDuAnById(list.get(0).getId_CongViec().getId_duan().getId());
			req.setAttribute("listDetail", list);
			req.setAttribute("listDuAn", listDuAn);
			//System.out.println(listDuAn.get(0).getName());			
			if (list.isEmpty()){
				String Message = "Bạn hiện tại không có Job nào !!";
				req.setAttribute("msg", Message);
				req.getRequestDispatcher("blank.jsp").forward(req, resp);
			}			
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
			break;
		case "/profile-edit":
			String id_raw = req.getParameter("id");
			req.setAttribute("id", id_raw);		
			req.getRequestDispatcher("role-update.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath();
		String ct = req.getContextPath();
		String id_raw = req.getParameter("id");
		String tenDuAn = req.getParameter("tenDuAn");
		String tenCv = req.getParameter("tenCv");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate"); 
		String status = req.getParameter("trangthai");
		int id = Integer.parseInt(id_raw);
		
		req.setAttribute("isSuccess", isSuccess);
		req.getRequestDispatcher("role-update.jsp").forward(req, resp);
	}
}