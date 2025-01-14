package poly.edu.shop.controller.site;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import poly.edu.shop.domain.Customer;
import poly.edu.shop.model.AdminLoginDto;
import poly.edu.shop.model.CustomerDto;
import poly.edu.shop.model.SiteLoginDto;
import poly.edu.shop.service.AccountService;
import poly.edu.shop.service.CustomerService;

@Controller
@RequestMapping("site/customers")
public class RegistrationController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private HttpSession session;
	
	@PostMapping("home")
	public String home(ModelMap model) {
		return "/site/home";
	}
	
	@GetMapping("home")
	public String gethome(ModelMap model) {
		return "/site/home";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		
		model.addAttribute("customer", new CustomerDto());
		
		return "site/registration";
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("customer") CustomerDto dto,
			BindingResult result ) {
		if (result.hasErrors()) {
			
			return new ModelAndView("site/registration");
		}
		
		Customer entity = new Customer();
		BeanUtils.copyProperties(dto, entity);
		
		
		customerService.save(entity);
		
		model.addAttribute("message", "Customer is registed!");
		
		return new ModelAndView("forward:/site/home",model);
	}
}