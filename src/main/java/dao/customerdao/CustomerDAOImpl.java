package dao.customerdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;

public class CustomerDAOImpl extends DAO implements CustomerDAO{
	public CustomerDAOImpl() {
		super();
	}

	@Override
	public boolean insertCustomer(Customer customer) {
		boolean isSuccess=true;
		String sqlCustomer = "INSERT INTO customer (fullName,mobile,addressId,accountId) VALUES (?,?,?,?)";
		String sqlAccount = "INSERT INTO account (username,password,role) VALUES (?,?,?)";
		String sqlAddress = "INSERT INTO address (city) VALUES (?)";
		try {
			connection.setAutoCommit(false);
			PreparedStatement ps = connection.prepareStatement(sqlAccount, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getAccount().getUsername());
			ps.setString(2, customer.getAccount().getPassword());
			ps.setString(3, customer.getAccount().getRole());
			ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			if(keys.next()) {
				customer.getAccount().setId(keys.getInt(1));
			}
			
			ps = connection.prepareStatement(sqlAddress, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getAddress().getCity());
			ps.executeUpdate();
			keys = ps.getGeneratedKeys();
			if(keys.next()) {
				customer.getAddress().setId(keys.getInt(1));
			}
			
			ps = connection.prepareStatement(sqlCustomer, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getFullName());
			ps.setString(2, customer.getMobile());
			ps.setInt(3, customer.getAddress().getId());
			ps.setInt(4, customer.getAccount().getId());
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

	@Override
	public Customer getCustomer(String username, String password) {
		Customer customer = null;
		String sql = "SELECT customer.*,address.*,account.* FROM customer,address,account WHERE addressId=address.id AND accountId=account.id AND username=? AND password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Address address = new Address();
				address.setCity(rs.getString("city"));
				address.setId(rs.getInt("address.id"));
				
				Account account = new Account();
				account.setId(rs.getInt("account.id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setRole(rs.getString("role"));
				
				customer = new Customer();
				customer.setId(rs.getInt("customer.id"));
				customer.setFullName(rs.getString("fullName"));
				customer.setMobile(rs.getString("mobile"));
				customer.setAccount(account);
				customer.setAddress(address);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;

	}

	@Override
	public List<Customer> findAll() {
		List<Customer> list = new ArrayList<>();
		String sql = "SELECT customer.*,address.*,account.* FROM customer,address,account WHERE addressId=address.id AND accountId=account.id";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Address address = new Address();
				address.setCity(rs.getString("city"));
				address.setId(rs.getInt("address.id"));
				
				Account account = new Account();
				account.setId(rs.getInt("account.id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setRole(rs.getString("role"));
				
				Customer customer = new Customer();
				customer.setId(rs.getInt("customer.id"));
				customer.setFullName(rs.getString("fullName"));
				customer.setMobile(rs.getString("mobile"));
				customer.setAccount(account);
				customer.setAddress(address);
				
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Customer findCustomerByUsername(String username) {
		Customer customer = new Customer();
		String sql = "SELECT customer.*,address.*,account.* FROM customer,address,account WHERE addressId=address.id AND accountId=account.id AND username=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Address address = new Address();
				address.setCity(rs.getString("city"));
				address.setId(rs.getInt("address.id"));
				
				Account account = new Account();
				account.setId(rs.getInt("account.id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setRole(rs.getString("role"));
				
				customer.setId(rs.getInt("customer.id"));
				customer.setFullName(rs.getString("fullName"));
				customer.setMobile(rs.getString("mobile"));
				customer.setAccount(account);
				customer.setAddress(address);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

}
