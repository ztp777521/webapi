package org.webapi.service;

import java.util.Map;

import org.springside.modules.orm.Page;

public interface ServiceSupport<T> {
	/**
	 * 保存对象
	 * 
	 * @param t
	 * 
	 */
	public void save(T t);

	public void save(T[] t);

	/**
	 * 删除对象，通过主键
	 * 
	 * @param i
	 */
	public void delete(Integer i);

	/**
	 * 修改对象，通过hql语句
	 * 
	 * @param hql
	 */
	public int batchExecute(final Map<String, ?> values);

	public int batchExecute(final String hql, Object... values);

	/**
	 * 查找总数
	 * 
	 * @return
	 */
	public long countHqlResult(String hql, Object... values);

	/**
	 * 查找全部
	 * 
	 */
	public Page<T> getAll(Page<T> page);

	/**
	 * 通过主键查找对象
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	public T get(final String filedName, final Integer id);

	
	public T findUniqueBy(final String property,final Object obj);
	
	/**
	 * 根据hql语句查找
	 * 
	 * @param page
	 * @param hql
	 * @param values
	 *            参数
	 * @return
	 */
	public Page<T> findPage(final Page<T> page, String hql,
			final Object... values);

	public Page<T> findPage(final Page<T> page, final Map<String, ?> values);

	public T findUnique(final Map<String, ?> values);

	public void initObject();

	/**
	 * 实例代理对象
	 */
	public Object findProxyObject(Object... values);

	/**
	 * 查找指定ID的名称 必须执行四个个参数
	 * (对应类的名称字段，查找名字对应的Class  , 该类主键字段，主键字段的值) 
	 * @param name
	 * @param values
	 * @return
	 */
	public String findName(final Object... values);
}
