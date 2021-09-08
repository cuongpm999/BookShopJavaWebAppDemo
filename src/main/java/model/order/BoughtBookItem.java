package model.order;

import model.book.BookItem;

public class BoughtBookItem {
	private int id;
	private int amount;
	private BookItem bookItem;
	
	public BoughtBookItem() {

	}

	public BoughtBookItem(int id, int amount, BookItem bookItem) {
		super();
		this.id = id;
		this.amount = amount;
		this.bookItem = bookItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BookItem getBookItem() {
		return bookItem;
	}

	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}

}
