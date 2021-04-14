package br.com.estudos.kanban.services.board;

import br.com.estudos.kanban.entities.Board;
import br.com.estudos.kanban.repositories.BoardRepository;
import br.com.estudos.kanban.request.board.NovoBoardRequest;
import br.com.estudos.kanban.response.board.BoardResponse;
import org.springframework.stereotype.Service;

@Service
public class NovoBoardService {

    private final BoardRepository repository;

    public NovoBoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public BoardResponse execute(NovoBoardRequest request) {
        var board = repository.save(new Board(request.getNome()));
        return new BoardResponse(board.getId(), board.getNome(), board.getDataCriacao());
    }

}
