package model.order;

import java.util.List;

public class Payment {
	private int id;
	private String paymentType;
	private double allMoney;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int id, String paymentType, double allMoney) {
		super();
		this.id = id;
		this.paymentType = paymentType;
		this.allMoney = allMoney;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(double allMoney) {
		this.allMoney = allMoney;
	}

}
