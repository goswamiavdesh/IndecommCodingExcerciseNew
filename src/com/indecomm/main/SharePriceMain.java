package com.indecomm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

import com.indecomm.bean.SharePriceBean;
import com.indecomm.customException.IndecommSystemException;
import com.indecomm.service.SharePriceService;
import com.indecomm.service.SharePriceServiceImplCsv;

public class SharePriceMain {

	/**
	 * This is main class , use to run the program to read csv file and give the output data
	 * as for which year and month company output was maximum
	 */
	public static int companyStartIndex = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// take input as file name from user keyboard with proper file extension 
		String input; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Here you declare your BufferedReader object and instance it.
		System.out.println("Please enter a valid file name with file extension !");
		System.out.println("Example :  'test.csv'");
		try {
			input = br.readLine();
			// validation if file input typed is not correct
			if(null!= input ){
				if(input.indexOf('.')<0 ) {
					throw new IndecommSystemException("File name entered is incorrect, Please enter a valid file name !");
				}
			}else{
				throw new IndecommSystemException("File name entered is incorrect, Please enter a valid file name !");
			}
			
			
			// read file and get map as output
			SharePriceService priceService = new SharePriceServiceImplCsv();
			Map<String, SharePriceBean> beanMap = priceService.readFile(input, companyStartIndex);
			System.out.println("--------------------------Desired output ---------------------------");
			// map returned by the service method is iterated to print output on console
			Iterator<String> itr = beanMap.keySet().iterator();
			while(itr.hasNext()){
				String key = itr.next();
				System.out.println("Company Name : "+key +" : Max share details : "+ beanMap.get(key) );
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occrred while readin input");
			e.printStackTrace();
		} catch(IndecommSystemException e){
			System.out.println("Exception occrred with reason : "+e.getMessage());
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("An Exception occrred while processing request !!");
			e.printStackTrace();
		}
		
	}

}
