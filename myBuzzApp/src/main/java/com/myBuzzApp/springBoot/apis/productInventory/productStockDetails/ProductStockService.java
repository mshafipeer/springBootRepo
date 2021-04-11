package com.myBuzzApp.springBoot.apis.productInventory.productStockDetails;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils.ProductStockViewDAO;
import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.productStockViewDeatils.ProductStockViewDetails;
import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.SharedService;
import com.myBuzzApp.springBoot.apis.shared.Utill;

@Service
public class ProductStockService {

	@Autowired
	private ProductStockDAO productStockDAO;
	
	@Autowired
	private ProductStockViewDAO productStockViewDAO;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	private ResponseDetails responseDetails;
	
	
	public ResponseDetails getStockById(ProductStockDetails productStockDetails)
	{
		if(Utill.isValidObject(productStockDetails)) {
			try{
				 ProductStockDetails productStockModels =  (ProductStockDetails) productStockDAO.findById(productStockDetails.getId());
				 if(Utill.isValidObject(productStockModels)){
					responseDetails.setProductStockDetails(productStockModels);
					responseDetails = sharedService.setSucessResponse(responseDetails);
				 }else{ 
					responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
				 }
			}catch(Exception ex) {
				System.out.println("error "+ex.getMessage());
				responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
			}
		}else {
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,Constants.REQUEST_OBJECT_FOUND_NULL);
		}
		
     return responseDetails;
	}
	
	public ResponseDetails getAllStockDetails()
	{
		try{
			 List<ProductStockDetails> productStockModelsList = (List<ProductStockDetails>) productStockDAO.findAll();
			 if(Utill.isValidObject(productStockModelsList)){
				responseDetails.setProductStockDetailsList(productStockModelsList);
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
	
	public ResponseDetails addStockDetails(ProductStockDetails productStockDetails)
	{
		 ProductStockDetails productStock = null;
		 System.out.println("productPartsModel.getBrandName() :"+productStockDetails.getSparePartId());
		 if(Utill.isValidObject(productStockDetails)) {
			try{  
			    if(productStockDetails.getId() == 0) { 
				    productStock = (ProductStockDetails) productStockDAO.findByProductRefrence(productStockDetails.getProductRefrence());		
				}
				if(productStock == null || productStockDetails.getId() > 0){
					productStock = productStockDAO.save(productStockDetails);
					responseDetails.setProductStockDetails(productStock);
					responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.RECORD_UPDATED_SUCESSFULY);
				}else {
					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,Constants.RECORD_ALREADY_EXISTS);
				}
				}catch(Exception ex)
				{
					System.out.println("error "+ex.getMessage());
					return sharedService.failedResponseWithEx(ex.getMessage());
				} 
		 } 
		 return responseDetails;
	}
	
	public ResponseDetails getStockByBrandAndModel(int brandId,int modelId)
	{
		try{
			 List<ProductStockDetails> productStockModelsList = (List<ProductStockDetails>) productStockDAO.findByBrandIdAndModelId(brandId,modelId);
			 if(Utill.isValidObject(productStockModelsList)){
				responseDetails.setProductStockDetailsList(productStockModelsList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			 }else{ 
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			 }
		}catch(Exception ex) {
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
     return responseDetails;
	}
		
	public ResponseDetails getStockByBrandModelAndSpareParts(int brandId,int modelId,int sparePartId)
	{
		try{
			 List<ProductStockDetails> productStockModelsList = (List<ProductStockDetails>) productStockDAO.findByBrandIdAndModelIdAndSparePartId(brandId,modelId,sparePartId);
			 if(Utill.isValidObject(productStockModelsList)){
				responseDetails.setProductStockDetailsList(productStockModelsList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			 }else{ 
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			 }
		}catch(Exception ex) {
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
     return responseDetails;
	}
	
	public ResponseDetails getStockByBrandAndModelFromView(int brandId,int modelId)
	{
		try{
			 List<ProductStockViewDetails> productStockViewDetailsList = (List<ProductStockViewDetails>) productStockViewDAO.findByBrandIdAndModelId(brandId,modelId);
			 if(Utill.isValidObject(productStockViewDetailsList)){
				responseDetails.setProductStockViewDetailsList(productStockViewDetailsList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			 }else{ 
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			 }
		}catch(Exception ex) {
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
     return responseDetails;
	}
	
	public boolean checkIfInvoiceExistsInStock(String invoiceNumber)
	{ 
		boolean isExists = false;
		try{  
			  isExists =  productStockViewDAO.existsByInvoiceNumber(invoiceNumber);
			  System.out.println("isExists "+ isExists);
		}catch(Exception ex) {
			System.out.println("error "+ex.getMessage());
			isExists = false;
		}
     return isExists;
	}
	
	
	
	
	
	
//	public ResponseDetails addStockDetails(ProductStockDetails productStockDetails)
//	{
//		 ProductStockDetails productStock = null;
//		 System.out.println("productPartsModel.getBrandName() :"+productStockDetails.getSparePartId());
//		 if(Utill.isValidObject(productStockDetails)) {
//			try{  
//			    if(productStockDetails.getId() == 0) {
//			    	int brandId = productStockDetails.getBrandId();
//			    	int modelId = productStockDetails.getModelId();
//			    	int sparePartId = productStockDetails.getSparePartId();
//			    	String invoiceNumber = productStockDetails.getInvoiceNumber();
//				    productStock = (ProductStockDetails) productStockDAO.
//				    				findByBrandIdAndModelIdAndSparePartIdAndInvoiceNumber(brandId,modelId,sparePartId,invoiceNumber);		
//				}
//				if(productStock == null || productStockDetails.getId() > 0){
//					productStock = productStockDAO.save(productStockDetails);
//					responseDetails.setProductStockDetails(productStock);
//					responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.RECORD_UPDATED_SUCESSFULY);
//				}else {
//					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,Constants.RECORD_ALREADY_EXISTS);
//				}
//				}catch(Exception ex)
//				{
//					System.out.println("error "+ex.getMessage());
//					return sharedService.failedResponseWithEx(ex.getMessage());
//				} 
//		 } 
//		 return responseDetails;
//	}
//	
	
}
