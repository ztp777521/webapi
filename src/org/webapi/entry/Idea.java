package org.webapi.entry;
// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Idea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_idea", schema = "dbo", catalog = "ZHPJY")
public class Idea implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ideaid;
	private String userId;
	private String userName;
	private String telephonenum;
	private String email;
	private String ideaContent;
	private Integer gridnum;
	private Integer isreply;
	private Date commitDate;
	private Integer ispublic;
	//private List<Ideareply> Ideareplylist;

	// Constructors

	/** default constructor */
	public Idea() {
	}

	/** minimal constructor */
	public Idea(String userId, String userName, String telephonenum,
			String email, String ideaContent, Integer isreply, Date commitDate,
			Integer ispublic) {
		this.userId = userId;
		this.userName = userName;
		this.telephonenum = telephonenum;
		this.email = email;
		this.ideaContent = ideaContent;
		this.isreply = isreply;
		this.commitDate = commitDate;
		this.ispublic = ispublic;
	}

	/** full constructor */
	public Idea(String userId, String userName, String telephonenum,
			String email, String ideaContent, Integer gridnum, Integer isreply,
			Date commitDate, Integer ispublic) {
		this.userId = userId;
		this.userName = userName;
		this.telephonenum = telephonenum;
		this.email = email;
		this.ideaContent = ideaContent;
		this.gridnum = gridnum;
		this.isreply = isreply;
		this.commitDate = commitDate;
		this.ispublic = ispublic;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ideaid", unique = true)
	public Integer getIdeaid() {
		return this.ideaid;
	}

	public void setIdeaid(Integer ideaid) {
		this.ideaid = ideaid;
	}

	@Column(name = "user_id")
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "telephonenum")
	public String getTelephonenum() {
		return this.telephonenum;
	}

	public void setTelephonenum(String telephonenum) {
		this.telephonenum = telephonenum;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "idea_content")
	public String getIdeaContent() {
		return this.ideaContent;
	}

	public void setIdeaContent(String ideaContent) {
		this.ideaContent = ideaContent;
	}

	@Column(name = "gridnum")
	public Integer getGridnum() {
		return this.gridnum;
	}

	public void setGridnum(Integer gridnum) {
		this.gridnum = gridnum;
	}

	@Column(name = "isreply")
	public Integer getIsreply() {
		return this.isreply;
	}

	public void setIsreply(Integer isreply) {
		this.isreply = isreply;
	}

	@Column(name = "commit_date", length = 23)
	public Date getCommitDate() {
		return this.commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	@Column(name = "ispublic")
	public Integer getIspublic() {
		return this.ispublic;
	}

	public void setIspublic(Integer ispublic) {
		this.ispublic = ispublic;
	}

//	public List<Ideareply> getIdeareplylist() {
//		return Ideareplylist;
//	}
//
//	public void setIdeareplylist(List<Ideareply> ideareplylist) {
//		Ideareplylist = ideareplylist;
//	}

}