package br.com.estudos.kanban.controller.board;


import br.com.estudos.kanban.request.board.NovoBoardRequest;
import br.com.estudos.kanban.response.board.NovoBoardResponse;
import br.com.estudos.kanban.services.board.NovoBoardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping
public class NovoBoardController {

    private static final String PATH = "v1/board";

    private final NovoBoardService novoBoardService;

    public NovoBoardController(NovoBoardService novoBoardService) {
        this.novoBoardService = novoBoardService;
    }

    @ApiOperation(value = "Cria um novo board")
    @PostMapping(PATH)
    public ResponseEntity<NovoBoardResponse> criar(@RequestBody @Valid NovoBoardRequest request,
                                                   UriComponentsBuilder uriBuilder) {
        var board = novoBoardService.execute(request);
        var url = PATH.concat("/{id}");
        URI uri = uriBuilder.path(url).buildAndExpand( board.getId()).toUri();
        return ResponseEntity.created(uri).body(board);
    }
}
