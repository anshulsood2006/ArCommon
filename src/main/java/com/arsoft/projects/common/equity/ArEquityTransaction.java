package com.arsoft.projects.common.equity;

public class ArEquityTransaction {
	
	private float triggerPrice;
	private float brokerage;
	private float totalBeforeLevies;
	private float goodsAndServicesTax;
	private float securitiesTransactionCharges;
	private float nseTransactionCharges;
	private float stampDuty;
	private float actualPrice;
	
	public ArEquityTransaction(){
		
	}
	
	public ArEquityTransaction
	(
			float triggerPrice, 
			float brokerage, 
			float totalBeforeLevies,
			float goodsAndServicesTax,
			float securitiesTransactionCharges,
			float nseTransactionCharges,
			float stampDuty,
			float actualPrice
	)
	{
		this.triggerPrice = triggerPrice;
		this.brokerage = brokerage;
		this.totalBeforeLevies = totalBeforeLevies;
		this.goodsAndServicesTax = goodsAndServicesTax;
		this.securitiesTransactionCharges = securitiesTransactionCharges;
		this.nseTransactionCharges = nseTransactionCharges;
		this.stampDuty = stampDuty;
		this.actualPrice = actualPrice;
	}
	
	public String toString(){
		return " Buy Price: "+this.getTriggerPrice()+" Brokerage: "+this.getBrokerage()+" Total Before Levies: "+this.getTotalBeforeLevies()+" GST: "+this.getGoodsAndServicesTax()
				+" STT: "+this.getSecuritiesTransactionCharges()+" Transaction Charges: "+this.getNseTransactionCharges()+" Stamp Duty: "+
				this.getStampDuty()+" Cost Price: "+this.getActualPrice();
	}
	
	public float getTriggerPrice() {
		return triggerPrice;
	}
	public void setTriggerPrice(float triggerPrice) {
		this.triggerPrice = triggerPrice;
	}
	public float getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(float brokerage) {
		this.brokerage = brokerage;
	}
	public float getTotalBeforeLevies() {
		return totalBeforeLevies;
	}
	public void setTotalBeforeLevies(float totalBeforeLevies) {
		this.totalBeforeLevies = totalBeforeLevies;
	}
	public float getGoodsAndServicesTax() {
		return goodsAndServicesTax;
	}
	public void setGoodsAndServicesTax(float goodsAndServicesTax) {
		this.goodsAndServicesTax = goodsAndServicesTax;
	}
	public float getSecuritiesTransactionCharges() {
		return securitiesTransactionCharges;
	}
	public void setSecuritiesTransactionCharges(float securitiesTransactionCharges) {
		this.securitiesTransactionCharges = securitiesTransactionCharges;
	}
	public float getNseTransactionCharges() {
		return nseTransactionCharges;
	}
	public void setNseTransactionCharges(float nseTransactionCharges) {
		this.nseTransactionCharges = nseTransactionCharges;
	}
	public float getStampDuty() {
		return stampDuty;
	}
	public void setStampDuty(float stampDuty) {
		this.stampDuty = stampDuty;
	}
	public float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}
	
}
