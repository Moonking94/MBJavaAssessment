package com.maybank.assessment.dto.assessment;

import com.maybank.assessment.dto.AssessmentBean;

public class AssessmentReqBean {

	private AssessmentBean bean = new AssessmentBean();
	
	public AssessmentReqBean() {
	}

	public AssessmentBean getBean() {
		return bean;
	}

	public void setBean(AssessmentBean bean) {
		this.bean = bean;
	}

}
