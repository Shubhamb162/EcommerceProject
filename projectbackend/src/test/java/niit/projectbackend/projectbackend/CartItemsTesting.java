package niit.projectbackend.projectbackend;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.projectbackend.projectbackend.dao.CartDao;
import niit.projectbackend.projectbackend.dao.CartItemsDao;
import niit.projectbackend.projectbackend.dao.ProductDao;

public class CartItemsTesting {
	AnnotationConfigApplicationContext context;
	CartItemsDao cartItemsDao;
	CartDao cartDao;
	ProductDao productDao;
	CartItems cartItems;
	Cart cart;
	Product product;

	@Before
	public void init() {
		// making object of AnnotationConfigApplicationContext
		context = new AnnotationConfigApplicationContext();
		// scanning the whole project for making bean objects
		context.scan("niit.projectbackend.projectbackend");
		// refresh the Spring Container
		context.refresh();
		// getting the beans of customerDao type
		cartItemsDao = (CartItemsDao) context.getBean("cartItemsDao");
		cartDao = (CartDao) context.getBean("cartDao");
		productDao = (ProductDao) context.getBean("productDao");
	}

	@Test
	public void addCartItemsTest() {
		product = productDao.getProduct(1);

		cartItems = new CartItems();
		
		cartItems.setProduct(product);
		
		cartItems.setCartItemsQuantity(2);
		
		cartItems.setCartItemsPrice(product.getProductPrice()*cartItems.getCartItemsQuantity());
		
		cart=cartDao.getCart(1);
		System.out.println(cart);
		cartItems.setCart(cart);
		
		ArrayList<CartItems> cartItemsList=new ArrayList<CartItems>();
		cartItemsList.add(cartItems);
		
		cart.setCartItems(cartItemsList);
		
		cart.setCartQuantity(cart.getCartQuantity()+cartItems.getCartItemsQuantity());
		cart.setCartTotalPrice(cart.getCartTotalPrice()+cartItems.getCartItemsPrice());
		Assert.assertEquals("CartItems Added",true,cartItemsDao.addCartItems(cartItems));
		Assert.assertEquals("Cart Added",true,cartDao.updateCart(cart));
		
		
		
		
		
		
		
		

	}
}
