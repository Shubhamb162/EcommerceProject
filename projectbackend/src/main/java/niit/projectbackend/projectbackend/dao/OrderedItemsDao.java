package niit.projectbackend.projectbackend.dao;

import org.springframework.stereotype.Component;
import niit.projectbackend.projectbackend.OrderedItems;

@Component
public interface OrderedItemsDao {

	public boolean addOrderedItems(OrderedItems orderedItems);

	public boolean deleteOrderedItems(OrderedItems orderedItems);

	public OrderedItems getOrderedItems(Integer id);

}
