package za.co.discovery.application.service.util;

import java.util.LinkedList;

import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;

public interface SortTransactionAccountBalances {

	LinkedList<CurrencyAccountBalancesDTO> sort(String clientId);

}
