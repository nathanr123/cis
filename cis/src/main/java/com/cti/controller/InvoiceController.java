package com.cti.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
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
		// binder.setValidator(userValidator);
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
		// binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/newinvoice", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewInvoice(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Invoice invoiceForm = new Invoice();

		model.put("invoiceForm", invoiceForm);

		mav.setViewName("invoice");

		return mav;
	}

	@RequestMapping(value = "/createnewinvoice", method = RequestMethod.POST)
	public ModelAndView doCreateNewInvoice(@ModelAttribute("invoiceForm") Invoice invoice, BindingResult result,
			Map<String, Object> model, SessionStatus status) {

		ModelAndView mav = new ModelAndView();

		// userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("invoice");

			return mav;
		} else {
			Date d = new Date();

			invoice.setCustname(invoice.getCustname());

			invoice.setDel_chalan_number(invoice.getDel_chalan_number());

			invoice.setExpairy_date(invoice.getExpairy_date());

			invoice.setInvoice_date(invoice.getInvoice_date());

			invoice.setInvoice_number(invoice.getInvoice_number());

			invoice.setPo_number(invoice.getPo_number());

			invoice.setWarrenty_date(invoice.getWarrenty_date());

			invoice.setWarrenty_term(invoice.getWarrenty_term());

			String id = getLatestInvoiceId();

			invoice.setInvoice_ID(id);

			invoice.setCreatedtime(d);

			invoice.setModifiedtime(d);

			InvoiceService.saveInvoice(invoice);

			mav.addObject("msg", " New Invoice Created Successfully");

			return new ModelAndView("redirect:/loadinvoice?invoice="+invoice.getInvoice_ID());

		}

	}

	@RequestMapping(value = "/loadinvoice", method = RequestMethod.GET)
	public ModelAndView goInvoiceUpdate(@RequestParam("invoice") String invoice, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Invoice invoiceForm = InvoiceService.getInvoiceById(invoice);

		if (invoiceForm == null) {

			invoiceForm = new Invoice();

		}
		List<Invoiceitemdetail> invoiceitemdetailForm = invoiceitemdetailService.listInvoiceitemdetail(invoice);// getInvoiceitemdetailById(user);

		model.put("invoiceitemdetaillist", invoiceitemdetailForm);

		model.put("invoiceitemdetailForm", new Invoiceitemdetail());

		model.put("invoiceForm", invoiceForm);

		mav.setViewName("updateinvoice");

		return mav;

	}

	@RequestMapping(value = "/deleteinvoice", method = RequestMethod.GET)
	public ModelAndView deleteInvoice(@RequestParam("invoice") String invoice, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!InvoiceService.removeInvoice(invoice)) {

			mav.addObject("msg", "Unable to delete " + invoice + ".");
		} else {
			mav.addObject("msg", invoice + " successfully deleted.");
		}
		mav.addObject("invoicelist", getAllInvoice());

		mav.setViewName("listinvoice");

		return mav;

	}

	@RequestMapping(value = "/updateinvoice", method = RequestMethod.POST)
	public ModelAndView updateInvoice(@ModelAttribute("invoiceForm") Invoice invoice, BindingResult result,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		// userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("invoice");

			return mav;
		} else {

			String view = "listinvoice";

			String msg = "";

			Date d = new Date();

			invoice.setCreatedtime(d);

			invoice.setModifiedtime(d);

			InvoiceService.updateInvoice(invoice);

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
		List<Invoice> invoice = InvoiceService.listInvoice();

		return invoice;
	}

	private Invoice getInvoice(String invoice) {
		return InvoiceService.getInvoiceById(invoice);
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
	public @ResponseBody ModelAndView goToNewInvoiceitemdetail(Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Invoiceitemdetail invoiceitemForm = new Invoiceitemdetail();

		model.put("invoiceitemdetailForm", invoiceitemForm);

		mav.setViewName("invoiceitemdetail");

		return mav;
	}

	@RequestMapping(value = "/createnewinvoiceitemdetail", method = RequestMethod.POST)
	public ModelAndView doCreateNewInvoiceitemdetail(@ModelAttribute("invoiceitemdetailForm") Invoiceitemdetail invoiceItem,
			BindingResult result, Map<String, Object> model, SessionStatus status)
			throws IOException {

		ModelAndView mav = new ModelAndView();

		// userValidator.validate(user, result);

		if (result.hasErrors()) {

			mav.setViewName("invoiceitemdetail");

			 return mav;
		} else {
			Date d = new Date();

			invoiceItem.setInvoicenumber(invoiceItem.getInvoicenumber());
			
			invoiceItem.setProduct_ID(invoiceItem.getProduct_ID());

			invoiceItem.setQty(invoiceItem.getQty());

			invoiceItem.setTax(invoiceItem.getTax());

			invoiceItem.setSerialnumber(invoiceItem.getSerialnumber());

			invoiceItem.setTaxamount(invoiceItem.getTaxamount());

			invoiceItem.setTotalprice(invoiceItem.getTotalprice());

			invoiceItem.setTotalpricetax(invoiceItem.getTotalpricetax());

			invoiceItem.setUnitrate(invoiceItem.getUnitrate());

			invoiceItem.setCreatedtime(d);

			invoiceItem.setModifiedtime(d);

			invoiceitemdetailService.saveInvoiceitemdetail(invoiceItem);

				
			return new ModelAndView("redirect:/loadinvoice?invoice="+invoiceItem.getInvoicenumber());
		}

	}

	@RequestMapping(value = "/loadinvoiceitemdetail", method = RequestMethod.GET)
	public ModelAndView goInvoiceitemdetailUpdate(@RequestParam("invoiceitemdetail") String invoiceitem,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();
		

		Invoiceitemdetail invoiceitemForm = invoiceitemdetailService.getInvoiceitemdetailById(invoiceitem);

		if (invoiceitemForm == null) {

			invoiceitemForm = new Invoiceitemdetail();

		}

		model.put("invoiceitemdetailForm", invoiceitemForm);

		mav.setViewName("updateinvoiceitemdetail");

		return mav;

	}

	@RequestMapping(value = "/deleteinvoiceitemdetail", method = RequestMethod.GET)
	public ModelAndView deleteInvoiceitemdetail(@RequestParam("invoiceitemdetail") String invoiceitem,
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		if (!invoiceitemdetailService.removeInvoiceitemdetail(invoiceitem)) {

			mav.addObject("msg", "Unable to delete " + invoiceitem + ".");
		} else {
			mav.addObject("msg", invoiceitem + " successfully deleted.");
		}
		mav.addObject("invoiceitemdetaillist", getAllInvoiceitemdetail());

		return new ModelAndView("redirect:/loadinvoice?invoice="+invoiceitem);


	}

	@RequestMapping(value = "/updateinvoiceitemdetail", method = RequestMethod.POST)
	public ModelAndView updateInvoiceitemdetail(@ModelAttribute("invoiceitemdetailForm") Invoiceitemdetail invoiceitem,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		// userDetailValidator.validate(userDetail, result);

		if (result.hasErrors()) {

			mav.setViewName("invoiceitemdetail");

			return mav;
		} else {

			String view = "listinvoiceitemdetail";

			String msg = "";

			Date d = new Date();

			invoiceitem.setCreatedtime(d);

			invoiceitem.setModifiedtime(d);

			invoiceitemdetailService.updateInvoiceitemdetail(invoiceitem);

			view = "index";

			msg = "Updated Successfully !!";

			return new ModelAndView("redirect:/loadinvoice?invoice="+invoiceitem.getInvoicenumber());
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
		List<Invoiceitemdetail> invoiceitem = invoiceitemdetailService.listInvoiceitemdetail();

		return invoiceitem;
	}

	private Invoiceitemdetail getInvoiceitemdetail(String invoiceitem) {
		return invoiceitemdetailService.getInvoiceitemdetailById(invoiceitem);
	}

	private String getLatestInvoiceitemdetailId() {
		int iddigit = 0;

		String latId = invoiceitemdetailService.getLatestInvoiceitemdetailID();

		if (latId != null)
			iddigit = Integer.valueOf(latId.substring(3, latId.length()));

		iddigit++;

		String str = String.format("PRO%04d", iddigit);

		return str;
	}

	@ModelAttribute("cust")
	public List<Client> getAllCli() {
		List<Client> client = InvoiceService.getCust();

		return client;
	}

	@ModelAttribute("pur")
	public List<Purchase> getAllPur() {
		List<Purchase> purchase = InvoiceService.getPur();

		return purchase;
	}


	@ModelAttribute("inv")
	public List<Invoice> getAllInv() {
		List<Invoice> invoice = invoiceitemdetailService.getInv();

		return invoice;
	}
	
}
