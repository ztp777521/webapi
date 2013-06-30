package org.webapi.entry;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Integratematerial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_integrate_material", schema = "dbo", catalog = "ZHPJY")
public class Integratematerial implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer materialid;
	private String materialContent;
	private String materialPicture;
	private Integer moduleTypeid;
	private String materialTitle;
	private Integer materialState;
	private String materialVideo;
	private Date materialCommitDate;
	private Date materialPublicDate;
	private Integer showTypeid;
	private String materialSource;
	private Integer commitPersonid;

	// Constructors

	/** default constructor */
	public Integratematerial() {
	}

	/** minimal constructor */
	public Integratematerial(String materialContent, Integer moduleTypeid,
			String materialTitle, Integer materialState) {
		this.materialContent = materialContent;
		this.moduleTypeid = moduleTypeid;
		this.materialTitle = materialTitle;
		this.materialState = materialState;
	}

	/** full constructor */
	public Integratematerial(String materialContent, String materialPicture,
			Integer moduleTypeid, String materialTitle, Integer materialState,
			String materialVideo, Date materialCommitDate,
			Date materialPublicDate, Integer showTypeid, String materialSource,
			Integer commitPersonid) {
		this.materialContent = materialContent;
		this.materialPicture = materialPicture;
		this.moduleTypeid = moduleTypeid;
		this.materialTitle = materialTitle;
		this.materialState = materialState;
		this.materialVideo = materialVideo;
		this.materialCommitDate = materialCommitDate;
		this.materialPublicDate = materialPublicDate;
		this.showTypeid = showTypeid;
		this.materialSource = materialSource;
		this.commitPersonid = commitPersonid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "materialid", unique = true)
	public Integer getMaterialid() {
		return this.materialid;
	}

	public void setMaterialid(Integer materialid) {
		this.materialid = materialid;
	}

	@Column(name = "material_content")
	public String getMaterialContent() {
		return this.materialContent;
	}

	public void setMaterialContent(String materialContent) {
		this.materialContent = materialContent;
	}

	@Column(name = "material_picture")
	public String getMaterialPicture() {
		return this.materialPicture;
	}

	public void setMaterialPicture(String materialPicture) {
		this.materialPicture = materialPicture;
	}

	@Column(name = "module_typeid")
	public Integer getModuleTypeid() {
		return this.moduleTypeid;
	}

	public void setModuleTypeid(Integer moduleTypeid) {
		this.moduleTypeid = moduleTypeid;
	}

	@Column(name = "material_title")
	public String getMaterialTitle() {
		return this.materialTitle;
	}

	public void setMaterialTitle(String materialTitle) {
		this.materialTitle = materialTitle;
	}

	@Column(name = "material_state")
	public Integer getMaterialState() {
		return this.materialState;
	}

	public void setMaterialState(Integer materialState) {
		this.materialState = materialState;
	}

	@Column(name = "material_video")
	public String getMaterialVideo() {
		return this.materialVideo;
	}

	public void setMaterialVideo(String materialVideo) {
		this.materialVideo = materialVideo;
	}

	@Column(name = "material_commit_date", length = 23)
	public Date getMaterialCommitDate() {
		return this.materialCommitDate;
	}

	public void setMaterialCommitDate(Date materialCommitDate) {
		this.materialCommitDate = materialCommitDate;
	}

	@Column(name = "material_public_date", length = 23)
	public Date getMaterialPublicDate() {
		return this.materialPublicDate;
	}

	public void setMaterialPublicDate(Date materialPublicDate) {
		this.materialPublicDate = materialPublicDate;
	}

	@Column(name = "show_typeid")
	public Integer getShowTypeid() {
		return this.showTypeid;
	}

	public void setShowTypeid(Integer showTypeid) {
		this.showTypeid = showTypeid;
	}

	@Column(name = "material_source")
	public String getMaterialSource() {
		return this.materialSource;
	}

	public void setMaterialSource(String materialSource) {
		this.materialSource = materialSource;
	}

	@Column(name = "commit_personid")
	public Integer getCommitPersonid() {
		return this.commitPersonid;
	}

	public void setCommitPersonid(Integer commitPersonid) {
		this.commitPersonid = commitPersonid;
	}

}