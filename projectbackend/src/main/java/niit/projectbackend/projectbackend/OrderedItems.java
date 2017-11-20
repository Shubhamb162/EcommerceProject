package niit.projectbackend.projectbackend;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderedItemsId;

	private Double orderedItemsTotalPrice;

	private Integer orderedItemsQuantity;
	
	private Double orderedItemsUnitPrice;

	@ManyToOne
	private Orders orders;

	@OneToOne(fetch = FetchType.EAGER)
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getOrderedItemsId() {
		return orderedItemsId;
	}

	public void setOrderedItemsId(Integer orderedItemsId) {
		this.orderedItemsId = orderedItemsId;
	}

	public Double getOrderedItemsTotalPrice() {
		return orderedItemsTotalPrice;
	}

	public void setOrderedItemsTotalPrice(Double orderedItemsTotalPrice) {
		this.orderedItemsTotalPrice = orderedItemsTotalPrice;
	}

	public Integer getOrderedItemsQuantity() {
		return orderedItemsQuantity;
	}

	public void setOrderedItemsQuantity(Integer orderedItemsQuantity) {
		this.orderedItemsQuantity = orderedItemsQuantity;
	}

	public Double getOrderedItemsUnitPrice() {
		return orderedItemsUnitPrice;
	}

	public void setOrderedItemsUnitPrice(Double orderedItemsUnitPrice) {
		this.orderedItemsUnitPrice = orderedItemsUnitPrice;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
