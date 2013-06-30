package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Groupcare entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_group_care", schema = "dbo", catalog = "ZHPJY")
public class Groupcare implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer groupCareid;
	private Integer groupid;
	private Integer careState;
	private Integer userid;

	// Constructors

	/** default constructor */
	public Groupcare() {
	}

	/** full constructor */
	public Groupcare(Integer groupid, Integer careState, Integer userid) {
		this.groupid = groupid;
		this.careState = careState;
		this.userid = userid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "group_careid", unique = true)
	public Integer getGroupCareid() {
		return this.groupCareid;
	}

	public void setGroupCareid(Integer groupCareid) {
		this.groupCareid = groupCareid;
	}

	@Column(name = "groupid")
	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	@Column(name = "care_state")
	public Integer getCareState() {
		return this.careState;
	}

	public void setCareState(Integer careState) {
		this.careState = careState;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}