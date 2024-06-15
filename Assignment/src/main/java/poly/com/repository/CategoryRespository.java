package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.com.domain.Category;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Long> {

}
