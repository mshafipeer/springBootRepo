package com.myBuzzApp.springBoot.apis.productInventory.brandDetails;

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
public class BrandController {
	
	
	@Autowired
	private BrandService brandService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllBrandDetails")
	public ResponseDetails getAllBrandDetails()
	{
		return brandService.getAllBrandDetails();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addBrandDetails")
	public ResponseDetails addBrandDetails(@RequestBody ProductBrand brandEntity)
	{
		return brandService.addBrandDetails(brandEntity);
	}
	

}
