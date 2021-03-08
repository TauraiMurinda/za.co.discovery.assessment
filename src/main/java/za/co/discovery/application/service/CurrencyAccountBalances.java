package za.co.discovery.application.service;

import java.util.List;

import za.co.discovery.application.dto.ClientDTO;
import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;

public interface CurrencyAccountBalances{

	List<CurrencyAccountBalancesDTO> displayCurrencyAccountBalances(ClientDTO clientDTO);
  }
