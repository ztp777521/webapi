package thinker.webapi.test;

import org.junit.Test;

public class GroupTest extends TestBase{

	@Test
	public void test()
	{
		postData.put("userId", 1);
		postData.put("groupName", "群名字");
		postData.put("groupDescription", "群说明说明说明");
		doTest("http://localhost:8080/webapi/group!addgroup.action");
	}
	
	@Test
	public void test001()
	{
		postData.put("applyUserid",1);
		doTest("http://localhost:8080/webapi/group!findgroup.action");
	}
}
