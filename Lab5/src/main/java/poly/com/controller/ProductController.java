package poly.com.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.com.DAO.ProductDAO;
import poly.com.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO dao;

	@GetMapping("/product/sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field) {
		List<Product> products = dao.findAll();

		// Sort products based on selected field
		Comparator<Product> comparator = null;
		switch (field.orElse("price")) {
		case "id":
			comparator = Comparator.comparing(Product::getId);
			break;
		case "name":
			comparator = Comparator.comparing(Product::getName);
			break;
		case "price":
			comparator = Comparator.comparing(Product::getPrice);
			break;
		case "createDate":
			comparator = Comparator.comparing(Product::getCreateDate);
			break;
		default:
			// Default sort by price (descending)
			comparator = Comparator.comparing(Product::getPrice).reversed();
		}
		Collections.sort(products, comparator);

		// Set sorted products to model
		model.addAttribute("items", products);
		model.addAttribute("field", field.orElse("price").toUpperCase());

		return "product/sort";
	}

	@RequestMapping("/product/page")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "product/page";
	}
}