package com.maybank.assessment.dto;

import java.time.Instant;

import com.maybank.assessment.model.AssessmentEntity;

public class AssessmentBean {

	private Long id;
	
	private String name;
	
	private Integer duration;
	
	private Character status;
	
	private Instant createdDt;
	
	private Instant modifiedDt;
	
	public AssessmentBean() {
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Instant getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Instant createdDt) {
		this.createdDt = createdDt;
	}

	public Instant getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(Instant modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	public void toBean(AssessmentEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.duration = entity.getDuration();
		this.status = entity.getStatus();
		this.createdDt = entity.getCreatedDt();
		this.modifiedDt = entity.getModifiedDt();
	}
	
}
