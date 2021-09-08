package dao.bookdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.book.Book;
import model.book.BookItem;

public class BookItemDAOImpl extends DAO implements BookItemDAO {

	public BookItemDAOImpl() {
		super();
	}

	@Override
	public List<BookItem> findByName(String name) {
		List<BookItem> list = new ArrayList<>();
		String sql = "SELECT book.*,bookitem.* FROM book,bookitem WHERE book.name LIKE ? AND book.id = bookitem.bookId";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BookItem bookItem = new BookItem(rs.getInt("book.id"), rs.getString("name"), rs.getString("author"),
						rs.getInt("year"), rs.getString("img"), rs.getDouble("price"), rs.getInt("amountStock"));
				list.add(bookItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookItem> findAll() {
		List<BookItem> list = new ArrayList<>();
		String sql = "SELECT book.*,bookitem.* FROM book,bookitem WHERE book.id = bookitem.bookId";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BookItem bookItem = new BookItem(rs.getInt("book.id"), rs.getString("name"), rs.getString("author"),
						rs.getInt("year"), rs.getString("img"), rs.getDouble("price"), rs.getInt("amountStock"));
				list.add(bookItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BookItem findById(int id) {
		BookItem bookItem = null;
		String sql = "SELECT book.*,bookitem.* FROM book,bookitem WHERE book.id=? AND book.id = bookitem.bookId";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bookItem = new BookItem(rs.getInt("book.id"), rs.getString("name"), rs.getString("author"),
						rs.getInt("year"), rs.getString("img"), rs.getDouble("price"), rs.getInt("amountStock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookItem;
	}

}
