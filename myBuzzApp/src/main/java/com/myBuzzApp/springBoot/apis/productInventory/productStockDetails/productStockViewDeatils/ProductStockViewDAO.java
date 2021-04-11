package com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockDetails;

public interface ProductStockViewDAO extends CrudRepository<ProductStockViewDetails,Integer> {
	
ProductStockDetails findByBrandIdAndModelIdAndSparePartIdAndInvoiceNumber(int brandId,int modelId,int sparePartId,String invoiceNumber);

	boolean existsByInvoiceNumber(String invoiceNumber);
	List<ProductStockViewDetails> findByBrandIdAndModelId(int brandId,int modelId);
	List<ProductStockViewDetails> findByBrandIdAndModelIdAndSparePartId(int brandId,int modelId,int sparePartId);
	
	ProductStockViewDetails findByProductRefrence(String productRefrence); 
	
	

}
