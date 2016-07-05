package com.cti.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		// binder.setValidator(userValidator);
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	PurchaseService purchaseService;

	@InitBinder("purchaseForm")
	protected void initPurchaseBinder(WebDataBinder binder) {
		// binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/newpurchase", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewPurchase(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Purchase purchaseForm = new Purchase();

		model.put("purchaseForm", purchaseForm);

		mav.setViewName("purchase");

		return mav;
	}

	@RequestMapping(value = "/createnewpurchase", method = RequestMethod.POST)
	public ModelAndView doCreateNewPurchase(@ModelAttribute("purchaseForm") Purchase purchase, BindingResult result,
			Map<String, Object> model, SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		// userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("purchase");

			return mav;
		} else {
			Date d = new Date();

			purchase.setPurchase_number(purchase.getPurchase_number());
			
			purchase.setPurchase_date(purchase.getPurchase_date());
			
			purchase.setPurchase_del_date(purchase.getPurchase_del_date());
			
			purchase.setPurchase_cust_name(purchase.getPurchase_cust_name());
			
			String id = getLatestPurchaseId();
			
			purchase.setPurchase_ID(id);

			purchase.setCreatedtime(d);

			purchase.setModifiedtime(d);

			

			purchaseService.savePurchase(purchase);

			mav.addObject("msg"," New Purchase Created Successfully");


			return new ModelAndView("redirect:/loadpurchase?purchase="+purchase.getPurchase_ID());

		}

	}

	@RequestMapping(value = "/loadpurchase", method = RequestMethod.GET)
	public ModelAndView goPurchaseUpdate(@RequestParam("purchase") String purchase,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Purchase purchasedetailForm = purchaseService.getPurchaseById(purchase);

		if (purchasedetailForm == null) {

			purchasedetailForm = new Purchase();

		}
		List<Purchaseitemdetail> purchaseitemdetailForm = purchaseitemdetailService.listPurchaseitemdetail(purchase);

		model.put("purchaseitemdetaillist", purchaseitemdetailForm);

		model.put("purchaseitemdetailForm", new Purchaseitemdetail());
		model.put("purchaseForm", purchasedetailForm);

		mav.setViewName("updatepurchase");

		return mav;

	}

	@RequestMapping(value = "/deletepurchase", method = RequestMethod.GET)
	public ModelAndView deletePurchase(@RequestParam("purchase") String pur,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!purchaseService.removePurchase(pur)) {

			mav.addObject("msg", "Unable to delete " + pur + ".");
		} else {
			
			mav.addObject("msg", pur + " successfully deleted.");
		}
		mav.addObject("purchaselist", getAllPurchase());

		mav.setViewName("listpurchase");

		return mav;

	}

	@RequestMapping(value = "/updatepurchase", method = RequestMethod.POST)
	public ModelAndView updatePurchase(
			@ModelAttribute("purchaseForm") Purchase purchaseDetail,
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

			purchaseDetail.setCreatedtime(d);

			purchaseDetail.setModifiedtime(d);

				purchaseService.updatePurchase(purchaseDetail);

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
		List<Purchase> pur = purchaseService.listPurchase();

		return pur;
	}

	private Purchase getPurchase(String pur) {
		return purchaseService.getPurchaseById(pur);
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
	public @ResponseBody ModelAndView goToNewPurchaseitemdetail(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Purchaseitemdetail purchaseForm = new Purchaseitemdetail();

		model.put("purchaseitemdetailForm", purchaseForm);

		mav.setViewName("purchaseitemdetail");

		return mav;
	}

	@RequestMapping(value = "/createnewpurchaseitemdetail", method = RequestMethod.POST)
	public ModelAndView doCreateNewPurchaseitemdetail(@ModelAttribute("purchaseitemdetailForm") Purchaseitemdetail purchaseItem,
			BindingResult result, Map<String, Object> model, SessionStatus status)
			throws IOException {

		ModelAndView mav = new ModelAndView();

		// userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("purchaseitemdetail");

			 return mav;
		} else {
			Date d = new Date();

			purchaseItem.setPurchasenumber(purchaseItem.getPurchasenumber());
			
			purchaseItem.setProduct_ID(purchaseItem.getProduct_ID());

			purchaseItem.setQty(purchaseItem.getQty());

			purchaseItem.setTax(purchaseItem.getTax());

			purchaseItem.setTaxamount(purchaseItem.getTaxamount());

			purchaseItem.setTotalprice(purchaseItem.getTotalprice());

			purchaseItem.setTotalpricetax(purchaseItem.getTotalpricetax());

			purchaseItem.setUnitrate(purchaseItem.getUnitrate());

			purchaseItem.setCreatedtime(d);

			purchaseItem.setModifiedtime(d);

			purchaseitemdetailService.savePurchaseitemdetail(purchaseItem);

				
			return new ModelAndView("redirect:/loadpurchase?purchase="+purchaseItem.getPurchasenumber());
		}

	}

	@RequestMapping(value = "/loadpurchaseitemdetail", method = RequestMethod.GET)
	public ModelAndView goPurchaseitemdetailUpdate(@RequestParam("purchaseitemdetail") String purchase,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Purchaseitemdetail purchasedetailForm = purchaseitemdetailService.getPurchaseitemdetailById(purchase);

		if (purchasedetailForm == null) {

			purchasedetailForm = new Purchaseitemdetail();

		}

		model.put("purchaseitemdetailForm", purchasedetailForm);

		mav.setViewName("updatepurchaseitemdetail");

		return mav;

	}


	@RequestMapping(value = "/deletepurchaseitemdetail", method = RequestMethod.GET)
	public ModelAndView deletePurchaseitemdetail(@RequestParam("purchaseitemdetail") String purchase,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!purchaseitemdetailService.removePurchaseitemdetail(purchase)) {

			mav.addObject("msg", "Unable to delete " + purchase + ".");
		} else {
			mav.addObject("msg", purchase + " successfully deleted.");
		}
		mav.addObject("purchaseitemdetaillist", getAllPurchaseitemdetail());

		return new ModelAndView("redirect:/loadpurchase?purchase="+purchase);


	}

	@RequestMapping(value = "/updatepurchaseitemdetail", method = RequestMethod.POST)
	public ModelAndView updatePurchaseitemdetail(
			@ModelAttribute("purchaseitemdetailForm") Purchaseitemdetail purchaseDetail,
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

			purchaseDetail.setCreatedtime(d);

			purchaseDetail.setModifiedtime(d);

				purchaseitemdetailService.updatePurchaseitemdetail(purchaseDetail);

				view = "index";

				msg = "Updated Successfully !!";

		
				return new ModelAndView("redirect:/loadpurchase?purchase="+purchaseDetail.getPurchasenumber());

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
		List<Purchaseitemdetail> pur = purchaseitemdetailService.listPurchaseitemdetail();

		return pur;
	}

	private Purchaseitemdetail getPurchaseitemdetail(String purchasename) {
		return purchaseitemdetailService.getPurchaseitemdetailById(purchasename);
	}



	private String getLatestPurchaseitemdetailId() {
		int iddigit = 0;

		String latId = purchaseitemdetailService.getLatestPurchaseitemdetailID();
		
		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("PRO%04d", iddigit); 

		return str;

		

	}
	
	@ModelAttribute("cust")
	public List<Client> getAllCustname() {
		List<Client> client = purchaseService.getCust();

		return client;
	}
	
	
	
}