package model.order;

import java.util.Date;
import java.util.List;

import model.book.BookItem;

public class Cart {
	private int id;
	private Date dateCreate;
	private List<BoughtBookItem> boughtBookItems;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, Date dateCreate, List<BoughtBookItem> boughtBookItems) {
		super();
		this.id = id;
		this.dateCreate = dateCreate;
		this.boughtBookItems = boughtBookItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public List<BoughtBookItem> getBoughtBookItems() {
		return boughtBookItems;
	}

	public void setBoughtBookItems(List<BoughtBookItem> boughtBookItems) {
		this.boughtBookItems = boughtBookItems;
	}

}
