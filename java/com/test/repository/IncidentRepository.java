package com.test.repository;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

import com.test.entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Integer>
{
	List<Incident> findBySeverityAndIncidentDateBetween(String severity, LocalDate startDate, LocalDate endDate);
    boolean existsByTitle(String title);
	
}
