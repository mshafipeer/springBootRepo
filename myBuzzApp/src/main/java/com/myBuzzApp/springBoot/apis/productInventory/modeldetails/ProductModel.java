package com.myBuzzApp.springBoot.apis.productInventory.modeldetails;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.myBuzzApp.springBoot.apis.productInventory.brandDetails.ProductBrand;
import com.myBuzzApp.springBoot.apis.productInventory.productParts.ProductPartDetails;

@Entity
@Table(name ="PRODUCT_MODEL")
public class ProductModel {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id; 
	
	@Column(name="MODEL_NAME")
	private String modelName;
	
	@Column(name="MODEL_DESC")
	private String modelDiscription ;
	
	@Column(name="DELETION_STATUS")
    private String deletionStatus = "N";
	
	@Column(name="BRAND_ID")
	private int brandId;
 
    @ManyToOne
    @JoinColumn(name="BRAND_ID" ,referencedColumnName = "ID" , insertable = false, updatable = false)
    private ProductBrand productBrand;
    
//    @ManyToOne(targetEntity = ProductBrand.class)
//    @JoinColumn(name="id", referencedColumnName= "brandId" )
//    private ProductBrand productBrand;
	
//	@OneToMany(targetEntity = ProductPartDetails.class,cascade =CascadeType.ALL)
//	@JoinColumn(name ="MODEL_ID", referencedColumnName= "ID")
//	private List<ProductPartDetails> productPartDetails;
	

//	public List<ProductPartDetails> getProductPartsModel() {
//		return productPartDetails;
//	}
//
//	public void setProductPartsModel(List<ProductPartDetails> productPartDetails) {
//		this.productPartDetails = productPartDetails;
//	}



	public int getId() {
		return id;
	}
	
	

	public void setId(int id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelDiscription() {
		return modelDiscription;
	}

	public void setModelDiscription(String modelDiscription) {
		this.modelDiscription = modelDiscription;
	}

	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

//	public String getBrandName() {
//		return brandName;
//	}
//
//	public void setBrandName(String brandName) {
//		this.brandName = brandName;
//	}
	
	public ProductBrand getProductBrand() {
		return productBrand;
	}



	public void setProductBrand(ProductBrand productBrand) {
		this.productBrand = productBrand;
	}



	public ProductModel(int id, String modelName, String modelDiscription, String deletionStatus, int brandId,
			List<ProductPartDetails> productPartDetails) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.modelDiscription = modelDiscription;
		this.deletionStatus = deletionStatus;
		this.brandId = brandId;
		//this.productPartDetails = productPartDetails;
	}
	

	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
