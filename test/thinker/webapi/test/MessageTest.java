package thinker.webapi.test;

import org.junit.Test;

public class MessageTest extends TestBase{
	
	@Test
	public void test()
	{
		postData.put("username", "admin");
		postData.put("password", "123456");
		doTest("http://localhost:8080/webapi/manager!login.action");
	}
}
