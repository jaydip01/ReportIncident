package com.test.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Incident {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

   
	 @Column(unique = true, nullable = false)
	 private String title;

	    @Column(nullable = false)
	    private String description;

	    @Column(nullable = false)
	    private String severity;

	    @Column(nullable = false)
	    private LocalDate incidentDate;

	    private String status;
	    private String notes;

}
