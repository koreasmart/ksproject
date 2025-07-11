package ksmybatis.admin.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmybatis.admin.common.domain.CommonCode;
import ksmybatis.admin.common.service.CommonService;
import ksmybatis.admin.member.domain.LoginHistory;
import ksmybatis.admin.member.domain.Member;
import ksmybatis.admin.member.mapper.MemberMapper;
import ksmybatis.admin.member.service.MemberService;
import ksmybatis.systems.utils.PageInfo;
import ksmybatis.systems.utils.Pageable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/admin/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

	private final MemberService memberService;
	private final CommonService commonService;
	private final MemberMapper memberMapper;
	
	@GetMapping("/loginHistory")
	public String loginHistoryView(Model model, Pageable pageable) {
		
		PageInfo<LoginHistory> loginHistory = memberService.getLoginHistoryList(pageable);
		
		var loginHistoryList = loginHistory.getContents();
		int currentPage = loginHistory.getCurrentPage();
		int lastPage = loginHistory.getLastPage();
		int startPageNum = loginHistory.getStartPageNum();
		int endPageNum = loginHistory.getEndPageNum();
		
		model.addAttribute("title", "회원로그인이력조회");
		model.addAttribute("loginHistoryList", loginHistoryList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		return "admin/member/loginHistoryView";
	}
	
	
	@GetMapping("/removeMember")
	public String removeMember(@RequestParam String memberId) {
		log.info("탈퇴 아이디: {}", memberId);
		
		memberService.removeMember(memberId);
		
		return "redirect:/admin/member/memberList";
	}
	
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		
		log.info("회원수정: {}", member);
		memberService.modifyMemberInfo(member);
		
		return "redirect:/admin/member/memberList";
	}
	
	@GetMapping("/modifyMember")
	public String modifyMemberView(@RequestParam String memberId
								  ,Model model) {
		
		Member memberInfo = memberService.getMemberInfoById(memberId);
		List<CommonCode> gradeList = commonService.getCommonCodeListByGroupCode("comm_group_1");
		
		model.addAttribute("title", "회원상세정보");
		model.addAttribute("memberInfo", memberInfo);
		model.addAttribute("gradeList", gradeList);
		
		return "admin/member/modifyMemberView";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member
						  , @RequestParam(required = false) List<String> memberTelNum) {
		
		log.info("회원 등록정보: {}", member);
		
		memberTelNum.forEach(telno -> log.info("회원 연락처: {}", telno ));
		
		memberService.addMember(member);
		
		return "redirect:/admin/member/memberList";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam String memberId) {
		log.info("memberId : {}", memberId);
		boolean isMember = memberMapper.checkMemberById(memberId);
		return isMember;
	}
	
	@GetMapping("/addMember")
	public String addMemberView(Model model) {
		
		List<CommonCode> gradeList = commonService.getCommonCodeListByGroupCode("comm_group_1");
		log.info("회원등급조회: {} || {} || {}", gradeList, gradeList, "다른데이터");
		
		model.addAttribute("title", "회원등록");
		model.addAttribute("gradeList", gradeList);
		
		return "admin/member/addMemberView";
	}
	
	@GetMapping("/memberList")
	public String memberListView(Model model) {
		
		var memberList = memberService.getMemberList();
		
		model.addAttribute("title", "회원목록조회");
		model.addAttribute("memberList", memberList);
		
		return "admin/member/memberListView";
	}
	
}















