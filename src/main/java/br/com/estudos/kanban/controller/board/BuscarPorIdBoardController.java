package br.com.estudos.kanban.controller.board;

import br.com.estudos.kanban.response.board.BoardResponse;
import br.com.estudos.kanban.services.board.BuscarPorIdBoardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BuscarPorIdBoardController {

    private static final String PATH = "v1/board/{id}";

    private final BuscarPorIdBoardService buscarPorIdBoardService;

    public BuscarPorIdBoardController(BuscarPorIdBoardService buscarPorIdBoardService) {
        this.buscarPorIdBoardService = buscarPorIdBoardService;
    }

    @ApiOperation(value = "Buscar board por id")
    @GetMapping(PATH)
    public ResponseEntity<BoardResponse> buscar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(buscarPorIdBoardService.execute(id));
    }
}