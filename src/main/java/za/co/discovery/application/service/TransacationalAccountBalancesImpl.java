package za.co.discovery.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.dto.ClientDTO;
import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;
import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.service.util.AccountBalanceCalculator;
import za.co.discovery.application.service.util.ClientAccounts;

/*Client is able to view all transactional accounts with the available balances  on each account in descending order 
with the highest balance displaying first and the lowest balance displaying last*/

@Service
@Transactional(readOnly=true)
public class TransacationalAccountBalancesImpl implements TransacationalAccountBalances {
	
	@Autowired
	private AccountBalanceCalculator accountBalanceCalculator;
	
	@Autowired
	private ClientAccounts  clientAccounts;
	private List<ClientAccount>ClientAccountList;
	private List<TransactionalAccountBalancesDTO> transactionalAccounts;
	

	@Override
	public  List<TransactionalAccountBalancesDTO>  displayTransactionalAccountBalances(ClientDTO clientDTO) {
		
		Client client = new Client();
		client.setClientId(clientDTO.getClientId());
		ClientAccountList=clientAccounts.getClientAccounts(client );
		transactionalAccounts=accountBalanceCalculator.getTransactionalAccountsBalances(ClientAccountList);
		return transactionalAccounts;
		
	}
  
	


}
