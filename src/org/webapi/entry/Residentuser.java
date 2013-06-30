package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Residentuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_resident_user", schema = "dbo", catalog = "ZHPJY")
public class Residentuser implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String loginname;
	private String realname;
	private String password;
	private String email;
	private String telephonenum;
	private String familyTelephonenum;
	private Integer commmunityid;
	private String thirdLogType;
	private String thirdLogAccount;

	// Constructors

	/** default constructor */
	public Residentuser() {
	}

	/** minimal constructor */
	public Residentuser(String loginname, String password, String email,
			String telephonenum, Integer commmunityid) {
		this.loginname = loginname;
		this.password = password;
		this.email = email;
		this.telephonenum = telephonenum;
		this.commmunityid = commmunityid;
	}

	/** full constructor */
	public Residentuser(String loginname, String realname, String password,
			String email, String telephonenum, String familyTelephonenum,
			Integer commmunityid, String thirdLogType, String thirdLogAccount) {
		this.loginname = loginname;
		this.realname = realname;
		this.password = password;
		this.email = email;
		this.telephonenum = telephonenum;
		this.familyTelephonenum = familyTelephonenum;
		this.commmunityid = commmunityid;
		this.thirdLogType = thirdLogType;
		this.thirdLogAccount = thirdLogAccount;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userid", unique = true)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "loginname")
	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	@Column(name = "realname")
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telephonenum")
	public String getTelephonenum() {
		return this.telephonenum;
	}

	public void setTelephonenum(String telephonenum) {
		this.telephonenum = telephonenum;
	}

	@Column(name = "family_telephonenum")
	public String getFamilyTelephonenum() {
		return this.familyTelephonenum;
	}

	public void setFamilyTelephonenum(String familyTelephonenum) {
		this.familyTelephonenum = familyTelephonenum;
	}

	@Column(name = "commmunityid")
	public Integer getCommmunityid() {
		return this.commmunityid;
	}

	public void setCommmunityid(Integer commmunityid) {
		this.commmunityid = commmunityid;
	}

	@Column(name = "third_log_type")
	public String getThirdLogType() {
		return this.thirdLogType;
	}

	public void setThirdLogType(String thirdLogType) {
		this.thirdLogType = thirdLogType;
	}

	@Column(name = "third_log_account")
	public String getThirdLogAccount() {
		return this.thirdLogAccount;
	}

	public void setThirdLogAccount(String thirdLogAccount) {
		this.thirdLogAccount = thirdLogAccount;
	}

}