package com.myBuzzApp.springBoot.apis.productInventory.productStockDetails;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductStockDAO  extends CrudRepository<ProductStockDetails,Integer>{
	
	ProductStockDetails findByBrandIdAndModelIdAndSparePartIdAndInvoiceNumber(int brandId,int modelId,int sparePartId,String invoiceNumber);

	ProductStockDetails  findByProductRefrence(String productRefrence);
	
	List<ProductStockDetails> findByBrandIdAndModelId(int brandId,int modelId);
	List<ProductStockDetails> findByBrandIdAndModelIdAndSparePartId(int brandId,int modelId,int sparePartId);
	ProductStockDetails findById(int id);
	 
	@Modifying
	@Query("update ProductStockDetails ps set ps.soldQuantity = ?1 where ps.id = ?2")
	int setSoldQuantityForProductStockDetails(int quantity, int id);
	
}
 