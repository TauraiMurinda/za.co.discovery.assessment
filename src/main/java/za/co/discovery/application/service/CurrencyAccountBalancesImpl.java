package za.co.discovery.application.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.dto.ClientDTO;
import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;
import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.service.util.AccountBalanceCalculator;
import za.co.discovery.application.service.util.ClientAccounts;
/*Client is able to view all currency accounts with the available balances  on each account in ascending order 
with the highest balance in Rand displaying first and the lowest balance displaying last*/

@Service
@Transactional
public class CurrencyAccountBalancesImpl implements  CurrencyAccountBalances{

    @Autowired
	AccountBalanceCalculator accountBalanceCalculator;
	
	@Autowired
	ClientAccounts  clientAccounts;
	List<ClientAccount>ClientAccountList;
	List<CurrencyAccountBalancesDTO> currencyBalances;
	 
	@Override
	public List<CurrencyAccountBalancesDTO> displayCurrencyAccountBalances(ClientDTO clientDTO) {
		Client client = new Client();
		client.setClientId(clientDTO.getClientId());
		ClientAccountList=clientAccounts.getClientAccounts(client);
		try {
			currencyBalances=accountBalanceCalculator.getCurrencyAccountsBalances(ClientAccountList);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return currencyBalances;
   }
}