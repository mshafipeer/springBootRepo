package com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name ="V_PRODUCT_STOCK_DETAILS")
 public class ProductStockViewDetails  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  
	@Id
	@Column(name="ID")
	private int id; 

	@Column(name="BRAND_ID")
	private int brandId;
	
	@Column(name="BRAND_NAME")
	private String brandName ;
	
	@Column(name="BRAND_DESC")
	private String brandDesc ;
	
	@Column(name="MODEL_ID")
	private int modelId ;
	
	@Column(name="MODEL_NAME")
	private String modelName;
	
	@Column(name="MODEL_DESC")
	private String modelDesc;
	
	@Column(name="SPARE_PART_ID")
	private int sparePartId;
	
	@Column(name="SPARE_PART_NAME")
	private String sparePartName ;
	
	@Column(name="SPARE_PART_DESC")
	private String sparePartDesc;
	
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
	
	@Column(name="CREATED_DATE")
	private String createdDate ;
	
	
	
//	@Column(name="PRODUCT_TYPE")
//	private String productType;

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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandDesc() {
		return brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelDesc() {
		return modelDesc;
	}

	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}

	public int getSparePartId() {
		return sparePartId;
	}

	public void setSparePartId(int sparePartId) {
		this.sparePartId = sparePartId;
	}

	public String getSparePartName() {
		return sparePartName;
	}

	public void setSparePartName(String sparePartName) {
		this.sparePartName = sparePartName;
	}

	public String getSparePartDesc() {
		return sparePartDesc;
	}

	public void setSparePartDesc(String sparePartDesc) {
		this.sparePartDesc = sparePartDesc;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
