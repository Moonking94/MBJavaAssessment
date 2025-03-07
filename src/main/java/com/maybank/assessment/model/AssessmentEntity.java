package com.maybank.assessment.model;

import java.time.LocalDateTime;

import com.maybank.assessment.dto.AssessmentBean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "assessment", schema = "maybank", catalog = "maybank")
public class AssessmentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for PostgreSQL
	@Column(name = "id")
    private Long id;
	
	@Column(name = "name", length = 150)
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "state_id")
	private Integer stateId;
	
	@Column(name = "status", length = 1)
	private Character status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_dt")
	private LocalDateTime createdDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_dt")
	private LocalDateTime modifiedDt;
	
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}

	public LocalDateTime getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(LocalDateTime modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	public void toEntity(AssessmentBean bean) {
		this.id = bean.getId();
		this.name = bean.getName();
		this.age = bean.getAge();
		this.address = bean.getAddress();
		this.city = bean.getCity();
		this.postcode = bean.getPostcode();
		this.stateId = bean.getStateId();
		this.status = bean.getStatus();
		this.createdDt = bean.getCreatedDt();
		this.modifiedDt = bean.getModifiedDt();
	}
}
