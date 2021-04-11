package com.myBuzzApp.springBoot.apis.productInventory.brandDetails;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;



@Entity
@Table(name ="PRODUCT_BRAND")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductBrand { 

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id; 
	
	@Column(name="BRAND_NAME")
	private String brandName;
	
	@Column(name="BRAND_DESC")
	private String brandDiscription ;
	

	@JsonIgnoreProperties(ignoreUnknown =true)
	@Column(name="DELETION_STATUS")
    private String deletionStatus = "N";
	

//	@OneToMany(targetEntity = ProductModel.class,cascade =CascadeType.ALL)
//	@JoinColumn(name ="brand_Id", referencedColumnName= "ID")
//	private List<ProductModel> productModel;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandDiscription() {
		return brandDiscription;
	}

	public void setBrandDiscription(String brandDiscription) {
		this.brandDiscription = brandDiscription;
	}

	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}
	
//	public List<ProductModel> getProductModel() {
//		return productModel;
//	}
//
//	public void setProductModel(List<ProductModel> productModel) {
//		this.productModel = productModel;
//	}
	
	public ProductBrand(int id, String brandName, String brandDiscription, String deletionStatus) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.brandDiscription = brandDiscription;
		this.deletionStatus = deletionStatus;
	}

	public ProductBrand() {

		// TODO Auto-generated constructor stub
	}

	
	
	
}
