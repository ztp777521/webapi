package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Shopservice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_shop_service", schema = "dbo", catalog = "ZHPJY")
public class Shopservice implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer useid;
	private String shopName;
	private String serviceName;
	private String serviceContent;
	private Integer serviceState;
	private String reson;
	private Integer shopid;
	private String userName;

	// Constructors

	/** default constructor */
	public Shopservice() {
	}

	/** full constructor */
	public Shopservice(Integer useid, String shopName, String serviceName,
			String serviceContent, Integer serviceState, String reson,
			Integer shopid, String userName) {
		this.useid = useid;
		this.shopName = shopName;
		this.serviceName = serviceName;
		this.serviceContent = serviceContent;
		this.serviceState = serviceState;
		this.reson = reson;
		this.shopid = shopid;
		this.userName = userName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "useid")
	public Integer getUseid() {
		return this.useid;
	}

	public void setUseid(Integer useid) {
		this.useid = useid;
	}

	@Column(name = "shop_name")
	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "service_name")
	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name = "service_content")
	public String getServiceContent() {
		return this.serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	@Column(name = "service_state")
	public Integer getServiceState() {
		return this.serviceState;
	}

	public void setServiceState(Integer serviceState) {
		this.serviceState = serviceState;
	}

	@Column(name = "reson")
	public String getReson() {
		return this.reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	@Column(name = "shopid")
	public Integer getShopid() {
		return this.shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}