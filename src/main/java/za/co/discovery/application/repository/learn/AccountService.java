package za.co.discovery.application.repository.learn;

import java.util.List;

import za.co.discovery.application.entity.learn.Account;
import za.co.discovery.application.entity.learn.Customer;

public interface AccountService {

	Account save(Account account);

	List<Account> findByCustomer(Customer customer);

}
