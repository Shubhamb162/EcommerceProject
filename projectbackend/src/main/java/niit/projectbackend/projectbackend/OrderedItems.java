package niit.projectbackend.projectbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderedItemsId;
	private Double orderedItemsTotalPrice;
	private Integer orderedItemsQuantity;
	private Integer orderedItemsUnitPrice;
	@ManyToOne
	private Orders orders;

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

	public Integer getOrderedItemsUnitPrice() {
		return orderedItemsUnitPrice;
	}

	public void setOrderedItemsUnitPrice(Integer orderedItemsUnitPrice) {
		this.orderedItemsUnitPrice = orderedItemsUnitPrice;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
