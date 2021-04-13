package br.com.estudos.kanban.services.board;

import br.com.estudos.kanban.entities.Board;
import br.com.estudos.kanban.repositories.BoardRepository;
import br.com.estudos.kanban.request.board.NovoBoardRequest;
import br.com.estudos.kanban.response.board.NovoBoardResponse;
import org.springframework.stereotype.Service;

@Service
public class NovoBoardService {

    private final BoardRepository repository;

    public NovoBoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public NovoBoardResponse execute(NovoBoardRequest request) {
        var board = repository.save(new Board(request.getNome()));
        return new NovoBoardResponse(board.getId(), board.getNome(), board.getDataCriacao());
    }

}
