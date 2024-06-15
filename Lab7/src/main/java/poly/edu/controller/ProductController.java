package poly.edu.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.dao.ProductDAO;
import poly.edu.model.Product;
import poly.edu.service.SessionService;

@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	@Autowired
	SessionService session;

	@RequestMapping("/product/sort")
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
		Collections.sort(products, comparator.reversed());

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

	@RequestMapping("/product/search")
	public String search(Model model, @RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		Double minPrice = min.orElse(Double.MIN_VALUE);
		Double maxPrice = max.orElse(Double.MAX_VALUE);

		List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);
		model.addAttribute("items", items);
		return "product/search";
	}

	@RequestMapping("/product/search-and-page")
	public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw, @RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(session.get("keywords", "")).trim();
		session.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		
		Page<Product> page = dao.findAllByNameLike("%"+kwords+"%", pageable);
		model.addAttribute("page", page);
		return "product/search-and-page";
	}
}