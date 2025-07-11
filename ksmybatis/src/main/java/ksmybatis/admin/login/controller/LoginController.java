package ksmybatis.admin.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ksmybatis.admin.member.domain.Member;
import ksmybatis.admin.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final MemberService memberService;
	
	@GetMapping("/admin/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/admin/login";
	}
	
	@PostMapping("/admin/login")
	public String login(@RequestParam String memberId, @RequestParam String memberPw, HttpSession session) {
		var loginResult = memberService.matchMember(memberId, memberPw);
		boolean isMathced = (boolean) loginResult.get("isMatched");
		String redirectUri = "redirect:/admin/login";
		
		if(isMathced) {
			Member memberInfo = (Member) loginResult.get("memberInfo");
			String sessionId = memberInfo.getMemberId();
			String sessionName = memberInfo.getMemberName();
			String sessionLevel = memberInfo.getMemberLevel();
			
			redirectUri = "redirect:/admin";
			
			session.setAttribute("SID", sessionId);
			session.setAttribute("SNAME", sessionName);
			session.setAttribute("SLEVEL", sessionLevel);
		}
		
		
		return redirectUri;
	}

	@GetMapping("/admin/login")
	public String loginView(Model model) {	
	
		model.addAttribute("title", "로그인");
		
		return "admin/login/loginView";
	}
}





