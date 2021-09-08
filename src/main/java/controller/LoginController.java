package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.customerdao.CustomerDAOImpl;
import model.customer.Customer;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
	private CustomerDAOImpl customerDAOImpl;
	
	@Override
	public void init() {
		customerDAOImpl = new CustomerDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Customer customer = customerDAOImpl.getCustomer(username, password);
		
		if(customer==null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			req.setAttribute("status", "logFaile");
			requestDispatcher.forward(req, resp);
		}
		else {
			Cookie cookie = new Cookie("username", customer.getAccount().getUsername());
			cookie.setMaxAge(-1);
			resp.addCookie(cookie);

			resp.sendRedirect("/BookShop/cart");
		}
	}
}
