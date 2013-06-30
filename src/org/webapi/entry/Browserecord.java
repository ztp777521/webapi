package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Browserecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_browse_record", schema = "dbo", catalog = "ZHPJY")
public class Browserecord implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer browseid;
	private Integer materialId;
	private Integer browseTimes;
	private String browseUserid;
	private Integer browseUserType;

	// Constructors

	/** default constructor */
	public Browserecord() {
	}

	/** full constructor */
	public Browserecord(Integer materialId, Integer browseTimes,
			String browseUserid, Integer browseUserType) {
		this.materialId = materialId;
		this.browseTimes = browseTimes;
		this.browseUserid = browseUserid;
		this.browseUserType = browseUserType;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "browseid", unique = true )
	public Integer getBrowseid() {
		return this.browseid;
	}

	public void setBrowseid(Integer browseid) {
		this.browseid = browseid;
	}

	@Column(name = "material_id" )
	public Integer getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	@Column(name = "browse_times" )
	public Integer getBrowseTimes() {
		return this.browseTimes;
	}

	public void setBrowseTimes(Integer browseTimes) {
		this.browseTimes = browseTimes;
	}

	@Column(name = "browse_userid" )
	public String getBrowseUserid() {
		return this.browseUserid;
	}

	public void setBrowseUserid(String browseUserid) {
		this.browseUserid = browseUserid;
	}

	@Column(name = "browse_user_type" )
	public Integer getBrowseUserType() {
		return this.browseUserType;
	}

	public void setBrowseUserType(Integer browseUserType) {
		this.browseUserType = browseUserType;
	}

}