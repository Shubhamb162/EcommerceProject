package niit.projectbackend.projectbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

@Entity
public class CartItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartItemsId;
	private Double cartItemsPrice;
	private Integer cartItemsQuantity;
	@ManyToOne
	private Cart cart;
	@OneToOne
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setCartItemsId(Integer cartItemsId) {
		this.cartItemsId = cartItemsId;
	}

	public Integer getCartItemsId() {
		return cartItemsId;
	}

	public void setCartItems(Integer cartItemsId) {
		this.cartItemsId = cartItemsId;
	}

	public Double getCartItemsPrice() {
		return cartItemsPrice;
	}

	public void setCartItemsPrice(Double cartItemsPrice) {
		this.cartItemsPrice = cartItemsPrice;
	}

	public Integer getCartItemsQuantity() {
		return cartItemsQuantity;
	}

	public void setCartItemsQuantity(Integer cartItemsQuantity) {
		this.cartItemsQuantity = cartItemsQuantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
