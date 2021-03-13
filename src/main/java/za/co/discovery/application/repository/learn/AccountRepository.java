package za.co.discovery.application.repository.learn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.discovery.application.entity.learn.Account;
import za.co.discovery.application.entity.learn.Customer;

public interface AccountRepository extends JpaRepository<Account, Long> {
	  List<Account> findByCustomer(Customer customer); 
}