package poly.com.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import poly.com.model.Account;


public interface AccountDAO extends JpaRepository<Account, String> {

}
