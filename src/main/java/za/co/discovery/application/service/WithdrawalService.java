package za.co.discovery.application.service;

import za.co.discovery.application.exception.NoEnoughFundsException;

public interface  WithdrawalService {
		public Double amountWithdrawing(String clientId ,double amount) throws NoEnoughFundsException;	
	}
