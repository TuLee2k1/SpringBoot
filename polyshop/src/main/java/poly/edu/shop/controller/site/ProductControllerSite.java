package poly.edu.shop.controller.site;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.validation.Valid;
import poly.edu.shop.domain.Category;
import poly.edu.shop.domain.Product;
import poly.edu.shop.model.CategoryDto;
import poly.edu.shop.model.ProductDto;
import poly.edu.shop.service.CategoryService;
import poly.edu.shop.service.ProductService;
import poly.edu.shop.service.StorageService;

@Controller
@RequestMapping("site/products")
public class ProductControllerSite {
	
	@Autowired
	ProductService productService;
	@Autowired
	StorageService storageService;
	
	
	@RequestMapping("")
	public String list(ModelMap model) {
	    List<Product> list  =	productService.findAll();
		
	    model.addAttribute("products", list);
	    
		return "site/list";
	}
	
	@GetMapping("detail/{productId}")
	public ModelAndView edit(ModelMap model, @PathVariable("productId") Long productId) {
		
		Optional<Product> opt = productService.findById(productId);
		ProductDto dto = new ProductDto();
		
		if(opt.isPresent()) {
			Product entity = opt.get();	
			
			BeanUtils.copyProperties(entity, dto);
			dto.setCategoryId(entity.getCategory().getCategoryId());
			dto.setIsEdit(true);
			
			model.addAttribute("product",dto);
			
			return new ModelAndView("site/detail",model);
		}
		
		model.addAttribute("message", "Product is not existed");
		
		return new ModelAndView("forward:/site/products", model); 
		
	}
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		Resource file = storageService.loadAsResource(filename);
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
				"attachment;filename=\""+ file.getFilename() + "\"").body(file);
	}
	
//	@GetMapping("search")
//	public String search(ModelMap model, @RequestParam(name="name", required = false) String name) {
//		List<Product> list = null;
//		
//		if(StringUtils.hasText(name)) {
//			list = productService.findByNameContaining(name);
//			
//		}else {
//			list = productService.findAll();
//		}
//		
//		model.addAttribute("categories", list);
//		
//		return "admin/categories/search";
//	}
//	
//	
//	@GetMapping("search/paginated")
//	public String search(ModelMap model,
//			@RequestParam(name="name", required = false) String name,
//			@RequestParam("page") Optional<Integer> page,
//			@RequestParam("size") Optional<Integer> size) {
//		
//		int currentPage = page.orElse(1);
//		int pageSize = size.orElse(5);
//		
//		Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("name"));
//		Page<Category> resultPage = null;
//		
//		
//		
//		if(StringUtils.hasText(name)) {
//			resultPage = productService.findByNameContaining(name, pageable);
//			model.addAttribute("name", name);
//			
//		}else {
//			resultPage = productService.findAll(pageable);
//		}
//		
//		int totalPages = resultPage.getTotalPages();
//		if(totalPages > 0) {
//			int start = Math.max(1, currentPage-2);
//			int end = Math.min(currentPage + 2, totalPages);
//			
//			if(totalPages > 5 ) {
//				if(end == totalPages) start = end -5;
//				else if(start ==1) end = start + 5;
//			}
//			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
//					.boxed()
//					.collect(Collectors.toList());
//			model.addAttribute("pageNumbers", pageNumbers);
//		}
//		
//		
//		model.addAttribute("productPage", resultPage);
//		
//		return "admin/categories/searchpaginated";
//	}
}
