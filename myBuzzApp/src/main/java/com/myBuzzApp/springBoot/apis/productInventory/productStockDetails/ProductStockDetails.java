package com.myBuzzApp.springBoot.apis.productInventory.productStockDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.myBuzzApp.springBoot.apis.productInventory.brandDetails.ProductBrand;
import com.myBuzzApp.springBoot.apis.productInventory.modeldetails.ProductModel;
import com.myBuzzApp.springBoot.apis.productInventory.productParts.ProductPartDetails;
import com.myBuzzApp.springBoot.apis.systemConfig.systemcodes.systemCodeValues.SystemCodeValuesDetails;



@Entity
@Table(name ="PRODUCT_STOCK_DETAILS")
public class ProductStockDetails  {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id; 
	
	@Column(name="PRODUCT_TYPE")
	private int productType;
	
	//@Column(name="BRAND_ID",insertable=false, updatable=false)
	@Column(name="BRAND_ID")
	private int brandId;
	
	@Column(name="MODEL_ID")
	private int modelId;
	
	@Column(name="SPARE_PART_ID")
	private int sparePartId ;
	
	@Column(name="QUALITY")
	private String productQuality ;
	
	@Column(name="RETAIL_BUY")
	private int retailBuy ;
	
	@Column(name="RETAIL_SELL")
	private int retailSell ;
	
	@Column(name="WHOLESALE_BUY")
	private int wholeSaleBuy ;
	
	@Column(name="WHOLESALE_SELL")
	private int wholeSaleSell ;
	
	@Column(name="TOTAL_QUANTITY")
	private int quantity ;
	
	@Column(name="SOLD_QUANTITY")
	private int soldQuantity ;
	
	@Column(name="INVOICE_ID")
	private String invoiceId ;
	
	@Column(name="INVOICE_NUMBER")
	private String invoiceNumber ;
	
	@Column(name="PROD_REFRENCE_ID")
	private String productRefrence ;
	
	@Column(name="NOTES")
	private String notes ;
	
	@Column(name="CREATED_USER_ID")
	private String cretedUserId ="admin";
	
	@Column(name="DELETION_STATUS")
    private String deletionStatus = "N";
	
	
	@ManyToOne
    @JoinColumn(name="SPARE_PART_ID" ,referencedColumnName = "ID" , insertable = false, updatable = false)
    private ProductPartDetails productPartDetails;
    
	
	 
	
	@ManyToOne
    @JoinColumn(name="PRODUCT_TYPE" ,referencedColumnName = "SYSTEM_CODE_DTL_ID" , insertable = false, updatable = false)
    private SystemCodeValuesDetails productTypeDetails;

	@ManyToOne
    @JoinColumn(name="QUALITY" ,insertable = false, updatable = false)
    private SystemCodeValuesDetails productQualityDetails;

	
//	@ManyToOne(targetEntity=ProductBrand.class,cascade =CascadeType.ALL)
//	//@ManyToOne(targetEntity=ProductBrand.class)
//	@JoinColumn(name ="BRAND_ID", referencedColumnName= "ID")
//	private ProductBrand productBrand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
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

	public int getSparePartId() {
		return sparePartId;
	}

	public void setSparePartId(int sparePartId) {
		this.sparePartId = sparePartId;
	}

	public String getProductQuality() {
		return productQuality;
	}

	public void setProductQuality(String productQuality) {
		this.productQuality = productQuality;
	}

	public int getRetailBuy() {
		return retailBuy;
	}

	public void setRetailBuy(int retailBuy) {
		this.retailBuy = retailBuy;
	}

	public int getRetailSell() {
		return retailSell;
	}

	public void setRetailSell(int retailSell) {
		this.retailSell = retailSell;
	}

	public int getWholeSaleBuy() {
		return wholeSaleBuy;
	}

	public void setWholeSaleBuy(int wholeSaleBuy) {
		this.wholeSaleBuy = wholeSaleBuy;
	}

	public int getWholeSaleSell() {
		return wholeSaleSell;
	}

	public void setWholeSaleSell(int wholeSaleSell) {
		this.wholeSaleSell = wholeSaleSell;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getProductRefrence() {
		return productRefrence;
	}

	public void setProductRefrence(String productRefrence) {
		this.productRefrence = productRefrence;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCretedUserId() {
		return cretedUserId;
	}

	public void setCretedUserId(String cretedUserId) {
		if(cretedUserId==null || "".equalsIgnoreCase(cretedUserId)){
			cretedUserId = "admin";
		}
		this.cretedUserId = cretedUserId;
	}
	
	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}

	public ProductPartDetails getProductPartDetails() {
		return productPartDetails;
	}

	public void setProductPartDetails(ProductPartDetails productPartDetails) {
		this.productPartDetails = productPartDetails;
	}

	public SystemCodeValuesDetails getProductTypeDetails() {
		return productTypeDetails;
	}

	public void setProductTypeDetails(SystemCodeValuesDetails productTypeDetails) {
		this.productTypeDetails = productTypeDetails;
	}

	public SystemCodeValuesDetails getProductQualityDetails() {
		return productQualityDetails;
	}

	public void setProductQualityDetails(SystemCodeValuesDetails productQualityDetails) {
		this.productQualityDetails = productQualityDetails;
	}
	
//	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
//	  <modelVersion>4.0.0</modelVersion>
//	  <groupId>mybizzApp.sb</groupId>
//	  <artifactId>myBuzzApp</artifactId>
//	  <version>0.0.1-SNAPSHOT</version>
//	  <packaging>pom</packaging>
//	  <name>My Business Application</name>
//	  <description>My Business Application</description>
//	</project>
}
