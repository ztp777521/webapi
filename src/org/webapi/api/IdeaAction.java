package org.webapi.api;

import java.util.Date;

import javax.annotation.Resource;

import org.springside.modules.orm.Page;
import org.webapi.entry.Idea;
import org.webapi.service.IdeaService;

/**
 * 意见信息Action
 * @author 
 *
 */
public class IdeaAction extends BaseAction<Idea>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Idea idea = new Idea();
	public IdeaService ideaService = null;
	

	public IdeaService getIdeaService() {
		return ideaService;
	}

	@Resource
	public void setIdeaService(IdeaService ideaService) {
		this.ideaService = ideaService;
	}


	public Idea getIdea() {
		return idea;
	}


	public void setIdea(Idea idea) {
		this.idea = idea;
	}


	public Idea getModel() {
		return idea;
	}

	/**
	 * 查询意见列表
	 */
	public void findidealist()
	{
		String strpageno = this.getRequest().getParameter("pageNo");
		String strpagesize = this.getRequest().getParameter("pageSize");
		try {
			int pageNo = 1;
			int pageSize = 10;
			int ispublic = -1;
			if(idea.getIspublic() != null && idea.getIspublic() > -1)
			{
				ispublic = idea.getIspublic();
			}
			if(strpageno != null && !(strpageno.equals("")))
			{
				pageNo = Integer.parseInt(strpageno);
			}
			if(strpagesize != null && !(strpagesize.equals("")))
			{
				pageSize = Integer.parseInt(strpagesize);
			}
			int userid = Integer.parseInt(idea.getUserId());
			Page<Idea> page = ideaService.findidealist(userid,ispublic, pageNo,  pageSize);
			setSuccessMessage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 提交意见
	 */
	public void addremark()
	{
		try {
			Date date = new Date() ;
			System.out.println(date);
			idea.setCommitDate(new Date());
			idea.setIspublic(0);
			idea.setIsreply(0);
			Boolean fals = ideaService.addremark(idea);
			if(fals)
				setSuccessMessage("OK");
			else
				setSuccessMessage("NO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
}
