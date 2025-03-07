package com.maybank.assessment.dto.assessment;

import java.util.List;

import com.maybank.assessment.dto.AssessmentBean;

public class AssessmentRespBean {

	private AssessmentSearchBean searchBean = new AssessmentSearchBean();
	
	private AssessmentBean bean = new AssessmentBean();
	
	private List<AssessmentBean> searchResults;
	
	private Long totalCount;
	
	public AssessmentRespBean() {
	}

	public AssessmentSearchBean getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(AssessmentSearchBean searchBean) {
		this.searchBean = searchBean;
	}

	public AssessmentBean getBean() {
		return bean;
	}

	public void setBean(AssessmentBean bean) {
		this.bean = bean;
	}

	public List<AssessmentBean> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<AssessmentBean> searchResults) {
		this.searchResults = searchResults;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	
}
