package ksmybatis.admin.products.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmybatis.admin.products.domain.Products;
import ksmybatis.admin.products.mapper.ProductsMapper;
import ksmybatis.admin.products.service.ProductsService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService{
	
	private final ProductsMapper productsMapper;
	
	/**
	 * 상품 목록 조회
	 */
	@Override
	public List<Products> getProductList() {
		
		var productList = productsMapper.getProductList();
		
		return productList;
	}
}
















