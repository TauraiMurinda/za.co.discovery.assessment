package za.co.discovery.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import za.co.discovery.application.service.ClientNetWorth;
import za.co.discovery.application.service.CurrencyAccountBalances;
import za.co.discovery.application.service.TransacationalAccountBalances;
import za.co.discovery.application.service.WithdrawalService;

@RestController
public class AtmController {
	
	@Autowired
	ClientNetWorth  clientNetWorth;
	
	@Autowired
	WithdrawalService  withdrawalService;
	
	@Autowired
	CurrencyAccountBalances currencyAccountBalances;
	
	
	@Autowired
	TransacationalAccountBalances  transacationalAccountBalances;

}
