package poly.edu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.shop.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
