package utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.book.BookItem;
import model.order.BoughtBookItem;
import model.order.Cart;
import model.order.Payment;

public class CartUtils {

	public static void checkCart(BookItem product, HttpServletRequest request) {
		int productId = product.getId();

		List<BoughtBookItem> boughtBooks = new ArrayList<>();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("giohang") != null) {
			boughtBooks = ((Cart) httpSession.getAttribute("giohang")).getBoughtBookItems();
		}

		boolean isExists = false;
		for (BoughtBookItem boughtBook : boughtBooks) {
			if (boughtBook.getBookItem().getId() == productId) {
				isExists = true;
				break;
			}
		}

		if (!isExists) {
			BoughtBookItem boughtBook = new BoughtBookItem();
			boughtBook.setBookItem(product);
			boughtBook.setAmount(1);
			boughtBooks.add(boughtBook);
		} else {
			for (BoughtBookItem boughtBook : boughtBooks) {
				if (boughtBook.getBookItem().getId() == productId) {
					boughtBook.setAmount(boughtBook.getAmount() + 1);
					break;
				}
			}
		}

		int soLuongMua = 0;
		for (BoughtBookItem boughtBook : boughtBooks) {
			soLuongMua += boughtBook.getAmount();
		}
		Cart cart = new Cart();
		cart.setDateCreate(new Date());
		cart.setBoughtBookItems(boughtBooks);

		httpSession.setAttribute("status", null);
		httpSession.setAttribute("giohang", cart);
		httpSession.setAttribute("soLuongMua", soLuongMua);

	}

	public static void tongTien(HttpServletRequest request) {
		List<BoughtBookItem> boughtBooks = new ArrayList<>();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("giohang") != null) {
			boughtBooks = ((Cart) httpSession.getAttribute("giohang")).getBoughtBookItems();
		}
		double t = 0;
		for (int i = 0; i < boughtBooks.size(); i++) {
			t += boughtBooks.get(i).getAmount() * boughtBooks.get(i).getBookItem().getPrice();
		}

		httpSession.setAttribute("tongTien", t);
	}

}
