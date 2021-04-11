package com.myBuzzApp.springBoot.apis.productInventory.productParts;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ProductPartsDAO  extends CrudRepository<ProductPartDetails,Integer>{
	
	ProductPartDetails findByBrandIdAndModelIdAndSparePartName(int brandId,int brandModel,String partName);
	
	List<ProductPartDetails> findByModelId(int modelId);
	List<ProductPartDetails> findByBrandId(int brandId);
	List<ProductPartDetails> findByBrandIdAndModelId(int brandId,int modelId); 
	
} 
