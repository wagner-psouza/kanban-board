package br.com.estudos.kanban.services.board;

import br.com.estudos.kanban.repositories.BoardRepository;
import br.com.estudos.kanban.response.board.BoardResponse;
import org.springframework.stereotype.Service;

@Service
public class BuscarPorIdBoardService {

    private final BoardRepository boardRepository;

    public BuscarPorIdBoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponse execute(Long id) {
        var board = boardRepository.findById(id).orElseThrow();
        return new BoardResponse(board.getId(), board.getNome(), board.getDataCriacao());
    }
}
