package ksmybatis.admin.vendors.service;

import java.util.List;

import ksmybatis.admin.vendors.domain.Vendors;
import ksmybatis.systems.utils.PageInfo;
import ksmybatis.systems.utils.Pageable;

public interface VendorsService {
	
	// 판매자 현황조회
	PageInfo<Vendors> getSellerList(Pageable pageable);

	// 거래처 목록조회
	List<Vendors> getVendorList();
}
