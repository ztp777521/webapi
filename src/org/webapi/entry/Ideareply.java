package org.webapi.entry;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ideareply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_idea_reply", schema = "dbo", catalog = "ZHPJY")
public class Ideareply implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ideaReplyid;
	private Integer ideaId;
	private String replyContent;
	private Date replyDate;
	private Integer replyUserid;

	// Constructors

	/** default constructor */
	public Ideareply() {
	}

	/** full constructor */
	public Ideareply(Integer ideaId, String replyContent, Date replyDate,
			Integer replyUserid) {
		this.ideaId = ideaId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyUserid = replyUserid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idea_replyid", unique = true)
	public Integer getIdeaReplyid() {
		return this.ideaReplyid;
	}

	public void setIdeaReplyid(Integer ideaReplyid) {
		this.ideaReplyid = ideaReplyid;
	}

	@Column(name = "idea_id")
	public Integer getIdeaId() {
		return this.ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

	@Column(name = "reply_content")
	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Column(name = "reply_date", length = 23)
	public Date getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Column(name = "reply_userid")
	public Integer getReplyUserid() {
		return this.replyUserid;
	}

	public void setReplyUserid(Integer replyUserid) {
		this.replyUserid = replyUserid;
	}

}