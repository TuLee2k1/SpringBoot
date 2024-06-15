package poly.com.controller.admin;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import poly.com.domain.Category;
import poly.com.model.CategoryDto;
import poly.com.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new CategoryDto());
		return "admin/categories/addOrEdit";
	}
	
	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") Integer categoryId) {
		
		Optional<Category> opt = categoryService.findById(categoryId);
		CategoryDto dto = new CategoryDto();
		
		if(opt.isPresent()) {
			Category entity = opt.get();	
			
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("category",dto);
			
			return new ModelAndView("admin/categories/addOrEdit",model);
		}
		
		model.addAttribute("message", "Category is not existed");
		
		return new ModelAndView("forward:/admin/categories", model); 
		
	}
	@GetMapping("delete/{categoryId}")
	public String delete() {
		return "redirect:/admin/categories/list";
	}
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@RequestBody CategoryDto dto, RedirectAttributes redirectAttributes) {
	    Category entity = new Category();
	    BeanUtils.copyProperties(dto, entity);
	    categoryService.save(entity);
	    
	    redirectAttributes.addFlashAttribute("message", "Category is saved!");
	    return "redirect:/admin/categories";
	}
	@GetMapping("")
	public String list(ModelMap model) {
		java.util.List<Category> list = categoryService.findAll();
		model.addAttribute("categories", list);
		return "admin/categories/list";
	}
	@GetMapping("search")
	public String search() {
		return "admin/categories/search";
	}
}
