package za.co.discovery.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*Find the transactional account per client with the highest balance
*/
@Service
@Transactional(readOnly=true)
public class TransactionalAccountHighestBalanceReportingService {
        
}
