package com.gome.gmhx.service.common;

public interface MachineReviewService {
	
	public String barCodeVerification(String machineModeCode,String barCode);
	
	public String machineRecevie(String serviceId);

}
