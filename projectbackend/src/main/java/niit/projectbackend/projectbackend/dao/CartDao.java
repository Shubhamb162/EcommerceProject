package niit.projectbackend.projectbackend.dao;

import org.springframework.stereotype.Component;

import niit.projectbackend.projectbackend.Cart;

@Component
public interface CartDao {
	public boolean addCart(Cart cart);

	public boolean deleteCart(Cart cart);

	public boolean updateCart(Cart cart);

	public Cart getCart(Integer id);

}
