package com.myBuzzApp.springBoot.apis.shared;

import org.springframework.stereotype.Service;

@Service
public class Utill {
	
	public static boolean isValidObject(Object obj) {
		boolean isValid = false ;
		if(obj != null && !"".equals(obj)) {
			isValid = true;
		}
		return isValid;
	}
	
	 
public ResponseDetails setSucessResponse(ResponseDetails responseDetails){
		
		if(Utill.isValidObject(responseDetails))
		{
			 responseDetails.setResponseCode(Constants.SUCESS_CODE);
			 responseDetails.setResponseDesc(Constants.SUCESS);
			 return responseDetails;
		}
		return null;
	}
}
