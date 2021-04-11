package com.myBuzzApp.springBoot.apis.productInventory.brandDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.CustomerRequest;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.SharedService;
import com.myBuzzApp.springBoot.apis.shared.Utill;

@Service
public class BrandService {

	@Autowired
	private BrandDAO brandDAO;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	CustomerRequest customerRequest;
	
	@Autowired
	ResponseDetails  responseDetails;
	
	public ResponseDetails getAllBrandDetails()
	{
		try {
			List<ProductBrand> productBrandList = (List<ProductBrand>) brandDAO.findAll();
			if(Utill.isValidObject(productBrandList)){
				responseDetails.setBrandDetailsList(productBrandList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			}else{ 
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			}
		}catch(Exception ex) {
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
     return responseDetails;
	}
	
	
	public ResponseDetails addBrandDetails(ProductBrand productBrand)
	{
		ProductBrand brandDetails = null;
		try{
			int id =  Utill.isValidObject(productBrand) ? productBrand.getId() :0;
			if(id == 0) {
				brandDetails = (ProductBrand) brandDAO.findByBrandName(productBrand.getBrandName());
			}
			
			if(brandDetails == null || id > 0 ){ 
				brandDetails = brandDAO.save(productBrand);
				responseDetails.setBrandDetails(brandDetails);
				responseDetails = sharedService.setSucessResponse(responseDetails);
				
				System.out.println("newly created brand : "+brandDetails);
			}else {
				responseDetails.setBrandDetails(productBrand);
				responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"Brand "+productBrand.getBrandName() +" already exists ");
			}
	       
		}catch(Exception ex)
		{
			System.out.println("error "+ex.getMessage());
			responseDetails.setBrandDetails(productBrand);
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
		
		 return responseDetails;
	}
	
}
