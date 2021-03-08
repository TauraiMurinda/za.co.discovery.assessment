package za.co.discovery.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import za.co.discovery.application.repository.ClientAccountRepository;

/*Client is able to view all transactional accounts with the available balances  on each account in descending order 
with the highest balance displaying first and the lowest balance displaying last*/

@Service
public class TransacationalAccountBalances implements AccountBalance {
	
	private ClientAccountRepository clientAccountRepository;

	public TransacationalAccountBalances(ClientAccountRepository clientAccountRepository) {
		super();
		this.clientAccountRepository = clientAccountRepository;
	}

	


}
