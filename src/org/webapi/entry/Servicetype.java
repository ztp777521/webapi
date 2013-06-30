package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Servicetype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_service_type", schema = "dbo", catalog = "ZHPJY")
public class Servicetype implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer serviceTypyid;
	private String serviceName;

	// Constructors

	/** default constructor */
	public Servicetype() {
	}

	/** full constructor */
	public Servicetype(String serviceName) {
		this.serviceName = serviceName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "service_typyid", unique = true)
	public Integer getServiceTypyid() {
		return this.serviceTypyid;
	}

	public void setServiceTypyid(Integer serviceTypyid) {
		this.serviceTypyid = serviceTypyid;
	}

	@Column(name = "service_name")
	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}