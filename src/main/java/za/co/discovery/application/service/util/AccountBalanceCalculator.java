package za.co.discovery.application.service.util;

import java.util.List;
import java.util.Optional;

import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;
import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;
import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;

public interface AccountBalanceCalculator {


	List<TransactionalAccountBalancesDTO> getTransactionalAccountsBalances(List<ClientAccount> transactionalAccounts);

	List<CurrencyAccountBalancesDTO> getCurrencyAccountsBalances(List<ClientAccount> currencyccounts);

}
