package za.co.discovery.application.service.util;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import za.co.discovery.application.entity.Denomination;
import za.co.discovery.application.repository.AtmAllocationRespository;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class NotesCalculatorImpl implements NotesCalculator {
	private AtmAllocationRespository  atmAllocationRespository;

	public Set<Denomination> getDenominations(int atm_id){
		return (TreeSet<Denomination>) atmAllocationRespository.getDenomination(atm_id);
	}
		
}
