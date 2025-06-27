package ksmybatis.admin.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmybatis.admin.member.domain.Member;

@Mapper
public interface MemberMapper {
	// 회원 탈퇴
	int removeMemberById(String memberId);
	
	// 특정회원 로그인이력 삭제
	int removeMemberLoginLogById(String memberId);
	
	// 특정회원수정
	int modifyMemberInfo(Member member);
	
	// 특정회원 조회
	Member getMemberInfoById(String memberId);
	
	// 회원등록
	int addMember(Member member);
	
	// 중복 아이디 체크
	boolean checkMemberById(String memberId);

	// 회원목록 조회
	List<Member> getMemberList();
}












