package com.myBuzzApp.springBoot.apis.shared;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {
	
	public static final String CROSS_ORIGIN_VALUE ="http://localhost:4200";
	
	public static final String SUCESS = "SUCESS";
	public static final String SUCESS_CODE = "00";
	public static final String FAILED = "FAILED";
	public static final String FAILED_CODE = "01";
	public static final String NO_RECORD_FOUND = "No record found.";
	public static final String REQUEST_OBJECT_FOUND_NULL = "request object is Null";
	public static final String RECORD_UPDATED_SUCESSFULY = "Record sucessfully updated."; 
	public static final String RECORD_NOT_UPDATED_SUCESSFULY = "Record not updated sucessfully.";
	public static final String RECORD_ALREADY_EXISTS = "Record already exists."; 
	
	
	public static void main(String args[]) throws Exception{
		
		//String expiryDateString = "01-Mar-2020";
		String documentExpiryString = "01/04/2019";
		String expiryDateString = "01/03/2020";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date eidRelaxExpiryDate = sdf.parse(expiryDateString);
		Date documentExpiryDate  = sdf.parse(documentExpiryString);
	    System.out.println("eidRelaxExpiryDate "+eidRelaxExpiryDate);

	    
	    if(documentExpiryDate.compareTo(new Date()) < 0) {
	    	 System.out.println("document is expired  documentExpiryDate :"+documentExpiryDate+" cirrent date is "+ (new Date())); 
	    }
	    
	    if(documentExpiryDate.compareTo(eidRelaxExpiryDate) > 0) {
	    	System.out.println("document is expired but , documentExpiryDate :"+documentExpiryDate+" eidRelaxExpiryDate is "+ (eidRelaxExpiryDate));
	    	
	    }
	    if(documentExpiryDate.compareTo(eidRelaxExpiryDate) < 0) {
	    	System.out.println("document is expired and is below  eidRelaxExpiryDate , documentExpiryDate :"+documentExpiryDate+" eidRelaxExpiryDate is "+ (eidRelaxExpiryDate));
	    	
	    }
	    
	}

}
