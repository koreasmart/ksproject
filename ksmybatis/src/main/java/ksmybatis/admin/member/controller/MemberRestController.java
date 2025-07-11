package ksmybatis.admin.member.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ksmybatis.admin.member.service.MemberService;
import ksmybatis.admin.member.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {

    private final MemberService memberService;

	/**
	 * @RequestBody Member memberInfo, Map<String, String> requestMap
	 * 			  : json 데이터의 키와 dto의 필드명과 일치하면 바인딩
	 * @return isDelete
	 */
	@PostMapping("/member/api/removeMember")
	public boolean removeMember(@RequestBody Map<String, String> requestMap) {
		boolean isDelete = false;
		
		String memberId = requestMap.get("memberId");
		String memberPw = requestMap.get("memberPw");
		
		log.info("탈퇴할 회원아이디: {}", memberId);
		log.info("탈퇴할 회원비밀번호: {}", memberPw);
		
		var resultMap = memberService.matchMember(memberId, memberPw);
		
		isDelete = (boolean) resultMap.get("isMatched");
		
		if(isDelete) memberService.removeMember(memberId);
		
		return isDelete;
	}
	
	@DeleteMapping("/member/api/{memberId}")
	public boolean removeMember(@PathVariable(name = "memberId") String memberId) {
		boolean isDelete = false;
		
		log.info("탈퇴할 아이디: {}", memberId);
		
		return isDelete;
	}

}







