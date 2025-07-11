package ksmybatis.admin.vendors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmybatis.admin.vendors.service.VendorsService;
import ksmybatis.systems.utils.Pageable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin/vendors")
@RequiredArgsConstructor
@Slf4j
public class VendorsController {

	private final VendorsService vendorsService;
	

	@GetMapping("/sellerList")
	public String sellerListView(Model model, Pageable pageable) {
		
		var sellerListInfo = vendorsService.getSellerList(pageable);
		
		var sellerList = sellerListInfo.getContents();
		int currentPage = sellerListInfo.getCurrentPage();
		int lastPage = sellerListInfo.getLastPage();
		int startPageNum = sellerListInfo.getStartPageNum();
		int endPageNum = sellerListInfo.getEndPageNum();
		
		log.info("sellerList : {}", sellerList);
		
		model.addAttribute("title", "판매자현황조회");
		model.addAttribute("sellerList", sellerList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
 		
		return "admin/vendors/sellerListView";
	}
	
	@GetMapping("/vendorList")
	public String vendorListView(Model model) {
		
		var vendorList = vendorsService.getVendorList();
		
		model.addAttribute("title", "거래처 목록조회");
		model.addAttribute("vendorList", vendorList);
		
		return "admin/vendors/vendorListView";
	}
}









