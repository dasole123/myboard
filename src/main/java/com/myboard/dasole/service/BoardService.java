package com.myboard.dasole.service;

import com.myboard.dasole.domain.Board;
import com.myboard.dasole.domain.BoardRepository;
import com.myboard.dasole.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }
}
