package niit.projectfrontend.projectfrontend;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import niit.projectbackend.projectbackend.Cart;
import niit.projectbackend.projectbackend.CartItems;
import niit.projectbackend.projectbackend.Customer;
import niit.projectbackend.projectbackend.OrderedItems;
import niit.projectbackend.projectbackend.Orders;
import niit.projectbackend.projectbackend.Product;
import niit.projectbackend.projectbackend.dao.CartDao;
import niit.projectbackend.projectbackend.dao.CartItemsDao;
import niit.projectbackend.projectbackend.dao.CustomerDao;
import niit.projectbackend.projectbackend.dao.OrderedItemsDao;
import niit.projectbackend.projectbackend.dao.OrdersDao;
import niit.projectbackend.projectbackend.dao.ProductDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	OrderedItemsDao orderedItemsDao;

	@RequestMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable("productId") Integer proId, Principal principal, Model m) {

		Product product = productDao.getProduct(proId); // getting product

		Customer customer = customerDao.getCustomer(principal.getName()); // getting
																			// customer

		Cart cart = customer.getCart(); // getting cart

		CartItems cartItems;
		cartItems = cartItemsDao.getCartItems(cart.getCartId(), product.getProductId());// getting
																						// existing
																						// cart
																						// //
																						// items

		System.out.println("CartId=" + cart.getCartId());
		System.out.println("Product Id=" + product.getProductId());
		// System.out.println("CartItems Id="+cartItems.getCartItemsId());

		if (cartItems == null)
			cartItems = new CartItems(); // creating new cartItems

		System.out.println("CartId=" + cart.getCartId());
		System.out.println("Product Id=" + product.getProductId());
		System.out.println("CartItems Id=" + cartItems.getCartItemsId());

		cartItems.setProduct(product); // setting product

		if (cartItems.getCartItemsQuantity() == null) { // setting quantity
			cartItems.setCartItemsQuantity(1);
		} else {
			cartItems.setCartItemsQuantity(cartItems.getCartItemsQuantity() + 1);
		}
		if (cartItems.getCartItemsPrice() == null) {// setting product price
			cartItems.setCartItemsPrice(product.getProductPrice());
		} else {
			cartItems.setCartItemsPrice(cartItems.getCartItemsQuantity() * product.getProductPrice());
		}

		cartItems.setCart(cart); // setting cart

		ArrayList<CartItems> items = new ArrayList<CartItems>();
		items.add(cartItems);
		cart.setCartItems(items);

		if (cart.getCartQuantity() == null) {
			cart.setCartQuantity(1);
		} else {
			cart.setCartQuantity(cart.getCartQuantity() + 1);
		}
		if (cart.getCartTotalPrice() == null) {
			cart.setCartTotalPrice(product.getProductPrice());
		} else {
			cart.setCartTotalPrice(cart.getCartTotalPrice() + product.getProductPrice());
		}

		if (cartItems.getCartItemsId() == null) {
			cartItemsDao.addCartItems(cartItems);
		} else {
			cartItemsDao.updateCartItems(cartItems);
		}
		cartDao.updateCart(cart);
		System.out.println("CartId=" + cart.getCartId());
		System.out.println("Product Id=" + product.getProductId());
		System.out.println("CartItems Id=" + cartItems.getCartItemsId());

		return "redirect:/";

		/*
		 * Product product=productDao.getProduct(proId);
		 * 
		 * Customer customer = customerDao.getCustomer(principal.getName());
		 * 
		 * Cart cart = customer.getCart();
		 * getCartItems(cart.getCartId(),product.getProductId()); CartItems
		 * cartItems=new CartItems(); cartItems.setProduct(product);
		 * 
		 * cartItems.setCartItemsQuantity(1);
		 * 
		 * cartItems.setCartItemsPrice(product.getProductPrice());
		 * cartItems.setCart(cart); ArrayList<CartItems> items=new
		 * ArrayList<CartItems>(); items.add(cartItems);
		 * cart.setCartItems(items); if(cart.getCartQuantity()==null) {
		 * cart.setCartQuantity(1); }else {
		 * cart.setCartQuantity(cart.getCartQuantity()+1); }
		 * if(cart.getCartTotalPrice()==null) {
		 * cart.setCartTotalPrice(product.getProductPrice()); }else {
		 * cart.setCartTotalPrice(cart.getCartTotalPrice()+product.
		 * getProductPrice()); }
		 * 
		 * cartItemsDao.addCartItems(cartItems); cartDao.updateCart(cart);
		 * return "redirect:/";
		 */
	}

	@RequestMapping("/myCart")
	public String myCart(Principal principal, Model m) {
		Customer customer = customerDao.getCustomer(principal.getName()); // getting
																			// customer
		// System.out.println(customer.getFirstName());
		m.addAttribute("customer", customer);
		Cart cart = customer.getCart(); // getting cart
		// System.out.println("my cart");
		m.addAttribute("cart", cart);
		List<CartItems> cartItems = cart.getCartItems();
		m.addAttribute("cartItems", cartItems);
		return "myCart";
	}

	@RequestMapping("/cartItemsEdit/{cartItemsId}")
	public String cartItemsEdit(@PathVariable("cartItemsId") Integer cartItemsId,
			@RequestParam("quantity") Integer quantity, Model m) {
		System.err.println(cartItemsId);

		CartItems cartItems = cartItemsDao.getCartItems(cartItemsId);

		Cart cart = cartItems.getCart();
		cart.setCartQuantity(cart.getCartQuantity() + quantity - cartItems.getCartItemsQuantity());
		cartItems.setCartItemsQuantity(quantity);

		cart.setCartTotalPrice(cart.getCartTotalPrice() - cartItems.getCartItemsPrice()
				+ (cartItems.getProduct().getProductPrice() * quantity));
		cartItems.setCartItemsPrice(quantity * cartItems.getProduct().getProductPrice());
		cartItemsDao.updateCartItems(cartItems);
		cartDao.updateCart(cart);

		return "redirect:/customer/myCart";
	}

	@RequestMapping("/cartItemsDelete/{cartItemsId}")
	public String cartItemsDelete(@PathVariable("cartItemsId") Integer cartItemsId, Model m) {

		CartItems cartItems = cartItemsDao.getCartItems(cartItemsId);

		Cart cart = cartItems.getCart();

		cart.setCartQuantity(cart.getCartQuantity() - cartItems.getCartItemsQuantity());

		cart.setCartTotalPrice(cart.getCartTotalPrice() - cartItems.getCartItemsPrice());

		cartDao.updateCart(cart);
		cartItemsDao.deleteCartItems(cartItems);
		// cartItemsDao.updateCartItems(cartItems);

		return "redirect:/customer/myCart";
	}

	@RequestMapping("/checkout/{cartId}")
	public String checkout(@PathVariable("cartId") Integer cartId, Principal principal, Model m) {

		Customer customer = customerDao.getCustomer(principal.getName()); // getting
																			// customer
		m.addAttribute("customer", customer);
		Cart cart = customer.getCart(); // getting carts
		m.addAttribute("cart", cart);
		List<CartItems> cartItems = cart.getCartItems();
		m.addAttribute("cartItems", cartItems);
		/*
		 * Cart cart=cartDao.getCart(cartId); Orders orders=new Orders();
		 * cart.get
		 */

		return "checkout";
	}

	@RequestMapping("/order")
	public String order(Principal principal, Model m) {
		Customer customer = customerDao.getCustomer(principal.getName()); // getting_customer

		Cart cart = customer.getCart(); // getting_cart

		Orders orders = new Orders(); // Creating_orders_object

		orders.setCustomer(customer); // setting_customer_to_orders

		List<CartItems> cartItems = cart.getCartItems(); // getting_list_of_cartItems

		List<OrderedItems> orderedItemsList = new ArrayList(); // creating_orderedItemsList

		cart.setCartQuantity(null);
		cart.setCartTotalPrice(null);
		cartDao.updateCart(cart); // updating_cart

		for (CartItems items : cartItems) {
			OrderedItems orderedItems = new OrderedItems(); // creating_orderedItems

			orderedItems.setProduct(items.getProduct()); // setting_Product
			orderedItems.setOrderedItemsQuantity(items.getCartItemsQuantity());// setting_OrderedItemsQuantity
			orderedItems.setOrderedItemsTotalPrice(items.getCartItemsPrice());// setting_OrderedItemsTotalPrice
			orderedItems.setOrderedItemsUnitPrice(items.getProduct().getProductPrice());// setting_OrderedItemsUnitPrice
			orderedItems.setOrders(orders); // setting_orders
			if (orders.getOrdersQuantity() == null) {
				orders.setOrdersQuantity(0);
			}
			orders.setOrdersQuantity(orders.getOrdersQuantity() + orderedItems.getOrderedItemsQuantity());// setting_Quantity
			if (orders.getOrdersTotalPrice() == null) {
				orders.setOrdersTotalPrice(0.0);
			}
			orders.setOrdersTotalPrice(orders.getOrdersTotalPrice() + orderedItems.getOrderedItemsTotalPrice());// setting_TotalPrice
			orderedItemsList.add(orderedItems);
			cartItemsDao.deleteCartItems(items);
		}
		orders.setOrderedItems(orderedItemsList); // setting_orderedItemsList_to_Orders
		ordersDao.placeOrders(orders); // setting_orders_to_orders_table
		
		for (OrderedItems orderedItems : orderedItemsList) {
			orderedItemsDao.addOrderedItems(orderedItems);
		}
		m.addAttribute("orders",orders);
		return "order";
	}
}
