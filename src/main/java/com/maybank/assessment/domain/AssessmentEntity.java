package com.maybank.assessment.domain;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
@Table(name = "assessment", schema = "maybank", catalog = "maybank")
public class AssessmentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for PostgreSQL
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "duration")
	private Long duration;
	
	@Column(name = "created_dt")
	private Instant createdDt;
	
	public AssessmentEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Instant getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Instant createdDt) {
		this.createdDt = createdDt;
	}
	
}
