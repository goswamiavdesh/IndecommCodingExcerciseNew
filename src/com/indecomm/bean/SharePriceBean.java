package com.indecomm.bean;


public class SharePriceBean {

	private int year;
	private String month;
	private String companyName ;
	private double sharePrice;
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the sharePrice
	 */
	public double getSharePrice() {
		return sharePrice;
	}
	/**
	 * @param sharePrice the sharePrice to set
	 */
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public String toString(){
		return "["+"year "+this.getYear()+" Month "+this.getMonth()+" Share Price "+this.getSharePrice()+"]";
	}
}
