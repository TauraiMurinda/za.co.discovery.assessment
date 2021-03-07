package za.co.discovery.application.service.util;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Atm;
import za.co.discovery.application.entity.AtmAllocation;
import za.co.discovery.application.entity.Denomination;
import za.co.discovery.application.repository.AtmAllocationRespository;
import za.co.discovery.application.repository.AtmRepository;
import za.co.discovery.application.repository.DenominationRepository;



@Service
@Transactional
public class NotesCalculatorImpl implements NotesCalculator {

	
	AtmRepository  atmRepository;
	AtmAllocationRespository  atmAllocationRespository;
	DenominationRepository denominationRepository;
	
	Denomination denomination;
	Atm atm;
	AtmAllocation  AtmAllocation;
	
	@Autowired
	private NotesCalculatorImpl(AtmRepository atmRepository, AtmAllocationRespository atmAllocationRespository,
			DenominationRepository denominationRepository) {
		super();
		this.atmRepository = atmRepository;
		this.atmAllocationRespository = atmAllocationRespository;
		this.denominationRepository = denominationRepository;
	}

	public Set<Denomination> getDenominations(int atm_id){
		return (TreeSet<Denomination>) atmAllocationRespository.getDenomination(atm_id);
	}
		

}
