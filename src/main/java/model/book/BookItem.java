package model.book;

public class BookItem extends Book{
	private double price;
	private int amountStock;

	public BookItem(int id, String name, String author, int year, String img, double price, int amountStock) {
		super(id, name, author, year, img);
		this.price = price;
		this.amountStock = amountStock;
	}

	public BookItem() {
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmountStock() {
		return amountStock;
	}

	public void setAmountStock(int amountStock) {
		this.amountStock = amountStock;
	}

}
