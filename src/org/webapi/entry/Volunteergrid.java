package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Volunteergrid entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_volunteer_grid", schema = "dbo", catalog = "ZHPJY")
public class Volunteergrid implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer volunteerGridid;
	private Integer userid;
	private Integer applyUserid;
	private Integer gridid;

	// Constructors

	/** default constructor */
	public Volunteergrid() {
	}

	/** minimal constructor */
	public Volunteergrid(Integer userid, Integer gridid) {
		this.userid = userid;
		this.gridid = gridid;
	}

	/** full constructor */
	public Volunteergrid(Integer userid, Integer applyUserid, Integer gridid) {
		this.userid = userid;
		this.applyUserid = applyUserid;
		this.gridid = gridid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "volunteer_gridid", unique = true)
	public Integer getVolunteerGridid() {
		return this.volunteerGridid;
	}

	public void setVolunteerGridid(Integer volunteerGridid) {
		this.volunteerGridid = volunteerGridid;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "apply_userid")
	public Integer getApplyUserid() {
		return this.applyUserid;
	}

	public void setApplyUserid(Integer applyUserid) {
		this.applyUserid = applyUserid;
	}

	@Column(name = "gridid")
	public Integer getGridid() {
		return this.gridid;
	}

	public void setGridid(Integer gridid) {
		this.gridid = gridid;
	}

}