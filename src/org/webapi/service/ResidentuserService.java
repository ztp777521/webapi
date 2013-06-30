package org.webapi.service;

import org.webapi.entry.Residentuser;

public interface ResidentuserService extends ServiceSupport<Residentuser>{

	/**
	 * 用户注册
	 * @param residentuser
	 * @return
	 * @throws Exception
	 */
	public Boolean register(Residentuser residentuser)throws Exception; 

	/**
	 * 根据用户的id查询用户信息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Residentuser getresidentuser(Integer userid)throws Exception;

	/**
	 * 修改个人信息
	 * @param residentuser
	 * @return
	 * @throws Exception
	 */
	public Boolean upuser(Residentuser residentuser)throws Exception;

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Residentuser login(String username, String password)throws Exception;

}
