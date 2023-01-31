package com.sparta.memo_06.service;

import com.sparta.memo_06.dto.requestDto.LoginRequestDto;
import com.sparta.memo_06.dto.requestDto.MemberRequestDto;
import com.sparta.memo_06.dto.responseDto.SuccessOrFail;
import com.sparta.memo_06.entity.Member;
import com.sparta.memo_06.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    public final MemberRepository memberRepository;


    //회원가입
    public ResponseEntity<?> signupMember(MemberRequestDto requestDto) {

        if (null == isPresentedEmail(requestDto.getEmail())) {
            Member member = new Member(requestDto);
            memberRepository.save(member);
            return new ResponseEntity<>(SuccessOrFail.success("사용할 수 있는 아이디입니다."), HttpStatus.OK);
        }
        return new ResponseEntity<>(SuccessOrFail.fail("EMAIL_ALREADY_USE","중복되는 아이디입니다."),HttpStatus.ALREADY_REPORTED);
    }



    private Member isPresentedEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        return optionalMember.orElse(null);
    }

}


