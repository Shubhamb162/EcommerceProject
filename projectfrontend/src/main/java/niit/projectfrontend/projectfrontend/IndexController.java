package niit.projectfrontend.projectfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import niit.projectbackend.projectbackend.Customer;
import niit.projectbackend.projectbackend.dao.CustomerDao;

@Controller
public class IndexController {
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		return new ModelAndView("index");		
	}
	
	@RequestMapping("/registration")
	public ModelAndView registration(Model m)
	{
	 	Customer customer=new Customer();
	 	m.addAttribute(customer);
		return new ModelAndView("registration");
	}
	
	@RequestMapping(value="/registerProcess",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("customer") Customer customer){ 
		customerDao.addCustomer(customer);
		return new ModelAndView("index");    
		}
	}

