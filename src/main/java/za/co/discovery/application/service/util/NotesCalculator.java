package za.co.discovery.application.service.util;

import java.util.Set;

import za.co.discovery.application.entity.Denomination;

public interface NotesCalculator {
		
	Set<Denomination>getDenominations(int atm_id);

}
