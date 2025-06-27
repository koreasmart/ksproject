package ksmybatis.admin.vendors.service;

import java.util.List;

import ksmybatis.admin.vendors.domain.Vendors;

public interface VendorsService {

	// 거래처 목록조회
	List<Vendors> getVendorList();
}
