package dao.orderdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionPool;
import model.order.Shipment;

public class ShipmentDAOImpl implements ShipmentDAO{
	public ShipmentDAOImpl() {
		super();
	}

	@Override
	public List<Shipment> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		List<Shipment> list = new ArrayList<>();
		String sql = "SELECT * FROM shipment";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Shipment(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getDouble("price")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connection);
		}

		return list;
	}

	@Override
	public Shipment findById(int id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		Shipment shipment = null;
		String sql = "SELECT * FROM shipment WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				shipment = new Shipment(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getDouble("price"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connection);
		}

		return shipment;
	}

}
