package poly.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bai1Controller {
	@RequestMapping("ok")
	public String ok() {
		return "ok";
	}
	@PostMapping("/ctrl/ok")
	public String m1(Model model) {
		model.addAttribute("ok", "Method 1");
		return "ok";
	}
	@GetMapping("/ctrl/ok")
	public String m2(Model model) {
		model.addAttribute("ok", "Method 2");
		return "ok";
	}
	@GetMapping(value="/ctrl/ok",params="x")
	public String m3(Model model) {
		model.addAttribute("ok", "Method 3");
		return "ok";
	}
}
