package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Employees;

/**
 * 
* 文件名称：EmployeeService.java<br>
* 摘要：雇员基本业务操作接口<br>
* -------------------------------------------------------<br>
* 作者：胡毅<br>
* 完成日期：2015年6月30日<br>
 */
public interface EmployeeService {

	public List<Employees> findAll();
	
	public List<Map<String, Object>> findOne(String id);
	
	public void save(Employees e);
	
	public void save(List<Employees> es);
}
