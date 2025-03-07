package com.maybank.assessment.dto.assessment;

import com.maybank.assessment.dto.AssessmentBean;
import com.maybank.assessment.dto.CommonSearchBean;

public class AssessmentSearchBean extends CommonSearchBean {

	private AssessmentBean parameterBean = new AssessmentBean();
	
	public AssessmentSearchBean() {
	}

	public AssessmentBean getParameterBean() {
		return parameterBean;
	}

	public void setParameterBean(AssessmentBean parameterBean) {
		this.parameterBean = parameterBean;
	}
	
}
