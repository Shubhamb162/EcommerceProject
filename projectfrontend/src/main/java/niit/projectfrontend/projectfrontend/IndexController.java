package niit.projectfrontend.projectfrontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import niit.projectbackend.projectbackend.Cart;
import niit.projectbackend.projectbackend.Category;
import niit.projectbackend.projectbackend.Customer;
import niit.projectbackend.projectbackend.Product;
import niit.projectbackend.projectbackend.dao.CartDao;
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

	@Autowired
	CartDao cartDao;

	@RequestMapping("/")
	public ModelAndView index(Model m) {
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		return new ModelAndView("index");
	}

	/*
	 * @RequestMapping("/index") public ModelAndView home() { return new
	 * ModelAndView("index"); }
	 */

	@RequestMapping("/signUp")
	public ModelAndView signUp(Model m) {
		Customer customer = new Customer();
		m.addAttribute(customer);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		return new ModelAndView("signUp");
	}

	@RequestMapping(value = "/signUpProcess", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		cartDao.addCart(cart);
		customerDao.addCustomer(customer);

		return "redirect:/login";
	}

	@RequestMapping("/productInformation/{productId}")
	public ModelAndView productInfo(@PathVariable(value = "productId") Integer id, Model m) {
		m.addAttribute("product", productDao.getProduct(id));
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		return new ModelAndView("productInformation");
	}

	@RequestMapping("/login")
	public ModelAndView login(Model m) {
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		return new ModelAndView("login");
	}

	@RequestMapping("/categoryItems/{categoryId}")
	public ModelAndView categoryItems(@PathVariable(value = "categoryId") Integer id, Model m) {
		m.addAttribute("products", productDao.getAllProductByCat(id));
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		return new ModelAndView("categoryItems");
	}

	

	@RequestMapping("/displayProduct/{productId}")
	public String displayProduct(@PathVariable("productId") Integer proid, ModelMap model) {
		model.addAttribute("product", productDao.getProduct(proid));
		return "productInformation";
	}

	
	
	@RequestMapping("/demo")
	public String demo() {
		return "demo";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
