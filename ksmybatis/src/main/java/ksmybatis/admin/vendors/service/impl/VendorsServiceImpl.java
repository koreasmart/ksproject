package ksmybatis.admin.vendors.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmybatis.admin.vendors.domain.Vendors;
import ksmybatis.admin.vendors.mapper.VendorsMapper;
import ksmybatis.admin.vendors.service.VendorsService;
import ksmybatis.systems.utils.PageInfo;
import ksmybatis.systems.utils.Pageable;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VendorsServiceImpl implements VendorsService {

	private final VendorsMapper vendorsMapper;
	
	@Override
	public PageInfo<Vendors> getSellerList(Pageable pageable) {
		int sellerListCount = vendorsMapper.getSellerListCount();
		var sellerList = vendorsMapper.getSellerList(pageable);
		return new PageInfo<>(sellerList, pageable, sellerListCount);
	}
	
	@Override
	public List<Vendors> getVendorList() {
		
		return vendorsMapper.getVendorList();
	}

}








