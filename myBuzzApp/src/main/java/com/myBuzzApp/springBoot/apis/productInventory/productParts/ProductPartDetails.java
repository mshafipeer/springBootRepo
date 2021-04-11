package com.myBuzzApp.springBoot.apis.productInventory.productParts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.myBuzzApp.springBoot.apis.productInventory.brandDetails.ProductBrand;
import com.myBuzzApp.springBoot.apis.productInventory.modeldetails.ProductModel;

@Entity
@Table(name ="PRODUCT_PARTS_DETAILS")
public class ProductPartDetails {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id; 
	
	@Column(name="BRAND_ID")
	private int brandId;
	
	@Column(name="MODEL_ID")
	private int modelId ;
	
	@Column(name="SPARE_PART_NAME")
	private String sparePartName ;
	
	
	@Column(name="SPARE_PART_DESC")
	private String spareDiscription ;

	@Column(name="DELETION_STATUS")
    private String deletionStatus = "N";
	
//	@ManyToOne
//    @JoinColumn(name="BRAND_ID" ,referencedColumnName = "ID" , insertable = false, updatable = false)
//    private ProductBrand productBrand;
	
	@ManyToOne
    @JoinColumn(name="MODEL_ID" ,referencedColumnName = "ID" , insertable = false, updatable = false)
    private ProductModel productModel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getSparePartName() {
		return sparePartName;
	}

	public void setSparePartName(String sparePartName) {
		this.sparePartName = sparePartName;
	}

	public String getSpareDiscription() {
		return spareDiscription;
	}

	public void setSpareDiscription(String spareDiscription) {
		this.spareDiscription = spareDiscription;
	}

	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}

//	public ProductBrand getProductBrand() {
//		return productBrand;
//	} 
//
//	public void setProductBrand(ProductBrand productBrand) {
//		this.productBrand = productBrand;
//	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
	
	
}
