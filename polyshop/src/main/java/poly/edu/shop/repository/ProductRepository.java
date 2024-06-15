package poly.edu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.shop.domain.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
