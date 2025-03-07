package com.maybank.assessment.dto.assessment;

import java.util.List;

import com.maybank.assessment.dto.AssessmentBean;

public class AssessmentRespBean {

	private AssessmentSearchBean searchBean = new AssessmentSearchBean();
	
	private AssessmentBean bean = new AssessmentBean();
	
	private List<AssessmentBean> searchResults;
	
	public AssessmentRespBean() {
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
	
}
