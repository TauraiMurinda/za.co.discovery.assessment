package za.co.discovery.application.service.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.service.AccountBalance;

@Component
@Transactional
public class ClientAccountsImpl implements ClientAccounts {

	private AccountBalance accountBalance;

	
	@Override
	public List<ClientAccount> getClientAccounts(int clientId){
		return ((ClientAccountRepository) accountBalance).findByClientId(clientId);	
	}
	
	@Override
	public List<ClientAccount> getClientAccounts(int clientId,String  clientAccountNumber, String accountTypeCode){
		return ((ClientAccountRepository) accountBalance).findByClientIdAndClientAccountNumberAndAccountTypeCode(clientId,clientAccountNumber,accountTypeCode);	
	}
	
	
	@Override
	public List<ClientAccount> getClientAccounts(int clientId, String accountTypeCode){
		return ((ClientAccountRepository) accountBalance).findByClientIdAndAccountTypeCode(clientId,accountTypeCode);	
	}
	
	@Override
	public List<ClientAccount> getClientAccounts(String  clientAccountNumber, String accountTypeCode){
		return ((ClientAccountRepository) accountBalance).findByClientAccountNumberAndAccountTypeCode(clientAccountNumber,accountTypeCode);	
	}
	
}
