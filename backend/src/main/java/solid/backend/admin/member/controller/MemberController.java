package solid.backend.admin.member.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import solid.backend.admin.member.dto.AuthDto;
import solid.backend.admin.member.dto.MemberDto;
import solid.backend.admin.member.service.AuthService;
import solid.backend.admin.member.service.MemberService;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class MemberController {

    private final MemberService memberService;
    private final AuthService authService;

    /**
     * 설명 : 회원 정보 가져오기
     * @return MemberDto
     */
    @ResponseBody
    @GetMapping("/member")
    public List<MemberDto> getMemberList() {
        return memberService.getMemberList();
    }

    /**
     * 설명 : 권한 정보 가져오기
     * @return AuthDto
     */
    @ResponseBody
    @GetMapping("/auth")
    public List<AuthDto> getAuthList() {
        return authService.getAuthList();
    }
}
