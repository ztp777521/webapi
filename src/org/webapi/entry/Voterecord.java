package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Voterecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_vote_record", schema = "dbo", catalog = "ZHPJY")
public class Voterecord implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer voteid;
	private Integer launchVoteid;
	private Integer volunteerid;
	private Integer userid;

	// Constructors

	/** default constructor */
	public Voterecord() {
	}

	/** full constructor */
	public Voterecord(Integer launchVoteid, Integer volunteerid, Integer userid) {
		this.launchVoteid = launchVoteid;
		this.volunteerid = volunteerid;
		this.userid = userid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "voteid", unique = true)
	public Integer getVoteid() {
		return this.voteid;
	}

	public void setVoteid(Integer voteid) {
		this.voteid = voteid;
	}

	@Column(name = "launch_voteid")
	public Integer getLaunchVoteid() {
		return this.launchVoteid;
	}

	public void setLaunchVoteid(Integer launchVoteid) {
		this.launchVoteid = launchVoteid;
	}

	@Column(name = "volunteerid")
	public Integer getVolunteerid() {
		return this.volunteerid;
	}

	public void setVolunteerid(Integer volunteerid) {
		this.volunteerid = volunteerid;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}