package org.webapi.entry;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mateialsubscribe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_material_subscribe", schema = "dbo", catalog = "ZHPJY")
public class Materialsubscribe implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userid;
	private Integer moduleid;
	private Integer secondaryCategoryid;
	private Integer subscribeState;
	private Integer showTypeid;

	// Constructors

	/** default constructor */
	public Materialsubscribe() {
	}

	/** minimal constructor */
	public Materialsubscribe(Integer userid, Integer moduleid,
			Integer subscribeState, Integer showTypeid) {
		this.userid = userid;
		this.moduleid = moduleid;
		this.subscribeState = subscribeState;
		this.showTypeid = showTypeid;
	}

	/** full constructor */
	public Materialsubscribe(Integer userid, Integer moduleid,
			Integer secondaryCategoryid, Integer subscribeState,
			Integer showTypeid) {
		this.userid = userid;
		this.moduleid = moduleid;
		this.secondaryCategoryid = secondaryCategoryid;
		this.subscribeState = subscribeState;
		this.showTypeid = showTypeid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "moduleid")
	public Integer getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	@Column(name = "secondary_categoryid")
	public Integer getSecondaryCategoryid() {
		return this.secondaryCategoryid;
	}

	public void setSecondaryCategoryid(Integer secondaryCategoryid) {
		this.secondaryCategoryid = secondaryCategoryid;
	}

	@Column(name = "subscribe_state")
	public Integer getSubscribeState() {
		return this.subscribeState;
	}

	public void setSubscribeState(Integer subscribeState) {
		this.subscribeState = subscribeState;
	}

	@Column(name = "show_typeid")
	public Integer getShowTypeid() {
		return this.showTypeid;
	}

	public void setShowTypeid(Integer showTypeid) {
		this.showTypeid = showTypeid;
	}

}