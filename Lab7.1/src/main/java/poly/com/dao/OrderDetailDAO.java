package poly.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.com.model.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{

}
