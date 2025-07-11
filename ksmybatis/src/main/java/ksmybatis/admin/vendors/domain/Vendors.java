package ksmybatis.admin.vendors.domain;

import java.util.List;

import ksmybatis.admin.member.domain.Member;
import ksmybatis.admin.products.domain.Products;
import lombok.Data;

@Data
public class Vendors {
	private String vendorCode; 
	private String vendorMemberId; 
	private String vendorBrno; 
	private String vendorName; 
	private String vendorAddress; 
	private String vendorDAddress; 
	private String vendorZip;
	private String vendorTelNo;
	
	// 1:1
	private Member sellerInfo;
	// 1:N
	private List<Products> productList;
}









