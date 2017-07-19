package com.arsoft.projects.common.equity;

public class ArEquityHelper {
	
	public static float getCostPrice(float buyPrice){
		float costPrice = 0.0f;
		
		return costPrice;
	}
	
	public static float getBrokerage(float buyPrice){		
		return buyPrice * ArEquityConstant.BROKERAGE;
	}
	
	public static float getGoodsAndServicesTax(float brokerage){		
		return brokerage * ArEquityConstant.GODDS_AND_SERVICE_TAX;
	}
	
	private static float getStampDuty(float totalBeforeLevies) {
		return totalBeforeLevies * ArEquityConstant.STAMP_DUTY;
	}

	private static float getNseTransactionCharges(float totalBeforeLevies) {
		return totalBeforeLevies * ArEquityConstant.NSE_TRANSACTION_CHARGES;
	}

	private static float getSecuritiesTransactionCharges(float totalBeforeLevies) {
		return totalBeforeLevies * ArEquityConstant.SECURITIES_TRANSACTION_TAX;
	}
	
	public static ArEquityTransaction getArEquityTransaction(float triggerPrice, ArEquityAction arEquityAction){
		ArEquityTransaction arEquityTransaction = new ArEquityTransaction();
		arEquityTransaction.setTriggerPrice(triggerPrice);
		float brokerage = getBrokerage(triggerPrice);
		arEquityTransaction.setBrokerage(brokerage);
		float totalBeforeLevies = 0.0f;
		if (arEquityAction.equals(ArEquityAction.BUY)){ 
			totalBeforeLevies = triggerPrice + brokerage;
		}
		else{
			totalBeforeLevies = triggerPrice - brokerage;
		}
		arEquityTransaction.setTotalBeforeLevies(totalBeforeLevies);
		float goodsAndServicesTax = getGoodsAndServicesTax(brokerage);
		arEquityTransaction.setGoodsAndServicesTax(goodsAndServicesTax);
		float securitiesTransactionCharges = getSecuritiesTransactionCharges(totalBeforeLevies);
		arEquityTransaction.setSecuritiesTransactionCharges(securitiesTransactionCharges);
		float nseTransactionCharges = getNseTransactionCharges(totalBeforeLevies);
		arEquityTransaction.setNseTransactionCharges(nseTransactionCharges);
		float stampDuty = getStampDuty(totalBeforeLevies);
		arEquityTransaction.setStampDuty(stampDuty);
		float actualPrice =0.0f;
		if (arEquityAction.equals(ArEquityAction.BUY)){ 
			actualPrice = totalBeforeLevies + goodsAndServicesTax + securitiesTransactionCharges + nseTransactionCharges + stampDuty;
		}else{
			actualPrice = totalBeforeLevies - goodsAndServicesTax - securitiesTransactionCharges - nseTransactionCharges - stampDuty;
		}
		arEquityTransaction.setActualPrice(actualPrice);
		return arEquityTransaction;
	}

}
