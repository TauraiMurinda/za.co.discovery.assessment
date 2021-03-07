package za.co.discovery.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Currency;

@Repository
@Transactional
public interface CurrencyRepository  extends JpaRepository<Currency, String>
{
}
