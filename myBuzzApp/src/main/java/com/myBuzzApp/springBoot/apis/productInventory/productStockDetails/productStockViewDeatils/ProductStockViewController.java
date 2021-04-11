package com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockDetails;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.constants.URLConstants;

@CrossOrigin(origins = URLConstants.CROSS_ORIGIN_VALUE)
@RestController
public class ProductStockViewController {
	
	@Autowired
	private ProductStockViewService productStockViewService;
	
	@RequestMapping(method=RequestMethod.POST,value= URLConstants.GET_STOCK_VIEW_DETAILS_BY_PRODUCT_REFERENCE)
	public ResponseDetails getStockViewDetailsByProductReference(@RequestBody ProductStockDetails productStockDetails) 
	{
		return productStockViewService.getStockViewDetailsByProductReference(productStockDetails);	
	}
	

}
