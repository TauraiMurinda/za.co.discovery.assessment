package za.co.discovery.application.service.util;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;

@Service
@Transactional
public class SortTransactionAccountBalances{
		 
	List<ClientAccount>  clientAccounts;
	Client client;
	
	AccountBalanceCalculator accountBalanceCalculator;
	
	
	LinkedList<Result> sort(int  clientId)
          {
		             this.clientAccounts= accountBalanceCalculator.getClientAccounts(clientId);
		             LinkedList<Result> results = (LinkedList<Result>) accountBalanceCalculator.getBalances(clientAccounts);
		             Comparator<Result> comparator = Comparator.comparing(Result::getZar_amount).reversed(); //descending order
					 return results.stream().sorted(comparator).collect(Collectors.toCollection(LinkedList::new));
	     }
	
}
