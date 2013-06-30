package thinker.webapi.test;

import org.junit.Test;

public class UnemploymentregistrationTest extends TestBase{
	
	@Test
	public void test()
	{
		postData.put("userid", 1);
		doTest("http://localhost:8080/webapi/unemploymentregistration!addunemploymentregistration.action");
	}
	
	@Test
	public void test001()
	{
		postData.put("unempRegid", 1);
		postData.put("userid", 1);
		doTest("http://localhost:8080/webapi/unemploymentregistration!getreplylist.action");
	}

}
