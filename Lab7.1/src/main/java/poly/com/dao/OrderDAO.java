package poly.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.com.model.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{

}
