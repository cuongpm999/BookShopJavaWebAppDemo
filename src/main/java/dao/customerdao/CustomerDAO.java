package dao.customerdao;

import java.util.List;

import model.customer.Customer;

public interface CustomerDAO {
	public boolean insertCustomer(Customer customer);
	public Customer getCustomer(String username, String password);
	public List<Customer> findAll();
	public Customer findCustomerByUsername(String username);

}
