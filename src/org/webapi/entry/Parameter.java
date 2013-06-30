package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Parameter entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_parameter", schema = "dbo", catalog = "ZHPJY")
public class Parameter implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer parameterid;
	private String pictureName;
	private String pictrueAddress;

	// Constructors

	/** default constructor */
	public Parameter() {
	}

	/** full constructor */
	public Parameter(String pictureName, String pictrueAddress) {
		this.pictureName = pictureName;
		this.pictrueAddress = pictrueAddress;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "parameterid", unique = true)
	public Integer getParameterid() {
		return this.parameterid;
	}

	public void setParameterid(Integer parameterid) {
		this.parameterid = parameterid;
	}

	@Column(name = "picture_name")
	public String getPictureName() {
		return this.pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	@Column(name = "pictrue_address")
	public String getPictrueAddress() {
		return this.pictrueAddress;
	}

	public void setPictrueAddress(String pictrueAddress) {
		this.pictrueAddress = pictrueAddress;
	}

}