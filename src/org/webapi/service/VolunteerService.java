package org.webapi.service;

import org.webapi.entry.Volunteer;

public interface VolunteerService extends ServiceSupport<Volunteer>{

	/**
	 * 申请格长
	 * @param volunteer
	 * @return
	 * @throws Exception
	 */
	public Boolean addvolunteer(Volunteer volunteer)throws Exception;

}
