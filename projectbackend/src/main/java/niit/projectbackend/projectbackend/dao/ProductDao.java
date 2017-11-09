package niit.projectbackend.projectbackend.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import niit.projectbackend.projectbackend.Product;

@Component
public interface ProductDao {

	public boolean addProduct(Product product);

	public boolean deleteProduct(Product product);

	public Product getProduct(Integer id);

	public boolean updateProduct(Product product);

	public List<Product> getAllProduct();
	
	public List<Product> getAllProductByCat(Integer id);
}
