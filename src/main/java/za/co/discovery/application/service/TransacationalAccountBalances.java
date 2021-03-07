package za.co.discovery.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import za.co.discovery.application.repository.ClientAccountRepository;

@Service
public class TransacationalAccountBalances implements AccountBalance {
	
	private ClientAccountRepository clientAccountRepository;

	public TransacationalAccountBalances(ClientAccountRepository clientAccountRepository) {
		super();
		this.clientAccountRepository = clientAccountRepository;
	}

	


}
