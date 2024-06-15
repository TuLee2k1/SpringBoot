package poly.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bai2Controller {
	@GetMapping("home")
	public String Bai1(Model model) {
		model.addAttribute("hello", "Hello Spring Boot");
		return "bai2";
	}
}
