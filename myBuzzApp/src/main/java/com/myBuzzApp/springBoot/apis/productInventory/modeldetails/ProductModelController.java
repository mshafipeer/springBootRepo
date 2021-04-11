package com.myBuzzApp.springBoot.apis.productInventory.modeldetails;

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
public class ProductModelController {
	
	@Autowired 
	private ProductModelService productModelService;
	
	@RequestMapping(method=RequestMethod.POST,value="/addModelDetails")
	public ResponseDetails addBrandDetails(@RequestBody ProductModel productModel)
	{
		System.out.println(" from controller productModel.getModelName() :"+productModel.getModelName());
		return productModelService.addModelDetails(productModel);
	}

	@RequestMapping(method=RequestMethod.POST,value="/getAllModelsByBrand")
	public ResponseDetails getAllModelsByBrand(@RequestBody String brandId)
	{
		System.out.println(" from controller brandId :"+brandId);
		return productModelService.getAllModelsByBrand(brandId);	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllModels")
	public ResponseDetails getAllModels()
	{
		System.out.println(" from controller brandId :");
		return productModelService.getAllModels();	
	}
	
}
