package niit.projectbackend.projectbackend.dao;

import org.springframework.stereotype.Component;
import niit.projectbackend.projectbackend.Orders;

@Component
public interface OrdersDao {
	
	public boolean placeOrders(Orders orders);

	public boolean cancelOrders(Orders orders);

	public Orders getOrders(Integer id);

}
