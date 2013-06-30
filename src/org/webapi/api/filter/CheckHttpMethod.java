package org.webapi.api.filter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckHttpMethod implements Filter
{
	private ServletContext application = null;
	
	public void destroy()
	{
		
	}

	/**
	 * 由于Android中的HTML5使用XMLHttpRequest发送异步请求时首先发送的是Options方式的请求，
	 * Api无法取到传递的参数，所以API在checkParams就会给出错误信息，然后XMLHttpRequest再次发
	 * 送POST或GET请求，参数能正确收到，但是返回结果却是这两次请求的合集，因此JSON字符串无法被
	 * 解析，为了解决这个问题，当请求方式不是POST时，一律不输出任何内容。
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		this.readCrosssitesFile(request);
		
		if(!request.getRequestURI().contains("userface"))
		{
			if(request.getMethod().toUpperCase().equals("POST"))
			{
				try {
					chain.doFilter(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
			{
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json;charset=UTF-8");
				response.addHeader("Access-Control-Allow-Origin", (String)application.getAttribute("sites"));
				// response.addHeader("Access-Control-Allow-Credentials","true");
				response.addHeader("Access-Control-Allow-Headers", "apptypeid,platformid,city,district,Content-Type, Authorization, Accept,X-Requested-With");
				response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
				response.getWriter().write("");
			}
		}
		else
		{
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig arg0) throws ServletException
	{
		
	}
	
	private void readCrosssitesFile(HttpServletRequest request)
	{
		application = request.getSession().getServletContext();
		String filePath = application.getRealPath("/crosssites.txt");
		
		Object obj = application.getAttribute("crosssites_lastmodify");
		Long oldTime = (long) 0;
		Long newTime = (long) 1;
		
		if(obj != null)
		{
			oldTime = (Long)obj;
			newTime = readFileLastModifyTime(filePath);
		}
		
		if(oldTime.equals(newTime))
		{
			return;
		}
		
		File file=new File(filePath);
	    BufferedInputStream bufferedInputStream=null;
		try 
		{	
		    bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
		    
		    byte[] fileByteData = readFileStream(bufferedInputStream);
		    String strFileContent = new String(fileByteData,"utf-8");
		    
		    application.setAttribute("sites", strFileContent);
		    application.setAttribute("crosssites_lastmodify", readFileLastModifyTime(filePath));
		} 
		catch (Exception e) 
		{
			application.setAttribute("sites", "*");
			application.setAttribute("crosssites_lastmodify", 0);
			e.printStackTrace();
		}
	}
	
	private byte[] readFileStream(InputStream fileStream) throws IOException
	{
		byte[] bytes = new byte[100];
		byte[] bytecount = null;
		int n = 0;
		int ilength = 0;
		try
		{
			while ((n = fileStream.read(bytes)) >= 0)
			{
				if (bytecount != null)
				{
					ilength = bytecount.length;
				}
				byte[] tempbyte = new byte[ilength + n];
				if (bytecount != null)
				{
					System.arraycopy(bytecount, 0, tempbyte, 0, ilength);
				}

				System.arraycopy(bytes, 0, tempbyte, ilength, n);
				bytecount = tempbyte;

				if (n == -1)
					break;
			}
		}
		finally
		{
			fileStream.close();
		}
		return bytecount;
	}
	
	private long readFileLastModifyTime(String filePath)
	{
		File file=new File(filePath);
		long lastmodified=file.lastModified();
		return lastmodified;
	}
}
