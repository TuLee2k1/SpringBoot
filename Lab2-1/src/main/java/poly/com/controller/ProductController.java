package poly.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.com.model.Product;

@Controller
public class ProductController {
  
  @GetMapping("/product/form")
  public String form() {
    return "productForm";
  }
  
  @PostMapping("/product/save")
  public String save(@ModelAttribute("product") Product product, Model model) {
    model.addAttribute("name", product.getName());
    model.addAttribute("price", product.getPrice());
    return "productForm";
  }
}
