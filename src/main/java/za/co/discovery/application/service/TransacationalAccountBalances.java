package za.co.discovery.application.service;

import java.util.List;

import za.co.discovery.application.dto.ClientDTO;
import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;

public interface TransacationalAccountBalances {

	 List<TransactionalAccountBalancesDTO>  displayTransactionalAccountBalances(ClientDTO clientDTO);

}
