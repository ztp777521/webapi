package thinker.webapi.test;

import java.util.HashMap;

import org.webapi.utility.HttpClient;

public class TestBase
{
	protected HttpClient http = new HttpClient();
	protected HashMap<String,Object> postData = new HashMap<String,Object>();
	
	public TestBase()
	{
		HashMap<String, String> httpHeaders = new HashMap<String, String>();
		httpHeaders.put("apptypeid", "3");
		httpHeaders.put("platformid", "2090");
		httpHeaders.put("city", "宁波市");
		httpHeaders.put("district", "海曙区");
		
		http.setHttpHeaders(httpHeaders);
	}
	
	public void doTest(String URL)
	{
		System.out.print(http.getString(URL, postData));
	}
}
