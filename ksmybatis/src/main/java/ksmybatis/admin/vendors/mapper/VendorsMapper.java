package ksmybatis.admin.vendors.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmybatis.admin.vendors.domain.Vendors;
import ksmybatis.systems.utils.Pageable;

@Mapper
public interface VendorsMapper {
	// 판매자 현황 갯수조회
	int getSellerListCount();
	
	// 판매자 현황 조회
	List<Vendors> getSellerList(Pageable pageable);
	
	// 판매자 거래처 삭제
	int removeVendorsBySellerId(String sellerId);

	// 거래처 목록 조회
	List<Vendors> getVendorList();
}













