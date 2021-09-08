package dao.orderdao;

import java.util.List;

import model.order.Shipment;

public interface ShipmentDAO {
	public List<Shipment> findAll();
	public Shipment findById(int id);

}
