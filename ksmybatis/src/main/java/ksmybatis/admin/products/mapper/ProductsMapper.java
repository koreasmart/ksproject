package ksmybatis.admin.products.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmybatis.admin.products.domain.Products;

@Mapper
public interface ProductsMapper {
	// 판매자가 등록한 상품 삭제
	int removeProductsBySellerId(String sellerId);

	// 상품목록 조회
	List<Products> getProductList();
}













