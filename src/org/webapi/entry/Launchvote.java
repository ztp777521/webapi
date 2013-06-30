package org.webapi.entry;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Launchvote entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_launch_vote", schema = "dbo", catalog = "ZHPJY")
public class Launchvote implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer voteid;
	private String voteReson;
	private Date voteTimeStart;
	private Date voteTimeEnd;
	private String voteTitle;

	// Constructors

	/** default constructor */
	public Launchvote() {
	}

	/** full constructor */
	public Launchvote(String voteReson, Date voteTimeStart, Date voteTimeEnd,
			String voteTitle) {
		this.voteReson = voteReson;
		this.voteTimeStart = voteTimeStart;
		this.voteTimeEnd = voteTimeEnd;
		this.voteTitle = voteTitle;
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

	@Column(name = "vote_reson", length = 500)
	public String getVoteReson() {
		return this.voteReson;
	}

	public void setVoteReson(String voteReson) {
		this.voteReson = voteReson;
	}

	@Column(name = "vote_time_start", length = 23)
	public Date getVoteTimeStart() {
		return this.voteTimeStart;
	}

	public void setVoteTimeStart(Date voteTimeStart) {
		this.voteTimeStart = voteTimeStart;
	}

	@Column(name = "vote_time_end", length = 23)
	public Date getVoteTimeEnd() {
		return this.voteTimeEnd;
	}

	public void setVoteTimeEnd(Date voteTimeEnd) {
		this.voteTimeEnd = voteTimeEnd;
	}

	@Column(name = "vote_title")
	public String getVoteTitle() {
		return this.voteTitle;
	}

	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}

}