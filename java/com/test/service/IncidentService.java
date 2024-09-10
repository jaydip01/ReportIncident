package com.test.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.test.entity.Incident;
import com.test.repository.IncidentRepository;

@Service
public class IncidentService
{

    @Autowired
    private IncidentRepository incidentRepository;

    private static final List<String> VALID_SEVERITY_LEVELS = List.of("Low", "Medium", "High");

    public Incident createIncident(Incident incident) {
        if (!VALID_SEVERITY_LEVELS.contains(incident.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity level");
        }
        if (incident.getIncidentDate().isAfter(LocalDate.now()) || incident.getIncidentDate().isBefore(LocalDate.now().minusDays(30))) {
            throw new IllegalArgumentException("Incident date must be within the last 30 days.");
        }
        if (incidentRepository.existsByTitle(incident.getTitle())) {
            throw new IllegalArgumentException("Incident title must be unique");
        }
        return incidentRepository.save(incident);
    }

    public Incident updateIncident(int id, Incident incidentUpdates) {
        Incident existingIncident = incidentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incident not found"));
        existingIncident.setStatus(incidentUpdates.getStatus());
        existingIncident.setNotes(incidentUpdates.getNotes());
        return incidentRepository.save(existingIncident);
    }

    public List<Incident> getAllIncidents(String severity, LocalDate startDate, LocalDate endDate) {
        if (severity != null) 
        {
            return incidentRepository.findBySeverityAndIncidentDateBetween(severity, startDate, endDate);
        }
        return incidentRepository.findAll();
    }

    public Incident getIncidentById(Integer id)
    {
        return incidentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incident not found"));
    }
}