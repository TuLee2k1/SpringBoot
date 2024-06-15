package edu.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.FileUploadUtil;
import edu.poly.model.Account;

@Controller
@RequestMapping("account")
public class AccountController {

	public static List<Account> list = new ArrayList<Account>();

	public int findByUserName(String username) {
		for (int i = 0; i < list.size(); i++) {
			Account account = list.get(i);
			if (account.getUsername().equals(username)) {
				return i; // Trả về chỉ số khi tìm thấy username
			}
		}
		return -1; // Trả về -1 nếu không tìm thấy username
	}

	@GetMapping("register")
	public String showForm(Model model) {
		model.addAttribute("ACCOUNT", new Account());
		return "register-form";
	}

	@PostMapping("SaveOrUpdate")
	public String SaveOrUpdate(@Validated @ModelAttribute("ACCOUNT") Account account, Errors result, Model model,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		if (result.hasErrors()) {
			if (multipartFile.isEmpty()) {
				model.addAttribute("ERROR", "Vui lòng chọn ảnh");
			}
			return "register-form";
		}

		int position = findByUserName(account.getUsername());
		String fileName = org.springframework.util.StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String uploadDir = "uploads/";
		FileUploadUtil.savefile(uploadDir, fileName, multipartFile);

		if (position < 0) {
			account.setPhoto(fileName);
			list.add(account);
			System.out.println("Thêm mới thành công " + account);
			model.addAttribute("message", "Thêm mới thành công!");
		} else {
			// Update
			account.setPhoto(fileName);
			list.set(position, account);
		}
		model.addAttribute("ACCOUNT", new Account());
		return "register-form";
	}

	@GetMapping("views")
	public String viewsAccount(Model model) {
		model.addAttribute("ACCOUNTS", list);
		return "view-accounts";
	}

	@GetMapping(value = "views", params = "btnDel")
	public String DelAccount(@RequestParam("username") String username, Model model) {
		int pos = findByUserName(username);

		if (pos >= 0) {
			list.remove(pos);
		}
		return "redirect:/account/views";
	}

	@GetMapping("register/{username}")
	public String edit(@PathVariable("username") String username, Model model) {

		int pos = findByUserName(username);
		if (pos < 0) {
			model.addAttribute("ACCOUNT", new Account());
		} else {
			model.addAttribute("ACCOUNT", list.get(pos));
		}
		return "register-form";
	}
}
