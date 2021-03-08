package za.co.discovery.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class BankBalanceDispensingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankBalanceDispensingSystemApplication.class, args);
	}

}

//
//Display transactional accounts with balances
//Display currency accounts with converted Rand values
//Withdraw (Calculation of notes to be dispensed)
//Reporting – Find the transactional account per client with the highest balance
//Reporting – Calculate aggregate financial position per client
