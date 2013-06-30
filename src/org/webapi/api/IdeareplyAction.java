package org.webapi.api;

import javax.annotation.Resource;

import org.springside.modules.orm.Page;
import org.webapi.entry.Ideareply;
import org.webapi.service.IdeareplyService;

/**
 * 查询意见回复Action
 * @author jerry
 *
 */
public class IdeareplyAction extends BaseAction<Ideareply>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Ideareply ideareply = new Ideareply();
	public IdeareplyService ideareplyService = null;
	
	
	
	public IdeareplyService getIdeareplyService() {
		return ideareplyService;
	}

	@Resource
	public void setIdeareplyService(IdeareplyService ideareplyService) {
		this.ideareplyService = ideareplyService;
	}


	public Ideareply getIdeareply() {
		return ideareply;
	}


	public void setIdeareply(Ideareply ideareply) {
		this.ideareply = ideareply;
	}


	public Ideareply getModel() {
		return ideareply;
	}
	
	/**
	 * 查询意见回复列表
	 */
	public void findideareplylist()
	{
		String strpageno = this.getRequest().getParameter("pageNo");
		String strpagesize = this.getRequest().getParameter("pageSize");
		int pageNo = 1;
		int pageSize = 10;
		int ideaid = ideareply.getIdeaId();
		if(strpageno != null && !(strpageno.equals("")))
		{
			pageNo = Integer.parseInt(strpageno);
		}
		if(strpagesize != null && !(strpagesize.equals("")))
		{
			pageSize = Integer.parseInt(strpagesize);
		}
		try {
			Page<Ideareply> page = ideareplyService.findideareplylist(ideaid,pageNo,pageSize);
			setSuccessMessage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}

}