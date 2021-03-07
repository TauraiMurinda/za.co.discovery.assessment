package za.co.discovery.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.discovery.application.entity.Denomination;

public interface DenominationRepository extends JpaRepository<Denomination, Integer> {

}
