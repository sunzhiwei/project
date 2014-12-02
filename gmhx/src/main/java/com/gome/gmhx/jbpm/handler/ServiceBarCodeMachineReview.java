package com.gome.gmhx.jbpm.handler;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class ServiceBarCodeMachineReview implements DecisionHandler {

	@Override
	public String decide(OpenExecution execution) {
		return "T2";
	}

}
