package org.webapi.api;

import javax.annotation.Resource;

import org.webapi.entry.Residentuser;
import org.webapi.service.ResidentuserService;

public class ResidentuserAction extends BaseAction<Residentuser>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ResidentuserService residentuserService = null;
	public Residentuser residentuser = new Residentuser();
	
	

	public Residentuser getResidentuser() {
		return residentuser;
	}

	public void setResidentuser(Residentuser residentuser) {
		this.residentuser = residentuser;
	}

	public ResidentuserService getResidentuserService() {
		return residentuserService;
	}

	@Resource
	public void setResidentuserService(ResidentuserService residentuserService) {
		this.residentuserService = residentuserService;
	}

	public Residentuser getModel() {
		return residentuser;
	}
	
	/**
	 * 用户登录
	 */
	public void login()
	{
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		try {
			Residentuser user = residentuserService.login(username,password);
			setSuccessMessage(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 用户注册
	 */
	public void register()
	{
		try {
			Boolean fals = residentuserService.register(residentuser);
			setSuccessMessage(fals);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}

	/**
	 * 修改个人信息
	 */
	public void upuser()
	{
		try {
			Residentuser uprResidentuser = residentuserService.getresidentuser(residentuser.getUserid());
			if(uprResidentuser != null)
			{
				uprResidentuser.setLoginname(residentuser.getLoginname());
				uprResidentuser.setRealname(residentuser.getRealname());
				uprResidentuser.setTelephonenum(residentuser.getTelephonenum());
				uprResidentuser.setEmail(residentuser.getEmail());
				uprResidentuser.setFamilyTelephonenum(residentuser.getFamilyTelephonenum());
				
				Boolean fals = residentuserService.upuser(uprResidentuser);
				if(fals)
				{
					setSuccessMessage(uprResidentuser);
				}else
				{
					setSuccessMessage("null");
				}
				
			}else
			{
				setSuccessMessage("修改个人信息失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
}
