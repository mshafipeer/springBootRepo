package com.myBuzzApp.springBoot.apis.productInventory.productStockDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils.ProductStockViewDetails;
import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils.ProductStockViewService;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.constants.URLConstants;
 
@CrossOrigin(origins = URLConstants.CROSS_ORIGIN_VALUE)
@RestController
public class ProductStockController {
	
	@Autowired
	private ProductStockService productStockService;
	@Autowired
	private ProductStockViewService productStockViewService;
	
	
	@RequestMapping(method=RequestMethod.GET,value=URLConstants.GET_ALL_STOCK_DETAILS)
	public ResponseDetails getAllStockDetails()
	{
		return productStockService.getAllStockDetails();
	}
	
	@RequestMapping(method=RequestMethod.POST,value = URLConstants.GET_STOCK_DETAILS_BY_ID)
	public ResponseDetails getStockById(@RequestBody ProductStockDetails productStockDetails)
	{
		return productStockService.getStockById(productStockDetails);
	}

	@RequestMapping(method=RequestMethod.POST,value = URLConstants.ADD_PRODUCT_STOCK_DETAILS)
	public ResponseDetails addStockDetails(@RequestBody ProductStockDetails productStockDetails)
	{
		return productStockService.addStockDetails(productStockDetails);
	}
	
	@RequestMapping(method=RequestMethod.POST,value = URLConstants.GET_STOCK_BY_BRAND_AND_MODEL)
	public ResponseDetails getStockByBrandAndModel(@RequestBody ProductStockDetails productStockDetails) 
	{
		return productStockService.getStockByBrandAndModel(productStockDetails.getBrandId(),productStockDetails.getModelId());	
	}
	
	@RequestMapping(method=RequestMethod.POST,value = URLConstants.GET_STOCK_BY_BRAND_MODEL_AND_SPARE_PARTS)
	public ResponseDetails getStockByBrandModelAndSpareParts(@RequestBody ProductStockDetails productStockDetails) 
	{
		return productStockService.getStockByBrandModelAndSpareParts(productStockDetails.getBrandId(),productStockDetails.getModelId(),productStockDetails.getSparePartId());	
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value=URLConstants.GET_ALL_STOCK_VIEW_DETAILS)
	public ResponseDetails getAllStockViewDetails()
	{ 
		return productStockViewService.getAllStockViewDetails();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getStockDeatilsByBrandAndModel")
	public ResponseDetails getStockByBrandAndModelFromView(@RequestBody ProductStockViewDetails productStockViewDetails) 
	{	System.out.println("in conrtoller getStockByBrandAndModelFromView :"+productStockViewDetails.getBrandId());
		return productStockViewService.getStockByBrandAndModelFromView(productStockViewDetails.getBrandId(),productStockViewDetails.getModelId());	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getStockDeatilsByBrandModelAndSpareParts")
	public ResponseDetails getStockByBrandModelAndSparePartsFromView(@RequestBody ProductStockDetails productStockDetails) 
	{
		return productStockViewService.getStockByBrandModelAndSparePartsFromView(productStockDetails.getBrandId(),productStockDetails.getModelId(),productStockDetails.getSparePartId());	
	}
	
	
	
	

}
