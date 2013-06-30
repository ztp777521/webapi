package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_group", schema = "dbo", catalog = "ZHPJY")
public class Group implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer groupid;
	private String groupDescription;
	private Integer applyUserid;
	private Integer groupState;
	private String reson;
	private String groupName;

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** minimal constructor */
	public Group(String groupDescription, Integer applyUserid,
			Integer groupState, String groupName) {
		this.groupDescription = groupDescription;
		this.applyUserid = applyUserid;
		this.groupState = groupState;
		this.groupName = groupName;
	}

	/** full constructor */
	public Group(String groupDescription, Integer applyUserid,
			Integer groupState, String reson, String groupName) {
		this.groupDescription = groupDescription;
		this.applyUserid = applyUserid;
		this.groupState = groupState;
		this.reson = reson;
		this.groupName = groupName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "groupid", unique = true)
	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	@Column(name = "group_description")
	public String getGroupDescription() {
		return this.groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	@Column(name = "apply_userid")
	public Integer getApplyUserid() {
		return this.applyUserid;
	}

	public void setApplyUserid(Integer applyUserid) {
		this.applyUserid = applyUserid;
	}

	@Column(name = "group_state")
	public Integer getGroupState() {
		return this.groupState;
	}

	public void setGroupState(Integer groupState) {
		this.groupState = groupState;
	}

	@Column(name = "reson")
	public String getReson() {
		return this.reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	@Column(name = "group_name")
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}