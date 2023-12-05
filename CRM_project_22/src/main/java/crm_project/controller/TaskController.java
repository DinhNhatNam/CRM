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
import crm_project.entity.GroupWork;
import crm_project.entity.NguoiDung;
import crm_project.reposivetory.CongViecReposivetory;
import crm_project22.service.GroupWorkService;
import crm_project22.service.TaskService;


@WebServlet(name = "TaskController", urlPatterns = {"/task","/task-add"})
public class TaskController extends HttpServlet {
	TaskService task = new TaskService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");	
		
		
		String path = req.getServletPath();
		switch (path) {
		case "/task":{
			List<CongViecNguoiDung> list = task.readAllTask();
			if(list.size()>0) {
				req.setAttribute("listTask", list);
				req.getRequestDispatcher("task.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("ok.html").forward(req, resp);
			}	
		}
			
			break;
		case "/task-add":{
			GroupWorkService groupWorkService = new GroupWorkService();
			List<NguoiDung> listnd = task.ReadAllNguoiDung();
			List<GroupWork> listgw = groupWorkService.ReadAllGroupWork();
			
			req.setAttribute("listnd", listnd);
			req.setAttribute("listGW", listgw);
			req.getRequestDispatcher("task-add.jsp").forward(req, resp);
		}
			
		default:
			break;
		}
		
		
		
		
				
				
				
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		int idduan =Integer.parseInt(req.getParameter("id_duan"));
		String tencongviec = req.getParameter("tencongviec");
		int nguoithuchien = Integer.parseInt(req.getParameter("id_nguoidung"));
		String datestart = req.getParameter("ngaybatdau");
		String dateend = req.getParameter("ngayketthuc");
		
		boolean check = task.InsertCongViecNguoiDung(tencongviec, datestart, dateend, idduan, nguoithuchien);
		if(check) {
			req.getRequestDispatcher("task-add.jsp").forward(req, resp);

		}else {
			req.getRequestDispatcher("ok.html").forward(req, resp);

		}
	}

}
