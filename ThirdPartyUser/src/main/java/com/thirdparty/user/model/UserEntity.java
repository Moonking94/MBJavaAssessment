package com.thirdparty.user.model;

import java.time.LocalDateTime;

import com.thirdparty.user.dto.UserBean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "user", schema = "thirdparty", catalog = "thirdparty")
public class UserEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for PostgreSQL
	@Column(name = "id")
    private Long id;
	
	@Column(name = "email", length = 255, unique = true)
	private String email;
	
	@Column(name = "name", length = 150)
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "status", length = 1)
	private Character status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_dt")
	private LocalDateTime createdDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_dt")
	private LocalDateTime modifiedDt;
	
	public UserEntity() {
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

	public void toEntity(UserBean bean) {
		this.id = bean.getId();
		this.name = bean.getName();
		this.email = bean.getEmail();
		this.age = bean.getAge();
		this.status = bean.getStatus();
		this.createdDt = bean.getCreatedDt();
		this.modifiedDt = bean.getModifiedDt();
	}
}
