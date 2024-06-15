package poly.com.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import poly.com.model.Product;
public interface ProductDAO extends JpaRepository<Product, Integer>{} 
