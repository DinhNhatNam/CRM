package crm_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project.entity.LoaiThanhVien;
import crm_project.reposivetory.LoaiThanhVienReposivetory;
import crm_project22.service.RoleService;
@WebServlet(name = "RoleController" , urlPatterns = {"/addrole","/role-table"})
public class RoleController extends HttpServlet {
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/addrole": {
			req.getRequestDispatcher("role-add.jsp").forward(req, resp);
			break;
		}
		case "/role-table":{
			List<LoaiThanhVien> list = new ArrayList<LoaiThanhVien>();
			list = roleService.ReadRoleService();
			req.setAttribute("listRole", list);
			req.getRequestDispatcher("role-table.jsp").forward(req, resp);
			break;
		}
		default:
			
			break;
		}
		
		
		}
RoleService roleService = new RoleService();
	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html; charset=UTF-8");
	req.setCharacterEncoding("UTF-8");	

		String path = req.getServletPath();
		switch (path) {
		case "/addrole": {
		String namerole = req.getParameter("namerole");
		String descrip = req.getParameter("descrip");
		System.out.println(namerole);
		boolean check = roleService.InseartIntoLoaiThanhVien(namerole, descrip);
		
			req.setAttribute("check", check);
			req.getRequestDispatcher("role-add.jsp").forward(req, resp);
	
			break;
		}
		case "/role-table":{
			
		
			break;
		}
		default:
			
			break;
		}
		
	}}
	

