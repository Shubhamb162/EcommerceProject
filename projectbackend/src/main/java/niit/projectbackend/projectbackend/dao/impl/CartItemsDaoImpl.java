package niit.projectbackend.projectbackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.projectbackend.projectbackend.CartItems;
import niit.projectbackend.projectbackend.Customer;
import niit.projectbackend.projectbackend.dao.CartItemsDao;

@Repository("cartItemsDao")
@Transactional

public class CartItemsDaoImpl implements CartItemsDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCartItems(CartItems cartItems) {
		try {
			sessionFactory.getCurrentSession().save(cartItems);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItems(CartItems cartItems) {
		try {
			sessionFactory.getCurrentSession().delete(cartItems);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateCartItems(CartItems cartItems) {
		try {
			sessionFactory.getCurrentSession().update(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CartItems getCartItems(Integer id) {
		return (CartItems) sessionFactory.getCurrentSession().get(CartItems.class, id);

	}

	@Override
	public CartItems getCartItems(Integer cartId, Integer productId) {
		try{
		return (CartItems) sessionFactory.getCurrentSession()
				.createQuery("from CartItems where cart_cartid=:cartId and product_productid=:productId")
				.setParameter("cartId", cartId).setParameter("productId", productId).getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
		

	}

}
