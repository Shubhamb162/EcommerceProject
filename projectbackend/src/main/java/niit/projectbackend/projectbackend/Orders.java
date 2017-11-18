package niit.projectbackend.projectbackend;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ordersId;

	private Integer ordersQuantity;
	
	private Double ordersTotalPrice;

	@ManyToOne
	private Customer customer;

	@OneToMany(mappedBy = "orders")
	private List<OrderedItems> orderedItems;

	public Integer getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	public Integer getOrdersQuantity() {
		return ordersQuantity;
	}

	public void setOrdersQuantity(Integer ordersQuantity) {
		this.ordersQuantity = ordersQuantity;
	}

	public Double getOrdersTotalPrice() {
		return ordersTotalPrice;
	}

	public void setOrdersTotalPrice(Double ordersTotalPrice) {
		this.ordersTotalPrice = ordersTotalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderedItems> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<OrderedItems> orderedItems) {
		this.orderedItems = orderedItems;
	}

}
