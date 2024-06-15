package poly.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poly.com.model.User;

@Controller
@RequestMapping("user")
public class Bai4Controller {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@GetMapping("create")
	public String create() {
		return "bai4";
	}
	
	@PostMapping("create")
	public String createPost() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username,password);
		
		request.setAttribute("usern", user);
		
		return "bai4";
	}
}
