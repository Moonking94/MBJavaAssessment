package com.maybank.assessment.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AbstractDao {

	private static final Logger Log = LoggerFactory.getLogger(AbstractDao.class);
	
	@PersistenceContext
	protected EntityManager em;

	public AbstractDao() {
	}
	
	public void clearEntityManagerCache() {
		em.clear();
	}
	
}
