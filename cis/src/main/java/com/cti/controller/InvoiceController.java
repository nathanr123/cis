package com.cti.controller;

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
import com.cti.model.Invoice;
import com.cti.model.Invoiceitemdetail;
import com.cti.model.Purchase;
import com.cti.service.InvoiceService;
import com.cti.service.InvoiceitemdetailService;



@Controller
@EnableWebMvcSecurity
public class InvoiceController {

	@Autowired
	InvoiceitemdetailService invoiceitemdetailService;
	@InitBinder("invoiceitemdetailForm")
	protected void initInvoiceitemdetailBinder(WebDataBinder binder) {
		//binder.setValidator(userValidator);
	}
	
	
	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Autowired
	InvoiceService InvoiceService;
	@InitBinder("invoiceForm")
	protected void initInvoiceBinder(WebDataBinder binder) {
		//binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/newinvoice", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewInvoice(
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Invoice userForm = new Invoice();

		model.put("invoiceForm", userForm);

		mav.setViewName("invoice");

		return mav;
	}

	

	@RequestMapping(value = "/createnewinvoice", method = RequestMethod.POST)
	public ModelAndView doCreateNewInvoice(@ModelAttribute("invoiceForm") Invoice user,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("invoice");

			return mav;
		} else {
			Date d = new Date();

			user.setCustname(user.getCustname());
			
			user.setDel_chalan_number(user.getDel_chalan_number());
			
			user.setExpairy_date(user.getExpairy_date());
			
			user.setInvoice_date(user.getInvoice_date());
			
			user.setInvoice_number(user.getInvoice_number());
			
			user.setPo_number(user.getPo_number());
			
			user.setWarrenty_date(user.getWarrenty_date());
			
			user.setWarrenty_term(user.getWarrenty_term());
			
			String id = getLatestInvoiceId();
			
			user.setInvoice_ID(id);

			user.setCreatedtime(d);

			user.setModifiedtime(d);

			

			InvoiceService.saveInvoice(user);

			mav.addObject("msg"," New Invoice Created Successfully");

			mav.setViewName("updateinvoice");

			return mav;
		}

	}

	@RequestMapping(value = "/loadinvoice", method = RequestMethod.GET)
	public ModelAndView goInvoiceUpdate(@RequestParam("invoice") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Invoice userdetailForm = InvoiceService.getInvoiceById(user);

		if (userdetailForm == null) {

			userdetailForm = new Invoice();

		}
		Invoiceitemdetail userForm = new Invoiceitemdetail();

		model.put("invoiceitemdetailForm", userForm);

		
		model.put("invoiceForm", userdetailForm);

		mav.setViewName("updateinvoice");

		return mav;

	}

	@RequestMapping(value = "/deleteinvoice", method = RequestMethod.GET)
	public ModelAndView deleteInvoice(@RequestParam("invoice") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!InvoiceService.removeInvoice(user)) {

			mav.addObject("msg", "Unable to delete " + user + ".");
		} else {
			mav.addObject("msg", user + " successfully deleted.");
		}
		mav.addObject("invoicelist", getAllInvoice());

		mav.setViewName("listinvoice");

		return mav;

	}

	@RequestMapping(value = "/updateinvoice", method = RequestMethod.POST)
	public ModelAndView updateInvoice(
			@ModelAttribute("invoiceForm") Invoice userDetail,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

	//	userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("invoice");

			return mav;
		} else {

			String view = "listinvoice";

			String msg = "";

			Date d = new Date();

			userDetail.setCreatedtime(d);

			userDetail.setModifiedtime(d);

				InvoiceService.updateInvoice(userDetail);

				view = "index";

				msg = "Updated Successfully !!";

		
			mav.addObject("msg", msg);

			mav.setViewName(view);

			return mav;
		}
	}

	@RequestMapping(value = "/listinvoice", method = RequestMethod.GET)
	public ModelAndView listInvoice(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("invoicelist", getAllInvoice());

		mav.setViewName("listinvoice");

		return mav;

	}

	public List<Invoice> getAllInvoice() {
		List<Invoice> emps = InvoiceService.listInvoice();

		return emps;
	}

	private Invoice getInvoice(String username) {
		return InvoiceService.getInvoiceById(username);
	}

	@ModelAttribute("priorityLevel")
	public Map<Integer, Integer> getPriority() {

		Map<Integer, Integer> userPriorty = new HashMap<Integer, Integer>();

		for (int i = 10; i > 0; i--) {
			userPriorty.put(i, i);
		}

		return userPriorty;
	}

	private String getLatestInvoiceId() {
		int iddigit = 0;

		String latId = InvoiceService.getLatestInvoiceID();

		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("INV%04d", iddigit); 

		return str;
	}
	
	
	
	
	@RequestMapping(value = "/newinvoiceitemdetail", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewInvoiceitemdetail(
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Invoiceitemdetail userForm = new Invoiceitemdetail();

		model.put("invoiceitemdetailForm", userForm);

		mav.setViewName("invoiceitemdetail");

		return mav;
	}

	

	@RequestMapping(value = "/createnewinvoiceitemdetail", method = RequestMethod.POST)
	public ModelAndView doCreateNewInvoiceitemdetail(@ModelAttribute("invoiceitemdetailForm") Invoiceitemdetail user,
			BindingResult result, Map<String, Object> model,
			SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		//userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("invoiceitemdetail");

			return mav;
		} else {
			Date d = new Date();

			user.setInvoicenumber(user.getInvoicenumber());
			
			user.setQty(user.getQty());
			
			user.setTax(user.getTax());
			
			user.setSerialnumber(user.getSerialnumber());
			
			user.setTaxamount(user.getTaxamount());
			
			user.setTotalprice(user.getTotalprice());
			
			user.setTotalpricetax(user.getTotalpricetax());
			
			user.setUnitrate(user.getUnitrate());
			
			String id = getLatestInvoiceitemdetailId();
			
			user.setProduct_ID(id);

			user.setCreatedtime(d);

			user.setModifiedtime(d);

			

			invoiceitemdetailService.saveInvoiceitemdetail(user);

			mav.addObject("msg"," New Invoice Item Created Successfully");

			mav.setViewName("index");

			return mav;
		}

	}

	@RequestMapping(value = "/loadinvoiceitemdetail", method = RequestMethod.GET)
	public ModelAndView goInvoiceitemdetailUpdate(@RequestParam("invoiceitemdetail") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Invoiceitemdetail userdetailForm = invoiceitemdetailService.getInvoiceitemdetailById(user);

		if (userdetailForm == null) {

			userdetailForm = new Invoiceitemdetail();

		}

		model.put("invoiceitemdetailForm", userdetailForm);

		mav.setViewName("updateinvoiceitemdetail");

		return mav;

	}

	@RequestMapping(value = "/deleteinvoiceitemdetail", method = RequestMethod.GET)
	public ModelAndView deleteInvoiceitemdetail(@RequestParam("invoiceitemdetail") String user,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!invoiceitemdetailService.removeInvoiceitemdetail(user)) {

			mav.addObject("msg", "Unable to delete " + user + ".");
		} else {
			mav.addObject("msg", user + " successfully deleted.");
		}
		mav.addObject("invoiceitemdetaillist", getAllInvoiceitemdetail());

		mav.setViewName("listinvoiceitemdetail");

		return mav;

	}

	@RequestMapping(value = "/updateinvoiceitemdetail", method = RequestMethod.POST)
	public ModelAndView updateInvoiceitemdetail(
			@ModelAttribute("invoiceitemdetailForm") Invoiceitemdetail userDetail,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

	//	userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("invoiceitemdetail");

			return mav;
		} else {

			String view = "listinvoiceitemdetail";

			String msg = "";

			Date d = new Date();

			userDetail.setCreatedtime(d);

			userDetail.setModifiedtime(d);

			invoiceitemdetailService.updateInvoiceitemdetail(userDetail);

				view = "index";

				msg = "Updated Successfully !!";

		
			mav.addObject("msg", msg);

			mav.setViewName(view);

			return mav;
		}
	}

	@RequestMapping(value = "/listinvoiceitemdetail", method = RequestMethod.GET)
	public ModelAndView listInvoiceitemdetail(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitemdetaillist", getAllInvoiceitemdetail());

		mav.setViewName("listinvoiceitemdetail");

		return mav;

	}

	public List<Invoiceitemdetail> getAllInvoiceitemdetail() {
		List<Invoiceitemdetail> emps = invoiceitemdetailService.listInvoiceitemdetail();

		return emps;
	}

	private Invoiceitemdetail getInvoiceitemdetail(String username) {
		return invoiceitemdetailService.getInvoiceitemdetailById(username);
	}



	private String getLatestInvoiceitemdetailId() {
		int iddigit = 0;

		String latId = invoiceitemdetailService.getLatestInvoiceitemdetailID();

		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("IIT%04d", iddigit); 

		return str;
	}

	
	
	@ModelAttribute("cust")
	public List<Client> getAllCli() {
		List<Client> emps = InvoiceService.getCust();

		return emps;
	}
	@ModelAttribute("pur")
	public List<Purchase> getAllPur() {
		List<Purchase> emps = InvoiceService.getPur();

		return emps;
	}
	
	
}
