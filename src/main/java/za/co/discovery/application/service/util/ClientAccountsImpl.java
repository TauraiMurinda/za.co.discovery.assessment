package za.co.discovery.application.service.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.repository.ClientAccountRepository;

@Component
@Transactional
public class ClientAccountsImpl implements ClientAccounts {
   
	@Autowired
	private ClientAccountRepository clientAccountRepository;

	
	
	
	@Override
	public List<ClientAccount> getClientAccounts(Client client){
		return clientAccountRepository.findByClient(client);	
	}
	
	@Override
	public List<ClientAccount> getClientAccounts(Client client,String  clientAccountNumber, String accountTypeCode){
		return  clientAccountRepository.findByClientAndClientAccountNumberAndAccountTypeCode(client,clientAccountNumber,accountTypeCode);	
	}
	
	
	@Override
	public List<ClientAccount> getClientAccounts(Client client, String accountTypeCode){
		return clientAccountRepository.findByClientAndAccountTypeCode(client,accountTypeCode);	
	}
	
	@Override
	public List<ClientAccount> getClientAccounts(String  clientAccountNumber, String accountTypeCode){
		return ((ClientAccountRepository) clientAccountRepository).findByClientAccountNumberAndAccountTypeCode(clientAccountNumber,accountTypeCode);	
	}
	
}
