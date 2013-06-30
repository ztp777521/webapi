package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Module entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_module", schema = "dbo", catalog = "ZHPJY")
public class Module implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer muduleid;
	private Integer muduleName;

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** full constructor */
	public Module(Integer muduleName) {
		this.muduleName = muduleName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "muduleid", unique = true)
	public Integer getMuduleid() {
		return this.muduleid;
	}

	public void setMuduleid(Integer muduleid) {
		this.muduleid = muduleid;
	}

	@Column(name = "mudule_name")
	public Integer getMuduleName() {
		return this.muduleName;
	}

	public void setMuduleName(Integer muduleName) {
		this.muduleName = muduleName;
	}

}