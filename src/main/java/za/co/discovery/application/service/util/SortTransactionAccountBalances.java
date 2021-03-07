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
	
	AccountBalanceCalculator accountBalanceCalcular;
	
	
	LinkedList<Result> sort(Client client)
          {
		             this.clientAccounts= accountBalanceCalcular.getClientAccounts(client);
		             LinkedList<Result> results = (LinkedList<Result>) accountBalanceCalcular.getBalances(clientAccounts);
		             Comparator<Result> comparator = Comparator.comparing(Result::getZar_amount).reversed(); //descending order
					 return results.stream().sorted(comparator).collect(Collectors.toCollection(LinkedList::new));
	     }
	
}
