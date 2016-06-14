package com.cti.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cti.model.ChangePassword;
import com.cti.model.Employee;

import com.cti.service.EmployeeService;

@Controller
@EnableWebMvcSecurity
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/newemployee", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewEmployeeRegistration(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Employee employeeForm = new Employee();

		model.put("employeeForm", employeeForm);

		mav.setViewName("employee");

		return mav;
	}

	@RequestMapping(value = "/createnewemployee", method = RequestMethod.POST)
	public ModelAndView doCreateNewEmployee(@ModelAttribute("employeeForm") Employee emp, BindingResult result,
			Map<String, Object> model, SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		Date d = new Date();

		String id = getLatestGroupId();

		emp.setEmpid(id);
		
		emp.setEmpname(emp.getEmpname());
		
		emp.setEmpnumber(emp.getEmpnumber());

		emp.setEmpage(emp.getEmpage());

		emp.setEmpgender(emp.getEmpgender());

		emp.setEmpdob(emp.getEmpdob());

		emp.setEmpaddr(emp.getEmpaddr());

		emp.setCreatedtime(d);

		emp.setModifiedtime(d);

		employeeService.saveEmployee(emp);

		// model.put("employeeForm", emp);

		mav.addObject("msg", "New Employee " + emp.getEmpname() + " Created Successfully");

		mav.setViewName("index");

		return mav;
	}

	@RequestMapping(value = "/loadEmployee", method = RequestMethod.GET)
	public ModelAndView goEmployeeupdate(@RequestParam("employee") String emp, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Employee employeeForm = employeeService.getEmployeeById(emp);

		if (employeeForm == null) {

			employeeForm = new Employee();

			employeeForm.setEmpname(emp);

		}

		model.put("employeeForm", employeeForm);

		mav.setViewName("updateemployee");

		return mav;

	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("employee") String emp, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!employeeService.removeEmployee(emp)) {

			mav.addObject("msg", "Unable to delete " + emp + ".");
		} else {
			mav.addObject("msg", emp + " successfully deleted.");
		}
		mav.addObject("employeelist", getAllEmployees());

		mav.setViewName("listemployee");

		return mav;

	}

	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("employeeForm") Employee emp, BindingResult result,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		String view = "listemployee";

		String msg = "";

		Date d = new Date();

		emp.setCreatedtime(d);

		emp.setModifiedtime(d);

		System.out.println(emp.getEmpaddr() +" "+ emp.getCreatedtime() +" "+ emp.getEmpage() +" "+ emp.getEmpcommaddr()
				+" "+ emp.getEmpgender() +" "+ emp.getEmpid() +" "+ emp.getEmpmobileno() +" "+ emp.getModifiedtime() +" "+ emp.getEmpname()
				+" "+ emp.getEmpdob());
		employeeService.updateEmployee(emp);

		msg = emp.getEmpname() + " Profile Updated Successfully !!";

		mav.addObject("employeelist", getAllEmployees());

		mav.addObject("msg", msg);

		mav.setViewName(view);

		return mav;

	}

	@RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
	public ModelAndView listEmployees(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("employeelist", getAllEmployees());

		mav.setViewName("listemployee");

		return mav;

	}

	public List<Employee> getAllEmployees() {
		List<Employee> emps = employeeService.listEmployees();

		return emps;
	}

	private Employee getEmployee(String empname) {
		return employeeService.getEmployeeById(empname);
	}

	@ModelAttribute("priorityLevel")
	public Map<Integer, Integer> getPriority() {

		Map<Integer, Integer> userPriorty = new HashMap<Integer, Integer>();

		for (int i = 10; i > 0; i--) {
			userPriorty.put(i, i);
		}

		return userPriorty;
	}

	private String getLatestGroupId() {
		int iddigit = 0;

		String latId = employeeService.getLatestGroupID();

		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("ENG%04d", iddigit);  

		return str;

	}

}
