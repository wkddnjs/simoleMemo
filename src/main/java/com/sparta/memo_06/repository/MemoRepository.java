package com.sparta.memo_06.repository;

import com.sparta.memo_06.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo,Long> {

    List<Memo> findAllByOrderByCreatedAt();

}
