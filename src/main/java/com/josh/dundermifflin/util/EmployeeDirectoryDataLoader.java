package com.josh.dundermifflin.util;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.josh.dundermifflin.service.EmployeeService;

/**
 * Application Lifecycle Listener implementation class EmployeeDirectoryDataLoader
 *
 */
public class EmployeeDirectoryDataLoader implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EmployeeDirectoryDataLoader() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
		WebApplicationContext springRootWebContainer = ContextLoader.getCurrentWebApplicationContext();
		EmployeeService employeeService = (EmployeeService) springRootWebContainer.getBean("EmployeeServiceImpl");
		List<Integer> employeeIdList = employeeService.listEmployeesByEid();
		System.out.println("Loading Employee data into EHCache............");
		for (Integer eid : employeeIdList) {
			employeeService.findEmployeeFormByEid(eid);
		}
		System.out.println("Successfully loaded Employee data into EHCache.");
    }
	
}
