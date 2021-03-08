package za.co.discovery.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.discovery.application.dto.ClientDTO;
import za.co.discovery.application.dto.ClientNetworthDTO;
import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;
import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;
import za.co.discovery.application.dto.TransactionalAccountHighestBalanceReportingDTO;
import za.co.discovery.application.service.ClientNetWorth;
import za.co.discovery.application.service.CurrencyAccountBalances;
import za.co.discovery.application.service.TransacationalAccountBalances;
import za.co.discovery.application.service.TransactionalAccountHighestBalanceReportingService;
import za.co.discovery.application.service.WithdrawalService;

@RestController
public class AtmController {
	
	ClientNetWorth  clientNetWorth;
	WithdrawalService  withdrawalService;
	CurrencyAccountBalances currencyAccountBalances;
	TransacationalAccountBalances  transacationalAccountBalances;
	
	@Autowired
	TransactionalAccountHighestBalanceReportingService transactionalAccountHighestBalanceTeportingService;
	private AtmController(ClientNetWorth clientNetWorth, WithdrawalService withdrawalService,
			CurrencyAccountBalances currencyAccountBalances,
			TransacationalAccountBalances transacationalAccountBalances,
			TransactionalAccountHighestBalanceReportingService transactionalAccountHighestBalanceTeportingService) {
		super();
		this.clientNetWorth = clientNetWorth;
		this.withdrawalService = withdrawalService;
		this.currencyAccountBalances = currencyAccountBalances;
		this.transacationalAccountBalances = transacationalAccountBalances;
		this.transactionalAccountHighestBalanceTeportingService = transactionalAccountHighestBalanceTeportingService;
	}
	
	
	   @GetMapping(value = "/transactionalAccountBalances" ,produces = "application/json")
	    public List<TransactionalAccountBalancesDTO> getTransactionalAccountBalances(@RequestBody ClientDTO clientDTO) {
		 List<TransactionalAccountBalancesDTO>  transactionalAccountBalances = null;
	        return transactionalAccountBalances;
	    }
	   
	   @GetMapping(value = "/currencyAccountBalances",produces = "application/json")
	    public List<CurrencyAccountBalancesDTO> getCurrencyAccountBalances(@RequestBody ClientDTO clientDTO) {
		 List<CurrencyAccountBalancesDTO>  currencyAccountBalances = null;
	        return currencyAccountBalances;
	    }
	   
	   
	   @GetMapping(value = "/clientNetworth" ,produces = "application/json")
	    public List<ClientNetworthDTO> getClientNetworth(@RequestBody ClientDTO clientDTO) {
		 List<ClientNetworthDTO>  ClientNetworth = null;
	        return ClientNetworth;
	    }
	   
	   
	   @GetMapping(value = "/transactionalAccountHighestBalances" ,produces = "application/json")
	    public List<TransactionalAccountHighestBalanceReportingDTO> getTransactionalAccountHighestBalanceReporting() {
		 List<TransactionalAccountHighestBalanceReportingDTO>  transactionalAccountHighestBalances = null;
	        return transactionalAccountHighestBalances;
	    }
	   
	   
	   @GetMapping(value = "/withDraw" ,produces = "application/json")
	    public Integer withDraw(@RequestBody ClientDTO clientDTO) {
		 Integer amount = null;
	        return amount;
	    }
	   
	   
	   
	 
	 
	 
	

}
