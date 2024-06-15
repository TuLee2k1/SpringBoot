package poly.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.com.springbean.ShoppingCartServiceImpl.DB;

@Controller
public class ItemController { 
	@RequestMapping("/item/index")  
	public String list(Model model) {
		model.addAttribute("items", DB.items.values());
		return "index"; 
	} 
}