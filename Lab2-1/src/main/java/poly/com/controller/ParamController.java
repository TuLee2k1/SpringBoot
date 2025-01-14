package poly.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping("/param/form")
	public String form() {
		return "form";
	}

	@RequestMapping("/param/save/{x}")
	public String save(@RequestParam("y") String x, @PathVariable("x")  String y,Model model) {
		model.addAttribute("y", y);
		model.addAttribute("x", x);
		return "form";
	}
}
