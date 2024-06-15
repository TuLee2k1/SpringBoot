package poly.com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.com.DAO.CategoryDAO;
import poly.com.model.Categories;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO dao;

	@RequestMapping("/category/index")
	public String index(Model model) {
		Categories item = new Categories();
		model.addAttribute("item", item);
		List<Categories> items = dao.findAll();
		model.addAttribute("items", items);
		return "category/index";
	}

	@RequestMapping("/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		
		Categories item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Categories> items = dao.findAll();
		model.addAttribute("items", items);
		return "category/index";
	}

	@RequestMapping(value = "/category/create", method = RequestMethod.POST)
	public String create(Categories item) {
		dao.save(item);
		return "redirect:/category/index";
	}

	@RequestMapping(value = "/category/update", method = RequestMethod.POST)
	public String update(Categories item) {
		dao.save(item);
		return "redirect:/category/edit/" + item.getId();
	}

	@RequestMapping("/category/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		dao.deleteById(id);
		return "redirect:/category/index";
	}
}
