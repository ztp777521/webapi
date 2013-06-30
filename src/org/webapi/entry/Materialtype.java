package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Materialtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_material_type", schema = "dbo", catalog = "ZHPJY")
public class Materialtype implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer moduleTypeid;
	private String moduleName;

	// Constructors

	/** default constructor */
	public Materialtype() {
	}

	/** full constructor */
	public Materialtype(String moduleName) {
		this.moduleName = moduleName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "module_typeid", unique = true)
	public Integer getModuleTypeid() {
		return this.moduleTypeid;
	}

	public void setModuleTypeid(Integer moduleTypeid) {
		this.moduleTypeid = moduleTypeid;
	}

	@Column(name = "module_name")
	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}