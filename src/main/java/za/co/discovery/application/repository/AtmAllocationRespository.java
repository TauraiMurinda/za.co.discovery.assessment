package za.co.discovery.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.discovery.application.entity.AtmAllocation;

@Repository
public interface AtmAllocationRespository  extends JpaRepository<AtmAllocation, Integer>{

}
