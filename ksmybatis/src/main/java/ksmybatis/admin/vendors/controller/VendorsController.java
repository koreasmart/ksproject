package ksmybatis.admin.vendors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmybatis.admin.vendors.service.VendorsService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/vendors")
@RequiredArgsConstructor
public class VendorsController {

	private final VendorsService vendorsService;
	
	@GetMapping("/vendorList")
	public String vendorListView(Model model) {
		
		var vendorList = vendorsService.getVendorList();
		
		model.addAttribute("title", "거래처 목록조회");
		model.addAttribute("vendorList", vendorList);
		
		return "admin/vendors/vendorListView";
	}
}









