package com.myBuzzApp.springBoot.apis.shared;


import java.util.List;

import org.springframework.stereotype.Service;

import com.myBuzzApp.springBoot.apis.productInventory.brandDetails.ProductBrand;
import com.myBuzzApp.springBoot.apis.productInventory.invoicedetails.InvoiceDetails;
import com.myBuzzApp.springBoot.apis.productInventory.modeldetails.ProductModel;

import com.myBuzzApp.springBoot.apis.productInventory.productParts.ProductPartDetails;
import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockDetails;
import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils.ProductStockViewDetails;
import com.myBuzzApp.springBoot.apis.systemConfig.systemcodes.SystemCodeDetails;

@Service
public class ResponseDetails {
	
	public InvoiceDetails invoiceDetails;
	public List <InvoiceDetails> invoiceDetailsList;
	
	public ProductBrand brandDetails;
	public List <ProductBrand> brandDetailsList; 
	
	public ProductModel productModelDetails;
	public List <ProductModel> productModelDetailsList;
	
	public ProductPartDetails productPartDetails;
	public List <ProductPartDetails> productPartDetailsList;
	
	public ProductStockDetails productStockDetails;
	public List <ProductStockDetails> productStockDetailsList;
	
	public ProductStockViewDetails productStockViewDetails;
	public List<ProductStockViewDetails> productStockViewDetailsList;
	
	
	public SystemCodeDetails mstSystemCodeDetails;
	public List <SystemCodeDetails> mstSystemCodeDetailsList;
	
	
	private String responseDesc;
	private String responseCode;
	 
	public ResponseDetails (){
	}
	
	public ResponseDetails (String responseCode, String responseDesc){
		this.responseCode = responseCode;
		this.responseDesc = responseDesc;
	}
	
	public String getResponseMessage() {
		return responseDesc;
	}
	public void setResponseMessage(String responseDesc) {
		this.responseDesc = responseDesc;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	public InvoiceDetails getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
    
	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	public List<InvoiceDetails> getInvoiceDetailsList() {
		return invoiceDetailsList;
	}

	public void setInvoiceDetailsList(List<InvoiceDetails> invoiceDetailsList) {
		this.invoiceDetailsList = invoiceDetailsList;
	}

	public ProductBrand getBrandDetails() {
		return brandDetails;
	}

	public void setBrandDetails(ProductBrand brandDetails) {
		this.brandDetails = brandDetails;
	}

	public List<ProductBrand> getBrandDetailsList() {
		return brandDetailsList;
	}

	public void setBrandDetailsList(List<ProductBrand> brandDetailsList) {
		this.brandDetailsList = brandDetailsList;
	}

	public ProductModel getProductModelDetails() {
		return productModelDetails;
	}

	public void setProductModelDetails(ProductModel productModelDetails) {
		this.productModelDetails = productModelDetails;
	}

	public List<ProductModel> getProductModelDetailsList() {
		return productModelDetailsList;
	}

	public void setProductModelDetailsList(List<ProductModel> productModelDetailsList) {
		this.productModelDetailsList = productModelDetailsList;
	}

	public ProductPartDetails getProductPartDetails() {
		return productPartDetails;
	}

	public void setProductPartDetails(ProductPartDetails productPartDetails) {
		this.productPartDetails = productPartDetails;
	}

	public List<ProductPartDetails> getProductPartDetailsList() {
		return productPartDetailsList;
	}

	public void setProductPartDetailsList(List<ProductPartDetails> productPartDetailsList) {
		this.productPartDetailsList = productPartDetailsList;
	}

	public ProductStockDetails getProductStockDetails() {
		return productStockDetails;
	}

	public void setProductStockDetails(ProductStockDetails productStockDetails) {
		this.productStockDetails = productStockDetails;
	}

	public List<ProductStockDetails> getProductStockDetailsList() {
		return productStockDetailsList;
	}

	public void setProductStockDetailsList(List<ProductStockDetails> productStockDetailsList) {
		this.productStockDetailsList = productStockDetailsList;
	}

	public ProductStockViewDetails getProductStockViewDetails() {
		return productStockViewDetails;
	}

	public void setProductStockViewDetails(ProductStockViewDetails productStockViewDetails) {
		this.productStockViewDetails = productStockViewDetails;
	}

	public List<ProductStockViewDetails> getProductStockViewDetailsList() {
		return productStockViewDetailsList;
	}

	public void setProductStockViewDetailsList(List<ProductStockViewDetails> productStockViewDetailsList) {
		this.productStockViewDetailsList = productStockViewDetailsList;
	}

	public SystemCodeDetails getMstSystemCodeDetails() {
		return mstSystemCodeDetails;
	}

	public void setMstSystemCodeDetails(SystemCodeDetails mstSystemCodeDetails) {
		this.mstSystemCodeDetails = mstSystemCodeDetails;
	}

	public List<SystemCodeDetails> getMstSystemCodeDetailsList() {
		return mstSystemCodeDetailsList;
	}

	public void setMstSystemCodeDetailsList(List<SystemCodeDetails> mstSystemCodeDetailsList) {
		this.mstSystemCodeDetailsList = mstSystemCodeDetailsList;
	}
	
}
