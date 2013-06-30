package org.webapi.entry;
// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Unemploymentregisration entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_unemployment_registration", schema = "dbo", catalog = "ZHPJY")
public class Unemploymentregistration implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer unempRegid;
	private Integer userid;
	private String username;
	private String telephonenum;
	private String email;
	private Date unempTime;
	private String familySituation;
	private String empIntentions;
	private String personalSituation;
	private String address;
	private Date commitDate;
	private Integer empState;
	//private List<Unemploymentreply> Unemplist;

	// Constructors

	/** default constructor */
	public Unemploymentregistration() {
	}

	/** minimal constructor */
	public Unemploymentregistration(Integer userid, String username,
			String telephonenum, String email, Date unempTime,
			String familySituation, String empIntentions,
			String personalSituation, String address, Date commitDate) {
		this.userid = userid;
		this.username = username;
		this.telephonenum = telephonenum;
		this.email = email;
		this.unempTime = unempTime;
		this.familySituation = familySituation;
		this.empIntentions = empIntentions;
		this.personalSituation = personalSituation;
		this.address = address;
		this.commitDate = commitDate;
	}

	/** full constructor */
	public Unemploymentregistration(Integer userid, String username,
			String telephonenum, String email, Date unempTime,
			String familySituation, String empIntentions,
			String personalSituation, String address, Date commitDate,
			Integer empState) {
		this.userid = userid;
		this.username = username;
		this.telephonenum = telephonenum;
		this.email = email;
		this.unempTime = unempTime;
		this.familySituation = familySituation;
		this.empIntentions = empIntentions;
		this.personalSituation = personalSituation;
		this.address = address;
		this.commitDate = commitDate;
		this.empState = empState;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "unemp_regid", unique = true)
	public Integer getUnempRegid() {
		return this.unempRegid;
	}

	public void setUnempRegid(Integer unempRegid) {
		this.unempRegid = unempRegid;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Column(name = "unemp_time", length = 23)
	public Date getUnempTime() {
		return this.unempTime;
	}

	public void setUnempTime(Date unempTime) {
		this.unempTime = unempTime;
	}

	@Column(name = "family_situation")
	public String getFamilySituation() {
		return this.familySituation;
	}

	public void setFamilySituation(String familySituation) {
		this.familySituation = familySituation;
	}

	@Column(name = "emp_intentions")
	public String getEmpIntentions() {
		return this.empIntentions;
	}

	public void setEmpIntentions(String empIntentions) {
		this.empIntentions = empIntentions;
	}

	@Column(name = "personal_situation")
	public String getPersonalSituation() {
		return this.personalSituation;
	}

	public void setPersonalSituation(String personalSituation) {
		this.personalSituation = personalSituation;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "commit_date", length = 23)
	public Date getCommitDate() {
		return this.commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	@Column(name = "emp_state")
	public Integer getEmpState() {
		return this.empState;
	}

	public void setEmpState(Integer empState) {
		this.empState = empState;
	}

//	public List<Unemploymentreply> getUnemplist() {
//		return Unemplist;
//	}
//
//	public void setUnemplist(List<Unemploymentreply> unemplist) {
//		Unemplist = unemplist;
//	}

}