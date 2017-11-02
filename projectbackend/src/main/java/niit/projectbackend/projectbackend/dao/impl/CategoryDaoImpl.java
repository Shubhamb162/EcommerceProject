package niit.projectbackend.projectbackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.projectbackend.projectbackend.Category;
import niit.projectbackend.projectbackend.dao.CategoryDao;;

@Repository("categoryDao") // for doing all database related operation we have
							// to use @Repository annotation
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Category getCategory(Integer id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategory() {
		 return sessionFactory.getCurrentSession().createQuery("from Category").getResultList();
	}

}
