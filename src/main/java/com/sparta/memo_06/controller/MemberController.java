package com.sparta.memo_06.controller;

import com.sparta.memo_06.dto.requestDto.LoginRequestDto;
import com.sparta.memo_06.dto.requestDto.MemberRequestDto;
import com.sparta.memo_06.dto.responseDto.SuccessOrFail;
import com.sparta.memo_06.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupMember(@RequestBody MemberRequestDto requestDto) {
        return new ResponseEntity<>(SuccessOrFail.success(memberService.signupMember(requestDto)), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginMember(@RequestBody LoginRequestDto requestDto) {
        return new ResponseEntity<>(SuccessOrFail.success(requestDto), HttpStatus.OK);
    }



}
