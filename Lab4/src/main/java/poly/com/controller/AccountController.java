package poly.com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import poly.com.cookieservice.CookieService;
import poly.com.paramservice.ParamService;
import poly.com.sessionservice.SessionService;

@Controller


public class AccountController {
	
	@Autowired 
	CookieService cookieService; 
	@Autowired 
	ParamService paramService; 
	@Autowired 
	SessionService sessionService; 
	
	@GetMapping("/account/login") 
	public String login1() { 
		return "login";  
		}  
	@PostMapping("/account/login") 
	public String login2() {
		 String un = paramService.getString("username", "");
		    String pw = paramService.getString("password", "");
		    boolean rm = paramService.getBoolean("remember", false);

		    if (un.equals("poly") && pw.equals("123")) {
		        // Lưu username vào session
		        sessionService.set("username", un);

		        // Xử lý ghi nhớ tài khoản
		        if (rm) {
		            // Ghi nhớ tài khoản 10 ngày
		            cookieService.add("user", un, 10);
		        } else {
		            // Xóa cookie tài khoản đã ghi nhớ trước đó
		            cookieService.remove("user");
		        }
		    }
		return "login"; 
		}
	   
}
