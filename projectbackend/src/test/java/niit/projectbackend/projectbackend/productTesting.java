package niit.projectbackend.projectbackend;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.projectbackend.projectbackend.dao.CategoryDao;
import niit.projectbackend.projectbackend.dao.ProductDao;

public class productTesting {
	//we have to declare reference variables here to access it in any method
		AnnotationConfigApplicationContext context;
		ProductDao productDao;
		Product product;
		CategoryDao categoryDao;
		Category category;
		Category products;
		
	    @Before
	    public void init()
	    {
	    	//making object of AnnotationConfigApplicationContext
	    	context=new AnnotationConfigApplicationContext();
	    	//scanning the whole project for making bean objects
	    	context.scan("niit.projectbackend.projectbackend");
	    	//refresh the Spring Container 
	    	context.refresh();
	    	//getting the beans of productDao type
	    	productDao=(ProductDao) context.getBean("productDao");
	    	//Creating the object of POJO class or Transaction manager
	    	product=new Product();
	    	//getting the beans of productDao type
	    	categoryDao=(CategoryDao) context.getBean("categoryDao");
	    	//Creating the object of POJO class or Transaction manager
	    
	    }
	    @Test  
	    public void productAddTest()  
	     {  
	    	category=categoryDao.getCategory(2);
	    	product.setProductName("cream");
	    	product.setProductDesc("cream biss");
	    	product.setProductPrice(70.00);
	    	product.setCategory(category);
	    	Product pro=new Product();
	    	pro.setCategory(category);
	    	pro.setProductName("ebi");
	    	pro.setProductDesc("tech");
	    	pro.setProductPrice(20.00);
	    	productDao.addProduct(pro);
	    
	    	productDao.addProduct(product);
	    	List<Product> products=category.getProducts();
			products.add(product);
			products.add(pro);
	category.setProducts(products);
	categoryDao.updateCategory(category);
	    	
	    	
	    	
	    	
	     }
	    /*
	     @Test
	     public void productDeleteTest()
	     {
	    	 product.setProductId(3);
	    	 Assert.assertEquals("Data Deleted",true,productDao.deleteProduct(product));
	     }
	     
	     @Test  
	     public void productGetTest() {  
	    	 product = productDao.getProduct(1);  
	         
	         Assert.assertNotNull(product);
	         System.out.println(product.getProductName());
	         System.out.println(product.getProductDesc());
	         System.out.println(product.getProductPrice());
	         }
	     
	    @Test 
	    public void productUpdateTest()
	    {
	    	product=productDao.getProduct(2);
	    	product.setProductName("Sanchi");
	    	product.setProductDesc("Milk");
	    	Assert.assertEquals("Updated",true,productDao.updateProduct(product));
	    }
	   
	    @Test
	    public void productListTest()
	    {
	    	List<product> productList=productDao.getALLproduct();
	    	boolean bool=productList.hasNext();
	    	System.out.println(productList.size());
	    	//Assert.assertEquals("",true,productList.isEmpty());
	    	//Assert.assertThat(productList, not(IsEmptyList.empty()));
	    }*/

}
