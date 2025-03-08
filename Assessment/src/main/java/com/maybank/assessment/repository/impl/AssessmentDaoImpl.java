package com.maybank.assessment.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maybank.assessment.dto.AssessmentBean;
import com.maybank.assessment.dto.assessment.AssessmentReqBean;
import com.maybank.assessment.dto.assessment.AssessmentRespBean;
import com.maybank.assessment.dto.assessment.AssessmentSearchBean;
import com.maybank.assessment.model.AssessmentEntity;
import com.maybank.assessment.repository.AbstractDao;
import com.maybank.assessment.repository.AssessmentDaoCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AssessmentDaoImpl extends AbstractDao implements AssessmentDaoCustom {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentDaoImpl.class);
	
	@PersistenceContext
	protected EntityManager em;
	
	public AssessmentDaoImpl() {
	}
	
	@Override
    public AssessmentRespBean search(AssessmentReqBean wsReqBean) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AssessmentBean> query = cb.createQuery(AssessmentBean.class);
        Root<AssessmentEntity> root = query.from(AssessmentEntity.class);

        List<Predicate> predicates = buildPredicates(cb, root, wsReqBean.getSearchBean());

        query.select(cb.construct(
                AssessmentBean.class,
                root.get("id"),
                root.get("email"),
                root.get("name"),
                root.get("age"),
                root.get("address"),
                root.get("city"),
                root.get("postcode"),
                root.get("stateId"),
                root.get("status"),
                root.get("createdDt"),
                root.get("modifiedDt")
        )).where(predicates.toArray(new Predicate[0]));

        TypedQuery<AssessmentBean> typedQuery = em.createQuery(query);
        
        // Pagination
        Integer pageNumber = wsReqBean.getSearchBean().getPageNumber() != null ? wsReqBean.getSearchBean().getPageNumber() : 0;
        Integer rowPerPage = wsReqBean.getSearchBean().getRowPerPage() != null ? wsReqBean.getSearchBean().getRowPerPage() : 10;
        typedQuery.setFirstResult(pageNumber * rowPerPage);
        typedQuery.setMaxResults(rowPerPage);

        List<AssessmentBean> resultList = typedQuery.getResultList();
        
        AssessmentRespBean responseData = new AssessmentRespBean();
        responseData.setSearchResults(resultList);
        responseData.setTotalCount(searchCount(wsReqBean).orElse(0L));
        
        return responseData;
    }
	
    private Optional<Long> searchCount(AssessmentReqBean wsReqBean) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<AssessmentEntity> root = countQuery.from(AssessmentEntity.class);

        List<Predicate> predicates = buildPredicates(cb, root, wsReqBean.getSearchBean());

        countQuery.select(cb.count(root)).where(predicates.toArray(new Predicate[0]));
        Long totalCount = em.createQuery(countQuery).getSingleResult();
        return Optional.of(totalCount);
    }
	
	private List<Predicate> buildPredicates(CriteriaBuilder cb, Root<AssessmentEntity> root, AssessmentSearchBean searchParam) {
        List<Predicate> predicates = new ArrayList<>();

        if (searchParam.getParameterBean().getEmail() != null) {
            predicates.add(cb.like(cb.lower(root.get("email")), "%" + searchParam.getParameterBean().getEmail().toLowerCase() + "%"));
        }
        if (searchParam.getParameterBean().getName() != null) {
            predicates.add(cb.like(cb.lower(root.get("name")), "%" + searchParam.getParameterBean().getName().toLowerCase() + "%"));
        }
        if (searchParam.getParameterBean().getAge() != null) {
            predicates.add(cb.equal(root.get("age"), searchParam.getParameterBean().getAge()));
        }
        if (searchParam.getParameterBean().getAddress() != null) {
            predicates.add(cb.like(cb.lower(root.get("address")), "%" + searchParam.getParameterBean().getAddress().toLowerCase() + "%"));
        }
        if (searchParam.getParameterBean().getCity() != null) {
            predicates.add(cb.like(cb.lower(root.get("city")), "%" + searchParam.getParameterBean().getCity().toLowerCase() + "%"));
        }
        if (searchParam.getParameterBean().getPostcode() != null) {
            predicates.add(cb.equal(root.get("postcode"), searchParam.getParameterBean().getPostcode()));
        }
        if (searchParam.getParameterBean().getStateId() != null) {
            predicates.add(cb.equal(root.get("stateId"), searchParam.getParameterBean().getStateId()));
        }
        if (searchParam.getParameterBean().getStatus() != null) {
            predicates.add(cb.equal(root.get("status"), searchParam.getParameterBean().getStatus()));
        }
        if (searchParam.getParameterBean().getCreatedDt() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("createdDt"), searchParam.getParameterBean().getCreatedDt()));
        }
        if (searchParam.getParameterBean().getModifiedDt() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("modifiedDt"), searchParam.getParameterBean().getModifiedDt()));
        }

        return predicates;
    }
}
