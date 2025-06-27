package ksmybatis.admin.vendors.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmybatis.admin.vendors.domain.Vendors;
import ksmybatis.admin.vendors.mapper.VendorsMapper;
import ksmybatis.admin.vendors.service.VendorsService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VendorsServiceImpl implements VendorsService {

	private final VendorsMapper vendorsMapper;
	
	@Override
	public List<Vendors> getVendorList() {
		
		return vendorsMapper.getVendorList();
	}

}








