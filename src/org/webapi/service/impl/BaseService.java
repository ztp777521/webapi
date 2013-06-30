package org.webapi.service.impl;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Set;

import org.springside.modules.orm.Page;
import org.webapi.dao.BaseDao;
import org.webapi.service.ServiceSupport;
import org.webapi.utility.EnumType;
import org.webapi.utility.GenericsUtils;

/**
 * Service
 * 
 * @author liujx
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class BaseService<T> implements ServiceSupport<T> {

	// 操作类别
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	// 查找总数hql
	public final String FIND_COUNT = "select count(o) from "+ entityClass.getName() + " o";
	// 根据id查找对应的名称hql
	public static final String FIND_NAME = "select {0} from {1} o where {2} = ''{3,number,####}''";
	// 查找初始化代理对象hql
	public static final String INIT_OBJECT = "select o from {0} o where {1} = ''{2}''";

	private BaseDao<T> baseDao = null;

	
	// --   公用服务方法    -- //
	public void initBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	public void save(T t) {
		baseDao.save(t);
	}
	
	public void save(T[] t){
		for(T t1 : t)
			baseDao.save(t1);
	}

	public void delete(Integer i) {
		baseDao.delete(i);
	}
	
	public int batchExecute(Map<String, ?> values) {
		return baseDao.batchExecute(getUpdateHql(values));
	}

	public int batchExecute(final String hql,Object...values){
		return baseDao.batchExecute(hql, values);
	}
	
	public long countHqlResult(String hql, Object... values) {
		return baseDao.countHqlResult(hql, values);
	}

	public Page<T> findPage(Page<T> page, String hql, Object... values) {
		return baseDao.findPage(page, hql, values);
	}

	public Page<T> findPage(Page<T> page, Map<String, ?> values) {
		return baseDao.findPage(page, getQueryHql(values,page));
	}

	public T findUnique(final Map<String, ?> values) {
		return baseDao.findUnique(getQueryHql(values,null));
	}

	public T findUnique(final String hql, Object... values) {
		return baseDao.findUnique(hql, values);
	}
	
	public T findUniqueBy(final String propertyName,final Object value){
		return baseDao.findUniqueBy(propertyName, value);
	}

	public Object findProxyObject(Object... values) {
		return baseDao.findUnique(MessageFormat.format(INIT_OBJECT, values));
	}

	public T get(final String filedName, final Integer id) {
		return baseDao.findUniqueBy(filedName, id);
	}

	public Page<T> getAll(Page<T> page) {
		return baseDao.getAll(page);
	}

	public String findName(final Object... values) {
		String hql = MessageFormat.format(FIND_NAME, values);
		// System.out.println(hql);
		return (String) findUnique(hql);
	}
	
	
	// --    拼接hql    -- //

	// 创建查询的hql语句
	public String getQueryHql(Map<String, ?> values,Page<T> page) {
		StringBuffer hql_query = new StringBuffer("from "
				+ entityClass.getName() + " o where 1=1");
		if (values != null) {
			Set<String> keySet = values.keySet();
			Object[] objs = keySet.toArray();
			int size = objs.length;
			String key = "";
			String filed = "";// 字段
			String op = ""; // 查询操作符
			String where = ""; // 查询条件
			for (int i = 0; i < size; i++) {
				key = objs[i].toString();
				op = getOprate(key);
				filed = key.substring(0, key.length() - 2);
				if (op.equals("like")) {
					where = " and " + filed +" "+ op + " '%" + values.get(key) + "%'";
				} else if (op.equals("in")) {
					String[] params = (String[])values.get(key);
					StringBuffer condition = new StringBuffer();
					for(int j=0;j < params.length;j++){
						condition.append("'"+params[j]+"',");
					}
					where = " and " + filed + " " + op + " (" + condition.delete(condition.lastIndexOf(","),condition.length())
							+ ")";
				} else {
					where = " and " + filed + " " + op + " '" + values.get(key) + "'";
				}
				hql_query.append(where);
			}
		}
		if(page != null && page.getOrder() != null)
			hql_query.append(" order by "+page.getOrderBy() + " "+page.getOrder());
		return String.valueOf(hql_query);
	}

	// 创建修改的hql语句
	public String getUpdateHql(Map<String, ?> values) {
		StringBuffer hql_update = new StringBuffer("update from "
				+ entityClass.getName() + " set ");
		if (values != null && values.size() > 1) {
			Set<String> keySet = values.keySet();
			Object[] objs = keySet.toArray();
			int size = objs.length;
			String filed = "";
			// 下标从一开始 ，因为第一个值是where条件
			for (int i = 1; i < size; i++) {
				filed = objs[i].toString();
				hql_update.append(filed + "='" + values.get(filed) + "'");
				hql_update.append(",");
			}
			hql_update = hql_update.deleteCharAt(hql_update.lastIndexOf(","));
			// where 条件
			hql_update.append(" where " + objs[0] + "=" + values.get(objs[0]));
		}
		return String.valueOf(hql_update);
	}

	
	// --  操作符判断  -- //
	
	public String getOprate(String filed) {
		String opreate = "=";
		EnumType.Type stuff = null;
		// try{
		stuff = EnumType.Type.valueOf(filed.substring(filed.length() - 2));
		// }catch(Exception e){
		// }
		switch (stuff) {
		case LT:
			opreate = "<";
			break;
		case LE:
			opreate = "<=";
			break;
		case GT:
			opreate = ">";
			break;
		case GE:
			opreate = ">=";
			break;
		case IN:
			opreate = "in";
			break;
		case LK:
			opreate = "like";
			break;
		}
		return opreate;
	}

	public static void main(String[] args) {
		System.out.println(MessageFormat.format(FIND_NAME, new Object[]{"efg","abc","hij",1234234432}));
	}
	
}
