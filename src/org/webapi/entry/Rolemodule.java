package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rolemodule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_role_module", schema = "dbo", catalog = "ZHPJY")
public class Rolemodule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer roleMuduleid;
	private Integer muduleid;
	private Integer roleid;

	// Constructors

	/** default constructor */
	public Rolemodule() {
	}

	/** full constructor */
	public Rolemodule(Integer muduleid, Integer roleid) {
		this.muduleid = muduleid;
		this.roleid = roleid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "role_muduleid", unique = true, nullable = false)
	public Integer getRoleMuduleid() {
		return this.roleMuduleid;
	}

	public void setRoleMuduleid(Integer roleMuduleid) {
		this.roleMuduleid = roleMuduleid;
	}

	@Column(name = "muduleid", nullable = false)
	public Integer getMuduleid() {
		return this.muduleid;
	}

	public void setMuduleid(Integer muduleid) {
		this.muduleid = muduleid;
	}

	@Column(name = "roleid", nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

}