package com.gome.sermanage.util;

import java.util.Comparator;

import com.gome.sermanage.entity.SerManage_Privilege;


public class ComparatorImpl implements Comparator<SerManage_Privilege>{
	
	@Override
	public int compare(SerManage_Privilege o1, SerManage_Privilege o2) {
		if(o1.getSubsequence()>o2.getSubsequence())return 1;
		else if(o1.getSubsequence()<o2.getSubsequence())return -1;
		else if(o1.getSubsequence()==o2.getSubsequence())return 0;
		return 0;
	}

}
