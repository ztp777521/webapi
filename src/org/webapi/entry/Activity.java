package org.webapi.entry;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Activity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_activity", schema = "dbo", catalog = "ZHPJY")
public class Activity implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer activityid;
	private Integer userid;
	private Integer groupid;
	private String activityName;
	private Date activityDateStart;
	private String activityContent;
	private Date activityDateEnd;
	private Integer activityState;
	private String reson;

	// Constructors

	/** default constructor */
	public Activity() {
	}

	/** minimal constructor */
	public Activity(Integer userid, Integer groupid, String activityName,
			Date activityDateStart, String activityContent,
			Date activityDateEnd, Integer activityState) {
		this.userid = userid;
		this.groupid = groupid;
		this.activityName = activityName;
		this.activityDateStart = activityDateStart;
		this.activityContent = activityContent;
		this.activityDateEnd = activityDateEnd;
		this.activityState = activityState;
	}

	/** full constructor */
	public Activity(Integer userid, Integer groupid, String activityName,
			Date activityDateStart, String activityContent,
			Date activityDateEnd, Integer activityState, String reson) {
		this.userid = userid;
		this.groupid = groupid;
		this.activityName = activityName;
		this.activityDateStart = activityDateStart;
		this.activityContent = activityContent;
		this.activityDateEnd = activityDateEnd;
		this.activityState = activityState;
		this.reson = reson;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "activityid", unique = true )
	public Integer getActivityid() {
		return this.activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	@Column(name = "userid" )
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "groupid" )
	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	@Column(name = "activity_name" )
	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Column(name = "activity_date_start" , length = 23)
	public Date getActivityDateStart() {
		return this.activityDateStart;
	}

	public void setActivityDateStart(Date activityDateStart) {
		this.activityDateStart = activityDateStart;
	}

	@Column(name = "activity_content" )
	public String getActivityContent() {
		return this.activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	@Column(name = "activity_date_end" , length = 23)
	public Date getActivityDateEnd() {
		return this.activityDateEnd;
	}

	public void setActivityDateEnd(Date activityDateEnd) {
		this.activityDateEnd = activityDateEnd;
	}

	@Column(name = "activity_state" )
	public Integer getActivityState() {
		return this.activityState;
	}

	public void setActivityState(Integer activityState) {
		this.activityState = activityState;
	}

	@Column(name = "reson")
	public String getReson() {
		return this.reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

}