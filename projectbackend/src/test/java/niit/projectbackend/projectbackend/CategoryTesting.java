package niit.projectbackend.projectbackend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import niit.projectbackend.projectbackend.dao.CategoryDao;

public class CategoryTesting {
	//we have to declare reference variables here to access it in any method
			AnnotationConfigApplicationContext context;
			CategoryDao categoryDao;
			Category category;
		 
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
		    	categoryDao=(CategoryDao) context.getBean("categoryDao");
		    	//Creating the object of POJO class or Transaction manager
		    	category=new Category();
		    }
		    @Test  
		    public void categoryAddTest()  
		     {  
		    	 //product.setproductId(102);
		    	 category.setCategoryName("sunfeast");
		    	 category.setCategoryDesc("bis");
		 		 Assert.assertEquals("Data Entered Ureka",true,categoryDao.addCategory(category));  
		     }
		    
		    /* @Test
		     public void categoryDeleteTest()
		     {
		    	 category.setCategoryId(2);
		    	 Assert.assertEquals("Data Deleted",true,categoryDao.deleteCategory(category));
		     }
		     
		     @Test  
		     public void productGetTest() {  
		    	 category = categoryDao.getCategory(1);  
		         
		         Assert.assertNotNull(category);
		         System.out.println(category.getCategoryName());
		         System.out.println(category.getCategoryDesc());
		          }
		     
		    @Test 
		    public void categoryUpdateTest()
		    {
		    	category=categoryDao.getCategory(1);
		    	category.setCategoryName("Sanchi");
		    	category.setCategoryDesc("Milk");
		    	Assert.assertEquals("Updated",true,categoryDao.updateCategory(category));
		    }*/
		   /*
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
