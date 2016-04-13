package com.utils.factory;

import com.dao.EmployeeDao;
import com.dao.impl.EmployeeDaoImpl;
import com.utils.JdbcUtil;

/**
 * 文件名称：DaoFactory.java<br>
 * 摘要：Dao工厂类，防止业务层new数据实现类出现耦合<br>
 * -------------------------------------------------------<br>
 * 作者：胡毅<br>
 * 完成日期：2015年6月29日<br>
 */
public class DaoFactory {
	public static EmployeeDao getEmployeeDao(JdbcUtil jdbcutil) {
		return new EmployeeDaoImpl(jdbcutil);
	}
}
