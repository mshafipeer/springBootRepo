package com.myBuzzApp.springBoot.apis.productInventory.invoicedetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.Constants;

@CrossOrigin(origins = Constants.CROSS_ORIGIN_VALUE)
@RestController
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	 
	
	@RequestMapping(method=RequestMethod.GET,value="/getInvoiceDetails")
	public ResponseDetails getInvoiceDetails()
	{
		return invoiceService.getInvoiceDetails();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addInvoiceDetails")
	public ResponseDetails addInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails)
	{
		return invoiceService.addInvoiceDetails(invoiceDetails);
	}
	

	@RequestMapping(method=RequestMethod.POST,value="/checkInvoiceByInvoiceNumber")
	public ResponseDetails checkInvoiceByInvoiceNumber(@RequestBody String invoiceNumber)
	{
		return invoiceService.checkInvoiceByInvoiceNumber(invoiceNumber);
	}
	

}
