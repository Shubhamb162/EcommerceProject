package niit.projectbackend.projectbackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import niit.projectbackend.projectbackend.Orders;
import niit.projectbackend.projectbackend.dao.OrdersDao;

@Repository("ordersDao")
@Transactional
public class OrdersDaoImpl implements OrdersDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean placeOrders(Orders orders) {
		try {
			sessionFactory.getCurrentSession().persist(orders);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean cancelOrders(Orders orders) {
		try {
			sessionFactory.getCurrentSession().delete(orders);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Orders getOrders(Integer id) {
		return sessionFactory.getCurrentSession().get(Orders.class, id);

	}

}
