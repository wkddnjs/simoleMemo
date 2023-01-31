package com.sparta.memo_06.service;

import com.sparta.memo_06.dto.requestDto.MemoRequestDto;
import com.sparta.memo_06.entity.Memo;
import com.sparta.memo_06.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;


    @Transactional
    public Memo createMemo(MemoRequestDto memeRequestDto) {
        Memo memo = new Memo(memeRequestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional
    public Memo updateMemo(Long id,MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        memo.Update(requestDto);
        return memo;
    }

}
