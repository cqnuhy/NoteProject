package com.utils.factory;

import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;

/**
 * 
 * 文件名称：ServiceFactory.java<br>
 * 摘要：在servlet（Controller）中解耦合业务层调用<br>
 * -------------------------------------------------------<br>
 * 作者：胡毅<br>
 * 完成日期：2015年6月29日<br>
 */
public class ServiceFactory {

	public static EmployeeService getEmployeeService(){
		return new EmployeeServiceImpl();
	}
}
