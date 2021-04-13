package br.com.estudos.kanban.controller.board;

import br.com.estudos.kanban.response.board.BuscarBoardResponse;
import br.com.estudos.kanban.services.board.BuscarBoardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BuscarBoardController {

    private static final String PATH = "v1/board/{id}";

    private final BuscarBoardService buscarBoardService;

    public BuscarBoardController(BuscarBoardService buscarBoardService) {
        this.buscarBoardService = buscarBoardService;
    }

    @ApiOperation(value = "Buscar board por id")
    @GetMapping(PATH)
    public ResponseEntity<BuscarBoardResponse> buscar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(buscarBoardService.execute(id));
    }
}