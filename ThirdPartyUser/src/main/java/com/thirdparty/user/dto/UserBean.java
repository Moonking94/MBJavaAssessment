package com.thirdparty.user.dto;

import java.time.LocalDateTime;

import com.thirdparty.user.model.UserEntity;

public class UserBean {

	private Long id;

	private String email;
	
	private String name;
	
	private Integer age;
	
	private Character status;
	
	private LocalDateTime createdDt;
	
	private LocalDateTime modifiedDt;
	
	public UserBean() {
	}
	
	public UserBean(Long id, String email, String name, Integer age, Character status, LocalDateTime createdDt, LocalDateTime modifiedDt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
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
	
	public void toBean(UserEntity entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.name = entity.getName();
		this.age = entity.getAge();
		this.status = entity.getStatus();
		this.createdDt = entity.getCreatedDt();
		this.modifiedDt = entity.getModifiedDt();
	}
}
