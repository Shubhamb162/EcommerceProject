package niit.projectbackend.projectbackend.dao;

import org.springframework.stereotype.Component;

import niit.projectbackend.projectbackend.CartItems;

@Component
public interface CartItemsDao {

	public boolean addCartItems(CartItems cartItems);

	public boolean deleteCartItems(CartItems cartItems);

	public boolean updateCartItems(CartItems cartItems);

	public CartItems getCartItems(Integer id);
}
