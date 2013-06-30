package thinker.webapi.test;

import org.junit.Test;

public class ResidentuserTest extends TestBase{

	@Test
	public void test()
	{
		postData.put("username", "ztp777521");
		postData.put("password", "974110");
		doTest("http://localhost:8080/webapi/residentuser!login.action");
	}
}
