package poly.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("home")
	@ResponseBody
	public String sayHello() {
		return "sign-in";
	}
}
