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

    Optional<ClientAccount> findById(String clientAccountNumber);
    
    @Query("SELECT c_acc FROM ClientAccount c_acc  WHERE c_acc.clientAccountNumber=(:clientAccountNumber) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientAccountNumberAndAccountTypeCode(String clientAccountNumber, String accountTypeCode);
   
    @Query("SELECT c_acc FROM ClientAccount c_acc  WHERE c_acc.clientAccountNumber=(:client) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientAndAccountTypeCode(Client client, String accountTypeCode);

    @Query("SELECT c_acc FROM ClientAccount c_acc  WHERE c_acc.clientAccountNumber=(:client) AND c_acc.accountTypeCode= (:accountTypeCode)")
	List<ClientAccount> findByClientAndClientAccountNumberAndAccountTypeCode(Client client, String clientAccountNumber,String accountTypeCode);

	List<ClientAccount> findByClient(Client client);

}
