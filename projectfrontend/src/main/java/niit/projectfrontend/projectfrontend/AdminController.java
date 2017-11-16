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
import niit.projectbackend.projectbackend.Product;
import niit.projectbackend.projectbackend.dao.CategoryDao;
import niit.projectbackend.projectbackend.dao.CustomerDao;
import niit.projectbackend.projectbackend.dao.ProductDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;
	
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
	@RequestMapping(value = "/productProcess", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product,
			@RequestParam("productImage") MultipartFile multiPartFile, ModelMap m, HttpServletRequest request) {
		/*
		 * System.out.println(product.getProductName());
		 * System.out.println("product cat"+product.getCategory());
		 */

		System.err.println("productId " + product.getProductId());
		if (product.getProductId() != null) {
			productDao.updateProduct(product);
		} else {
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
		return "redirect:/admin/productDisplay";
	}
	@RequestMapping(value = "/categoryProcess", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") Category category, ModelMap m, HttpServletRequest request) {
		if (category.getCategoryId() != null) {
			categoryDao.updateCategory(category);
		} else {
			categoryDao.addCategory(category);
		}
		return "redirect:/admin/categoryDisplay";
	}
	
	
	
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("category") Category category, ModelMap m,
			HttpServletRequest request) {

		categoryDao.addCategory(category);
		return "redirect:/categoryDisplay";
	}

	@RequestMapping("/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") Integer proId, Model m) {
		Product product = productDao.getProduct(proId);
		m.addAttribute("product", product);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		return "productDisplay";

	}

	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") Integer proId, Model m) {
		Product product = productDao.getProduct(proId);
		productDao.deleteProduct(product);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		Product product2 = new Product();
		m.addAttribute("product", product2);
		return "productDisplay";
	}

	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId") Integer catId, Model m) {
		Category category = categoryDao.getCategory(catId);
		m.addAttribute("category", category);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		return "categoryDisplay";

	}

	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") Integer catId, Model m) {
		Category category = categoryDao.getCategory(catId);
		categoryDao.deleteCategory(category);
		List<Category> categoryList = categoryDao.getAllCategory();
		m.addAttribute("categoryLists", categoryList);
		List<Product> productList = productDao.getAllProduct();
		m.addAttribute("productLists", productList);
		Category category2 = new Category();
		m.addAttribute("category", category2);
		return "categoryDisplay";
	}

	
}
