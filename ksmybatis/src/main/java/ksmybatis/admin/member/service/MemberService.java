package ksmybatis.admin.member.service;

import java.util.List;
import java.util.Map;

import ksmybatis.admin.member.domain.LoginHistory;
import ksmybatis.admin.member.domain.Member;
import ksmybatis.systems.utils.PageInfo;
import ksmybatis.systems.utils.Pageable;

public interface MemberService {

	// 로그인 이력조회
	PageInfo<LoginHistory> getLoginHistoryList(Pageable pageable);
	
	// 회원정보일치 확인
	Map<String, Object> matchMember(String memberId, String memberPw);
	
	// 회원탈퇴
	void removeMember(String memberId);
	
	// 특정회원수정
	void modifyMemberInfo(Member member);
	
	// 특정회원정보 조회
	Member getMemberInfoById(String memberId);
	
	// 회원등록
	void addMember(Member member);

	// 회원 목록 조회
	List<Member> getMemberList();
}
