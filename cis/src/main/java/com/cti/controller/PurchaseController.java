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
import com.cti.model.Invoice;
import com.cti.model.Purchase;
import com.cti.model.Purchaseitemdetail;
import com.cti.service.PurchaseService;
import com.cti.service.PurchaseitemdetailService;

@Controller
@EnableWebMvcSecurity
public class PurchaseController {


	@Autowired
	PurchaseitemdetailService purchaseitemdetailService;
	@InitBinder("purchaseitemdetailForm")
	protected void initPurchaseitemdetailBinder(WebDataBinder binder) {
		//binder.setValidator(userValidator);
	}

	@Autowired
	PurchaseService purchaseService;
	@InitBinder("purchaseForm")
	protected void initPurchaseBinder(WebDataBinder binder) {
		//binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/newpurchase", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewPurchase(
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Purchase userForm = new Purchase();

		model.put("purchaseForm", userForm);

		mav.setViewName("purchase");

		return mav;
	}

	

	@RequestMapping(value = "/createnewpurchase", method = RequestMethod.POST)
	public ModelAndView doCreateNewPurchase(@ModelAttribute("purchaseForm") Purchase user,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("purchase");

			return mav;
		} else {
			Date d = new Date();

			user.setPurchase_number(user.getPurchase_number());
			
			user.setPurchase_date(user.getPurchase_date());
			
			user.setPurchase_del_date(user.getPurchase_del_date());
			
			user.setPurchase_cust_name(user.getPurchase_cust_name());
			
			String id = getLatestPurchaseId();
			
			user.setPurchase_ID(id);

			user.setCreatedtime(d);

			user.setModifiedtime(d);

			

			purchaseService.savePurchase(user);

			mav.addObject("msg"," New Purchase Created Successfully");

			mav.setViewName("updatepurchase");

			return mav;
		}

	}

	@RequestMapping(value = "/loadpurchase", method = RequestMethod.GET)
	public ModelAndView goPurchaseUpdate(@RequestParam("purchase") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Purchase userdetailForm = purchaseService.getPurchaseById(user);

		if (userdetailForm == null) {

			userdetailForm = new Purchase();

		}

		model.put("purchaseForm", userdetailForm);

		mav.setViewName("updatepurchase");

		return mav;

	}

	@RequestMapping(value = "/deletepurchase", method = RequestMethod.GET)
	public ModelAndView deletePurchase(@RequestParam("purchase") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!purchaseService.removePurchase(user)) {

			mav.addObject("msg", "Unable to delete " + user + ".");
		} else {
			mav.addObject("msg", user + " successfully deleted.");
		}
		mav.addObject("purchaselist", getAllPurchase());

		mav.setViewName("listpurchase");

		return mav;

	}

	@RequestMapping(value = "/updatepurchase", method = RequestMethod.POST)
	public ModelAndView updatePurchase(
			@ModelAttribute("purchaseForm") Purchase userDetail,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

	//	userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("purchase");

			return mav;
		} else {

			String view = "listpurchase";

			String msg = "";

			Date d = new Date();

			userDetail.setCreatedtime(d);

			userDetail.setModifiedtime(d);

				purchaseService.updatePurchase(userDetail);

				view = "index";

				msg = "Updated Successfully !!";

		
			mav.addObject("msg", msg);

			mav.setViewName(view);

			return mav;
		}
	}

	@RequestMapping(value = "/listpurchase", method = RequestMethod.GET)
	public ModelAndView listPurchase(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaselist", getAllPurchase());

		mav.setViewName("listpurchase");

		return mav;

	}

	public List<Purchase> getAllPurchase() {
		List<Purchase> emps = purchaseService.listPurchase();

		return emps;
	}

	private Purchase getPurchase(String username) {
		return purchaseService.getPurchaseById(username);
	}

	@ModelAttribute("priorityLevel")
	public Map<Integer, Integer> getPriority() {

		Map<Integer, Integer> userPriorty = new HashMap<Integer, Integer>();

		for (int i = 10; i > 0; i--) {
			userPriorty.put(i, i);
		}

		return userPriorty;
	}

	private String getLatestPurchaseId() {
		int iddigit = 0;

		String latId = purchaseService.getLatestPurchaseID();


		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("PUR%04d", iddigit); 

		return str;

	}
	
	
	
	
	
	@RequestMapping(value = "/newpurchaseitemdetail", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewPurchaseitemdetail(
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Purchaseitemdetail userForm = new Purchaseitemdetail();

		model.put("purchaseitemdetailForm", userForm);

		mav.setViewName("purchaseitemdetail");

		return mav;
	}

	

	@RequestMapping(value = "/createnewpurchaseitemdetail", method = RequestMethod.POST)
	public ModelAndView doCreateNewPurchaseitemdetail(@ModelAttribute("purchaseitemdetailForm") Purchaseitemdetail user,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("purchaseitemdetail");

			return mav;
		} else {
			Date d = new Date();

			user.setPurchasenumber(user.getPurchasenumber());
			
			user.setQty(user.getQty());
			
			user.setTax(user.getTax());
			
			user.setTaxamount(user.getTaxamount());
			
			user.setTotalprice(user.getTotalprice());
			
			user.setTotalpricetax(user.getTotalpricetax());
			
			user.setUnitrate(user.getUnitrate());
			
			String id = getLatestPurchaseitemdetailId();
			
			user.setProduct_ID(id);

			user.setCreatedtime(d);

			user.setModifiedtime(d);

			

			purchaseitemdetailService.savePurchaseitemdetail(user);

			mav.addObject("msg"," New Purchase Item Created Successfully");

			mav.setViewName("index");

			return mav;
		}

	}

	@RequestMapping(value = "/loadpurchaseitemdetail", method = RequestMethod.GET)
	public ModelAndView goPurchaseitemdetailUpdate(@RequestParam("purchaseitemdetail") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Purchaseitemdetail userdetailForm = purchaseitemdetailService.getPurchaseitemdetailById(user);

		if (userdetailForm == null) {

			userdetailForm = new Purchaseitemdetail();

		}

		model.put("purchaseitemdetailForm", userdetailForm);

		mav.setViewName("updatepurchaseitemdetail");

		return mav;

	}

	@RequestMapping(value = "/deletepurchaseitemdetail", method = RequestMethod.GET)
	public ModelAndView deletePurchaseitemdetail(@RequestParam("purchaseitemdetail") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!purchaseitemdetailService.removePurchaseitemdetail(user)) {

			mav.addObject("msg", "Unable to delete " + user + ".");
		} else {
			mav.addObject("msg", user + " successfully deleted.");
		}
		mav.addObject("purchaseitemdetaillist", getAllPurchaseitemdetail());

		mav.setViewName("listpurchaseitemdetail");

		return mav;

	}

	@RequestMapping(value = "/updatepurchaseitemdetail", method = RequestMethod.POST)
	public ModelAndView updatePurchaseitemdetail(
			@ModelAttribute("purchaseitemdetailForm") Purchaseitemdetail userDetail,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

	//	userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("purchaseitemdetail");

			return mav;
		} else {

			String view = "listpurchaseitemdetail";

			String msg = "";

			Date d = new Date();

			userDetail.setCreatedtime(d);

			userDetail.setModifiedtime(d);

				purchaseitemdetailService.updatePurchaseitemdetail(userDetail);

				view = "index";

				msg = "Updated Successfully !!";

		
			mav.addObject("msg", msg);

			mav.setViewName(view);

			return mav;
		}
	}

	@RequestMapping(value = "/listpurchaseitemdetail", method = RequestMethod.GET)
	public ModelAndView listPurchaseitemdetail(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseitemdetaillist", getAllPurchaseitemdetail());

		mav.setViewName("listpurchaseitemdetail");

		return mav;

	}

	public List<Purchaseitemdetail> getAllPurchaseitemdetail() {
		List<Purchaseitemdetail> emps = purchaseitemdetailService.listPurchaseitemdetail();

		return emps;
	}

	private Purchaseitemdetail getPurchaseitemdetail(String username) {
		return purchaseitemdetailService.getPurchaseitemdetailById(username);
	}



	private String getLatestPurchaseitemdetailId() {
		int iddigit = 0;

		String latId = purchaseitemdetailService.getLatestPurchaseitemdetailID();
		
		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("PIT%04d", iddigit); 

		return str;

		

	}
	
	@ModelAttribute("cust")
	public List<Client> getAllCustname() {
		List<Client> emps = purchaseService.getCust();

		return emps;
	}
	
	
	
}
