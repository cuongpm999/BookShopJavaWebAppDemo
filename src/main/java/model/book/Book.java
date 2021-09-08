package model.book;

public class Book {
	private int id;
	private String name;
	private String author;
	private int year;
	private String img;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, String author, int year, String img) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.year = year;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
