package com.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.entity.Employees;

/**
* 文件名称：EmployeeDao.java<br>
* 摘要：雇员基本数据操作接口<br>
* -------------------------------------------------------<br>
* 作者：胡毅<br>
* 完成日期：2015年6月29日<br>
 */
public interface EmployeeDao extends BaseDao<Employees,Serializable> {

	public List<Map<String, Object>> findOneForMap(String id) throws SQLException;
	
	public void save(Employees e) throws SQLException;

}
