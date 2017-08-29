package com.josh.dundermifflin.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.dao.entity.Employee;
import com.josh.dundermifflin.service.EmployeeService;
import com.josh.dundermifflin.web.controller.model.EmployeeForm;

@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier("EmployeeServiceImpl")
	private EmployeeService employeeService;
	
	private EmployeeController() {}

	@RequestMapping(value="addEmployee", method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute EmployeeForm ef, Model model) {
		employeeService.addEmployee(ef);
		model.addAttribute("message", "Employee added successfully.");
		return "index";
	}
	
	@RequestMapping(value="showEmployees", method=RequestMethod.GET)
	public String showEmployees(Model model) {
		List<EmployeeForm> employeeList = employeeService.listEmployees();
		model.addAttribute("employeeList", employeeList);
		return "showEmployees";
	}
	
	@RequestMapping(value="changeEmployeePhoto.do", method=RequestMethod.POST)
	public String changeEmployeePhoto(@ModelAttribute EmployeeForm ef, Model model) {
		System.out.println("Controller Employee name: "+ef.getName());
		employeeService.changePhoto(ef);
		model.addAttribute("message", "Photo successfully updated.");
		return "redirect:showEmployees.do";
	}
	
	//Code to render the image on the UI
	@RequestMapping(value="findImageByEid.do", method=RequestMethod.GET)
	public void findImageByEid(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String eid = req.getParameter("eid");
		byte[] img = employeeService.findImageByEid(Integer.parseInt(eid));		
		res.setContentType("image/jpg");
		ServletOutputStream out = res.getOutputStream();
		if (img != null) {
			out.write(img);
			out.flush();
		}
	}
}
