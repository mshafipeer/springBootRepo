package com.myBuzzApp.springBoot.apis.systemConfig.systemcodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.myBuzzApp.springBoot.apis.shared.Constants;
import com.myBuzzApp.springBoot.apis.shared.ResponseDetails;
import com.myBuzzApp.springBoot.apis.shared.constants.URLConstants;

@CrossOrigin(origins = Constants.CROSS_ORIGIN_VALUE)
@RestController
public class SystemCodeController {
	
	@Autowired
	private SystemCodeService systemCodeService;
	
	@RequestMapping(method=RequestMethod.POST,value = URLConstants.GET_SYSTEM_CODE_BY_TYPE)
	public ResponseDetails getSystemCodeByType(@RequestBody SystemCodeDetails systemCodeDetails)
	{
		System.out.println("in controller getSystemCodeLists with valies +> "+systemCodeDetails);
		System.out.println("in controller systemCodeDetails.getSystemCodeType() +> "+systemCodeDetails.getSystemCodeType());
		
		return systemCodeService.getSystemCodeByType(systemCodeDetails);
	}
	
	@RequestMapping(method=RequestMethod.POST,value = URLConstants.GET_SYSTEM_CODE_LIST_BY_TYPES)
	public ResponseDetails getSystemCodeByTypeList(@RequestBody String systemCodeTypesArray [])
	{
		System.out.println("in controller getSystemCodeLists with valies +> "+systemCodeTypesArray);
		return systemCodeService.getSystemCodeByTypeList(systemCodeTypesArray);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value = URLConstants.SAVE_SYSTEM_CODE_DETAILS)
	public ResponseDetails saveSystemCodeDetails(@RequestBody SystemCodeDetails systemCodeDetails)
	{
		System.out.println("in controller saveSystemCodeDetails vaules => "+systemCodeDetails);
		return systemCodeService.saveSystemCodeDetails(systemCodeDetails);
	}
	

}
