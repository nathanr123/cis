package com.cti.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cti.model.Client;
import com.cti.service.ClientService;

@Controller
@EnableWebMvcSecurity
public class ClientController {

	@Autowired
	ClientService clientService;
	@InitBinder("clientForm")
	protected void initComponentBinder(WebDataBinder binder) {
		//binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/newclient", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewClient(
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Client userForm = new Client();

		model.put("clientForm", userForm);

		mav.setViewName("client");

		return mav;
	}

	

	@RequestMapping(value = "/createnewclient", method = RequestMethod.POST)
	public ModelAndView doCreateNewClient(@ModelAttribute("clientForm") Client user,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("client");

			return mav;
		} else {
			Date d = new Date();

			user.setClientname(user.getClientname());
			
			user.setContactperson(user.getContactperson());
			
			user.setDepartment(user.getDepartment());
			
			user.setAddress(user.getAddress());
			
			String id = getLatestClientId();
			
			user.setClient_ID(id);

			user.setCreatedtime(d);

			user.setModifiedtime(d);

			

			clientService.saveClient(user);

			mav.addObject("msg"," New Client Created Successfully");

			mav.setViewName("index");

			return mav;
		}

	}

	@RequestMapping(value = "/loadclient", method = RequestMethod.GET)
	public ModelAndView goClientUpdate(@RequestParam("client") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Client userdetailForm = clientService.getClientById(user);

		if (userdetailForm == null) {

			userdetailForm = new Client();

		}

		model.put("clientForm", userdetailForm);

		mav.setViewName("updateclient");

		return mav;

	}

	@RequestMapping(value = "/deleteclient", method = RequestMethod.GET)
	public ModelAndView deleteClient(@RequestParam("client") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!clientService.removeClient(user)) {

			mav.addObject("msg", "Unable to delete " + user + ".");
		} else {
			mav.addObject("msg", user + " successfully deleted.");
		}
		mav.addObject("clientlist", getAllClient());

		mav.setViewName("listclient");

		return mav;

	}

	@RequestMapping(value = "/updateclient", method = RequestMethod.POST)
	public ModelAndView updateClient(
			@ModelAttribute("clientForm") Client userDetail,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

	//	userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("client");

			return mav;
		} else {

			String view = "listclient";

			String msg = "";

			Date d = new Date();

			userDetail.setCreatedtime(d);

			userDetail.setModifiedtime(d);

				clientService.updateClient(userDetail);

				view = "index";

				msg = "Your Profile Updated Successfully !!";

		
			mav.addObject("msg", msg);

			mav.setViewName(view);

			return mav;
		}
	}

	@RequestMapping(value = "/listclient", method = RequestMethod.GET)
	public ModelAndView listClient(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("clientlist", getAllClient());

		mav.setViewName("listclient");

		return mav;

	}

	public List<Client> getAllClient() {
		List<Client> emps = clientService.listClient();

		return emps;
	}

	private Client getClient(String username) {
		return clientService.getClientById(username);
	}

	@ModelAttribute("priorityLevel")
	public Map<Integer, Integer> getPriority() {

		Map<Integer, Integer> userPriorty = new HashMap<Integer, Integer>();

		for (int i = 10; i > 0; i--) {
			userPriorty.put(i, i);
		}

		return userPriorty;
	}

	private String getLatestClientId() {
		int iddigit = 0;

		String latId = clientService.getLatestClientID();

		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("CLI%04d", iddigit); 

		return str;

	}
	
	
	
}
