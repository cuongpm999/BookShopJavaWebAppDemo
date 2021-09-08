package dao.orderdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.order.Shipment;

public class ShipmentDAOImpl extends DAO implements ShipmentDAO{
	public ShipmentDAOImpl() {
		super();
	}

	@Override
	public List<Shipment> findAll() {
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
		}

		return list;
	}

	@Override
	public Shipment findById(int id) {
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
		}

		return shipment;
	}

}
