package br.com.estudos.kanban.services.board;

import br.com.estudos.kanban.repositories.BoardRepository;
import br.com.estudos.kanban.response.board.BuscarBoardResponse;
import br.com.estudos.kanban.response.board.BuscarBoardResponseBuilder;
import org.springframework.stereotype.Service;

@Service
public class BuscarBoardService {

    private final BoardRepository boardRepository;

    public BuscarBoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BuscarBoardResponse execute(Long id) {
        var board = boardRepository.findById(id).orElseThrow();
        return BuscarBoardResponseBuilder.builder()
                .id(board.getId())
                .nome(board.getNome())
                .data(board.getDataCriacao())
                .buckets(board.getBuckets())
                .build();
    }
}
