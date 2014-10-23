package com.indecomm.bo;

import java.util.Map;

import com.indecomm.bean.SharePriceBean;
import com.indecomm.customException.IndecommSystemException;

public class SharePriceBO {
	/**
	 * This is a business class and will have the core logic
	 */

	String delimString = ",";

	/**
	 * This method is used to parse read line into bean, then is put into map with keys as company name
	 * @param readData
	 * @param companyIndex
	 * @param beanMap
	 * @param headers
	 * @throws IndecommSystemException
	 */
	public void parseToBean(String[] readData , int companyIndex, Map<String, SharePriceBean> beanMap , String[] headers ) throws IndecommSystemException{
		
		try{
			// data read is mapped to bean and is put in map
			for(int i=companyIndex;i<readData.length;i++){
				SharePriceBean bean = new SharePriceBean();
				bean.setYear(Integer.parseInt(readData[0]));
				bean.setMonth(readData[1]);
				bean.setCompanyName(headers[i]);
				bean.setSharePrice(Double.parseDouble(readData[i]));
				SharePriceBean beanValue = beanMap.get(bean.getCompanyName());
				if(beanValue != null){
					// check if the data is already present , if yes check if share value is greater then existing value
					if(bean.getSharePrice() > beanValue.getSharePrice()){
						//if yes value in map is replaced by greater value
						beanMap.put(bean.getCompanyName(), bean);
					}
				}else{
					beanMap.put(bean.getCompanyName(), bean);
				}
			}
		}catch (ArithmeticException e){
			throw new IndecommSystemException("An Arthematic Exception occrred in BO while processing request");
		}
		catch(IndexOutOfBoundsException e){
			throw new IndecommSystemException("An Index bound Exception occrred in BO while processing request");
		}
	}
}
