package org.webapi.api;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springside.modules.orm.Page;
import org.springside.modules.utils.web.struts2.Struts2Utils;
import org.webapi.utility.JsonUtil;
import org.webapi.utility.URLCode;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 控制器基类
 * 
 * @author 
 * @param <T>
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>, Preparable
{
	private static final long	serialVersionUID	= 1L;
	protected String			returnMsg			= "";
	private String[]			excludeFields		= new String[] { "autoCount", "order", "orderBy", "orderBySetted" };
	private Log					logger				= LogFactory.getLog(BaseAction.class);
	private ServletContext application = null;

	public void prepare() throws Exception
	{
	}

	/**
	 * 获取Log实例
	 * 
	 * @return
	 */
	public Log getLogger()
	{
		return logger;
	}

	/**
	 * 将所有URL参数输出成字符串
	 * @param s连接符，默认为&
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String urlParamToDebugString(String s)
	{
		if(s == null || s.trim().length() == 0)
		{
			s = "&";
		}
		Map params = this.getRequest().getParameterMap();

		if (params != null)
		{
			Set<String> parameters = params.keySet();
			Iterator<String> it = parameters.iterator();
			StringBuffer buf = new StringBuffer();

			for (int paramCount = 0; it.hasNext();)
			{
				String parameterName = it.next();
				String parameterValue = this.getRequest().getParameter(parameterName);

				if (parameterValue != null)
				{
					if (paramCount > 0)
					{
						buf.append(s);
					}

					if (this.getMethod().equals("GET"))
					{
						parameterValue = new URLCode().convertCode(parameterValue, "ISO-8859-1");
					}
					buf.append(parameterName);
					buf.append("=");
					buf.append(parameterValue);
					++paramCount;
				}
			}

			return buf.toString();
		}

		return "";
	}

	/**
	 * 将所有HTTPHeader里的变量输出到字符串
	 * @param s分隔符，默认为回车
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String HTTPHeaersToDebugString(String s)
	{
		if(s == null || s.trim().length() == 0)
		{
			s = "\r\n";
		}
		StringBuffer sb = new StringBuffer();
		Enumeration en = this.getRequest().getHeaderNames();
		while (en.hasMoreElements())
		{
			String name = (String) en.nextElement();
			String value = this.getRequest().getHeader(name);
			sb.append(name + "=" + value + s);
		}

		return sb.toString();
	}

	/**
	 * 获取HttpServletRequest实例
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest()
	{
		return Struts2Utils.getRequest();
	}

	/**
	 * 获取参数传递是POST还是GET
	 * 
	 * @return
	 */
	public String getMethod()
	{
		return getRequest().getMethod().toUpperCase();
	}

	/**
	 * 从HTTP HEADER里获取指定名称的值
	 * 
	 * @param name
	 * @return
	 */
	public String getHeader(String name)
	{
		try
		{
			return new URLCode().convertCode(this.getRequest().getHeader(name),"ISO-8859-1");
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 检查是否在URL参数里提供了必填参数
	 * 
	 * @param params
	 * @return
	 */
	public boolean checkParams(String[] params)
	{
		if (params == null || params.length == 0)
		{
			return true;
		}

		HttpServletRequest request = this.getRequest();

		try
		{
			for (String s : params)
			{
				String p = request.getParameter(s);
				if (p == null || p.length() < 1)
				{
					return false;
				}
			}
		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}

	/**
	 * 设置错误响应消息
	 * 
	 * @param msg
	 */
	public void setErrorMessage(String msg)
	{
		returnMsg = "{\"status\":\"ERROR\",\"data\":\"" + msg + "\"}";
	}
	
	public void setErrorMessage(Object msg)
	{
		returnMsg = "{\"status\":\"ERROR\",\"data\":\"" + msg + "\"}";
	}

	public void setSuccessMessage(boolean data)
	{
		returnMsg = "{\"status\":\"OK\",\"data\":\"" + data + "\"}";
	}
	
	public void setSuccessMessage(Integer data)
	{
		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		returnMsg = "{\"status\":\"OK\",\"data\":" + data.toString() + "}";
	}
	
	public void setSuccessMessage(Double data)
	{
		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		returnMsg = "{\"status\":\"OK\",\"data\":" + data.toString() + "}";
	}
	
	public void setSuccessMessage(Long data)
	{
		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		returnMsg = "{\"status\":\"OK\",\"data\":" + data.toString() + "}";
	}
	
	public void setSuccessMessage(Float data)
	{
		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		returnMsg = "{\"status\":\"OK\",\"data\":" + data.toString() + "}";
	}
	
	public void setSuccessMessage(String data)
	{
		returnMsg = "{\"status\":\"OK\",\"data\":\"" + data + "\"}";
	}
	
	public void setSuccessMessage(String data, boolean isJSONString)
	{
		if(!isJSONString)
		{
			setSuccessMessage(data);
			return;
		}
		returnMsg = "{\"status\":\"OK\",\"data\":" + data + "}";
	}

	/**
	 * 设置成功响应消息
	 * 
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public void setSuccessMessage(Object data)
	{
		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		try
		{
			if (data instanceof Page)
			{
				returnMsg = "{\"status\":\"OK\",\"data\":" + JsonUtil.objectToJson(data, excludeFields) + "}";
				formatReturnMsg();
			}
			else
			{
				returnMsg = "{\"status\":\"OK\",\"data\":" + JsonUtil.objectToJson(data) + "}";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setErrorMessage(e.getMessage());
		}
	}

	/**
	 * 设置成功响应消息
	 * 
	 * @param data
	 * @param dateformat
	 * @param excludes
	 */
	@SuppressWarnings("unchecked")
	public void setSuccessMessage(Object data, String[] excludes)
	{
		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		try
		{
			if (data instanceof Page)
			{
				String[] newExcludes = new String[excludeFields.length + excludes.length];
				System.arraycopy(excludes, 0, newExcludes, 0, excludes.length);
				System.arraycopy(excludeFields, 0, newExcludes, excludes.length, excludeFields.length);
				returnMsg = "{\"status\":\"OK\",\"data\":" + JsonUtil.objectToJson(data,  excludeFields) + "}";
				formatReturnMsg();
			}
			else
			{
				returnMsg = "{\"status\":\"OK\",\"data\":" + JsonUtil.objectToJson(data,  excludes) + "}";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setErrorMessage(e.getMessage());
		}
	}

	private void formatReturnMsg()
	{
		returnMsg = returnMsg.replace("totalPages", "totalpages");
		returnMsg = returnMsg.replace("totalCount", "totalcount");
		returnMsg = returnMsg.replace("hasNext", "hasnext");
		returnMsg = returnMsg.replace("hasPre", "haspre");
		returnMsg = returnMsg.replace("nextPage", "nextpage");
		returnMsg = returnMsg.replace("pageNo", "pageno");
		returnMsg = returnMsg.replace("pageSize", "pagesize");
		returnMsg = returnMsg.replace("prePage", "prepage");
	}

	/**
	 * 设置成功响应消息
	 */
	public void setSuccessMessage(List<?> data)
	{

		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		try
		{
			returnMsg = "{\"status\":\"OK\",\"data\":" + JsonUtil.collectionToJsonArray(data) + "}";
		}
		catch (Exception e)
		{
			setErrorMessage(e.getMessage());
		}
	}

	/**
	 * 设置成功响应消息
	 * 
	 * @param data
	 * @param dateformat
	 * @param excludes
	 */
	public void setSuccessMessage(List<?> data, String[] excludes)
	{

		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		try
		{
			returnMsg = "{\"status\":\"OK\",\"data\":" + JsonUtil.collectionToJsonArray(data,  excludes) + "}";
		}
		catch (Exception e)
		{
			setErrorMessage(e.getMessage());
		}
	}

	/**
	 * 设置成功响应消息
	 * 
	 * @param data
	 */
	public void setSuccessMessage(Object[] data)
	{
		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		try
		{
			returnMsg = "{\"status\":\"OK\",\"data\":" + JsonUtil.collectionToJsonArray(data) + "}";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setErrorMessage(e.getMessage());
		}
	}

	/**
	 * 设置成功响应消息
	 * 
	 * @param data
	 * @param dateformat
	 * @param excludes
	 */
	public void setSuccessMessage(Object[] data, String[] excludes)
	{
		if (data == null)
		{
			setErrorMessage("entity not fount.");
		}
		try
		{
			returnMsg = "{\"status\":\"OK\",\"data\":" + JsonUtil.collectionToJsonArray(data,  excludes) + "}";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setErrorMessage(e.getMessage());
		}
	}
	
	public void writeResponse(String message)
	{
		writeResponse(message, "utf-8");
	}
	
	public void writeResponse(String message, String encoding)
	{
		this.application = this.getRequest().getSession().getServletContext();
		
		HttpServletResponse response = Struts2Utils.getResponse();
		response.setCharacterEncoding(encoding);
		response.setContentType("application/json;charset=" + encoding);
		response.addHeader("Access-Control-Allow-Origin", (String)this.application.getAttribute("sites"));
		// response.addHeader("Access-Control-Allow-Credentials","true");
		response.addHeader("Access-Control-Allow-Headers", "apptypeid,platformid,city,district,Content-Type, Authorization, Accept,X-Requested-With");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		Struts2Utils.renderText(message);
	}

	public Page<T> getPage()
	{
		Page<T> page = new Page<T>();
		page.setPageNo(getPageno());
		page.setPageSize(getPagesize());
		return page;
	}

	public int getPageno()
	{
		try
		{
			return Integer.parseInt(this.getRequest().getParameter("pageno"));
		}
		catch(Exception e)
		{
			return 1;
		}
	}

	public int getPagesize()
	{
		try
		{
			return Integer.parseInt(this.getRequest().getParameter("pagesize"));
		}
		catch(Exception e)
		{
			return 15;
		}
	}
}
