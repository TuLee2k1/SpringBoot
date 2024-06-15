package poly.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.com.model.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
