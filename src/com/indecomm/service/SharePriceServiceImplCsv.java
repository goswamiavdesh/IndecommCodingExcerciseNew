package com.indecomm.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.indecomm.bean.SharePriceBean;
import com.indecomm.bo.SharePriceBO;
import com.indecomm.customException.IndecommSystemException;

public class SharePriceServiceImplCsv implements SharePriceService {

	/**
	 * This class has a behaviour to read csv file type 
	 * it implements SharePriceService interface
	 */
	
	SharePriceBO  priceBO = new SharePriceBO();
	
	/**
	 * This method is used to read csv file
	 * @param file
	 * @param companyStartIndex
	 * @throws IndecommSystemException
	 */
	@Override
	public Map<String, SharePriceBean> readFile(String file , int companyStartIndex) throws IndecommSystemException {
		// TODO Auto-generated method stub
		String delimString = ",";
		BufferedReader reader;
		String line;
		String[] headers;
		Map<String, SharePriceBean> beanMap = new HashMap<String, SharePriceBean>();
		
		try {
			reader = new BufferedReader(new FileReader(file));
			headers = reader.readLine().split(delimString);
				while((line = reader.readLine())!=null){
						String [] readData = line.split(delimString);
						// validation if data is valid in csv file
						if(readData.length != headers.length){
							throw new IndecommSystemException("Invalid data in file");
						}else{
							// method is called to parse the data to bean and map it to a hash map
							priceBO.parseToBean(readData,companyStartIndex,beanMap,headers);
						}
				}
			
		} catch (FileNotFoundException e) {
			throw new IndecommSystemException("Exception occurred in service while reading file, Check the file name !!!");
		} catch(IOException e){
			throw new IndecommSystemException("An IO exception has occurred in service while processing !!!");
		}catch(IndecommSystemException e){
			throw new IndecommSystemException("Exception occrred in service method while processing request");
		}
		
		return beanMap;
	}

}
