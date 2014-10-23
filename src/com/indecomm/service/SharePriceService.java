/**
 * 
 */
package com.indecomm.service;

import java.util.Map;

import com.indecomm.bean.SharePriceBean;

/**
 * @author new
 * This interface is used to make the code scalable as if new file type is there 
 * we just need to make another class implementing this interface with behaviour to read other file type 
 *
 */
public interface SharePriceService {

	public Map<String, SharePriceBean> readFile(String file, int companyStartIndex) throws Exception;
}
