package org.webapi.entry;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Unemploymentreply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_unemployment_reply", schema = "dbo", catalog = "ZHPJY")
public class Unemploymentreply implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer replyid;
	private Integer unempRegid;
	private String unempReplyContent;
	private Date replyDate;
	private String replyName;
	private String replyUserid;

	// Constructors

	/** default constructor */
	public Unemploymentreply() {
	}

	/** minimal constructor */
	public Unemploymentreply(Integer unempRegid, String unempReplyContent,
			Date replyDate, String replyUserid) {
		this.unempRegid = unempRegid;
		this.unempReplyContent = unempReplyContent;
		this.replyDate = replyDate;
		this.replyUserid = replyUserid;
	}

	/** full constructor */
	public Unemploymentreply(Integer unempRegid, String unempReplyContent,
			Date replyDate, String replyName, String replyUserid) {
		this.unempRegid = unempRegid;
		this.unempReplyContent = unempReplyContent;
		this.replyDate = replyDate;
		this.replyName = replyName;
		this.replyUserid = replyUserid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "replyid", unique = true)
	public Integer getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}

	@Column(name = "unemp_regid")
	public Integer getUnempRegid() {
		return this.unempRegid;
	}

	public void setUnempRegid(Integer unempRegid) {
		this.unempRegid = unempRegid;
	}

	@Column(name = "unemp_reply_content")
	public String getUnempReplyContent() {
		return this.unempReplyContent;
	}

	public void setUnempReplyContent(String unempReplyContent) {
		this.unempReplyContent = unempReplyContent;
	}

	@Column(name = "reply_date", length = 23)
	public Date getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Column(name = "reply_name")
	public String getReplyName() {
		return this.replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	@Column(name = "reply_userid")
	public String getReplyUserid() {
		return this.replyUserid;
	}

	public void setReplyUserid(String replyUserid) {
		this.replyUserid = replyUserid;
	}

}