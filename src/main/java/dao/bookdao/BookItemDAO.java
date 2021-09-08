package dao.bookdao;

import java.util.List;

import model.book.BookItem;

public interface BookItemDAO {
	public List<BookItem> findByName(String name);
	public List<BookItem> findAll();
	public BookItem findById(int id);
}
