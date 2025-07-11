package ksmybatis.admin.products.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmybatis.admin.products.domain.Products;
import ksmybatis.admin.products.service.ProductsService;
import ksmybatis.systems.utils.Pageable;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class ProductsController {

	private final ProductsService productsService;
		
	/**
	 * 상품목록 조회
	 * @return productListView
	 */
	@GetMapping("/productList")
	public String productListView(Model model) {
		
		List<Products> productList = productsService.getProductList();
		
		model.addAttribute("title", "상품목록조회");
		model.addAttribute("productList", productList);
		
		return "admin/products/productListView";
	}
}











