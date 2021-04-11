package com.myBuzzApp.springBoot.apis.systemConfig.systemcodes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.myBuzzApp.springBoot.apis.systemConfig.systemcodes.systemCodeValues.SystemCodeValuesDetails;


//@NamedQuery(name = "SystemCodeDetails.findBySystemCodeType",query = "SELECT a FROM SystemCodeDetails a ORDER BY c.name DESC")
@Entity
@Table(name ="GENERIC_MST_SYSTEM_CODE")
public class SystemCodeDetails  {
	
	@Id
	@GeneratedValue
	@Column(name="SYSTEM_CODE_ID")
	private int systemCodeId; 
	
	@Column(name="SYSTEM_CODE_TYPE")
	private String systemCodeType;
	
	@Column(name="SYSTEM_CODE_DESC")
	private String systemCodeDesc ;
	
	@Column(name="DELETION_STATUS")
    private String deletionStatus = "N";
	  
	//@OneToMany(targetEntity = SystemCodeValuesDetails.class,cascade =CascadeType.ALL) 
	@OneToMany(targetEntity = SystemCodeValuesDetails.class,cascade =CascadeType.ALL) 
	@JoinColumn(name ="SYSTEM_CODE_ID", referencedColumnName= "SYSTEM_CODE_ID")
	private List<SystemCodeValuesDetails>  dtlSystemCodeDetails;

//	@OneToMany(targetEntity = SystemCodeValuesDetails.class,cascade =CascadeType.ALL) 
//	@JoinColumn(name ="SYSTEM_CODE_ID", referencedColumnName= "SYSTEM_CODE_ID")
//	private List<SystemCodeValuesDetails>  dtlSystemCodeDetails;

	public int getSystemCodeId() {
		return systemCodeId;
	}

	public void setSystemCodeId(int systemCodeId) {
		this.systemCodeId = systemCodeId;
	}

	public String getSystemCodeType() {
		return systemCodeType;
	}

	public void setSystemCodeType(String systemCodeType) {
		this.systemCodeType = systemCodeType;
	}

	public String getSystemCodeDesc() {
		return systemCodeDesc;
	}

	public void setSystemCodeDesc(String systemCodeDesc) {
		this.systemCodeDesc = systemCodeDesc;
	}

	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}

	public List<SystemCodeValuesDetails> getDtlSystemCodeDetails() {
		return dtlSystemCodeDetails;
	}

	public void setDtlSystemCodeDetails(List<SystemCodeValuesDetails> dtlSystemCodeDetails) {
		this.dtlSystemCodeDetails = dtlSystemCodeDetails;
	}

//	public List<SystemCodeValuesDetails> getSystemCodeValuesDetailsList() {
//		return systemCodeValuesDetailsList;
//	}
//
//	public void setSystemCodeValuesDetailsList(List<SystemCodeValuesDetails> systemCodeValuesDetailsList) {
//		this.systemCodeValuesDetailsList = systemCodeValuesDetailsList;
//	}

	
//	@ManyToOne(targetEntity=ProductBrand.class,cascade =CascadeType.ALL)
//	@ManyToOne(targetEntity=ProductBrand.class)
//	@JoinColumn(name ="BRAND_ID", referencedColumnName= "ID")
//	private ProductBrand productBrand;

	
	
}
