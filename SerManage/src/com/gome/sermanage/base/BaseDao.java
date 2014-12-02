package com.gome.sermanage.base;

import java.util.List;


public interface BaseDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @throws Exception 
	 */
	Object save(Object entity) throws Exception;
	
	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Object obj) throws Exception;

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	T update(T entity) throws Exception;

	/**
	 * 查询实体，如果id为null，则返回null，并不会抛异常�?
	 * 
	 * @param id
	 * @return
	 */
	T getById(Long id) throws Exception;

	/**
	 * 查询实体
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids) throws Exception;

	/**
	 * 查询�?��
	 * 
	 * @return
	 */
	List<T> findAll() throws Exception;

}
