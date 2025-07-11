package ksmybatis.admin.member.domain;

import lombok.Data;

@Data
public class Member {
	private String memberId; 
	private String memberPw; 
	private String memberName; 
	private String memberLevel;
	private String memberLevelName; 
	private String memberAddress; 
	private String memberDAddress; 
	private String memberZip; 
	private String memberTelNo; 
	private String memberTelNo1; 
	private String memberTelNo2; 
	private String memberTelNo3; 
	private String memberEmail; 
	private String memberRegDate;
}
