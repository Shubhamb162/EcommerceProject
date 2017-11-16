package niit.projectbackend.projectbackend.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import niit.projectbackend.projectbackend.Customer;

@Component
public interface CustomerDao {

	public boolean addCustomer(Customer customer);

	public boolean deleteCustomer(Customer customer);

	public Customer getCustomer(Integer id);

	public boolean updateCustomer(Customer customer);

	public List<Customer> getALLCustomer();

	public Customer getCustomer(String emailId);

}
