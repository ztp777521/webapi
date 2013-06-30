package thinker.webapi.test;

import org.junit.Test;

public class IntegratematerialTest extends TestBase{

	@Test
	public void test1()
	{
		postData.put("moduleTypeid", 2);
		postData.put("materialState", 2);
		postData.put("showTypeid", 1);
		doTest("http://localhost:8080/webapi/integratematerial!getlist.action");
	}
}
