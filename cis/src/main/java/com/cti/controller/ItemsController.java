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

import com.cti.model.Component;
import com.cti.model.Items;
import com.cti.service.ComponentService;
import com.cti.service.ItemsService;

@Controller
@EnableWebMvcSecurity
public class ItemsController {

	@Autowired
	ComponentService componentService;
	@InitBinder("componentForm")
	protected void initComponentBinder(WebDataBinder binder) {
		//binder.setValidator(userValidator);
	}
	@Autowired
	ItemsService itemsService;
	@InitBinder("itemsForm")
	protected void initItemsBinder(WebDataBinder binder) {
		//binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/newitems", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewItems(
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Items userForm = new Items();

		model.put("itemsForm", userForm);

		mav.setViewName("items");

		return mav;
	}

	

	@RequestMapping(value = "/createnewitems", method = RequestMethod.POST)
	public ModelAndView doCreateNewItems(@ModelAttribute("itemsForm") Items user,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("items");

			return mav;
		} else {
			Date d = new Date();

			user.setPart_number(user.getPart_number());
			
			user.setDescription(user.getDescription());
			
			String id = getLatestItemsId();
			
			user.setProduct_ID(id);

			user.setCreatedtime(d);

			user.setModifiedtime(d);

			

			itemsService.saveItems(user);

			mav.addObject("msg"," New Item Created Successfully");

			mav.setViewName("index");

			return mav;
		}

	}

	@RequestMapping(value = "/loaditems", method = RequestMethod.GET)
	public ModelAndView goItemsUpdate(@RequestParam("items") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Items userdetailForm = itemsService.getItemsById(user);

		if (userdetailForm == null) {

			userdetailForm = new Items();

		}

		model.put("itemsForm", userdetailForm);

		mav.setViewName("updateitems");

		return mav;

	}

	@RequestMapping(value = "/deleteitems", method = RequestMethod.GET)
	public ModelAndView deleteItems(@RequestParam("items") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!itemsService.removeItems(user)) {

			mav.addObject("msg", "Unable to delete " + user + ".");
		} else {
			mav.addObject("msg", user + " successfully deleted.");
		}
		mav.addObject("itemslist", getAllItems());

		mav.setViewName("listitems");

		return mav;

	}

	@RequestMapping(value = "/updateitems", method = RequestMethod.POST)
	public ModelAndView updateItems(
			@ModelAttribute("itemsForm") Items userDetail,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

	//	userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("items");

			return mav;
		} else {

			String view = "listitems";

			String msg = "";

			Date d = new Date();

			userDetail.setCreatedtime(d);

			userDetail.setModifiedtime(d);

				itemsService.updateItems(userDetail);

				view = "index";

				msg = "Your Profile Updated Successfully !!";

		
			mav.addObject("msg", msg);

			mav.setViewName(view);

			return mav;
		}
	}

	@RequestMapping(value = "/listitems", method = RequestMethod.GET)
	public ModelAndView listItems(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("itemslist", getAllItems());

		mav.setViewName("listitems");

		return mav;

	}

	public List<Items> getAllItems() {
		List<Items> emps = itemsService.listItems();

		return emps;
	}

	private Items getItems(String username) {
		return itemsService.getItemsById(username);
	}

	@ModelAttribute("priorityLevel")
	public Map<Integer, Integer> getPriority() {

		Map<Integer, Integer> userPriorty = new HashMap<Integer, Integer>();

		for (int i = 10; i > 0; i--) {
			userPriorty.put(i, i);
		}

		return userPriorty;
	}

	private String getLatestItemsId() {
		int iddigit = 0;

		String latId = itemsService.getLatestItemsID();

		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("ITE%04d", iddigit); 

		return str;

	}
	
	
	
	

	
	@RequestMapping(value = "/newcomponent", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewComponent(
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Component userForm = new Component();

		model.put("componentForm", userForm);

		mav.setViewName("component");

		return mav;
	}

	

	@RequestMapping(value = "/createnewcomponent", method = RequestMethod.POST)
	public ModelAndView doCreateNewItems(@ModelAttribute("componentForm") Component user,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("component");

			return mav;
		} else {
			Date d = new Date();

			user.setCtipartno(user.getCtipartno());
			
			user.setCtiuspartno(user.getCtiuspartno());
			
			user.setManufacturer(user.getManufacturer());
			
			user.setMfgdesc(user.getMfgdesc());
			
			user.setMfgpartno(user.getMfgpartno());
			
			user.setPackages(user.getPackages());
			
			user.setType(user.getType());
			
			
			String id = getLatestComponentId();
			
			user.setComp_ID(id);

			user.setCreatedtime(d);

			user.setModifiedtime(d);

			

			componentService.saveComponent(user);

			mav.addObject("msg"," New Component Created Successfully");

			mav.setViewName("index");

			return mav;
		}

	}

	@RequestMapping(value = "/loadcomponent", method = RequestMethod.GET)
	public ModelAndView goComponentUpdate(@RequestParam("component") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Component userdetailForm = componentService.getComponentById(user);

		if (userdetailForm == null) {

			userdetailForm = new Component();

		}

		model.put("componentForm", userdetailForm);

		mav.setViewName("updatecomponent");

		return mav;

	}

	@RequestMapping(value = "/deletecomponent", method = RequestMethod.GET)
	public ModelAndView deleteComponent(@RequestParam("component") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!componentService.removeComponent(user)) {

			mav.addObject("msg", "Unable to delete " + user + ".");
		} else {
			mav.addObject("msg", user + " successfully deleted.");
		}
		mav.addObject("componentlist", getAllComponent());

		mav.setViewName("listcomponent");

		return mav;

	}

	@RequestMapping(value = "/updatecomponent", method = RequestMethod.POST)
	public ModelAndView updateComponent(
			@ModelAttribute("compoentForm") Component userDetail,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

	//	userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("component");

			return mav;
		} else {

			String view = "listcomponent";

			String msg = "";

			Date d = new Date();

			userDetail.setCreatedtime(d);

			userDetail.setModifiedtime(d);

				componentService.updateComponent(userDetail);

				view = "index";

				msg = "Your Profile Updated Successfully !!";

		
			mav.addObject("msg", msg);

			mav.setViewName(view);

			return mav;
		}
	}

	@RequestMapping(value = "/listcomponent", method = RequestMethod.GET)
	public ModelAndView listComponent(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("componentlist", getAllComponent());

		mav.setViewName("listcomponent");

		return mav;

	}

	public List<Component> getAllComponent() {
		List<Component> emps = componentService.listComponent();

		return emps;
	}

	private Component getComponent(String username) {
		return componentService.getComponentById(username);
	}

	

	private String getLatestComponentId() {
		int iddigit = 0;

		String latId = componentService.getLatestComponentID();

		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("COM%04d", iddigit); 

		return str;

	}
	
}
