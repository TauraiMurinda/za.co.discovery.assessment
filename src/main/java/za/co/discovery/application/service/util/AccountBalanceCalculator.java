package za.co.discovery.application.service.util;

import java.util.List;
import java.util.Optional;

import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;

public interface AccountBalanceCalculator {

	List<ClientAccount> getClientAccounts(int clientId);

	List<ClientAccount> getClientAccounts(int clientId, String accountTypeCode);

	List<ClientAccount> getClientAccounts(String clientAccountNumber, String accountTypeCode);

	List<Result> getBalances(List<ClientAccount> Currencyccounts);

	List<ClientAccount> getClientAccounts(int clientId, String clientAccountNumber, String accountTypeCode);

}
