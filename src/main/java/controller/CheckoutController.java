package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.customerdao.CustomerDAOImpl;
import dao.orderdao.OrderDAOImpl;
import model.customer.Customer;
import model.order.Order;
import model.order.Payment;
import utils.CartUtils;

@WebServlet(urlPatterns = "/checkout")
public class CheckoutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("checkout.jsp");
		requestDispatcher.forward(req, resp);
		
	}

}
