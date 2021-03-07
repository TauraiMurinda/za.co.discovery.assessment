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

    List<ClientAccount> findByClientId(int clientId);
    
    @Query("SELECT c_acc FROM ClientAccount c_acc  WHERE c_acc.clientAccountNumber=(:clientAccountNumber) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientAccountNumberAndAccountTypeCode(String clientAccountNumber, String accountTypeCode);
   
    @Query("SELECT c_acc FROM ClientAccount c_acc  WHERE c_acc.clientAccountNumber=(:clientId) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientIdAndAccountTypeCode(int clientId, String accountTypeCode);

    @Query("SELECT c_acc FROM ClientAccount c_acc,Client clynt  WHERE clynt.clientId=(:clientId) and c_acc.clientAccountNumber=(:clientAccountNumber) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientIdAndClientAccountNumberAndAccountTypeCode(int clientId, String clientAccountNumber,String accountTypeCode);

}
