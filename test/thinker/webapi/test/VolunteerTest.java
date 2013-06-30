package thinker.webapi.test;

import org.junit.Test;

public class VolunteerTest extends TestBase
{
	@Test
	public void test()
	{
		doTest("http://localhost:8080/webapi/volunteer!findgridinfolist.action");
	}
}
