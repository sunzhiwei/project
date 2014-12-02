package com.gome.gmhx.dao.sysconfig;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gome.gmhx.entity.HxMenu;
import com.gome.gmhx.entity.HxRoleMenu;

@Repository("hxRoleMenuDao")
public interface HxRoleMenuDao {
	List<HxMenu> getMenuTree();

	List<HxMenu> getMenuTreeData(String roleId);

	void addRoleMenu(HxRoleMenu roleMenu);

	void deleteCompleteByRoleId(String roleId);
}
