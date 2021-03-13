package za.co.discovery.application.repository.learn;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.learn.Account;
import za.co.discovery.application.entity.learn.Customer;

@Repository
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

  @PersistenceContext
  private EntityManager em;

  @Override
  @Transactional
  public Account save(Account account) {

    if (account.getId() == null) {
      em.persist(account);
      return account;
    } else {
      return em.merge(account);
    }
  }

  @Override
  public List<Account> findByCustomer(Customer customer) {

    TypedQuery query = em.createQuery("select a from Account a where a.customer = ?1", Account.class);
    query.setParameter(1, customer);

    return query.getResultList();
  }
}