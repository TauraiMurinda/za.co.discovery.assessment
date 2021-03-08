package za.co.discovery.application.service.util;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;
import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;

@Component
@Transactional
public class SortTransactionAccountBalancesImpl  implements SortTransactionAccountBalances {
		 
	List<ClientAccount>  clientAccountsList;
	Client client;
	
	AccountBalanceCalculator accountBalanceCalculator;
	ClientAccounts  clientAccount;
	  
	
	
	@Override
	
	public LinkedList<CurrencyAccountBalancesDTO> sort(int  clientId)
          {
		             this.clientAccountsList= clientAccount.getClientAccounts(clientId);
		             LinkedList<CurrencyAccountBalancesDTO> results = (LinkedList<CurrencyAccountBalancesDTO>) accountBalanceCalculator.getCurrencyAccountsBalances(clientAccountsList);
		             Comparator<CurrencyAccountBalancesDTO> comparator = Comparator.comparing(CurrencyAccountBalancesDTO::getZarAmount).reversed(); //descending order
					 return results.stream().sorted(comparator).collect(Collectors.toCollection(LinkedList::new));
	     }
	
}
