package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * State entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_state", schema = "dbo", catalog = "ZHPJY")
public class State implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer stateid;
	private Integer value;
	private String text;

	// Constructors

	/** default constructor */
	public State() {
	}

	/** full constructor */
	public State(Integer value, String text) {
		this.value = value;
		this.text = text;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "stateid", unique = true)
	public Integer getStateid() {
		return this.stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	@Column(name = "value")
	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Column(name = "text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}