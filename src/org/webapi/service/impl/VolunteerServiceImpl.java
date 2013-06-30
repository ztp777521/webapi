package org.webapi.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.webapi.dao.VolunteerDao;
import org.webapi.entry.Volunteer;
import org.webapi.service.VolunteerService;

@Service
public class VolunteerServiceImpl extends BaseService<Volunteer> implements VolunteerService{

	public VolunteerDao volunteerDao = null;
	
	
	public VolunteerDao getVolunteerDao() {
		return volunteerDao;
	}

	@Resource
	public void setVolunteerDao(VolunteerDao volunteerDao) {
		this.volunteerDao = volunteerDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(volunteerDao);
	}


	/**
	 * 申请网格格长
	 */
	public Boolean addvolunteer(Volunteer volunteer) throws Exception {
		try {
			this.save(volunteer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
