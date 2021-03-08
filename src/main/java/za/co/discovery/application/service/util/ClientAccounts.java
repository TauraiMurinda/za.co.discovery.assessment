package za.co.discovery.application.service.util;

import java.util.List;

import za.co.discovery.application.entity.ClientAccount;

public interface ClientAccounts {
	
	List<ClientAccount> getClientAccounts(int clientId);

	List<ClientAccount> getClientAccounts(int clientId, String accountTypeCode);

	List<ClientAccount> getClientAccounts(String clientAccountNumber, String accountTypeCode);

	List<ClientAccount> getClientAccounts(int clientId, String clientAccountNumber, String accountTypeCode);

}
