package org.webapi.utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


public class PingYinUtil
{
	private ServletContext application = null;
	
	public PingYinUtil(HttpServletRequest request)
	{
		this.application = request.getSession().getServletContext();
		readTableFile();
	}
	private void readTableFile()
	{
		String filePath = application.getRealPath("/citypinyin.txt");
		
		Object obj = application.getAttribute("citypinyintable_lastmodify");
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
		    
		    JSONArray jsonArr = JSONArray.fromObject(strFileContent);
		    
		    application.setAttribute("citypinyintable", jsonArr);
		    application.setAttribute("citypinyintable_lastmodify", readFileLastModifyTime(filePath));
		} 
		catch (Exception e) 
		{
			application.setAttribute("citypinyintable", null);
			application.setAttribute("citypinyintable_lastmodify", 0);
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
	
	
	/**
	 * 将字符串中的中文转化为拼音,其他字符不变
	 * 
	 * @param inputString
	 * @return
	 */
	public String getPingYin(String inputString)
	{
		Object obj = this.application.getAttribute("citypinyintable");
		JSONArray jsonArr = null;
		if(obj != null)
		{
			jsonArr = (JSONArray)obj;
		}
		
		if(jsonArr != null)
		{
			String pinyin = "";
			JSONObject jsonObj = null;
			for(int i = 0; i < jsonArr.size(); i++)
			{
				jsonObj = jsonArr.getJSONObject(i);
				try
				{
					pinyin = jsonObj.getString(inputString);
					if(pinyin != null && pinyin.trim().length() > 0)
					{
						return pinyin;
					}
				}
				catch(Exception e)
				{
					continue;
				}
				
			}
		}
		
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);

		char[] input = inputString.trim().toCharArray();
		String output = "";

		try
		{
			for (int i = 0; i < input.length; i++)
			{
				if (java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+"))
				{
					String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
					output += temp[0];
				}
				else
					output += java.lang.Character.toString(input[i]);
			}
		}
		catch (BadHanyuPinyinOutputFormatCombination e)
		{
			e.printStackTrace();
		}
		return output;
	}
}