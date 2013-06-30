package org.webapi.api;

import javax.annotation.Resource;

import org.springside.modules.orm.Page;
import org.webapi.entry.Activity;
import org.webapi.service.ActivityService;

public class ActivityAction extends BaseAction<Activity>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Activity activity = new Activity();
	private ActivityService activityService = null;
	
	public ActivityService getActivityService() {
		return activityService;
	}

	@Resource
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Activity getModel() {
		return activity;
	}
	
	/**
	 * 发布活动
	 */
	public void addactivity()
	{
		try {
			activity.setActivityState(0);
			Boolean fals = activityService.addactivty(activity);
			if(fals)
				setSuccessMessage("OK");
			else
				setSuccessMessage("NO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 查询未过期的活动列表
	 */
	public void findactivitylist()
	{
		String struserid = this.getRequest().getParameter("userid");
		String strpageNo = this.getRequest().getParameter("pageNo");
		String strpageSize = this.getRequest().getParameter("pageSize");
		int userid = -1;
		int pageNo = 1;
		int pageSize = 10;
		if(strpageNo != null && !(strpageNo.equals("")))
			pageNo = Integer.parseInt(strpageNo);
		
		if(strpageSize != null && !(strpageSize.equals("")))
			pageSize = Integer.parseInt(strpageSize);
		
		if(struserid != null && !(struserid.equals("")))
			userid = Integer.parseInt(struserid);
		try {
			Page<Activity> page = activityService.findactivitylist(userid,pageNo,pageSize);
			setSuccessMessage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
}