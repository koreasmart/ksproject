package ksmybatis.admin.member.domain;

import lombok.Data;

@Data
public class LoginHistory {

	private Integer loginNum;
	private String loginId;
	private String loginIP;
	private String loginDate;
	
	// 1:1
	private Member memberInfo;
}
