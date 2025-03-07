package com.maybank.assessment.model;

import java.time.Instant;

import com.maybank.assessment.dto.AssessmentBean;

import jakarta.persistence.*;

@Entity
@Table(name = "assessment", schema = "maybank", catalog = "maybank")
public class AssessmentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for PostgreSQL
	@Column(name = "id")
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "duration")
	private Integer duration;
	
	@Column(name = "created_dt")
	private Instant createdDt;
	
	@Column(name = "modified_dt")
	private Instant modifiedDt;
	
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
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

	public void toEntity(AssessmentBean bean) {
		this.id = bean.getId();
		this.name = bean.getName();
		this.duration = bean.getDuration();
		this.createdDt = bean.getCreatedDt();
		this.modifiedDt = bean.getModifiedDt();
	}
}
