package com.example.mail.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
    
    private final JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text) {
        // 이메일 전송 로직 구현

        SimpleMailMessage message = new SimpleMailMessage(); // SimpleMailMessage 객체 생성
        message.setTo(to); // 받는 사람 이메일 주소
        message.setSubject(subject); // 이메일 제목
        message.setText(text); // 이메일 본문 내용

        mailSender.send(message); // 이메일 전송
    }

    // 활용 : 비밀번호 변경, 회원가입 승인, DM발송
}
