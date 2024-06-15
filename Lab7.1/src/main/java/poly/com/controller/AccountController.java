package poly.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.com.dao.AccountDAO;
import poly.com.model.Account;
import poly.com.service.SesionService;

@Controller
public class AccountController {
	@Autowired
	AccountDAO dao;

	@Autowired
	SesionService session;

	@GetMapping("/account/login")
	public String login() {
		return "account/login";
	}

	@PostMapping("/account/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			Account user = dao.getOne(username);
			if (!user.getPassword().equals(password)) {
				model.addAttribute("message", "Invalid password");
			} else {
				String uri = session.get("security-uri");
				if (uri != null) {
					return "redirect:" + uri;
				} else {
					model.addAttribute("message", "Login succeed");
				}
			}
		} catch (Exception e) {
			model.addAttribute("message", "Invalid username");
		}
		return "account/login";
	}
}
