package com.myBuzzApp.springBoot.apis.productInventory.productParts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;

@CrossOrigin(origins = Constants.CROSS_ORIGIN_VALUE)
@RestController
public class ProductPartsController {
	
	@Autowired
	private ProductPartsService productPartsService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllSparePartsDetails")
	public ResponseDetails getAllProductPartDetails()
	{
		return productPartsService.getAllProductPartsDetails();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addSparePartsDetails")
	public ResponseDetails addProductSparePartsDetails(@RequestBody ProductPartDetails productPartDetails)
	{
		return productPartsService.addProductSparePartsDetails(productPartDetails);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getSparePartsByBrands")
	public ResponseDetails getSparePartsByBrandId(@RequestBody String brandId)
	{
		System.out.println(" from controller modelId :"+brandId);
		return productPartsService.getSparePartsByBrandId(brandId);	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getSparePartsByModel")
	public ResponseDetails getSparePartsByModelId(@RequestBody String modelId)
	{
		System.out.println(" from controller modelId :"+modelId);
		return productPartsService.getSparePartsByModelId(modelId);	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getSparePartsByBrandAndModels")
	public ResponseDetails getSparePartsByBrandAndModelId(@RequestBody ProductPartDetails productPartDetails) 
	{
		return productPartsService.getSparePartsByBrandAndModelId(productPartDetails.getBrandId(),productPartDetails.getModelId());	
	}

}
