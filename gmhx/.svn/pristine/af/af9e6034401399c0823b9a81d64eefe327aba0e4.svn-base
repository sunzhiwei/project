package com.gome.gmhx.service.sysconfig.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.gmhx.dao.sysconfig.HxRoleMenuDao;
import com.gome.gmhx.entity.HxMenu;
import com.gome.gmhx.entity.HxRoleMenu;
import com.gome.gmhx.service.sysconfig.RoleMenuService;

@Service("roleMenuService")
public class HxRoleMenuServiceImpl implements RoleMenuService {
	@Resource
	private HxRoleMenuDao hxRoleMenuDao;
	
	@Override
	public List<HxMenu> getMenuTree() {
		return hxRoleMenuDao.getMenuTree();
	}
	
	@Override
	public List<HxMenu> getMenuTreeData(String roleId) {
		return hxRoleMenuDao.getMenuTreeData(roleId);
	}
	
	@Override
	public void addRoleMenu(HxRoleMenu roleMenu) {
		hxRoleMenuDao.addRoleMenu(roleMenu);
	}

	@Override
	public void deleteCompleteByRoleId(String roleId) {
		hxRoleMenuDao.deleteCompleteByRoleId(roleId);
	}

}
