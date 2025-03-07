package com.maybank.assessment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maybank.assessment.model.AssessmentEntity;

@Repository
public interface AssessmentDao extends JpaRepository<AssessmentEntity, Long>, AssessmentDaoCustom {

	Optional<AssessmentEntity> findByName(String name);
	
}
