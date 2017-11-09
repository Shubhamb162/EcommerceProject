package niit.projectfrontend.projectfrontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView index(Model m) {
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
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
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerDao.addCustomer(customer);
		return new ModelAndView("index");
	}

	@RequestMapping("/productDisplay")
	public ModelAndView productDisplay(Model m) {
		Product product = new Product();
		m.addAttribute(product);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		return new ModelAndView("productDisplay");
	}

	@RequestMapping(value = "/productProcess", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product,
			@RequestParam("productImage") MultipartFile multiPartFile, ModelMap m, HttpServletRequest request) {
		/*
		 * System.out.println(product.getProductName());
		 * System.out.println("product cat"+product.getCategory());
		 */
		
		System.err.println("productId "+product.getProductId());
		if(product.getProductId()!=null)
		{
			productDao.updateProduct(product);
		}else
		{
		productDao.addProduct(product);
		}
		// String path =
		// "C:/Users/Shubham/workspace/EcommerceP/projectfrontend/src/main/webapp/resources/";
		String path = request.getServletContext().getRealPath("/resources/");
		String totalFileWithPath = path + String.valueOf(product.getProductName()) + ".jpg";
		System.out.println(totalFileWithPath);
		File productImage = new File(totalFileWithPath);
		if (!multiPartFile.isEmpty()) {
			try {
				byte fileBuffer[] = multiPartFile.getBytes();
				FileOutputStream fileOutputStream = new FileOutputStream(productImage);
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
				bufferedOutputStream.write(fileBuffer);
				bufferedOutputStream.close();
			} catch (Exception e) {
				m.addAttribute("File Exeception" + e);
			}

		} 

		/*
		 * List<Product> productList= productDao.getAllProduct();
		 * m.addAttribute("productLists",productList); Product product1=new
		 * Product(); m.addAttribute(product1);
		 */
		return "redirect:/productDisplay";
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

	@RequestMapping("/categoryDisplay")
	public ModelAndView categoryDisplay(Model m) {
		Category category = new Category();
		m.addAttribute(category);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		return new ModelAndView("categoryDisplay");
	}

	@RequestMapping(value = "/categoryProcess", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") Category category, ModelMap m, HttpServletRequest request) {

		categoryDao.addCategory(category);
		return "redirect:/categoryDisplay";
	}

	@RequestMapping("/categoryItems/{categoryId}")
	public ModelAndView categoryItems(@PathVariable(value = "categoryId") Integer id, Model m) {
		m.addAttribute("products", productDao.getAllProductByCat(id));
		return new ModelAndView("categoryItems");
	}
	
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("category") Category category, ModelMap m, HttpServletRequest request) {

		categoryDao.addCategory(category);
		return "redirect:/categoryDisplay";
	}
	
	
	@RequestMapping("/editProduct/{productId}")
     public String editProduct(@PathVariable("productId") Integer proId,Model m)
     {
		Product product=productDao.getProduct(proId);
		m.addAttribute("product",product);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		return "productDisplay";
		
     }



}
