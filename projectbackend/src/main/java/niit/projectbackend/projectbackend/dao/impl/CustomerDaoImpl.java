package niit.projectbackend.projectbackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import niit.projectbackend.projectbackend.Customer;
import niit.projectbackend.projectbackend.dao.CustomerDao;

@Repository("customerDao")//for doing all database related operation we have to use @Repository annotation
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		try{
			sessionFactory.getCurrentSession().persist(customer);
			return true;			
		}
		catch(Exception ex)
		{		
			return false;
		}
		//return false; we can write here also but logically we have to write in Catch block
	}
	
	@Override
	public boolean deleteCustomer(Customer customer) {
			try{
			  sessionFactory.getCurrentSession().delete(customer);
				 return true;
			}
			catch(Exception ex)
			{
				return false;
			}
	}

	@Override
	public Customer getCustomer(Integer id) {
		return (Customer)sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getALLCustomer() {
	  return sessionFactory.getCurrentSession().createQuery("from Customer").getResultList(); 
	}
	
}
