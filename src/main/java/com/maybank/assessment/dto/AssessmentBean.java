package com.maybank.assessment.dto;

import java.time.LocalDateTime;

import com.maybank.assessment.model.AssessmentEntity;

public class AssessmentBean {

	private Long id;

	private String email;
	
	private String name;
	
	private Integer age;
	
	private String address;
	
	private String city;
	
	private String postcode;
	
	private Integer stateId;
	
	private Character status;
	
	private LocalDateTime createdDt;
	
	private LocalDateTime modifiedDt;
	
	public AssessmentBean() {
	}

	public AssessmentBean(Long id, String email, String name, Integer age, String address, String city, String postcode, Integer stateId, Character status, LocalDateTime createdDt, LocalDateTime modifiedDt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.stateId = stateId;
        this.status = status;
        this.createdDt = createdDt;
        this.modifiedDt = modifiedDt;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void toBean(AssessmentEntity entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.name = entity.getName();
		this.age = entity.getAge();
		this.address = entity.getAddress();
		this.city = entity.getCity();
		this.postcode = entity.getPostcode();
		this.stateId = entity.getStateId();
		this.status = entity.getStatus();
		this.createdDt = entity.getCreatedDt();
		this.modifiedDt = entity.getModifiedDt();
	}
	
}
