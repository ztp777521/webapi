package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_shop", schema = "dbo", catalog = "ZHPJY")
public class Shop implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer shopid;
	private Integer userid;
	private Integer serviceTypeid;
	private String shopName;
	private String serviceContent;
	private Integer shopState;
	private String shopAddress;
	private String telephonenum;
	private String coordinateX;
	private String coordinateY;

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** minimal constructor */
	public Shop(Integer userid, Integer serviceTypeid, String shopName,
			String serviceContent, Integer shopState, String telephonenum) {
		this.userid = userid;
		this.serviceTypeid = serviceTypeid;
		this.shopName = shopName;
		this.serviceContent = serviceContent;
		this.shopState = shopState;
		this.telephonenum = telephonenum;
	}

	/** full constructor */
	public Shop(Integer userid, Integer serviceTypeid, String shopName,
			String serviceContent, Integer shopState, String shopAddress,
			String telephonenum, String coordinateX, String coordinateY) {
		this.userid = userid;
		this.serviceTypeid = serviceTypeid;
		this.shopName = shopName;
		this.serviceContent = serviceContent;
		this.shopState = shopState;
		this.shopAddress = shopAddress;
		this.telephonenum = telephonenum;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "shopid", unique = true)
	public Integer getShopid() {
		return this.shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "service_typeid")
	public Integer getServiceTypeid() {
		return this.serviceTypeid;
	}

	public void setServiceTypeid(Integer serviceTypeid) {
		this.serviceTypeid = serviceTypeid;
	}

	@Column(name = "shop_name")
	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "service_content")
	public String getServiceContent() {
		return this.serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	@Column(name = "shop_state")
	public Integer getShopState() {
		return this.shopState;
	}

	public void setShopState(Integer shopState) {
		this.shopState = shopState;
	}

	@Column(name = "shop_address")
	public String getShopAddress() {
		return this.shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	@Column(name = "telephonenum")
	public String getTelephonenum() {
		return this.telephonenum;
	}

	public void setTelephonenum(String telephonenum) {
		this.telephonenum = telephonenum;
	}

	@Column(name = "coordinate_X")
	public String getCoordinateX() {
		return this.coordinateX;
	}

	public void setCoordinateX(String coordinateX) {
		this.coordinateX = coordinateX;
	}

	@Column(name = "coordinate_Y")
	public String getCoordinateY() {
		return this.coordinateY;
	}

	public void setCoordinateY(String coordinateY) {
		this.coordinateY = coordinateY;
	}

}