package za.co.discovery.application.service.util;

import java.util.List;

import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;

public interface AccountBalanceCalculator {

	List<ClientAccount> getClientAccounts(Client client);

	List<ClientAccount> getClientAccounts(Client client, String clientAccountNumber, String accountTypeCode);

	List<ClientAccount> getClientAccounts(Client client, String accountTypeCode);

	List<ClientAccount> getClientAccounts(String clientAccountNumber, String accountTypeCode);

	List<Result> getBalances(List<ClientAccount> Currencyccounts);

}
