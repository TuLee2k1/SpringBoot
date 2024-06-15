package poly.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
@RequestMapping("hello")
@ResponseBody
public String sayHello() {
	return "<h1>Hello Java Spring Boot</h1>";
}
}
