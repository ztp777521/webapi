package thinker.webapi.test;

import org.junit.Test;

public class ActivityTest extends TestBase{

	@Test
	public void test()
	{
		postData.put("groupid",1);
		postData.put("userid",1);
		postData.put("activityName","活动名称");
		postData.put("activityDateStart","2013-05-6");
		postData.put("activityDateEnd","2013-05-6");
		postData.put("activityContent","活动内容");
		doTest("http://localhost:8080/webapi/activity!addactivity.action");
	}
	
	@Test
	public void test002()
	{
		postData.put("userid",1);
		doTest("http://localhost:8080/webapi/activity!findactivitylist.action");
	}
}
