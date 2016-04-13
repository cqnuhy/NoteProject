package com.dao.impl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.EmployeeDao;
import com.entity.Employees;
import com.utils.JdbcUtil;
import com.utils.ReflectionUtil;

/**
 * 
 * 文件名称：EmployeeDaoImpl.java<br>
 * 摘要：数据层操作类，只需要数据库连接即可，不负责关闭<br>
 * -------------------------------------------------------<br>
 * 作者：胡毅<br>
 * 完成日期：2015年6月29日<br>
 */
public class EmployeeDaoImpl extends BaseDaoImpl<Employees, Serializable> implements EmployeeDao{
	
	private JdbcUtil jdbcutil = null;
	
	public EmployeeDaoImpl(JdbcUtil jdbcutil){
		this.jdbcutil = jdbcutil;
	}
	
	@Override
	public List<Employees> findAll() throws SQLException{
		
		List<Employees> list = new ArrayList<Employees>();
		String sql = "select * from employees";
		PreparedStatement statm = jdbcutil.getPreparedStatement(sql);
		ResultSet rs = statm.getResultSet();
		while (rs.next()) {
			Employees e = new Employees();
			e.setId(rs.getString("id"));
			e.setAge(rs.getInt("age"));
			e.setFirst(rs.getString("first"));
			e.setLast(rs.getString("last"));
			list.add(e);
		}
		if(null != rs && !rs.isClosed()){
			rs.close();
		}
		if(null != statm && !statm.isClosed()){
			statm.close();
		}
		return list;
	}

	@Override
	public List<Employees> findOne(String id) throws SQLException {
		
		List<Employees> list = new ArrayList<Employees>();
		String sql = "select * from employees where id ='"+id+"'";
		PreparedStatement statm = jdbcutil.getPreparedStatement(sql);
		ResultSet rs = statm.getResultSet();
		while (rs.next()) {
			Employees e = new Employees();
			e.setId(rs.getString("id"));
			e.setAge(rs.getInt("age"));
			e.setFirst(rs.getString("first"));
			e.setLast(rs.getString("last"));
			list.add(e);
		}
		
		if(null != rs && !rs.isClosed()){
			rs.close();
		}
		if(null != statm && !statm.isClosed()){
			statm.close();
		}
		return list;
	}
	
	@Override
	public List<Map<String,Object>> findOneForMap(String id) throws SQLException {
		
		ReflectionUtil<Employees> e = new ReflectionUtil<Employees>();
		e.getFeilds(new Employees());
		List<String> fields = e.getFieldName();
		Map<String,Object> entity = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = "select * from employees where id ='"+id+"'";
		PreparedStatement statm = jdbcutil.getPreparedStatement(sql);
		ResultSet rs = statm.getResultSet();
		while (rs.next()) {
			entity = new HashMap<String, Object>();
			for (int i = 1; i <= fields.size(); i++) {
				entity.put(fields.get(i-1), rs.getObject(i));
			}
			list.add(entity);
		}
		
		if(null != rs && !rs.isClosed()){
			rs.close();
		}
		if(null != statm && !statm.isClosed()){
			statm.close();
		}
		return list;
	}

	@Override
	public void save(Employees e) throws SQLException {
		
		String sql = " INSERT INTO employees VALUES("+e.getId()+",'"+e.getAge()+"','"+e.getFirst()+"','"+e.getLast()+"') ";
		PreparedStatement statm = jdbcutil.getPreparedStatement(sql);
		statm.execute();
		if(null != statm && !statm.isClosed()){
			statm.close();
		}
	}
}
