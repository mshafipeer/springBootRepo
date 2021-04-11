package com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockDetails;
import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.SharedService;
import com.myBuzzApp.springBoot.apis.shared.Utill;

@Service
public class ProductStockViewService {
	
	@Autowired
	private ProductStockViewDAO productStockViewDAO;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	private ResponseDetails responseDetails;
	 
	public ResponseDetails getStockByBrandAndModelFromView(int brandId,int modelId)
	{	System.out.println("getStockByBrandAndModelFromView with beand id =>"+brandId + "model id => "+modelId);
		try{
			 List<ProductStockViewDetails> productStockViewDetailsList = (List<ProductStockViewDetails>) productStockViewDAO.findByBrandIdAndModelId(brandId,modelId);
			 if(Utill.isValidObject(productStockViewDetailsList)){
				responseDetails.setProductStockViewDetailsList(productStockViewDetailsList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			 }else{ 
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			 }
		}catch(Exception ex) {
			System.out.println("Exception =>"+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
     return responseDetails;
	}
	
	public ResponseDetails getStockByBrandModelAndSparePartsFromView(int brandId,int modelId,int sparePartId)
	{
		System.out.println("getStockByBrandModelAndSparePartsFromView with beand id =>"+brandId + "model id => "+modelId);
		try{
			 List<ProductStockViewDetails> productStockViewDetailsList = (List<ProductStockViewDetails>) productStockViewDAO.findByBrandIdAndModelIdAndSparePartId(brandId,modelId,sparePartId);
			 if(Utill.isValidObject(productStockViewDetailsList)){
				responseDetails.setProductStockViewDetailsList(productStockViewDetailsList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			 }else{ 
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			 }
		}catch(Exception ex) {
			System.out.println("Exception =>"+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
     return responseDetails;
	}
	
	
	public ResponseDetails getAllStockViewDetails()
	{
		try{ 
			 List<ProductStockViewDetails> productStockViewDetails = (List<ProductStockViewDetails>) productStockViewDAO.findAll();
			 if(Utill.isValidObject(productStockViewDetails)){
				responseDetails.setProductStockViewDetailsList(productStockViewDetails);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			 }else{ 
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			 }
		}catch(Exception ex){
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
     return responseDetails;
	}
	
	
	public ResponseDetails getStockViewDetailsByProductReference(ProductStockDetails productStockDetails)
	{
		if(Utill.isValidObject(productStockDetails)) {
			int requestedQuantity = productStockDetails.getQuantity();
			String  productRefrence = productStockDetails.getProductRefrence();
			if(Utill.isValidObject(productRefrence)){
				try{
					 ProductStockViewDetails productStockViewDetails = (ProductStockViewDetails) productStockViewDAO.findByProductRefrence(productRefrence);
					 if(Utill.isValidObject(productStockViewDetails)){
						 int avaliableStockQuantity = productStockViewDetails.getQuantity() - productStockViewDetails.getSoldQuantity();
						if(requestedQuantity <= avaliableStockQuantity){
							 responseDetails.setProductStockViewDetails(productStockViewDetails);
							 responseDetails = sharedService.setSucessResponse(responseDetails);
						}else{
							 responseDetails.setProductStockViewDetails(productStockViewDetails);
							 responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"Limited Avaliable Stock Exceeds => "+avaliableStockQuantity); 
						}
					 }else{
						 responseDetails.setProductStockViewDetails(null);
						 responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND); 
					 }
				}catch(Exception ex){
					System.out.println("error "+ex.getMessage());
					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
				}
			}else{
				responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"Invalid Product Reference passed");
			}
		}else {
			System.out.println("productStockDetails fould invalid object "+productStockDetails );
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,Constants.REQUEST_OBJECT_FOUND_NULL);
		}
     return responseDetails;
	}
	
	
	
	

}
