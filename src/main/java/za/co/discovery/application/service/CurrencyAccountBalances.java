package za.co.discovery.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.service.util.CurrencyConverter;

@Service
public class CurrencyAccountBalances implements  AccountBalance{

	private ClientAccountRepository clientAccountRepository;

	
  
	
}