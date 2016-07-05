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

		Items itemsForm = new Items();

		model.put("itemsForm", itemsForm);

		mav.setViewName("items");

		return mav;
	}

	

	@RequestMapping(value = "/createnewitems", method = RequestMethod.POST)
	public ModelAndView doCreateNewItems(@ModelAttribute("itemsForm") Items items,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("items");

			return mav;
		} else {
			Date d = new Date();

			items.setPart_number(items.getPart_number());
			
			items.setDescription(items.getDescription());
			
			String id = getLatestItemsId();
			
			items.setProduct_ID(id);

			items.setCreatedtime(d);

			items.setModifiedtime(d);

			

			itemsService.saveItems(items);

			mav.addObject("msg"," New Item Created Successfully");

			mav.setViewName("index");

			return mav;
		}

	}

	@RequestMapping(value = "/loaditems", method = RequestMethod.GET)
	public ModelAndView goItemsUpdate(@RequestParam("items") String items,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Items itemsForm = itemsService.getItemsById(items);

		if (itemsForm == null) {

			itemsForm = new Items();

		}

		model.put("itemsForm", itemsForm);

		mav.setViewName("updateitems");

		return mav;

	}

	@RequestMapping(value = "/deleteitems", method = RequestMethod.GET)
	public ModelAndView deleteItems(@RequestParam("items") String items,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!itemsService.removeItems(items)) {

			mav.addObject("msg", "Unable to delete " + items + ".");
		} else {
			mav.addObject("msg", items + " successfully deleted.");
		}
		mav.addObject("itemslist", getAllItems());

		mav.setViewName("listitems");

		return mav;

	}

	@RequestMapping(value = "/updateitems", method = RequestMethod.POST)
	public ModelAndView updateItems(
			@ModelAttribute("itemsForm") Items items,
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

			items.setCreatedtime(d);

			items.setModifiedtime(d);

				itemsService.updateItems(items);

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
		List<Items> items = itemsService.listItems();

		return items;
	}

	private Items getItems(String items) {
		return itemsService.getItemsById(items);
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

		Component componentForm = new Component();

		model.put("componentForm", componentForm);

		mav.setViewName("component");

		return mav;
	}

	

	@RequestMapping(value = "/createnewcomponent", method = RequestMethod.POST)
	public ModelAndView doCreateNewItems(@ModelAttribute("componentForm") Component component,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("component");

			return mav;
		} else {
			Date d = new Date();

			component.setCtipartno(component.getCtipartno());
			
			component.setCtiuspartno(component.getCtiuspartno());
			
			component.setManufacturer(component.getManufacturer());
			
			component.setMfgdesc(component.getMfgdesc());
			
			component.setMfgpartno(component.getMfgpartno());
			
			component.setPackages(component.getPackages());
			
			component.setType(component.getType());
			
			
			String id = getLatestComponentId();
			
			component.setComp_ID(id);

			component.setCreatedtime(d);

			component.setModifiedtime(d);

			

			componentService.saveComponent(component);

			mav.addObject("msg"," New Component Created Successfully");

			mav.setViewName("index");

			return mav;
		}

	}

	@RequestMapping(value = "/loadcomponent", method = RequestMethod.GET)
	
	public ModelAndView goComponentUpdate(@RequestParam("component") String component,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Component componentForm = componentService.getComponentById(component);

		if (componentForm == null) {

			componentForm = new Component();

		}

		model.put("componentForm", componentForm);

		mav.setViewName("updatecomponent");

		return mav;

	}

	@RequestMapping(value = "/deletecomponent", method = RequestMethod.GET)
	public ModelAndView deleteComponent(@RequestParam("component") String component,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!componentService.removeComponent(component)) {

			mav.addObject("msg", "Unable to delete " + component + ".");
		} else {
			mav.addObject("msg", component + " successfully deleted.");
		}
		mav.addObject("componentlist", getAllComponent());

		mav.setViewName("listcomponent");

		return mav;

	}

	@RequestMapping(value = "/updatecomponent", method = RequestMethod.POST)
	public ModelAndView updateComponent(
			@ModelAttribute("compoentForm") Component component,
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

			component.setCreatedtime(d);

			component.setModifiedtime(d);

				componentService.updateComponent(component);

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
		List<Component> component = componentService.listComponent();

		return component;
	}

	private Component getComponent(String component) {
		return componentService.getComponentById(component);
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
