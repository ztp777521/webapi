package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Showtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_show_type", schema = "dbo", catalog = "ZHPJY")
public class Showtype implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer showTypeid;
	private String showTypeName;

	// Constructors

	/** default constructor */
	public Showtype() {
	}

	/** full constructor */
	public Showtype(String showTypeName) {
		this.showTypeName = showTypeName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "show_typeid", unique = true)
	public Integer getShowTypeid() {
		return this.showTypeid;
	}

	public void setShowTypeid(Integer showTypeid) {
		this.showTypeid = showTypeid;
	}

	@Column(name = "show_type_name")
	public String getShowTypeName() {
		return this.showTypeName;
	}

	public void setShowTypeName(String showTypeName) {
		this.showTypeName = showTypeName;
	}

}