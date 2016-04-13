package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Employees;
import com.service.EmployeeService;
import com.utils.factory.ServiceFactory;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private TestServlet() {}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		// 获取数据
		EmployeeService employeeService = ServiceFactory.getEmployeeService();
		List<Employees> list = new ArrayList<Employees>();
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		if(id!=null&&!id.equals("")){
			map = employeeService.findOne(id);
		}else{
			list = employeeService.findAll();
		}
		// 设置响应内容类型
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "数据库结果";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n");
		// show for entity
		for (Employees e : list) {
			out.println("ID: " + e.getId() + "<br>");
			out.println("Age: " + e.getAge() + "<br>");
			out.println("First: " + e.getFirst() + "<br>");
			out.println("Last: " + e.getLast() + "<br>");
			out.println("----------------------------------<br>");
		}
		// show for map
		for (Map<String,Object> e : map) {
			Set<String> key = e.keySet();
			for (String str : key) {
				out.println(str+": " + e.get(str) + "<br>");
			}
			out.println("----------------------------------<br>");
		}
		// 显示值
		out.println("<a href='"+request.getContextPath()+"/'>返回</a></body></html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
