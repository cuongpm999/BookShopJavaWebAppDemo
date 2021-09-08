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
import model.order.Cart;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;

@WebServlet(urlPatterns = "/finish")
public class CheckoutFinishController extends HttpServlet{
	private CustomerDAOImpl customerDAOImpl;
	private OrderDAOImpl orderDAOImpl;
	
	@Override
	public void init() {
		customerDAOImpl = new CustomerDAOImpl();
		orderDAOImpl = new OrderDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		finish(req, resp);
	}
	
	private void finish(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession httpSession = req.getSession();
		Payment payment = new Payment();
		Shipment shipment = new Shipment();
		Cart cart = new Cart();
		
		String username = httpSession.getAttribute("username").toString();
		if(httpSession.getAttribute("payment")!=null) {
			payment =  (Payment) httpSession.getAttribute("payment");
		}
		if(httpSession.getAttribute("shipment")!=null) {
			shipment =  (Shipment) httpSession.getAttribute("shipment");
		}
		
		if(httpSession.getAttribute("giohang")!=null) {
			cart =  (Cart) httpSession.getAttribute("giohang");
		}
		
		Customer customer = customerDAOImpl.findCustomerByUsername(username);
		Order order = new Order();
		order.setPayment(payment);
		order.setCustomer(customer);
		order.setCart(cart);
		order.setShipment(shipment);
		
		boolean check = orderDAOImpl.insertOrder(order);
		if(check) {
			httpSession.setAttribute("payment", null);
			httpSession.setAttribute("giohang", null);
			httpSession.setAttribute("soLuongMua", null);
			httpSession.setAttribute("shipment", null);
			httpSession.setAttribute("tongTien", null);
		
			resp.sendRedirect("/BookShop/");
		}
		else {
			req.setAttribute("status", "faile");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("checkout.jsp");
			requestDispatcher.forward(req, resp);
		}
		
	}


}
