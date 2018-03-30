package com.arsoft.projects.common.webservice.rest.business;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.arsoft.projects.common.business.entity.ArAddressInfo;
import com.arsoft.projects.common.business.entity.ArAmPmEnum;
import com.arsoft.projects.common.business.entity.ArBusinessEntityInfo;
import com.arsoft.projects.common.business.entity.ArContactInfo;
import com.arsoft.projects.common.business.entity.ArContactTypeEnum;
import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDayEnum;
import com.arsoft.projects.common.business.entity.ArEntityInfo;
import com.arsoft.projects.common.business.entity.ArGenderEnum;
import com.arsoft.projects.common.business.entity.ArIdentificationInfo;
import com.arsoft.projects.common.business.entity.ArIdentificationTypeEnum;
import com.arsoft.projects.common.business.entity.ArKycInfo;
import com.arsoft.projects.common.business.entity.ArMonthEnum;
import com.arsoft.projects.common.business.entity.ArOperationTimeInfo;
import com.arsoft.projects.common.business.entity.ArTime;

@Path("/business")
public class ArBusinessService {

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ArBusinessEntityInfo getBusinessEntityInfoJson() {
		return get();
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ArBusinessEntityInfo getBusinessEntityInfoXML() {
		return get();
	}
	
	public ArBusinessEntityInfo get() {
		ArBusinessEntityInfo arBusinessEntityInfo = new ArBusinessEntityInfo();
		arBusinessEntityInfo.setBusinessName("Grofers");
		ArDate businessDateOfRegisteration = new ArDate(30, ArMonthEnum.MARCH, 2018);
		arBusinessEntityInfo.setBusinessDateOfRegisteration(businessDateOfRegisteration);
		ArKycInfo businessKycInfo = new ArKycInfo();
		List<ArIdentificationInfo> listIdentificationInfo = new ArrayList<>();
		ArIdentificationInfo arIdentificationInfo = new ArIdentificationInfo(ArIdentificationTypeEnum.PAN, "XXXXX0000X");
		listIdentificationInfo.add(arIdentificationInfo);
		arIdentificationInfo = new ArIdentificationInfo(ArIdentificationTypeEnum.ADHAAR, "1111-1111-1111");
		listIdentificationInfo.add(arIdentificationInfo);
		arIdentificationInfo = new ArIdentificationInfo(ArIdentificationTypeEnum.TIN, "1111-XXXXX0000X-1111");
		listIdentificationInfo.add(arIdentificationInfo);
		businessKycInfo.setListIdentificationInfo(listIdentificationInfo);
		List<ArAddressInfo> listAddressInfo = new ArrayList<>();
		ArAddressInfo addressInfo = new ArAddressInfo("Business B1/714 14th Tower", "Business Purvanchal Royal Park, Sector 137", "Business Noida", "Business Uttar Pradesh", 201301,"Business India" );
		listAddressInfo.add(addressInfo);
		addressInfo = new ArAddressInfo("Business House 131, Flat 4", "Business Westend MArg", "Business Saidulajab", "Business Delhi", 110030,"Business India" );
		listAddressInfo.add(addressInfo);
		businessKycInfo.setListAddressInfo(listAddressInfo);
		List<ArContactInfo> listContactInfo = new ArrayList<>();
		ArContactInfo arContactInfo = new ArContactInfo(ArContactTypeEnum.EMAIL, "business@gmail.com");
		listContactInfo.add(arContactInfo);
		arContactInfo = new ArContactInfo(ArContactTypeEnum.MOBILE, "111111111");
		listContactInfo.add(arContactInfo);
		arContactInfo = new ArContactInfo(ArContactTypeEnum.LANDLINE, "9999999");
		listContactInfo.add(arContactInfo);
		businessKycInfo.setListContactInfo(listContactInfo);
		arBusinessEntityInfo.setBusinessKycInfo(businessKycInfo);
		ArOperationTimeInfo businessOperationTimeInfo = new ArOperationTimeInfo();
		List<ArDayEnum> daysOfOperation = new ArrayList<>();
		daysOfOperation.add(ArDayEnum.MONDAY);
		daysOfOperation.add(ArDayEnum.TUESDAY);
		daysOfOperation.add(ArDayEnum.WEDNESDAY);
		daysOfOperation.add(ArDayEnum.THURSDAY);
		daysOfOperation.add(ArDayEnum.FRIDAY);
		businessOperationTimeInfo.setDaysOfOperation(daysOfOperation);
		ArTime startTiming = new ArTime(9, ArAmPmEnum.AM);
		businessOperationTimeInfo.setStartTiming(startTiming);
		ArTime closeTiming = new ArTime(18, 15, ArAmPmEnum.PM);
		businessOperationTimeInfo.setCloseTiming(closeTiming);
		arBusinessEntityInfo.setBusinessOperationTimeInfo(businessOperationTimeInfo);
		ArEntityInfo businessOwnerInfo = new ArEntityInfo();
		businessOwnerInfo.setFirstName("Anshul");
		businessOwnerInfo.setMiddleName("K");
		businessOwnerInfo.setLastName("Sood");
		ArDate dateOfBirth = new ArDate(5, ArMonthEnum.APRIL, 1985);
		businessOwnerInfo.setDateOfBirth(dateOfBirth);
		businessOwnerInfo.setGender(ArGenderEnum.MALE);
		ArKycInfo kycInfo = new ArKycInfo();
		listAddressInfo = new ArrayList<>();
		addressInfo = new ArAddressInfo("Owner B1/714 14th Tower", "Owner Purvanchal Royal Park, Sector 137", "Owner Noida", "Owner Uttar Pradesh", 201301,"Owner India" );
		listAddressInfo.add(addressInfo);
		addressInfo = new ArAddressInfo("Owner House 131, Flat 4", "Owner Westend MArg", "Owner Saidulajab", "Owner Delhi", 110030,"Owner India" );
		listAddressInfo.add(addressInfo);
		kycInfo.setListAddressInfo(listAddressInfo);
		kycInfo.setListContactInfo(listContactInfo);
		listIdentificationInfo = new ArrayList<>();
		arIdentificationInfo = new ArIdentificationInfo(ArIdentificationTypeEnum.PAN, "Pan Owner");
		listIdentificationInfo.add(arIdentificationInfo);
		arIdentificationInfo = new ArIdentificationInfo(ArIdentificationTypeEnum.ADHAAR, "Adhar Owner");
		listIdentificationInfo.add(arIdentificationInfo);
		arIdentificationInfo = new ArIdentificationInfo(ArIdentificationTypeEnum.TIN, "Tin Owner");
		listIdentificationInfo.add(arIdentificationInfo);
		kycInfo.setListIdentificationInfo(listIdentificationInfo);
		listContactInfo = new ArrayList<>();
		arContactInfo = new ArContactInfo(ArContactTypeEnum.EMAIL, "business@gmail.com");
		listContactInfo.add(arContactInfo);
		arContactInfo = new ArContactInfo(ArContactTypeEnum.MOBILE, "8888877777");
		listContactInfo.add(arContactInfo);
		arContactInfo = new ArContactInfo(ArContactTypeEnum.LANDLINE, "00000999999");
		listContactInfo.add(arContactInfo);
		kycInfo.setListContactInfo(listContactInfo);
		businessOwnerInfo.setKycInfo(kycInfo);
		arBusinessEntityInfo.setBusinessOwnerInfo(businessOwnerInfo);
		return arBusinessEntityInfo;
	}
}
