package ksmybatis.admin.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmybatis.admin.member.domain.LoginHistory;
import ksmybatis.admin.member.domain.Member;
import ksmybatis.systems.crypto.annotation.Decrypt;
import ksmybatis.systems.crypto.annotation.Encrypt;
import ksmybatis.systems.utils.Pageable;

@Mapper
public interface MemberMapper {
	// 로그인이력 테이블의 총행의 갯수 조회
	int getMemberLoginLogCount();
	
	// 로그인이력 조회
	List<LoginHistory> getLoginHistoryList(Pageable pageable);
	
	// 회원 탈퇴
	int removeMemberById(String memberId);
	
	// 특정회원 로그인이력 삭제
	int removeMemberLoginLogById(String memberId);
	
	// 특정회원수정
	int modifyMemberInfo(Member member);
	
	// 특정회원 조회
	@Decrypt(only={"memberPw"})
	Member getMemberInfoById(String memberId);
	
	// 회원등록
	@Encrypt(only= {"memberPw"})
	int addMember(Member member);
	
	// 중복 아이디 체크
	boolean checkMemberById(String memberId);

	// 회원목록 조회
	@Decrypt(only={"memberPw"})
	List<Member> getMemberList();
}












