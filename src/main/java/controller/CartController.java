package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.orderdao.ShipmentDAOImpl;
import model.order.Cart;
import model.order.Payment;
import model.order.Shipment;

@WebServlet(urlPatterns = "/cart")
public class CartController extends HttpServlet{
	private ShipmentDAOImpl shipmentDAOImpl;
	
	@Override
	public void init() {
		shipmentDAOImpl = new ShipmentDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listShipment", shipmentDAOImpl.findAll());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("cart.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String paymentType = req.getParameter("paymentType");
		int shipmentId = Integer.parseInt(req.getParameter("shipmentId"));
		Shipment shipment = shipmentDAOImpl.findById(shipmentId);
		
		HttpSession httpSession = req.getSession();
		
		Payment payment = new Payment();

		payment.setPaymentType(paymentType);
		payment.setAllMoney((double) httpSession.getAttribute("tongTien") + shipment.getPrice());
		
		httpSession.setAttribute("payment", payment);
		httpSession.setAttribute("shipment", shipment);
		resp.sendRedirect("/BookShop/checkout");
		
	}
}
