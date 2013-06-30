package org.webapi.api;

import javax.annotation.Resource;

import org.springside.modules.orm.Page;
import org.webapi.entry.Shop;
import org.webapi.service.ShopService;

public class ShopAction extends BaseAction<Shop>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShopService shopService = null; 
	private Shop shop = new Shop();

	public ShopService getShopService() {
		return shopService;
	}

	@Resource
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Shop getModel() {
		return shop;
	}

	/**
	 * 申请商户
	 */
	public void addshop()
	{
		try {
			shop.setShopState(0);
			Boolean fals = shopService.addshop(shop);
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
	 * 根据用户id查询商户列表
	 */
	public void findshoplist()
	{
		int pageNo = 0;
		int pageSize = 10;
		try {
			Page<Shop> page = shopService.getshopall(shop.getUserid(), pageNo, pageSize);
			setSuccessMessage(page);
		} catch (Exception e) 
		{
			e.printStackTrace();
			setSuccessMessage("服务器端出错");
		}
		writeResponse(returnMsg);
	}
}
