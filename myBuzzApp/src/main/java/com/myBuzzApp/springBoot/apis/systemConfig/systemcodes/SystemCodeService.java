package com.myBuzzApp.springBoot.apis.systemConfig.systemcodes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.SharedService;
import com.myBuzzApp.springBoot.apis.shared.Utill;

@Service
public class SystemCodeService {

	@Autowired
	private SystemCodeDAO systemCodeDAO;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	private ResponseDetails responseDetails;
	
	
	public ResponseDetails getSystemCodeByType(SystemCodeDetails systemCodeDetails)
	{	responseDetails = new ResponseDetails();
		if(Utill.isValidObject(systemCodeDetails)) {
			System.out.println(systemCodeDetails.getSystemCodeType());
			
			try{
				 SystemCodeDetails systemCodeModels =  (SystemCodeDetails) systemCodeDAO.findBySystemCodeType(systemCodeDetails.getSystemCodeType());
				 if(Utill.isValidObject(systemCodeModels)){  
					responseDetails.setMstSystemCodeDetails(systemCodeModels);
					responseDetails = sharedService.setSucessResponse(responseDetails);
				 }else{ 
					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
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
	
	public ResponseDetails getSystemCodeByTypeList(String systemCodeTypesArray[])
	{
		System.out.println("systemCodeTypesArray=>"+systemCodeTypesArray);
		
		if(Utill.isValidObject(systemCodeTypesArray) && systemCodeTypesArray.length > 0) {
			
			List<SystemCodeDetails> systemCodeDetailsList = getSystemCodeLists(systemCodeTypesArray);
			
			if(Utill.isValidObject(systemCodeDetailsList)) {
				
				responseDetails.setMstSystemCodeDetailsList(systemCodeDetailsList);
				responseDetails = sharedService.setSucessResponse(responseDetails);
				
			}else{
				responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.NO_RECORD_FOUND);
			}
		}else{
			responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,Constants.REQUEST_OBJECT_FOUND_NULL);
		}
		
     return responseDetails;
	}
	
	public List<SystemCodeDetails> getSystemCodeLists(String systemCodeTypesArray[]){

		System.out.println("in getSystemCodeLists with valies +> "+systemCodeTypesArray);
		
		List<SystemCodeDetails> systemCodeModelsList = new ArrayList<>();
		if(Utill.isValidObject(systemCodeTypesArray) && systemCodeTypesArray.length > 0) {
		   try{
				SystemCodeDetails systemCodeModels = null;
				for (String systemCodeType : systemCodeTypesArray){
					systemCodeModels = (SystemCodeDetails) systemCodeDAO.findBySystemCodeType(systemCodeType);
					if(Utill.isValidObject(systemCodeModels)) {
						systemCodeModelsList.add(systemCodeModels);
					}
				}
			}catch(Exception ex) {
				System.out.println("error "+ex.getMessage());
				 systemCodeModelsList = null;
			}
		}
		System.out.println("after executing getSystemCodeLists with valies +> "+systemCodeTypesArray);
		if(Utill.isValidObject(systemCodeModelsList) && systemCodeModelsList.size() > 0) {
			return systemCodeModelsList;
		}else {
			return null;
		}
		
	}

	public ResponseDetails saveSystemCodeDetails(SystemCodeDetails systemCodeDetails)
	{
		 System.out.println(" save for SystemCodeDetails.getSystemCodeType() :"+systemCodeDetails.getSystemCodeType());
		 if(Utill.isValidObject(systemCodeDetails)) {
			try{  
				SystemCodeDetails newSystemCodeDetails = systemCodeDAO.save(systemCodeDetails);
				if(Utill.isValidObject(newSystemCodeDetails)) {
					responseDetails.setMstSystemCodeDetails(newSystemCodeDetails);
					responseDetails = sharedService.setSucessResponseWithDesc(responseDetails,Constants.RECORD_UPDATED_SUCESSFULY);
				}else{
					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,"System Code not updated properly");
				}
				  
			}catch(Exception ex)
			{
					System.out.println("error "+ex.getMessage());
					responseDetails = sharedService.setFailedResponseWithDesc(responseDetails,ex.getMessage());
			} 
		 } 
		 return responseDetails;
	}
}
