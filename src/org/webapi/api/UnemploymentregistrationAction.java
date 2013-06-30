package org.webapi.api;

import java.util.Date;

import javax.annotation.Resource;

import org.springside.modules.orm.Page;
import org.webapi.entry.Unemploymentregistration;
import org.webapi.entry.Unemploymentreply;
import org.webapi.service.UnemploymentregistrationService;
import org.webapi.service.UnemploymentreplyService;

public class UnemploymentregistrationAction extends BaseAction<Unemploymentregistration>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Unemploymentregistration unemploymentregistration = new Unemploymentregistration();
	private UnemploymentregistrationService unemploymentregistrationService = null;
	private UnemploymentreplyService unemploymentreplyService = null;
	
	
	public UnemploymentreplyService getUnemploymentreplyService() {
		return unemploymentreplyService;
	}

	@Resource
	public void setUnemploymentreplyService(
			UnemploymentreplyService unemploymentreplyService) {
		this.unemploymentreplyService = unemploymentreplyService;
	}

	public UnemploymentregistrationService getUnemploymentregistrationService() {
		return unemploymentregistrationService;
	}

	@Resource
	public void setUnemploymentregistrationService(
			UnemploymentregistrationService unemploymentregistrationService) {
		this.unemploymentregistrationService = unemploymentregistrationService;
	}

	public Unemploymentregistration getUnemploymentregistration() {
		return unemploymentregistration;
	}

	public void setUnemploymentregistration(
			Unemploymentregistration unemploymentregistration) {
		this.unemploymentregistration = unemploymentregistration;
	}


	public Unemploymentregistration getModel() {
		return unemploymentregistration;
	}
	
	/**
	 * 失业登记
	 */
	public void  addunemploymentregistration()
	{
		try {
			unemploymentregistration.setEmpState(0);
			unemploymentregistration.setCommitDate(new Date());
			unemploymentregistration.setUnempTime(new Date());
			
			Boolean fals = unemploymentregistrationService.addunemploymentregistration(unemploymentregistration);
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
	 * 查询失业登记信息
	 */
	public void findunempregrep()
	{
		String struserid = this.getRequest().getParameter("userid");
		String strpageno = this.getRequest().getParameter("pageNo");
		String strpagesize = this.getRequest().getParameter("pageSize");
		int userid = -1;
		int pageNo = 1;
		int pageSize = 10;
		if(strpageno == null || !(strpageno.equals("")))
			pageNo = Integer.parseInt(strpageno);
		if(strpagesize == null || !(strpagesize.equals("")))
			pageSize = Integer.parseInt(strpagesize);
		if(struserid != null && !(struserid.equals("")))
			userid = Integer.parseInt(struserid);
		try {
			Page<Unemploymentregistration> unempage = unemploymentregistrationService.findunempregreplist(userid,pageNo,pageSize);
			setSuccessMessage(unempage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 根据失业登记id查询回复信息
	 */
	public void getreplylist()
	{
		String struserid = this.getRequest().getParameter("userid");
		int userid = -1;
		int pageno = 1;
		int pagesize = 10;
		if(struserid == null || !(struserid.equals("")))
			userid = Integer.parseInt(struserid);
		try {
			Page<Unemploymentreply> page = unemploymentreplyService.getreplylist(userid,pageno,pagesize);
			setSuccessMessage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
}
