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
import crm_project.entity.DuAnNguoiDung;
import crm_project.entity.GroupWork;
import crm_project.entity.NguoiDung;
import crm_project.reposivetory.GroupWorkReposivetory;
import crm_project22.service.GroupWorkService;

@WebServlet(name = "GroupworkController", 
urlPatterns = { "/groupwork", "/groupwork-add","/groupwork-detail","/groupwork-edit"})
public class GroupworkController extends HttpServlet {
	GroupWorkService groupWorkService = new GroupWorkService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/groupwork": {
			GroupWorkReposivetory groupWorkReposivetory = new GroupWorkReposivetory();
			List<GroupWork> list = new ArrayList<GroupWork>();
			list = groupWorkReposivetory.SelectAllFromDuAn();
			req.setAttribute("listgroupwork", list);
			req.getRequestDispatcher("groupwork.jsp").forward(req, resp);
		}
			break;
		case "/groupwork-add": {
			req.getRequestDispatcher("groupwork-add.jsp").forward(req, resp);
		}break;
		case "/groupwork-detail":{
			
			
			
			int id = Integer.parseInt(req.getParameter("id") ); 
			
			List<CongViecNguoiDung> list =  groupWorkService.Groupworkmetmoiqua(id);
			List<DuAnNguoiDung> listcheck = groupWorkService.GetDuAnNguoiDung(id);
			List<Double> listCount = groupWorkService.Counting(id);
			
			req.setAttribute("listcheck", listcheck);
			req.setAttribute("listcongviec", list);
			req.setAttribute("listcount", listCount);
			req.getRequestDispatcher("groupwork-detail.jsp").forward(req, resp);
		}

			break;
		case "/groupwork-edit":{
			String id_raw = req.getParameter("id");
			int id = Integer.parseInt(id_raw); 
			
			List<GroupWork> list = groupWorkService.FindDuAnById(id);
			
			req.setAttribute("namedn", list.get(0).getName());
			req.setAttribute("nbatdau",list.get(0).getNgaybatdau() );
			req.setAttribute("nketthuc",list.get(0).getNgaykethuc() );
			req.setAttribute("id",id_raw);
			req.getRequestDispatcher("groupwork-edit.jsp").forward(req, resp);
		}
		break;
		
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/groupwork-add":{
			String ten = req.getParameter("tenduan");
			String ngaybatdau = req.getParameter("ngaybatdau");
			String ngayketthuc = req.getParameter("ngayketthuc");		
			HttpSession session = req.getSession();
			int id_nguoidung = (int) session.getAttribute("id_nguoidung");
			boolean check = groupWorkService.CreateGroupWork(ten, ngaybatdau, ngayketthuc, id_nguoidung);

			req.getRequestDispatcher("groupwork-add.jsp").forward(req, resp);
		} case"/groupwork-edit":{
			System.out.println("có đây ko ");
			String id_raw = req.getParameter("id");
			int id = Integer.parseInt(id_raw);
			System.err.println(id_raw+"check đây nek");
			List<GroupWork> list = groupWorkService.FindDuAnById(id);
			
			list.get(0).setName(req.getParameter("tenduan"));
			list.get(0).setNgaybatdau(req.getParameter("ngaybatdau"));
			list.get(0).setNgaykethuc(req.getParameter("ngayketthuc"));
			Boolean a = groupWorkService.UpdateGroupwork(list.get(0));
			if(a) {
				System.err.println("có chạy tới đây hơm");
				req.getRequestDispatcher("groupwork-edit.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("404.html").forward(req, resp);
			}
		}
			
			break;

		default:
			break;
		}
		
		
	}

}
