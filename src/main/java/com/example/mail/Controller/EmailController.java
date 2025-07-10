package com.example.mail.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mail.Service.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EmailController {

    private final EmailService emailService;
    
    // 이메일 폼 요청을 처리하는 메서드
    // 이메일 폼을 보여주는 뷰로 이동
    @GetMapping({"/", "/form"})
    public String form() {
        log.info("이메일 폼 요청");
        return "emailForm"; // 이메일 폼 뷰로 이동
    }

    // 이메일 전송 요청을 처리하는 메서드
    // ajax로 비동기식 전송 시 변수는 @RequestParam으로 받는다.
    // DTO는 @requestBody로 받는다.
    @GetMapping("/send")
    public String sendEmail(@RequestParam String to, 
                            @RequestParam String subject, 
                            @RequestParam String text,
                            Model model) {
        log.info("이메일 전송 요청: to={}, subject={}, text={}", to, subject, text);
        
        // 이메일 전송 로직을 호출 (서비스 클래스에서 구현)
        emailService.sendEmail(to, subject, text);
        model.addAttribute("message", "이메일이 성공적으로 전송되었습니다.");
        
        return "result"; // 이메일 전송 성공 뷰로 이동
    }
}
