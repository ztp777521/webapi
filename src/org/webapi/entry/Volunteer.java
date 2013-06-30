package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Volunteer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_volunteer", schema = "dbo", catalog = "ZHPJY")
public class Volunteer implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer applyUserid;
	private String applyGridid;
	private String applyReson;
	private Integer state;
	private String reson;
	private Integer ispass;
	private Integer userid;

	// Constructors

	/** default constructor */
	public Volunteer() {
	}

	/** minimal constructor */
	public Volunteer(String applyGridid, String applyReson, Integer state,
			Integer ispass, Integer userid) {
		this.applyGridid = applyGridid;
		this.applyReson = applyReson;
		this.state = state;
		this.ispass = ispass;
		this.userid = userid;
	}

	/** full constructor */
	public Volunteer(String applyGridid, String applyReson, Integer state,
			String reson, Integer ispass, Integer userid) {
		this.applyGridid = applyGridid;
		this.applyReson = applyReson;
		this.state = state;
		this.reson = reson;
		this.ispass = ispass;
		this.userid = userid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "apply_userid", unique = true)
	public Integer getApplyUserid() {
		return this.applyUserid;
	}

	public void setApplyUserid(Integer applyUserid) {
		this.applyUserid = applyUserid;
	}

	@Column(name = "apply_gridid")
	public String getApplyGridid() {
		return this.applyGridid;
	}

	public void setApplyGridid(String applyGridid) {
		this.applyGridid = applyGridid;
	}

	@Column(name = "apply_reson")
	public String getApplyReson() {
		return this.applyReson;
	}

	public void setApplyReson(String applyReson) {
		this.applyReson = applyReson;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "reson")
	public String getReson() {
		return this.reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	@Column(name = "ispass")
	public Integer getIspass() {
		return this.ispass;
	}

	public void setIspass(Integer ispass) {
		this.ispass = ispass;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}