package thinker.webapi.test;

import org.junit.Test;

public class ShopTest extends TestBase{

	@Test
	public void test1()
	{
		
		postData.put("userid", 1);
		postData.put("shopName", "商户名称");
		postData.put("telephonenum", "15810213614");
		postData.put("serviceTypeid", 1);
		postData.put("shopAddress", "商户地址");
		postData.put("serviceContent", "商户内容");
		doTest("http://localhost:8080/webapi/shop!addshop.action");
	}
	
	
	@Test
	public void test2()
	{
		
		postData.put("userid", 1);
		doTest("http://localhost:8080/webapi/shop!findshoplist.action");
	}
	
}
