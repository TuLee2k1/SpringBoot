package poly.edu.shop.controller.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import poly.edu.shop.domain.Customer;

import poly.edu.shop.model.SiteLoginDto;

import poly.edu.shop.service.CustomerService;

@Controller
public class SiteLoginController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("login")
	public String login(ModelMap model) {
		model.addAttribute("customer", new SiteLoginDto() );
		return "/site/login";
	}
	
	@PostMapping("login")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("customer") SiteLoginDto dto,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("/site/login",model);
		}
		
		Customer customer = customerService.login(dto.getName(), dto.getPassword());
		
		if(customer == null) {
			model.addAttribute("message", "Invalid username or password" );
			return new ModelAndView("/site/login",model);
		}
		session.setAttribute("username", customer.getName());
		
		Object ruri = session.getAttribute("redirect-uri");
		if(ruri != null) {
			session.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:"+ruri);
		}
		
		return new ModelAndView("forward:/site/home", model);
	}
}
