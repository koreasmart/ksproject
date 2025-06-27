package ksmybatis.admin.products.service;

import java.util.List;

import ksmybatis.admin.products.domain.Products;

public interface ProductsService {

	// 상품 목록 조회
	List<Products> getProductList();


}
