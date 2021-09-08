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

import dao.bookdao.BookItemDAOImpl;
import model.book.BookItem;
import utils.CartUtils;

@WebServlet(urlPatterns = "/")
public class HomeController extends HttpServlet {

	private BookItemDAOImpl bookItemDAOImpl;

	@Override
	public void init() {
		bookItemDAOImpl = new BookItemDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {

		case "/":
			fillAll(req, resp);
			break;
		case "/search-name":
			String name = req.getParameter("key");
			findByName(req, resp, name);
			break;
		case "/buy":
			int id = Integer.parseInt(req.getParameter("id"));
			addBookToCart(req, resp, id);
			break;
			
		case "/book-detail":
			int idBook = Integer.parseInt(req.getParameter("id"));
			bookDetail(req, resp, idBook);
			break;
		}
		

	}

	private void fillAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BookItem> list = new ArrayList<>();
		list = bookItemDAOImpl.findAll();
		req.setAttribute("listBook", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(req, resp);

	}

	private void findByName(HttpServletRequest req, HttpServletResponse resp, String name)
			throws ServletException, IOException {
		List<BookItem> list = new ArrayList<>();
		list = bookItemDAOImpl.findByName(name);
		req.setAttribute("listBook", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(req, resp);

	}
	
	private void addBookToCart(HttpServletRequest req, HttpServletResponse resp, int id) throws IOException {
		BookItem bookItem = bookItemDAOImpl.findById(id);
		CartUtils.checkCart(bookItem, req);
		CartUtils.tongTien(req);
		resp.sendRedirect("/BookShop/");
	}
	
	private void bookDetail(HttpServletRequest req, HttpServletResponse resp, int id) throws IOException, ServletException {
		BookItem bookItem = bookItemDAOImpl.findById(id);
		req.setAttribute("product", bookItem);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("product_detail.jsp");
		requestDispatcher.forward(req, resp);
	}

}
