package crm_project.filter;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FilterController", urlPatterns = {"/role-adds","/role-table","/role-update","/user-add","/user-table","/user-update","/task","/task-add","/task-update","/groupwork","/groupwork-add"})
public class FilterController implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getServletPath();
		String ct = req.getContextPath();
		HttpSession session = req.getSession();
		String role = (String) session.getAttribute("roleName");
		switch (url) {
		case "/role-adds":
			if (role!= null && role.toUpperCase().equals("ADMIN")) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/role-table":
			if (role!= null && role.toUpperCase().equals("ADMIN")) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/user-add":
			if (role!= null && role.toUpperCase().equals("ADMIN")) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/user-table":
			if (role!= null && (role!= null && role.toUpperCase().equals("ADMIN"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/role-update":
			if (role!= null && (role!= null && role.toUpperCase().equals("ADMIN"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/user-update":
			if (role!= null && (role!= null && role.toUpperCase().equals("ADMIN"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/task":
			if (role!= null && (role.toUpperCase().equals("ADMIN") || role.toUpperCase().equals("LEADER"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/task-add":
			if (role!= null && (role.toUpperCase().equals("ADMIN") || role.toUpperCase().equals("LEADER"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/task-update":
			if (role!= null && (role.toUpperCase().equals("ADMIN") || role.toUpperCase().equals("LEADER"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/groupwork":
			if (role!= null && (role.toUpperCase().equals("ADMIN") || role.toUpperCase().equals("LEADER"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/groupwork-add":
			if (role!= null && (role.toUpperCase().equals("ADMIN") || role.toUpperCase().equals("LEADER"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		case "/groupwork-update":
			if (role!= null && (role.toUpperCase().equals("ADMIN") || role.toUpperCase().equals("LEADER"))) {
				chain.doFilter(req, resp);
			} else
				resp.sendRedirect(ct + "/403.jsp");
			break;
		default:
			System.out.println("ko tim thay link");
		}
	}	
}