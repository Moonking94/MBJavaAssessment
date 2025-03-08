package com.thirdparty.user.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thirdparty.user.dto.UserBean;
import com.thirdparty.user.dto.user.UserReqBean;
import com.thirdparty.user.dto.user.UserRespBean;
import com.thirdparty.user.dto.user.UserSearchBean;
import com.thirdparty.user.model.UserEntity;
import com.thirdparty.user.repository.AbstractDao;
import com.thirdparty.user.repository.UserDaoCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UserDaoImpl extends AbstractDao implements UserDaoCustom {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@PersistenceContext
	protected EntityManager em;
	
	public UserDaoImpl() {
	}
	
	@Override
    public UserRespBean search(UserReqBean wsReqBean) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserBean> query = cb.createQuery(UserBean.class);
        Root<UserEntity> root = query.from(UserEntity.class);

        List<Predicate> predicates = buildPredicates(cb, root, wsReqBean.getSearchBean());

        query.select(cb.construct(
                UserBean.class,
                root.get("id"),
                root.get("email"),
                root.get("name"),
                root.get("age"),
                root.get("status"),
                root.get("createdDt"),
                root.get("modifiedDt")
        )).where(predicates.toArray(new Predicate[0]));

        TypedQuery<UserBean> typedQuery = em.createQuery(query);
        
        // Pagination
        Integer pageNumber = wsReqBean.getSearchBean().getPageNumber() != null ? wsReqBean.getSearchBean().getPageNumber() : 0;
        Integer rowPerPage = wsReqBean.getSearchBean().getRowPerPage() != null ? wsReqBean.getSearchBean().getRowPerPage() : 10;
        typedQuery.setFirstResult(pageNumber * rowPerPage);
        typedQuery.setMaxResults(rowPerPage);

        List<UserBean> resultList = typedQuery.getResultList();
        
        UserRespBean responseData = new UserRespBean();
        responseData.setSearchResults(resultList);
        responseData.setTotalCount(searchCount(wsReqBean).orElse(0L));
        
        return responseData;
    }
	
    private Optional<Long> searchCount(UserReqBean wsReqBean) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<UserEntity> root = countQuery.from(UserEntity.class);

        List<Predicate> predicates = buildPredicates(cb, root, wsReqBean.getSearchBean());

        countQuery.select(cb.count(root)).where(predicates.toArray(new Predicate[0]));
        Long totalCount = em.createQuery(countQuery).getSingleResult();
        return Optional.of(totalCount);
    }
	
	private List<Predicate> buildPredicates(CriteriaBuilder cb, Root<UserEntity> root, UserSearchBean searchParam) {
        List<Predicate> predicates = new ArrayList<>();

        if (searchParam.getParameterBean().getName() != null) {
            predicates.add(cb.like(cb.lower(root.get("name")), "%" + searchParam.getParameterBean().getName().toLowerCase() + "%"));
        }
        if (searchParam.getParameterBean().getAge() != null) {
            predicates.add(cb.equal(root.get("age"), searchParam.getParameterBean().getAge()));
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
