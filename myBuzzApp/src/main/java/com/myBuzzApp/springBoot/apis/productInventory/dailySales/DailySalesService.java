package com.myBuzzApp.springBoot.apis.productInventory.dailySales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockDAO;
import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockDetails;
import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockService;
import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.SharedService;
import com.myBuzzApp.springBoot.apis.shared.Utill;


@Service
public class DailySalesService {
 
	@Autowired
	private DailySalesDAO dailySalesDAO;
	
	@Autowired
	private ProductStockDAO productStockDAO;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	ResponseDetails  responseDetails;
	
	public DailySalesService(){
	}

	
	public ResponseDetails saveSalesTranactionDetails(List<DailySalesDetails> dailySalesDetailsList)
	{   
		try{
			if(Utill.isValidObject(dailySalesDetailsList)){
				DailySalesDetails newInsertedRecord = null;
				for (DailySalesDetails dailySalesDetails : dailySalesDetailsList){
					if(Utill.isValidObject(dailySalesDetails)){
						newInsertedRecord = dailySalesDAO.save(dailySalesDetails);
						if (Utill.isValidObject(newInsertedRecord)){
						    updateProductStock(newInsertedRecord);
						}else {
							System.out.println("Sales Record not inserted "+dailySalesDetails.getProductRefrence());
						}
					}
	            }
				responseDetails = sharedService.setSucessResponse(responseDetails);
			}			
		}catch(Exception ex){
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
			return responseDetails;
		}
		return responseDetails;  
	}
	
	public int updateProductStock(DailySalesDetails dailySalesDetails){ 
		int updatedRecord = 0;
		if(Utill.isValidObject(dailySalesDetails)) {
			System.out.println("system to update sales quanittity to stock in updateProductStock for prod ref [" + dailySalesDetails.getProductRefrence());
			try{
				ProductStockDetails productStockDetails = productStockDAO.findById(dailySalesDetails.getProductId());
				if(Utill.isValidObject(productStockDetails)){
					System.out.println("productStockDetails.getId() = "+productStockDetails.getId());
					System.out.println("current sales quantity ["+ productStockDetails.getSoldQuantity() +"] and request quantity ["+ dailySalesDetails.getQuantity()+"]");
					int updateSalesQuantity =  productStockDetails.getSoldQuantity() + dailySalesDetails.getQuantity();
					
					System.out.println("updateSalesQuantity = "+updateSalesQuantity); 
					productStockDetails.setSoldQuantity(updateSalesQuantity);
					productStockDetails = productStockDAO.save(productStockDetails);
				    //updatedRecord = productStockDAO.setRemaningQuantityForProductStockDetails(updateSalesQuantity, productStockDetails.getId());
					if(productStockDetails.getSoldQuantity() == updateSalesQuantity ){
						System.out.println("record updated sucessfully [" + updatedRecord);
					}else {
						System.out.println("record not updated  sucessfully [" + updatedRecord);
					} 
				}
			}catch (Exception ex) {
				responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());	
				System.out.println("Exception while updating quantity in stock due to  [" +ex.getMessage());
			}
		}
		return updatedRecord;
	}
}
