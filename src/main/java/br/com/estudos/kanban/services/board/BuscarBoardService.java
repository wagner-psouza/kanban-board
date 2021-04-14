package br.com.estudos.kanban.services.board;

import br.com.estudos.kanban.repositories.BoardRepository;
import br.com.estudos.kanban.response.board.BoardResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarBoardService {

    private final BoardRepository boardRepository;

    public BuscarBoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardResponse> execute() {
        return boardRepository.findAll()
                .stream()
                .map(board -> new BoardResponse(board.getId(), board.getNome(), board.getDataCriacao()))
                .collect(Collectors.toList());
    }

}
