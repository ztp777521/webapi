package org.webapi.api;

import javax.annotation.Resource;

import org.springside.modules.orm.Page;
import org.webapi.entry.Integratematerial;
import org.webapi.service.IntegratematerialService;

/**
 * 资料信息Action
 * @author jerry
 *
 */
public class IntegratematerialAction extends BaseAction<Integratematerial>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IntegratematerialService integratematerialService = null;
	public Integratematerial integratematerial = new Integratematerial();
	
	
	public IntegratematerialService getIntegratematerialService() {
		return integratematerialService;
	}

	@Resource
	public void setIntegratematerialService(
			IntegratematerialService integratematerialService) {
		this.integratematerialService = integratematerialService;
	}


	public Integratematerial getIntegratematerial() {
		return integratematerial;
	}

	public void setIntegratematerial(Integratematerial integratematerial) {
		this.integratematerial = integratematerial;
	}


	public Integratematerial getModel() {
		return integratematerial;
	}

	/**
	 * 查询信息列表
	 */
	public void getlist()
	{
		String strpageNo = this.getRequest().getParameter("pageNo");
		String strpageSize = this.getRequest().getParameter("pageSize");
		String strmoduleTypeid = this.getRequest().getParameter("moduleTypeid");
		String strmaterialState = this.getRequest().getParameter("materialState");
		String strshowTypeid = this.getRequest().getParameter("showTypeid");
		int materialState = -1;
		int materialtypeid = -1;
		int showTypeid = -1;
		int pageNo = 1;
		int pageSize = 10;
		if(strpageNo != null && !(strpageNo.equals("")))
		{
			pageNo = Integer.parseInt(strpageNo);
		}
		if(strpageSize != null && !(strpageSize.equals("")))
		{
			pageSize = Integer.parseInt(strpageSize);
		}
		if(strmoduleTypeid != null && !(strmoduleTypeid.equals("")))
		{
			materialtypeid = Integer.parseInt(strmoduleTypeid);
		}
		
		if(strmaterialState != null && !(strmaterialState.equals("")))
		{
			materialState = Integer.parseInt(strmaterialState);
		}
		
		if(strshowTypeid != null && !(strshowTypeid.equals("")))
		{
			showTypeid = Integer.parseInt(strshowTypeid);
		}
		
		try {
			Page<Integratematerial> page = integratematerialService.findlist(materialtypeid,materialState,showTypeid,pageNo,pageSize);
			setSuccessMessage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
}
