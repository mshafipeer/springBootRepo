package com.myBuzzApp.springBoot.apis.productInventory.modeldetails;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ProductModelDAO  extends CrudRepository<ProductModel,Integer>{
	
	ProductModel findByModelName(String modelName); 
	
	ProductModel findByBrandIdAndModelName(int brandId ,String modelName);
	
	List<ProductModel> findByBrandId(int brandId);
}
