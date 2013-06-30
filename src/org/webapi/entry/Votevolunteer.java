package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Votevolunteer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_vote_volunteer", schema = "dbo", catalog = "ZHPJY")
public class Votevolunteer implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer voteVolunteerid;
	private Integer gridid;
	private Integer volunteerid;
	private String volunteerName;
	private Integer voteid;

	// Constructors

	/** default constructor */
	public Votevolunteer() {
	}

	/** full constructor */
	public Votevolunteer(Integer gridid, Integer volunteerid,
			String volunteerName, Integer voteid) {
		this.gridid = gridid;
		this.volunteerid = volunteerid;
		this.volunteerName = volunteerName;
		this.voteid = voteid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "vote_volunteerid", unique = true)
	public Integer getVoteVolunteerid() {
		return this.voteVolunteerid;
	}

	public void setVoteVolunteerid(Integer voteVolunteerid) {
		this.voteVolunteerid = voteVolunteerid;
	}

	@Column(name = "gridid")
	public Integer getGridid() {
		return this.gridid;
	}

	public void setGridid(Integer gridid) {
		this.gridid = gridid;
	}

	@Column(name = "volunteerid")
	public Integer getVolunteerid() {
		return this.volunteerid;
	}

	public void setVolunteerid(Integer volunteerid) {
		this.volunteerid = volunteerid;
	}

	@Column(name = "volunteer_name")
	public String getVolunteerName() {
		return this.volunteerName;
	}

	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}

	@Column(name = "voteid")
	public Integer getVoteid() {
		return this.voteid;
	}

	public void setVoteid(Integer voteid) {
		this.voteid = voteid;
	}

}