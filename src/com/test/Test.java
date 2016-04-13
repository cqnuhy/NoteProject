package com.test;

import java.util.ArrayList;
import java.util.List;

import com.entity.Employees;
import com.service.EmployeeService;
import com.utils.factory.ServiceFactory;

/**
 * 
* 文件名称：Test.java<br>
* 摘要：测试类<br>
* -------------------------------------------------------<br>
* 作者：胡毅<br>
* 完成日期：2016年4月12日<br>
 */
public class Test {

	/**
	 * 测试JDBC手动提交事务
	 * @date 2016年4月13日 上午9:25:41
	 * @author 胡毅
	 */
	public void testTransaction(){
		Employees e1 = new Employees();
		e1.setAge(25);
		e1.setFirst("hu8");
		e1.setLast("yi8");
		Employees e2 = new Employees();
		e2.setAge(25);
		e2.setFirst("hu9");
		e2.setLast("yi9");
		
		List<Employees> es = new ArrayList<Employees>();
		es.add(e1);
		es.add(e2);
		
		EmployeeService eService = ServiceFactory.getEmployeeService();
		eService.save(es);
	}
	
	public static void main(String[] args) {
		new Test().testTransaction();
	}
}
