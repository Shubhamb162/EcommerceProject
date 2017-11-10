package niit.projectbackend.projectbackend.dao;

import java.util.List;
import niit.projectbackend.projectbackend.Category;

public interface CategoryDao {

	public boolean addCategory(Category category);

	public boolean deleteCategory(Category category);

	public Category getCategory(Integer id);

	public boolean updateCategory(Category category);

	public List<Category> getAllCategory();
	// public List<Product> getAllProductOfCategory(S);

}
