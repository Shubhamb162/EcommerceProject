package niit.projectbackend.projectbackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import niit.projectbackend.projectbackend.OrderedItems;
import niit.projectbackend.projectbackend.dao.OrderedItemsDao;

@Repository("orderedItemsDao")
@Transactional
public class OrderedItemsDaoImpl implements OrderedItemsDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addOrderedItems(OrderedItems orderedItems) {
		try {
			sessionFactory.getCurrentSession().save(orderedItems);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	@Override
	public boolean deleteOrderedItems(OrderedItems orderedItems) {
		try {
			sessionFactory.getCurrentSession().delete(orderedItems);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	
	@Override
	public OrderedItems getOrderedItems(Integer id) {
		return (OrderedItems) sessionFactory.getCurrentSession().get(OrderedItems.class, id);

	}

	

	
}
