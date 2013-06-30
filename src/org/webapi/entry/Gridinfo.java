package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gridinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_gridinfo", schema = "dbo", catalog = "ZHPJY")
public class Gridinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String gridName;
	private String gridnum;

	// Constructors

	/** default constructor */
	public Gridinfo() {
	}

	/** full constructor */
	public Gridinfo(String gridName, String gridnum) {
		this.gridName = gridName;
		this.gridnum = gridnum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true )
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "grid_name" )
	public String getGridName() {
		return this.gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	@Column(name = "gridnum" )
	public String getGridnum() {
		return this.gridnum;
	}

	public void setGridnum(String gridnum) {
		this.gridnum = gridnum;
	}

}