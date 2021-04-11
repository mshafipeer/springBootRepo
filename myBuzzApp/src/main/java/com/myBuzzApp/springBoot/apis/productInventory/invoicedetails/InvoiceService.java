package com.myBuzzApp.springBoot.apis.productInventory.invoicedetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myBuzzApp.springBoot.apis.productInventory.productStockDetails.ProductStockService;
import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.SharedService;
import com.myBuzzApp.springBoot.apis.shared.Utill;


@Service
public class InvoiceService {

	@Autowired
	private InvoiceDAO invoiceDAO;
	
	@Autowired 
	private ProductStockService productStockService;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	ResponseDetails  responseDetails;
	
	public InvoiceService(){
	}
	 

	public ResponseDetails getInvoiceDetails()
	{ 
		System.out.println("getInvoiceDetailsTest :");
		 try {
			 List<InvoiceDetails> invoiceDetails = (List<InvoiceDetails>) invoiceDAO.findAll();
			 responseDetails.setInvoiceDetailsList(invoiceDetails);
			 responseDetails = sharedService.setSucessResponse(responseDetails);
			 System.out.println("ResponseDetails:"+responseDetails); 
		 }catch(Exception ex) {
			 sharedService.failedResponse();
		 }
		 return responseDetails;   
	}
	public ResponseDetails addInvoiceDetails(InvoiceDetails invoiceDetails)
	{   
		try{
			if(Utill.isValidObject(invoiceDetails)){
				System.out.println("invoiceModel.getInvoiceNumber() :"+invoiceDetails.getInvoiceNumber());
				InvoiceDetails invoiceDetails1 = null;
				if(invoiceDetails.getId()  > 0) {
					// this is to check if invoice Number is modified and is attached to stock then not let
					boolean isInvoiceNumberAttached = checkIfInvoiceIsAttachedToAnystock(invoiceDetails);
					if(isInvoiceNumberAttached) {
						responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"Invoice Number can not be changed as it is acctached to Stock!");
						return responseDetails;
					}
				}else {
					invoiceDetails1 = (InvoiceDetails) invoiceDAO.findByInvoiceNumber(invoiceDetails.getInvoiceNumber());
				}
				System.out.println("invoiceModel1:"+invoiceDetails);
				System.out.println("invoiceDetails.getId() :"+invoiceDetails.getId());
				System.out.println("Utill.isValidObject(invoiceDetails):"+Utill.isValidObject(invoiceDetails));

				if((invoiceDetails1 == null) || invoiceDetails.getId() > 0){  
					invoiceDetails1 = invoiceDAO.save(invoiceDetails); 
					responseDetails.setInvoiceDetails(invoiceDetails1);
					responseDetails = sharedService.setSucessResponse(responseDetails);
				}else { 
					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"invoice Number "+invoiceDetails.getInvoiceNumber() +" already exists ");
				}
			}else {
				responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,Constants.REQUEST_OBJECT_FOUND_NULL);
			}
			
		}catch(Exception ex)
		{
			System.out.println("error "+ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());

		}
		return responseDetails;  
	}
	
	
	public ResponseDetails checkInvoiceByInvoiceNumber(String invoiceNumber)
	{
		try{
			System.out.println("invoiceNumber:"+invoiceNumber);
			InvoiceDetails invoiceDetails = (InvoiceDetails) invoiceDAO.findByInvoiceNumber(invoiceNumber);
			if(Utill.isValidObject(invoiceDetails)) {
				responseDetails.setInvoiceDetails(invoiceDetails);
				responseDetails = sharedService.setSucessResponse(responseDetails);
			}else {
				responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"invoice Number "+invoiceNumber+" does not exists");
			}
		}catch(Exception ex)
		{ System.out.println(ex.getMessage());
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
		}
		return responseDetails; 
	}
	 
	public boolean checkIfInvoiceIsAttachedToAnystock(InvoiceDetails invoiceDetails) {
		boolean isAttached = false;
		if(Utill.isValidObject(invoiceDetails)) {
			try {
				InvoiceDetails invoiceDtls = (InvoiceDetails) invoiceDAO.findById(invoiceDetails.getId());
				if(Utill.isValidObject(invoiceDtls) && Utill.isValidObject(invoiceDetails.getInvoiceNumber())){
					if(!invoiceDetails.getInvoiceNumber().equalsIgnoreCase(invoiceDtls.getInvoiceNumber())){
						isAttached = productStockService.checkIfInvoiceExistsInStock(invoiceDtls.getInvoiceNumber());
					}
				}
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				isAttached = false;
			}
		}
	    return isAttached;
	}
}
