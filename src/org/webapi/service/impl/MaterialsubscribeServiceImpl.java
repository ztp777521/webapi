package org.webapi.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.webapi.dao.MaterialsubscribeDao;
import org.webapi.entry.Materialsubscribe;
import org.webapi.service.MaterialsubscribeService;

@Service
public class MaterialsubscribeServiceImpl extends BaseService<Materialsubscribe> implements MaterialsubscribeService{

	public MaterialsubscribeDao materialsubscribeDao = null;
	
	public MaterialsubscribeDao getMaterialsubscribeDao() {
		return materialsubscribeDao;
	}

	@Resource
	public void setMaterialsubscribeDao(MaterialsubscribeDao materialsubscribeDao) {
		this.materialsubscribeDao = materialsubscribeDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(materialsubscribeDao);
	}

}
