package com.myBuzzApp.springBoot.apis.shared;

import org.springframework.stereotype.Service;

@Service
public class SharedService {
	ResponseDetails responseDetails;
	
	public  ResponseDetails sucessResponse() {
		return new ResponseDetails("00","SUCESS");
	}
	
	public  ResponseDetails sucessResponseWithDesc(String responseMsg) {
		return new ResponseDetails("00",responseMsg);
	}
	
	
	public  ResponseDetails failedResponse() {
		return new ResponseDetails("E01","Failed");
	}
	public  ResponseDetails failedResponseWithDesc(String responseMsg) {
		return new ResponseDetails("E01",responseMsg);
	}
	
	public  ResponseDetails failedResponseWithEx(String exceptionMsg) {
		return new ResponseDetails("EX",exceptionMsg);
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
	
	public ResponseDetails setSucessResponseWithDesc(ResponseDetails responseDetails ,String desc){
		
		if(Utill.isValidObject(responseDetails))
		{
			 responseDetails.setResponseCode(Constants.SUCESS_CODE);
			 responseDetails.setResponseDesc(desc);
			 return responseDetails;
		}
		return null;
	}
	
	public ResponseDetails setFailedResponse(ResponseDetails responseDetails){
		
		if(Utill.isValidObject(responseDetails))
		{
			 responseDetails.setResponseCode(Constants.FAILED_CODE);
			 responseDetails.setResponseDesc(Constants.FAILED);
			 return responseDetails;
		}
		return null;
	}
	
public ResponseDetails setFailedResponseWithDesc(ResponseDetails responseDetails,String desc){
		
		if(Utill.isValidObject(responseDetails))
		{
			 responseDetails.setResponseCode(Constants.FAILED_CODE);
			 responseDetails.setResponseDesc(desc);
			 return responseDetails;
		}
		return null;
	}
	
	
}
