package crm_project.API;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm_project.entity.LoaiThanhVien;
import crm_project.payload.respone.BaseRespone;
import crm_project22.service.RoleService;
@WebServlet(name = "apiRoleController" , urlPatterns = "/api/role/delete")
public class ApiRoleController extends HttpServlet {
	// khoi tao gson ben ngoai de doget dopost deu sai dc
	private Gson gson = new Gson();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//String json = "{\"id\":0,\"name\":\"a hê hê hê\",\"mota\":\"ahihii\"}";
//	LoaiThanhVien ltv = new LoaiThanhVien();
//	ltv.setId(0);
//	ltv.setMota("ahihii");
//	ltv.setName("đây là tên á");
	
	//LoaiThanhVien ltv= gson.fromJson(json, LoaiThanhVien.class);
	RoleService roleService = new RoleService();
	//String dataJson = gson.toJson(ltv);
	int id = Integer.parseInt(req.getParameter("id"));
	boolean isSuccess = roleService.deleteRoleById(id);
	
	BaseRespone baseRespone = new BaseRespone();
	baseRespone.setMessage(isSuccess ? "xóa thành công": "fail rồi ");
	baseRespone.setStatuscode(200);
	baseRespone.setData(isSuccess);
	
	
	String dataJson = gson.toJson(baseRespone);

	PrintWriter out = resp.getWriter();
	resp.setContentType("application/json");
	resp.setCharacterEncoding("UTF-8");	
	out.print(dataJson);
	out.flush();
}


}
