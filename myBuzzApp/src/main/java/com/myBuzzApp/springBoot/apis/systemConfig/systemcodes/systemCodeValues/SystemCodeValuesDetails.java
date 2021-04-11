package com.myBuzzApp.springBoot.apis.systemConfig.systemcodes.systemCodeValues;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockDetails;
import com.myBuzzApp.springBoot.apis.systemConfig.systemcodes.SystemCodeDetails;

@Entity 
@Table(name ="GENERIC_DTL_SYSTEM_CODE")
public class SystemCodeValuesDetails {
	 
	@Id
	@GeneratedValue
	@Column(name="SYSTEM_CODE_DTL_ID")
	private int systemCodeDtlId; 
	
	//@ManyToOne
    //@JoinColumn(name = "SystemCodeDetails_systemCodeId")
	//private SystemCodeDetails SystemCodeDetails;
	@Column(name="SYSTEM_CODE_ID")
	private int systemCodeId;
	
	@Column(name="VALUE_CODE")
	private String valueCode ;
	
	@Column(name="VALUE")
	private String value ;
	
	@Column(name="DELETION_STATUS")
    private String deletionStatus = "N";
	
	@OneToMany(mappedBy="productTypeDetails")
	private List<ProductStockDetails> productStockDetails1;

	public int getSystemCodeDtlId() {
		return systemCodeDtlId;
	}

	public void setSystemCodeDtlId(int systemCodeDtlId) {
		this.systemCodeDtlId = systemCodeDtlId;
	}

	public int getSystemCodeId() {
		return systemCodeId;
	}

	public void setSystemCodeId(int systemCodeId) {
		this.systemCodeId = systemCodeId;
	}

	public String getValueCode() {
		return valueCode;
	}

//	public SystemCodeDetails getSystemCodeDetails() {
//		return SystemCodeDetails;
//	}
//
//	public void setSystemCodeDetails(SystemCodeDetails systemCodeDetails) {
//		SystemCodeDetails = systemCodeDetails;
//	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}

}
