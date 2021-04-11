package com.myBuzzApp.springBoot.apis.productInventory.brandDetails;

import org.springframework.data.repository.CrudRepository;

public interface BrandDAO  extends CrudRepository<ProductBrand,Integer>{
	
	ProductBrand findByBrandName(String brandName);
	ProductBrand findByBrandDiscription(String desc);
}
