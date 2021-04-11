package com.myBuzzApp.springBoot.apis.productInventory.modeldetails;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.SharedService;
import com.myBuzzApp.springBoot.apis.shared.Utill;

@Service
public class ProductModelService {

	@Autowired
	private ProductModelDAO productModelDAO;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	private ResponseDetails responseDetails;
	
	public ResponseDetails addModelDetails(ProductModel productModel)
	{
		try{
			System.out.println("productModel.getModelName() :"+productModel.getModelName());
			ProductModel productModelDetails = null;
			if(Utill.isValidObject(productModel)){
				if(productModel.getId() == 0) {
					productModelDetails = (ProductModel) productModelDAO.findByBrandIdAndModelName(productModel.getBrandId(), productModel.getModelName());
				}
				if(productModelDetails == null || productModel.getId() > 0 ){
					productModelDetails = productModelDAO.save(productModel);
					responseDetails.setProductModelDetails(productModelDetails);
					responseDetails = sharedService.setSucessResponse(responseDetails);
				}else{
					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"Model "+productModel.getModelName() +" already exists");
				}
			}
				 
		}catch(Exception ex)
		{
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
		return responseDetails;
	}
	
	
	public ResponseDetails getAllModelsByBrand(String brandId)
	{
		try {
			List<ProductModel> productModelDetailsList = (List<ProductModel>) productModelDAO.findByBrandId(Integer.parseInt(brandId));
			responseDetails.setProductModelDetailsList(productModelDetailsList);
			responseDetails = sharedService.setSucessResponse(responseDetails);
		}catch(Exception ex) {
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
		
		return responseDetails;
	}
	
	public ResponseDetails getAllModels()
	{
		try {
			List<ProductModel> productModelDetailsList = (List<ProductModel>) productModelDAO.findAll();
			responseDetails.setProductModelDetailsList(productModelDetailsList);
			responseDetails = sharedService.setSucessResponse(responseDetails);
		}catch(Exception ex) {
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
		return responseDetails;
	}
	
	
}
