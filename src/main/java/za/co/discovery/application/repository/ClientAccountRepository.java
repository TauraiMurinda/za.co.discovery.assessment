package za.co.discovery.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;

@Repository
@Transactional
public interface ClientAccountRepository extends JpaRepository<ClientAccount, String> {

   // @Query("SELECT c_acc FROM ClientAccount c_acc  WHERE c_acc.clientId=(:clientId)")
    List<ClientAccount> findByClient(Client client);
    
    //@Query("SELECT c_acc FROM ClientAccount c_acc  WHERE c_acc.clientAccountNumber=(:clientAccountNumber) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientAccountNumberAndAccountTypeCode(String clientAccountNumber, String accountTypeCode);
   
   // @Query("SELECT c_acc FROM ClientAccount c_acc  WHERE c_acc.client.clientId=(:clientId) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientAndAccountTypeCode(Client client, String accountTypeCode);

    //@Query("SELECT c_acc FROM ClientAccount c_acc,Client clynt  WHERE clynt.client.clientId=(:clientId) and c_acc.clientAccountNumber=(:clientAccountNumber) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientAndClientAccountNumberAndAccountTypeCode(Client client, String clientAccountNumber,String accountTypeCode);
   
    @Query("UPDATE ClientAccount c_acc1 SET c_acc1.displayBalance=(:newBalance) WHERE c_acc1.client.clientId=(:clientId) and c_acc1.clientAccountNumber=(:accountNumber)  ")
    ClientAccount saveBalance(Client client, String accountNumber, double newBalance);

}
