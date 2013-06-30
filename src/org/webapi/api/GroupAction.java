package org.webapi.api;

import javax.annotation.Resource;

import org.springside.modules.orm.Page;
import org.webapi.entry.Group;
import org.webapi.service.GroupService;

public class GroupAction extends BaseAction<Group>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Group group = new Group();
	private GroupService groupService = null;

	public GroupService getGroupService() {
		return groupService;
	}

	@Resource
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Group getModel() {
		return group;
	}
	
	 /**
	  * 申请创建活动群
	  */
	public void addgroup()
	{
		try {
			group.setGroupState(0);
			Boolean fals = groupService.addgroup(group);
			if(fals)
				setSuccessMessage("OK");
			else
				setSuccessMessage("NO");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 查询关注的群列表
	 */
	public void findgroup()
	{
		int pageNo = 1;
		int pageSize = 10;
		try {
			Page<Group> page = groupService.findgrouplist(group.getApplyUserid(),pageNo, pageSize);
			setSuccessMessage(page);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
}
