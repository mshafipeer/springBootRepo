package com.myBuzzApp.springBoot.apis.productInventory.productParts;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.SharedService;
import com.myBuzzApp.springBoot.apis.shared.Utill;

@Service
public class ProductPartsService {

	@Autowired
	private ProductPartsDAO productPartsDAO;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	private ResponseDetails responseDetails;
	
	public ResponseDetails getAllProductPartsDetails()
	{
		try{
			 List<ProductPartDetails> productPartsModels = (List<ProductPartDetails>) productPartsDAO.findAll();
			 if(Utill.isValidObject(productPartsModels)){
				responseDetails.setProductPartDetailsList(productPartsModels);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			 }else{ 
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			 }
		}catch(Exception ex) {
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
     return responseDetails;
	}
	
	public ResponseDetails addProductSparePartsDetails(ProductPartDetails productPartDetails)
	{	
		if(Utill.isValidObject(productPartDetails)) {
			System.out.println("productPartsModel.getBrandName() :"+productPartDetails.getSparePartName());
			ProductPartDetails productPartDetailEntity = null;
		    try{
		    	if(productPartDetails.getId() == 0){
		    		int brandId = productPartDetails.getBrandId();
		    		int modelId = productPartDetails.getModelId();
		    		String sparePartName = productPartDetails.getSparePartName();
		    	    productPartDetailEntity = (ProductPartDetails) productPartsDAO.
		    	    						  findByBrandIdAndModelIdAndSparePartName(brandId,modelId,sparePartName);
		    	 }
		    	 if(productPartDetailEntity == null || productPartDetails.getId() > 0 ){ 
		    		   productPartDetailEntity = productPartsDAO.save(productPartDetails);
		    		   responseDetails.setProductPartDetails(productPartDetailEntity);
					   responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.RECORD_UPDATED_SUCESSFULY);
				 }else {
					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"spare part "+productPartDetails.getSparePartName() +" already exists ");
				 }
		   }catch(Exception ex)
		   {
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		   }
		}
		return responseDetails;
	} 
	 
	public ResponseDetails getSparePartsByModelId(String modelId)
	{
		System.out.println("getSparePartsByBrandId brandId:"+modelId);
		if(Utill.isValidObject(modelId))
		{
			try{
				List<ProductPartDetails> productPartDetailsList = (List<ProductPartDetails>) productPartsDAO.findByModelId(Integer.parseInt(modelId));
				if(Utill.isValidObject(productPartDetailsList)) {
					responseDetails.setProductPartDetailsList(productPartDetailsList);
					responseDetails = sharedService.setSucessResponse(responseDetails);
				}else {
					responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
				}
			}catch(Exception ex) 
			{ System.out.println(ex.getMessage());
				responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
			}
			
		}else {
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"modelId not passed properly. please check");
		}
		return responseDetails; 
	}
	
	
	public ResponseDetails getSparePartsByBrandId(String brandId)
	{	
		System.out.println("getSparePartsByBrandId brandId:"+brandId);
		try{
			List<ProductPartDetails> productPartDetailsList = (List<ProductPartDetails>) productPartsDAO.findByBrandId(Integer.parseInt(brandId));
			if(Utill.isValidObject(productPartDetailsList)) {
				responseDetails.setProductPartDetailsList(productPartDetailsList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			}else {
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			}
		}catch(Exception ex)
		{ System.out.println(ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
		return responseDetails; 
	}
	
	
	public ResponseDetails getSparePartsByBrandAndModelId(int brandId,int modelId)
	{	
		System.out.println("getSparePartsByBrandAndModelId brandId:"+brandId);
		try{
			List<ProductPartDetails> productPartDetailsList = (List<ProductPartDetails>) productPartsDAO.findByBrandIdAndModelId(brandId,modelId);
			if(Utill.isValidObject(productPartDetailsList)) {
				responseDetails.setProductPartDetailsList(productPartDetailsList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			}else {
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			}
		}catch(Exception ex)
		{ System.out.println(ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
		return responseDetails; 
	}
	 

	
	
	
	
}
