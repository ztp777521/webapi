package org.webapi.dao;

import java.util.List;
import java.util.Map;

import org.springside.modules.orm.Page;

/**
 * 数据访问接口
 * 
 * @author
 * 
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 保存对象
	 * 
	 * @param t
	 * 
	 */
	public void save(T t);

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
	public int batchExecute(final String hql,final Object... params);
	
	public int batchExecute(final String hql,final Map<String,?> values);

	/**
	 * 查找总数
	 * 
	 * @return
	 */
	public long countHqlResult(String hql, Object... values);
	
	//public long countHqlResult(String hql, Map<String,?> values);

	/**
	 * 查找全部
	 * 
	 */
	public Page<T> getAll(Page<T> page);

	/**
	 * 通过主键查找对象 返回的只是一个代理
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	public T get(Integer id);

	public T findUniqueBy(final String propertyName, final Object value) ;
	
	/**
	 * 根据hql语句查找
	 * 
	 * @param page
	 * @param hql
	 * @param values
	 *            参数
	 * @return
	 */
	public Page<T> findPage(final Page<T> page, final String hql, final Object... values);
	
	public Page<T> findPage(final Page<T> page, final String hql, final Map<String,?> values);
	
	public <X> X findUnique(final String hql, final Map<String, ?> values) ;
	
	public <X> X findUnique(final String hql, final Object ... values);
	
	public <X> List<X> find(final String hql, final Object... values);
	
    // public T findUniqueBy(final String property,final Object values);

}
