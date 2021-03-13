package za.co.discovery.application.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Currency;
import za.co.discovery.application.entity.CurrencyConversionRate;

@Repository
@Transactional
public interface CurrencyConversionRateRepository  extends JpaRepository<CurrencyConversionRate, String>
{
	CurrencyConversionRate findByCurrency(Currency currency);
}
