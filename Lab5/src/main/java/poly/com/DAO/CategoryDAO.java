package poly.com.DAO;



import org.springframework.data.jpa.repository.JpaRepository;

import poly.com.model.Categories;

public interface CategoryDAO  extends JpaRepository<Categories, String> {

}
