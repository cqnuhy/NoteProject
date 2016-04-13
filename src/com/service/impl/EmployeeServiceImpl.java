package com.service.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.dao.EmployeeDao;
import com.entity.Employees;
import com.service.EmployeeService;
import com.utils.JdbcUtil;
import com.utils.factory.DaoFactory;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employees> findAll() {
		// 在服务层统一连接，保持整个业务在一个数据库连接中操作
		JdbcUtil jdbcUtil = new JdbcUtil();
		Connection conn = jdbcUtil.getConnection();
		EmployeeDao employeeDao = DaoFactory.getEmployeeDao(jdbcUtil);
		List<Employees> list = null;
		try {
			conn.setAutoCommit(false);
			list = employeeDao.findAll();
			conn.commit();
		} catch (Exception e) {
			jdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally{
			jdbcUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findOne(String id) {
		JdbcUtil jdbcUtil = new JdbcUtil();
		Connection conn = jdbcUtil.getConnection();
		EmployeeDao employeeDao = DaoFactory.getEmployeeDao(jdbcUtil);
		List<Map<String, Object>> list = null;
		try {
			conn.setAutoCommit(false);
			list = employeeDao.findOneForMap(id);
			conn.commit();
		} catch (Exception e) {
			jdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally{
			jdbcUtil.close(conn);
		}
		return list;
	}

	@Override
	public void save(Employees e) {
		JdbcUtil jdbcUtil = new JdbcUtil();
		Connection conn = jdbcUtil.getConnection();
		EmployeeDao employeeDao = DaoFactory.getEmployeeDao(jdbcUtil);
		try {
			conn.setAutoCommit(false);
			employeeDao.save(e);
			conn.commit();
		} catch (Exception e1) {
			jdbcUtil.rollback(conn);
			e1.printStackTrace();
		} finally{
			jdbcUtil.close(conn);
		}
	}

	@Override
	public void save(List<Employees> es) {
		JdbcUtil jdbcUtil = new JdbcUtil();
		Connection conn = jdbcUtil.getConnection();
		EmployeeDao employeeDao = DaoFactory.getEmployeeDao(jdbcUtil);
		try {
			conn.setAutoCommit(false);
			for (Employees employees : es) {
				employeeDao.save(employees);
//				Object o = null;
//				System.err.println(o.toString());
			}
			conn.commit();
		} catch (Exception e) {
			jdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally{
			jdbcUtil.close(conn);
		}
	}

}
