package com.sparta.memo_06.controller;

import com.sparta.memo_06.dto.requestDto.MemoRequestDto;
import com.sparta.memo_06.dto.responseDto.SuccessOrFail;
import com.sparta.memo_06.repository.MemoRepository;
import com.sparta.memo_06.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memo")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;
    private final MemoRepository memoRepository;

    @PostMapping("/auth/create")
    public ResponseEntity<?> createMemo(@RequestBody MemoRequestDto memoRequestDto) {
        return new ResponseEntity<>(SuccessOrFail.success(memoService.createMemo(memoRequestDto)), HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<?> readMemo() {
        return new ResponseEntity<>(SuccessOrFail.success(memoRepository.findAllByOrderByCreatedAt()),HttpStatus.OK);
    }

    @PutMapping("/auth/update/{id}")
    public ResponseEntity<?> updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto) {
        return new ResponseEntity<>(SuccessOrFail.success(memoService.updateMemo(id,requestDto)),HttpStatus.OK);
    }

    @DeleteMapping("/auth/delete/{id}")
    public ResponseEntity<?> deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return new ResponseEntity<>(SuccessOrFail.success("해당 게시글을 제거하였습니다."),HttpStatus.OK);
    }

}
