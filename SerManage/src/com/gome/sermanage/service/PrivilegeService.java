package com.gome.sermanage.service;

import java.util.List;
import java.util.Map;

import com.gome.sermanage.entity.SerManage_Privilege;



public interface PrivilegeService {

    List<SerManage_Privilege> findByLevel(Integer menuid,Integer level) throws Exception;
    
    List<SerManage_Privilege> list(Map map) throws Exception;
}