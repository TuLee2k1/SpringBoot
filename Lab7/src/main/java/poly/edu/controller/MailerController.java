package poly.edu.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class MailerController {

    @Autowired
    private JavaMailSender mailer;

    @ResponseBody
    @RequestMapping("/mailer/demo")
    public String demo(Model model) {
    	System.out.println("ok");
        try {
            MimeMessage mail = mailer.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("leetub4@gmail.com");
            helper.setSubject("Subject");
            helper.setText("Body");
            helper.setFrom("leetub4@gmail.com");
            mailer.send(mail);
            System.out.println("ok");
            return "OK";
        } catch (MessagingException e) {
            return e.getMessage();
        }
    }
}
