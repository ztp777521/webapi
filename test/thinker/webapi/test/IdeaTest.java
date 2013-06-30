package thinker.webapi.test;

import org.junit.Test;

public class IdeaTest extends TestBase{
	
	@Test
	public void test()
	{
//		userName:userName,
//		telephonenum:telephonenum,
//		email:email,
//		ideaContent:ideaContent
		postData.put("userName", "ztp777521");
		postData.put("telephonenum", "974110");
		postData.put("email", "974110");
		postData.put("ideaContent", "974110");
		doTest("http://localhost:8080/webapi/idea!addremark.action");
	}
	
	@Test
	public void test002()
	{
		postData.put("userId", 1);
		postData.put("pageNo", 1);
		postData.put("pageSize", 10);
//		doTest("http://localhost:8080/webapi/idea!findidealist.action");
		doTest("http://192.168.0.1:1020/webapi/idea!findidealist.action");
	}
}
