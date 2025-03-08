package com.maybank.assessment.dto.assessment;

import com.maybank.assessment.dto.AssessmentBean;

public class AssessmentReqBean {

	private AssessmentSearchBean searchBean = new AssessmentSearchBean();
	
	private AssessmentBean bean = new AssessmentBean();
	
	public AssessmentReqBean() {
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

}
