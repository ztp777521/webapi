package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.ShopserviceDao;
import org.webapi.entry.Shopservice;
import org.webapi.service.ShopserviceService;

@Service
public class ShopserviceServiceImpl extends BaseService<Shopservice> implements ShopserviceService{

	public ShopserviceDao shopserviceDao = null;
	
	public ShopserviceDao getShopserviceDao() {
		return shopserviceDao;
	}

	@Resource
	public void setShopserviceDao(ShopserviceDao shopserviceDao) {
		this.shopserviceDao = shopserviceDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(shopserviceDao);
	}

	/**
	 * 发布服务
	 */
	public Boolean addshopservice(Shopservice shopservicetow) throws Exception {
		try {
			this.save(shopservicetow);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查看服务信息
	 */
	public Page<Shopservice> findshopservice(int pageNo,int pageSize) throws Exception {
		Page<Shopservice> page = new Page<Shopservice>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String, Object> values = new HashMap<String, Object>();
		this.findPage(page, values);
		return page;
	}

}
