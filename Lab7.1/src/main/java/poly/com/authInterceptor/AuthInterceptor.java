package poly.com.authInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poly.com.model.Account;
import poly.com.service.SesionService;


@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SesionService session;

@Override 
public boolean preHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler) throws Exception { 
	 
	  String uri = request.getRequestURI();   
	  Account user = session.get("user"); // lấy từ session      
	  String error = "";
	  if(user == null) { // chưa đăng nhập    
		  error = "Please login!"; 
		  }
	  // không đúng vai trò 
	  else if(!user.isAdmin() && uri.startsWith("/admin/"))
	  {    
		  error = "Access denied!"; 
	  }   
	  if(error.length() > 0) { 
		  // có lỗi    
		  session.set("security-uri", uri);
		  response.sendRedirect("/account/login?error=" + error);
		  return false;
  }  
	  return true; 
	  }
}
