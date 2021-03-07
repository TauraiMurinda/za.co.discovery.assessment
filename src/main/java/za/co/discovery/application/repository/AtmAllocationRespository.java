package za.co.discovery.application.repository;

import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import za.co.discovery.application.entity.AtmAllocation;
import za.co.discovery.application.entity.Denomination;

@Repository
public interface AtmAllocationRespository  extends JpaRepository<AtmAllocation, Integer>{
	
	
	//@Query("SELECT c_acc FROM Atm c_acc  WHERE c_acc.location=(:locattion)")
	@Query("SELECT atm_aloc FROM AtmAllocation atm_aloc,Atm atm where atm.location=(:location)")
	Set<AtmAllocation> findByAtmLocation(String location);
	
	@Query("SELECT atm_aloc FROM AtmAllocation atm_aloc,Atm atm where atm.atmId=(:atm_id)")
	Set<AtmAllocation> findByAtmID(int atm_id);
	
	@Query("SELECT dem FROM Denomination dem,Atm atm where atm.atmId=(:atm_id)")
	Set<Denomination>getDenomination(int atm_id);

}
