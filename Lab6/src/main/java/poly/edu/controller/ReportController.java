package poly.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import poly.edu.dao.ProductDAO;
import poly.edu.model.Report;

@Controller
public class ReportController {
	@Autowired
	ProductDAO productDAO;
	
	@GetMapping("/report/inventory-by-category")
	public String inventory(Model model) {
		List<Report> items = productDAO.getInventoryByCategory();
		model.addAttribute("items", items);
		return "report/inventory-by-category";
	}
}
