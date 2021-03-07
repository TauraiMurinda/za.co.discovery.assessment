package za.co.discovery.application.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.discovery.application.entity.Atm;

public interface AtmRepository extends JpaRepository<Atm, Integer> {
		Atm findByLocation(String location);
	
}
