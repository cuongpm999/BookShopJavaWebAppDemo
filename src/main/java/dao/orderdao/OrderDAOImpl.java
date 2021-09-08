package dao.orderdao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Iterator;

import dao.DAO;
import model.order.BoughtBookItem;
import model.order.Cart;
import model.order.Order;

public class OrderDAOImpl extends DAO implements OrderDAO{
	public OrderDAOImpl() {
		super();
	}

	@Override
	public boolean insertOrder(Order order) {
		boolean isSuccess=true;
		String sqlOrder = "INSERT INTO bookshop.order (customerId,paymentId,cartId,shipmentId) VALUES (?,?,?,?)";
		String sqlPayment = "INSERT INTO payment (paymentType,allMoney) VALUES (?,?)";
		String sqlCart = "INSERT INTO cart (dateCreate) VALUES (?)";
		String sqlBoughtBook = "INSERT INTO boughtbookitem (amount,cartId,bookItemId) VALUES (?,?,?)";
		String sqlBookItem = "UPDATE bookitem SET amountStock=? WHERE bookId=?";
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement ps = connection.prepareStatement(sqlPayment, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, order.getPayment().getPaymentType());
			ps.setDouble(2, order.getPayment().getAllMoney());
			ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			if(keys.next()) {
				order.getPayment().setId(keys.getInt(1));
			}
			
			ps = connection.prepareStatement(sqlCart, Statement.RETURN_GENERATED_KEYS);
			Timestamp date = new Timestamp(order.getCart().getDateCreate().getTime());
			ps.setTimestamp(1, date);
			ps.executeUpdate();
			keys = ps.getGeneratedKeys();
			if(keys.next()) {
				order.getCart().setId(keys.getInt(1));
			}
			
			for (BoughtBookItem boughtBookItem : order.getCart().getBoughtBookItems()) {
				ps = connection.prepareStatement(sqlBoughtBook, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, boughtBookItem.getAmount());
				ps.setInt(2, keys.getInt(1));
				ps.setInt(3, boughtBookItem.getBookItem().getId());
				ps.executeUpdate();
				
				ps=connection.prepareStatement(sqlBookItem);
				ps.setInt(1, boughtBookItem.getBookItem().getAmountStock() - boughtBookItem.getAmount());
				ps.setInt(2, boughtBookItem.getBookItem().getId());
				ps.executeUpdate();
			}
			
			ps = connection.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getCustomer().getId());
			ps.setInt(2, order.getPayment().getId());
			ps.setInt(3, order.getCart().getId());
			ps.setInt(4, order.getShipment().getId());
			ps.executeUpdate();
			

		} catch (SQLException e) {
			isSuccess=false;
			try {
				connection.rollback();
				isSuccess=false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				isSuccess=false;
				e.printStackTrace();
			}
		}
		return isSuccess;
	}

}
