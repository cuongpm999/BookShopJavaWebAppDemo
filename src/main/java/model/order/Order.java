package model.order;

import java.util.List;

import model.customer.Customer;

public class Order {
	private int id;
	private Payment payment;
	private Customer customer;
	private Shipment shipment;
	private Cart cart;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int id, Payment payment, Customer customer, Shipment shipment, Cart cart) {
		super();
		this.id = id;
		this.payment = payment;
		this.customer = customer;
		this.shipment = shipment;
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
