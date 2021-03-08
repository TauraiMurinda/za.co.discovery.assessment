package za.co.discovery.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.dto.ClientDTO;
import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;
import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;
import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.service.util.AccountBalanceCalculator;
import za.co.discovery.application.service.util.ClientAccounts;

/*Client is able to view all transactional accounts with the available balances  on each account in descending order 
with the highest balance displaying first and the lowest balance displaying last*/

@Service
@Transactional(readOnly=true)
public class TransacationalAccountBalancesImpl implements TransacationalAccountBalances {
	
	private AccountBalanceCalculator accountBalanceCalculator;
	private ClientAccounts  clientAccounts;
	private List<ClientAccount>ClientAccountList;
	private List<TransactionalAccountBalancesDTO> transactionalAccounts;
	

	@Override
	public  List<TransactionalAccountBalancesDTO>  displayTransactionalAccountBalances(ClientDTO clientDTO) {
		ClientAccountList=clientAccounts.getClientAccounts(clientDTO.getClientId());
		return transactionalAccounts=accountBalanceCalculator.getTransactionalAccountsBalances(ClientAccountList);
		
	}
  
	


}
