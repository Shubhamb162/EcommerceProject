package niit.projectbackend.projectbackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import niit.projectbackend.projectbackend.Product;
import niit.projectbackend.projectbackend.dao.ProductDao;

@Repository("productDao") // for doing all database related operation we have to
							// use @Repository annotation
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Product getProduct(Integer id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		return sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
	}

	@Override
	public List<Product> getAllProductByCat(Integer id) {
		try{
		 return sessionFactory.getCurrentSession().createQuery("from Product where category_categoryid=:id", Product.class).setParameter("id", id).getResultList();
		}
		catch (Exception e) {
			return null;
		}
		
	}

}
