package poly.com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.com.model.Product;

@Controller
public class ProductControllerBai4 {
  
  @GetMapping("/product-form")
  public String form(Model model) {
    Product p = new Product();
    p.setName("iPhone 30");
    p.setPrice(5000.0);
    model.addAttribute("product", p);
    return "productFormBai4";
  }
  
  @PostMapping("/product-save")
  public String save(@ModelAttribute("product") Product product, Model model) {
    model.addAttribute("name", product.getName());
    model.addAttribute("price", product.getPrice());
    return "productFormBai4";
  }
  
  @ModelAttribute("products")
  public List<Product> getItems() {
    return Arrays.asList(new Product("Iphone 15", 10000.0), new Product("Iphone 16", 120000.0));
  }
}
