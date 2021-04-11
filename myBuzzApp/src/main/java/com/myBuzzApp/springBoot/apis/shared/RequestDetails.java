package com.myBuzzApp.springBoot.apis.shared;

import com.myBuzzApp.springBoot.apis.systemConfig.systemcodes.SystemCodeDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestDetails {
	private SystemCodeDetails sytemCodeDetails;

}
