package com.test.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import com.test.entity.Incident;
import com.test.service.IncidentService;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController 
{
	 @Autowired
	    private IncidentService incidentService;

	    @PostMapping
	    public Incident createIncident(@RequestBody Incident incident) {
	        return incidentService.createIncident(incident);
	    }

	    @PutMapping("/{id}")
	    public Incident updateIncident(@PathVariable Integer id, @RequestBody Incident incident) {
	        return incidentService.updateIncident(id, incident);
	    }

	    @GetMapping
	    public List<Incident> getAllIncidents(@RequestParam(required = false) String severity,
	                                          @RequestParam(required = false) LocalDate startDate,
	                                          @RequestParam(required = false) LocalDate endDate) {
	        return incidentService.getAllIncidents(severity, startDate, endDate);
	    }

	    @GetMapping("/{id}")
	    public Incident getIncidentById(@PathVariable Integer id) {
	        return incidentService.getIncidentById(id);
	    }


}
