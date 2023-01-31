package com.sparta.memo_06.entity;

import com.sparta.memo_06.dto.requestDto.MemoRequestDto;
import com.sparta.memo_06.util.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Memo extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

    @JoinColumn(name = "memoId",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    public Memo(MemoRequestDto memoRequestDto) {
        this.title = memoRequestDto.getTitle();
        this.contents = memoRequestDto.getContents();
    }

    public void Update(MemoRequestDto memoRequestDto) {
        this.title = memoRequestDto.getTitle();
        this.contents = memoRequestDto.getContents();
    }

}
