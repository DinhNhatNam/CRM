package crm_project.API;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm_project.payload.respone.BaseRespone;
import crm_project22.service.UserService;



@WebServlet (name = "ApiUserController", urlPatterns = { "/api/user/delete" })
public class ApiUserController extends HttpServlet {
	private Gson gson = new Gson();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(req.getParameter("id"));
		UserService us = new UserService();
		boolean isSuccess = us.deleteUserByID(id);
		
		BaseRespone respone = new BaseRespone();
		respone.setStatuscode(200);
		respone.setMessage(isSuccess ? "thanh cong" : " that bai");
		respone.setData(isSuccess);
		String dataJSON = gson.toJson(respone);	

		out.print(dataJSON);
		out.flush();
	}
}