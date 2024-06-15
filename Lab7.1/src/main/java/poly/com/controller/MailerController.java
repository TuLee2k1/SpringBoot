package poly.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import poly.com.service.MailerService;

@Controller
public class MailerController {
	@Autowired
	MailerService mailer;

	@ResponseBody
	@RequestMapping("/mailer/demo")
	public String demo(Model model) {
		mailer.queue("leetub4@gmail.com", "Subject", "Body");
		return "Mail của bạn sẽ được gửi đi trong giây lát";
	}
	
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) {
		return "mailform";
	}
	
	@PostMapping("/sendEmail")
	public String sentEmail(Model model, HttpServletRequest request, 
            @RequestParam("to") String to, 
            @RequestParam("subject") String subject, 
            @RequestParam("body") String body) {
		try {
			mailer.send(to, subject, body);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("message", "Gửi mail thành công!");
		return "mailform";
	}
}
