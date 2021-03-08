package za.co.discovery.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.discovery.application.dto.ClientDTO;
import za.co.discovery.application.dto.ClientNetworthDTO;
import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;
import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;
import za.co.discovery.application.dto.TransactionalAccountHighestBalanceReportingDTO;
import za.co.discovery.application.exception.NoEnoughFundsException;
import za.co.discovery.application.service.CurrencyAccountBalances;
import za.co.discovery.application.service.ClientNetWorth;
import za.co.discovery.application.service.CurrencyAccountBalancesImpl;
import za.co.discovery.application.service.TransacationalAccountBalances;
import za.co.discovery.application.service.TransacationalAccountBalancesImpl;
import za.co.discovery.application.service.TransactionalAccountHighestBalanceReportingService;
import za.co.discovery.application.service.WithdrawalService;

@RestController
public class AtmController {

	ClientNetWorth clientNetWorth;
	WithdrawalService withdrawalService;
	CurrencyAccountBalances currencyAccountBalances;
	TransacationalAccountBalances transacationalAccountBalances;
	CurrencyAccountBalances accountBalance;

	@Autowired
	TransactionalAccountHighestBalanceReportingService transactionalAccountHighestBalanceTeportingService;

	AtmController(ClientNetWorth clientNetWorth, WithdrawalService withdrawalService,
			CurrencyAccountBalancesImpl currencyAccountBalances,
			TransacationalAccountBalancesImpl transacationalAccountBalances,
			TransactionalAccountHighestBalanceReportingService transactionalAccountHighestBalanceTeportingService) {
		super();
		this.clientNetWorth = clientNetWorth;
		this.withdrawalService = withdrawalService;
		this.currencyAccountBalances = currencyAccountBalances;
		this.transacationalAccountBalances = transacationalAccountBalances;
		this.transactionalAccountHighestBalanceTeportingService = transactionalAccountHighestBalanceTeportingService;
	}

	@GetMapping(value = "/transactionalAccountBalances", produces = "application/json")
	@ResponseBody
	public List<TransactionalAccountBalancesDTO> getTransactionalAccountBalances(@RequestBody ClientDTO clientDTO) {
		List<TransactionalAccountBalancesDTO> transactionalAccountBalances = transacationalAccountBalances
				.displayTransactionalAccountBalances(clientDTO);
		return transactionalAccountBalances;
	}

	@GetMapping(value = "/currencyAccountBalances", produces = "application/json")
	@ResponseBody
	public List<CurrencyAccountBalancesDTO> getCurrencyAccountBalances(@RequestBody ClientDTO clientDTO) {
		List<CurrencyAccountBalancesDTO> currencyAccountBalances = getCurrencyAccountBalances(clientDTO);
		return currencyAccountBalances;
	}

	@GetMapping(value = "/clientNetworth", produces = "application/json")
	@ResponseBody
	public List<ClientNetworthDTO> getClientNetworth(@RequestBody ClientDTO clientDTO) {
		List<ClientNetworthDTO> ClientNetworth = null;
		return ClientNetworth;
	}

	@GetMapping(value = "/transactionalAccountHighestBalances", produces = "application/json")
	@ResponseBody
	public List<TransactionalAccountHighestBalanceReportingDTO> getTransactionalAccountHighestBalanceReporting() {
		List<TransactionalAccountHighestBalanceReportingDTO> transactionalAccountHighestBalances = null;
		return transactionalAccountHighestBalances;
	}
	

	@GetMapping(value = "/withDraw", produces = "application/json")
	@ResponseBody
	public synchronized Double withDraw(@RequestParam int clientId, @RequestParam double amount) throws NoEnoughFundsException {
		return withdrawalService.amountWithdrawing(clientId, amount);
	}

}
