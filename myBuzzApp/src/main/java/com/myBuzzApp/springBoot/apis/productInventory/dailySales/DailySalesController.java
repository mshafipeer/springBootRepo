package com.myBuzzApp.springBoot.apis.productInventory.dailySales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.constants.URLConstants;

import org.springframework.web.bind.annotation.RestController;
import com.myBuzzApp.springBoot.apis.shared.Constants;


@CrossOrigin(origins = Constants.CROSS_ORIGIN_VALUE)
@RestController
public class DailySalesController {
	
	@Autowired
	private DailySalesService dailySalesService;
	
	@RequestMapping(method=RequestMethod.POST,value=URLConstants.SAVE_SALES_TRANACTION_DETAILS)
	public ResponseDetails saveSalesTranactionDetails(@RequestBody List<DailySalesDetails> dailySalesDetailsList)
	{
		return dailySalesService.saveSalesTranactionDetails(dailySalesDetailsList);
	}

}
