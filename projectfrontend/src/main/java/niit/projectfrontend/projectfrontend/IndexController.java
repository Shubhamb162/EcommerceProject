package niit.projectfrontend.projectfrontend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import niit.projectbackend.projectbackend.Category;
import niit.projectbackend.projectbackend.Customer;
import niit.projectbackend.projectbackend.Product;
import niit.projectbackend.projectbackend.dao.CategoryDao;
import niit.projectbackend.projectbackend.dao.CustomerDao;
import niit.projectbackend.projectbackend.dao.ProductDao;

@Controller
public class IndexController {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/index")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping("/registration")
	public ModelAndView registration(Model m) {
		Customer customer = new Customer();
		m.addAttribute(customer);
		return new ModelAndView("registration");
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerDao.addCustomer(customer);
		return new ModelAndView("index");
	}
	
	@RequestMapping("/productDisplay")
	public ModelAndView productDisplay(Model m)
	{
		Product product=new Product();
		m.addAttribute(product);
		List<Product> productList= productDao.getAllProduct();
		m.addAttribute("productLists",productList);
		List<Category> categoryList=categoryDao.getAllCategory();
		m.addAttribute("categoryLists",categoryList);
		return new ModelAndView("productDisplay");
	}
	
	@RequestMapping(value = "/productProcess", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product,Model m) {
		System.out.println(product.getProductName());
		System.out.println("product cat"+product.getCategory());
		productDao.addProduct(product);
		/*List<Product> productList= productDao.getAllProduct();
		m.addAttribute("productLists",productList);
		Product product1=new Product();
		m.addAttribute(product1);*/
		return "redirect:/productDisplay";
	}
}
