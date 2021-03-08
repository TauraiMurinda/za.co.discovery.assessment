package za.co.discovery.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.service.util.CurrencyConverter;
/*Client is able to view all currency accounts with the available balances  on each account in ascending order 
with the highest balance in Rand displaying first and the lowest balance displaying last*/

@Service
public class CurrencyAccountBalances implements  AccountBalance{

	private ClientAccountRepository clientAccountRepository;

	
  
	
}