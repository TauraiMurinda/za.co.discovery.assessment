package za.co.discovery.application.repository;

import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.discovery.application.entity.Atm;

public interface AtmRepository extends JpaRepository<Atm, Integer> {
	
//	int getAtm(String location);
//	Set<Integer>getAtmallocations(int atm_id);
//	Set<String>getDenominations(Set<Integer> atmAllocation,Map<Integer,String> denominationtypes);
//	Map<Integer,String>getDenominationTypes(int atm_id,Set<String> denominations);
	
}
